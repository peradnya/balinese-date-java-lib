package peradnya.libs.balinesedate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class BalineseDate implements Serializable, Cloneable, Comparable<BalineseDate> {

    private static final long serialVersionUID = 1001L;

    // Start of Pengalantaka Eka Sungsang to Pon (need to be confirmed)
    // Web: http://erwandigunawandly.blogspot.co.id/2014/06/luni-solar-shofiyulloh-st.html
    private static final GregorianCalendar DATE_TRANSITION_PON          = new GregorianCalendar(1971, 0, 27);

    // Start of Pengalantaka Eka Sungsang to Paing (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_PAING        = new GregorianCalendar(2000, 0, 6);

    // Start of Sasih Berkesinambungan (Kawolu, Caka 1914) (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_SK_START     = new GregorianCalendar(1993, 0, 24);

    // Finish of Sasih Berkesinambungan (Kawolu, Caka 1924) (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_SK_FINISH    = new GregorianCalendar(2003, 0, 3);

    // Lookup table for sasih
    private static final BalineseDateConst.Sasih[] lookupSasih          = BalineseDateConst.Sasih.values();

    private final BalineseDateConst.BalineseDatePivot pivot;
    
    private final int penanggal;
    private final boolean isPangelong;
    private final boolean isNgunaratri;

    private final int saka;
    private final BalineseDateConst.Sasih sasih;
    private final boolean isNampihSasih;

    private final GregorianCalendar calendar;
    private final BalineseDatePawukon pawukon;


    public BalineseDate() {
        this(new GregorianCalendar(), false);
    }

    public BalineseDate(int year, int month, int dayOfMonth) {
        this(new GregorianCalendar(year, month, dayOfMonth), false);
    }

    public BalineseDate(GregorianCalendar calendar)  {
        this(calendar, true);
    }

    private BalineseDate(GregorianCalendar calendar, boolean copy) {
        GregorianCalendar date = copy ? (GregorianCalendar) calendar.clone() : calendar;
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);

        this.calendar           = date;
        this.pivot              = chooseBestPivot(this.calendar);

        int pDIY                = calcPawukonDayInYear(this.pivot, this.calendar);
        this.pawukon            = new BalineseDatePawukon(pDIY);

        int[] resPenanggal      = calcPenanggal(this.pivot, this.calendar);

        this.penanggal          = resPenanggal[0];
        this.isPangelong        = resPenanggal[1] == 1;
        this.isNgunaratri       = resPenanggal[2] == 1;

        int[] resSasih          = calcSasih(this.pivot, this.penanggal, this.isPangelong, this.isNgunaratri, this.calendar);

        this.saka               = resSasih[0];
        this.sasih              = lookupSasih[resSasih[1]];
        this.isNampihSasih      = resSasih[2] == 1;
    }

    public GregorianCalendar getCalendar() {
        return (GregorianCalendar) calendar.clone();
    }

    public BalineseDatePawukon getPawukon() {
        return pawukon;
    }

    public int getPenanggal() {
        return penanggal;
    }

    public boolean isPangelong() {
        return isPangelong;
    }

    /**
     * @return the isNgunaratri
     */
    public boolean isNgunaratri() {
        return isNgunaratri;
    }

    /**
     * @return the saka
     */
    public int getSaka() {
        return saka;
    }

    /**
     * @return the sasih
     */
    public BalineseDateConst.Sasih getSasih() {
        return sasih;
    }

    /**
     * @return the isNampihSasih
     */
    public boolean isNampihSasih() {
        return isNampihSasih;
    }

    @Override
    public Object clone() {
        return new BalineseDate(this.getCalendar());
    }

    @Override
	public int compareTo(BalineseDate that) {
		return this.calendar.compareTo(that.getCalendar());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            return this.compareTo((BalineseDate) obj) == 0;
        }
    }
    
    @Override
    public String toString() {
        return "";
    }

    private static BalineseDateConst.BalineseDatePivot chooseBestPivot(GregorianCalendar calendar) {
        return (calendar.compareTo(DATE_TRANSITION_PAING) < 0) ? 
            BalineseDateConst.BalineseDatePivot.PIVOT_NG_PON : 
            BalineseDateConst.BalineseDatePivot.PIVOT_NG_PAING;
    }

    private static int calcPawukonDayInYear(
        BalineseDateConst.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff = BalineseDateUtil.getDeltaDay(pivot.getCalendar(), calendar);
        return BalineseDateUtil.mod(pivot.getPawukonDayInYear() + diff, BalineseDateConst.DAYS_IN_YEAR_PAWUKON);
    }

    private static int[] calcPenanggal(BalineseDateConst.BalineseDatePivot pivot, GregorianCalendar calendar) {
        int[]   res     = new int[3];

        int dayDiff     = BalineseDateUtil.getDeltaDay(pivot.getCalendar(), calendar);
        int daySkip     = (int) Math.ceil((double) dayDiff / BalineseDateConst.NGUNARATRI);
        int dayTotal    = pivot.getPenanggal() + dayDiff + daySkip;

        // calc penanggal
        res[0]  = BalineseDateUtil.mod(dayTotal, 30);

        // calc if this pangelong
        res[1]  = (res[0] == 0 || res[0] > 15) ? 1 : 0;

        // calc if this ngunaratri
        res[2]  = BalineseDateUtil.mod(dayDiff, BalineseDateConst.NGUNARATRI) == 0 ? 1 : 0;

        // if penanggal 0, change to penanggal 15
        res[0] = BalineseDateUtil.mod(res[0], 15);
        res[0] = (res[0] == 0) ? 15 : res[0];

        return res;
    }

    private static int[] calcSasih(
        BalineseDateConst.BalineseDatePivot pivot, 
        int penanggal, 
        boolean isPangelong, 
        boolean isNgunaratri, 
        GregorianCalendar calendar) {

        int[]   res     = new int[3];

        int dayDiff     = BalineseDateUtil.getDeltaDay(pivot.getCalendar(), calendar);
        int daySkip     = (int) Math.ceil((double) dayDiff / BalineseDateConst.NGUNARATRI);
        int dayTotal    = pivot.getPenanggal() + dayDiff + daySkip;

        // sometime pivot is tilem and also ngunaratri, so need to normalize.
        int pivotOffset = pivot.getPenanggal() == 0 && pivot.getNgunaratriDay() == 0 ? 0 : 1;

        // calc number of sasih
        int totalSasih  = (int) Math.ceil((double) dayTotal / 30) - pivotOffset;

        int currentSasih  = pivot.getSasih().getId();
        int currentSaka   = pivot.getSaka() - (currentSasih == BalineseDateConst.Sasih.KADASA.getId() ? 1 : 0);
        int nampihCount   = pivot.isNampihSasih() ? 1 : 0;

        // flags
        boolean nyepiFix = false;

        // in Sasih Kesinambungan (SK) period (1993 - 2002)
        boolean inSK        = false;
        if (pivot.getCalendar().compareTo(DATE_TRANSITION_SK_START) >= 0 && 
            pivot.getCalendar().compareTo(DATE_TRANSITION_SK_FINISH) < 0) {
                inSK        = true;
        }

        while (totalSasih != 0) {

            if (dayDiff >= 0) {

                if (nampihCount == 0 || nampihCount == 2) {
                    nampihCount     = 0;
                    totalSasih      = totalSasih - 1;
                    currentSasih    = BalineseDateUtil.mod(currentSasih + 1, 12);
                } else {
                    totalSasih      = totalSasih - 1;
                }

                // special case in 1995, 1997 which nyepi at tilem kedasa.
                // Tilem kasanga that year happened in the same day as another religion holy day.
                // Source: https://books.google.co.id/books?id=4ND9KPn2o8AC&pg=PA29
                if (currentSasih == BalineseDateConst.Sasih.KADASA.getId() && nampihCount == 0) { 
                    currentSaka = currentSaka + 1;
                    if (currentSaka == 1917 || currentSaka == 1919) {
                        currentSaka = currentSaka - 1;
                        nyepiFix    = true;
                    }
                } else if (currentSasih == BalineseDateConst.Sasih.DESTHA.getId() && 
                    nampihCount == 0 && nyepiFix) {
                        currentSaka = currentSaka + 1;
                        nyepiFix    = false;
                }

                if (currentSasih == BalineseDateConst.Sasih.KAWOLU.getId() && currentSaka == 1914) {
                    inSK = true;
                } else if (currentSasih == BalineseDateConst.Sasih.KAWOLU.getId() && currentSaka == 1924) {
                    inSK = false; 
                }

            } else if (dayDiff < 0) {

                if (nampihCount == 0 || nampihCount == 2) {
                    nampihCount     = 0;
                    totalSasih      = totalSasih + 1;
                    currentSasih    = BalineseDateUtil.mod(currentSasih - 1, 12);
                } else {
                    totalSasih      = totalSasih + 1;
                }

                // special case in 1995, 1997 which nyepi at tilem kedasa.
                // Tilem kasanga that year happened in the same day as another religion holy day.
                // Source: https://books.google.co.id/books?id=4ND9KPn2o8AC&pg=PA29
                if (currentSasih == BalineseDateConst.Sasih.KADASA.getId() && nampihCount == 0) {
                    if (currentSaka == 1917 || currentSaka == 1919) {
                        currentSaka = currentSaka - 1;
                        nyepiFix    = true;
                    }
                } else if (currentSasih == BalineseDateConst.Sasih.KASANGA.getId() && nampihCount == 0) { 
                    if (!nyepiFix) {
                        currentSaka = currentSaka - 1; 
                    } else {
                        nyepiFix = false;
                    }
                }

                if (currentSasih == BalineseDateConst.Sasih.KAPITU.getId() && currentSaka == 1914) {
                    inSK = false;
                } else if (currentSasih == BalineseDateConst.Sasih.KAPITU.getId() && currentSaka == 1924) {
                    inSK = true; 
                }
            }

            switch (currentSaka % 19) {
                case 0:
                case 6:
                case 11:
                    if (currentSasih == BalineseDateConst.Sasih.DESTHA.getId() && !inSK) {
                        //TODO: find out is mala desta happened in 2003.
                        if (currentSaka != 1925) {
                            nampihCount++;
                        }
                    }
                    break;
                case 3:
                case 8:
                case 14:
                case 16:
                    if (currentSasih == BalineseDateConst.Sasih.SADHA.getId() && !inSK) {
                        nampihCount++;
                    }
                    break;
                case 2:
                case 10:
                    if (currentSasih == BalineseDateConst.Sasih.DESTHA.getId() && inSK) {
                        nampihCount++;
                    }
                    break;
                case 4:
                    if (currentSasih == BalineseDateConst.Sasih.KATIGA.getId() && inSK) {
                        nampihCount++;
                    }
                    break;
                case 7:
                    if (currentSasih == BalineseDateConst.Sasih.KASA.getId() &&  inSK) {
                        nampihCount++;
                    }
                    break;
                case 13:
                    if (currentSasih == BalineseDateConst.Sasih.KADASA.getId() && inSK) {
                        nampihCount++;
                    }
                    break;
                case 15:
                    if (currentSasih == BalineseDateConst.Sasih.KARO.getId() && inSK) {
                        nampihCount++;
                    }
                    break;
                case 18:
                    if (currentSasih == BalineseDateConst.Sasih.SADHA.getId() && inSK) {
                        nampihCount++;
                    }
                    break;
            }
        }

        res[0] = currentSaka;
        res[1] = currentSasih;

        if (dayTotal >= 0) {
            res[2] = nampihCount == 2 ? 1 : 0;
        } else {
            res[2] = nampihCount == 1 ? 1 : 0;
        }

        return res;

    }
	
}
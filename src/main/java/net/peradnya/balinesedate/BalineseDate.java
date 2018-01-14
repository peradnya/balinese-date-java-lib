package net.peradnya.balinesedate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class BalineseDate implements Serializable, Cloneable, Comparable<BalineseDate> {

    private static final long serialVersionUID = 1001L;

    // Start of Pengalantaka Eka Sungsang to Pon (need to be confirmed)
    // From: http://erwandigunawandly.blogspot.co.id/2014/06/luni-solar-shofiyulloh-st.html
    private static final GregorianCalendar DATE_TRANSITION_PON      = new GregorianCalendar(1971, 1, 27);

    // Start of Pengalantaka Eka Sungsang to Paing (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_PAING    = new GregorianCalendar(2000, 1, 6);

    private final Constants.BalineseDatePivot pivot;
    private final int ngunaratri;
    
    private final int penanggal;
    private final boolean isPangelong;
    private final Constants.Sasih sasih;
    private final int saka;

    private final GregorianCalendar calendar;
    private final BalinesePawukon pawukon;


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

        this.calendar   = date;
        this.pivot      = chooseBestPivot(this.calendar);

        int pDIY        = calcPawukonDayInYear(this.pivot, this.calendar);
        this.pawukon    = new BalinesePawukon(pDIY);

        int[] resPenanggal = calcPenanggal(this.pivot, this.calendar);

        this.penanggal  = resPenanggal[0];
        this.isPangelong = false;

        this.saka = 0;
        this.sasih = Constants.Sasih.KASA;
        this.ngunaratri = 0;
    }

    public GregorianCalendar getCalendar() {
        return (GregorianCalendar) calendar.clone();
    }

    public BalinesePawukon getPawukon() {
        return pawukon;
    }

    public int getPenanggal() {
        return penanggal;
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

    private static Constants.BalineseDatePivot chooseBestPivot(GregorianCalendar calendar) {
        return (calendar.compareTo(DATE_TRANSITION_PAING) < 0) ? 
            Constants.BalineseDatePivot.PIVOT_NG_PON : 
            Constants.BalineseDatePivot.PIVOT_NG_PAING;
    }

    private static int calcPawukonDayInYear(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff    = Utils.getDeltaDay(pivot.getCalendar(), calendar);
        return Utils.mod(pivot.getPawukonDayInYear() + diff, Constants.DAYS_IN_YEAR_PAWUKON);
    }

    private static int[] calcPenanggal(Constants.BalineseDatePivot pivot, GregorianCalendar calendar) {
        int[]   res     = new int[3];

        int     dayDiff = Utils.getDeltaDay(pivot.getCalendar(), calendar);
        int     daySkip = 0;

        daySkip = (int) Math.ceil((double) dayDiff / Constants.NGUNARATRI);

        // calc penanggal
        res[0]  = Utils.mod(pivot.getPenanggal() + dayDiff + daySkip, 30);
        // calc if this pangelong
        res[1]  = !(pivot.isPangelong() ^ res[0] < 15) ? 1 : 0;
        // calc if this ngunaratri
        res[2]  = Utils.mod(dayDiff, Constants.NGUNARATRI) == 0 ? 1 : 0;

        // if penanggal 0, change to penanggal 15
        res[0] = Utils.mod(res[0], 15);
        res[0] = (res[0] == 0) ? 15 : res[0];

        return res;
    }
	
}
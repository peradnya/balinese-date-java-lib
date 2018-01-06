package net.peradnya.balinesedate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BalineseDate implements Serializable, Cloneable, Comparable<BalineseDate> {

    private static final long serialVersionUID = 1001L;

    private static final GregorianCalendar DATE_NYEPI_1921 = new GregorianCalendar(1999, 3, 18);



    private Constants.BalineseDatePivot pivot;
    private int ngunaRatri;
    
    private int penanggal;
    private Constants.MoonStatus penanggalStatus;
    private Constants.Sasih sasih;
    private int saka;

    private GregorianCalendar calendar;
    private BalinesePawukon pawukon;




    public BalineseDate() {
        GregorianCalendar temp = new GregorianCalendar();

        temp.set(Calendar.HOUR_OF_DAY, 0);
        temp.set(Calendar.MINUTE, 0);
        temp.set(Calendar.SECOND, 0);
        temp.set(Calendar.MILLISECOND, 0);

        initBalineseDate(temp);
    }

    public BalineseDate(int year, int month, int dayOfMonth) {
        initBalineseDate(new GregorianCalendar(year, month, dayOfMonth));
    }

    public BalineseDate(GregorianCalendar calendar) {
        initBalineseDate((GregorianCalendar) calendar.clone());
    }

    private void initBalineseDate(GregorianCalendar calendar) {
        try {
            this.calendar   = calendar;
            this.pivot      = chooseBestPivot(this.calendar);

            int pDIY        = calcPawukonDayInYear(this.pivot, this.calendar);
            this.pawukon    = new BalinesePawukon(pDIY);

            int tempTanggal = calcPenanggal(this.pivot, this.calendar);

            this.penanggal  = tempTanggal % 15;
            this.penanggalStatus = (tempTanggal / 15 == 0) ? 
                Constants.MoonStatus.PENANGGAL: 
                Constants.MoonStatus.PANGELONG;

            

        } catch (BalinesePawukonException ex) {
            //later
        }
    }

    public GregorianCalendar getCalendar() {
        return (GregorianCalendar) calendar.clone();
    }

    public BalinesePawukon getPawukon() {
        return pawukon;
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
        return (DATE_NYEPI_1921.compareTo(calendar) >= 0) ? 
            Constants.BalineseDatePivot.PIVOT_1999 : 
            Constants.BalineseDatePivot.PIVOT_2000;
    }

    private static int calcPawukonDayInYear(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff    = Utils.getDeltaDay(pivot.getCalendar(), calendar);

        return Utils.mod(pivot.getPawukonDayInYear() + diff, Constants.DAYS_IN_YEAR_PAWUKON);
    }

    private static int calcNgunaRatri(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff    = Utils.getDeltaDay(pivot.getCalendar(), calendar);

        return Utils.mod(pivot.getPawukonDayInYear() + diff, Constants.MAX_NGUNARATRI);
    }

    private static int calcPenanggal(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff = Utils.getDeltaDay(pivot.getCalendar(), calendar);
        int days = pivot.getDayInPengalantaka() + diff;

        int countNG     = 0;
        int startNG     = 0;
        int penanggal   = 0;
        int pangelong   = pivot.isPangelong() ? 0 : 15;

        if (diff >= 0) {
            startNG     = pivot.getDayInPengalantaka() - (pivot.getDayInPengalantaka() % 63);
        } else {
            startNG     = pivot.getDayInPengalantaka() + 63 - (pivot.getDayInPengalantaka() % 63);
        }

        countNG     = (int) Math.ceil((days - startNG) / 63);
        countNG     = countNG + (pivot.isNgunaRatri() ? 1 : 0);

        penanggal   = (diff + pivot.getPenanggal() + pangelong + countNG) % 30;

        return penanggal;
    }
	
}
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

            this.ngunaRatri = calcNgunaRatri(this.pivot, this.calendar);

        } catch (BalinesePawukonException ex) {
            //later
        }
    }

    public GregorianCalendar getCalendar() {
        return (GregorianCalendar) calendar.clone();
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

        return (pivot.getPawukonDayInYear() + diff) % Constants.DAYS_IN_YEAR_PAWUKON;
    }

    private static int calcNgunaRatri(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff    = Utils.getDeltaDay(pivot.getCalendar(), calendar);

        return (pivot.getNgunaRatri() + diff) % Constants.MAX_NGUNARATRI;
    }

    private static int calcPenaggal(
        Constants.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        return 0;
    }
	
}
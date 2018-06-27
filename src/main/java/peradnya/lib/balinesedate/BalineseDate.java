/**
 *  Copyright 2018 Ida Bagus Putu Peradnya Dinata
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package peradnya.lib.balinesedate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * BalineseDate provides implementation of Saka Calendar used by Indonesia Hindu's.
 * <p>
 * Class BalineseDate provides information about:
 * <ul>
 *  <li>Pawukon info (Wewaran, Wuku, Paringkelan, etc.)</li>
 *  <li>Sasih info (Date (1-15), Date Status (Penanggal, Pangelong, Purnama, Tilem), Sasih name, etc.)</li>
 *  <li>Saka info (Saka year)</li>
 * </ul>
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 * @see BalineseDatePawukon
 */
public final class BalineseDate implements Serializable {

    private static final long serialVersionUID = 1001L;

    // Start of Pengalantaka Eka Sungsang to Pon (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_PON          = new GregorianCalendar(1971, 0, 27);

    // Start of Pengalantaka Eka Sungsang to Paing (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_PAING        = new GregorianCalendar(2000, 0, 6);

    // Start of Sasih Berkesinambungan (Kawolu, Caka 1914) (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_SK_START     = new GregorianCalendar(1993, 0, 24);

    // Finish of Sasih Berkesinambungan (Kawolu, Caka 1924) (need to be confirmed)
    private static final GregorianCalendar DATE_TRANSITION_SK_FINISH    = new GregorianCalendar(2003, 0, 3);

    // Lookup table for sasih
    private static final BalineseDateConst.Sasih[] lookupSasih          = BalineseDateConst.Sasih.values();

    private static final String NULL_CALENDAR = "Calendar value must not null.";

    private final BalineseDateConst.BalineseDatePivot pivot;
    
    private final int[] date;
    private final BalineseDateConst.DateStatus dateStatus;

    private final int saka;
    private final BalineseDateConst.Sasih sasih;

    private final GregorianCalendar calendar;
    private final BalineseDatePawukon pawukon;

    /**
     * Construct BalineseDate with current date.
     */
    public BalineseDate() {
        this(new GregorianCalendar(), false);
    }

    /**
     * Construct BalineseDate with specific date.
     * 
     * @param year the gregorian year.
     * @param month the gregorian month of year. Start from 0 (January) to 11 (December).
     * @param dayOfMonth the gregorian day of month. Start from 1 - 31.
     * 
     * @see java.util.GregorianCalendar
     */
    public BalineseDate(int year, int month, int dayOfMonth) {
        this(new GregorianCalendar(year, month, dayOfMonth), false);
    }

    /**
     * Construct BalineseDate with specific date.
     * 
     * @param calendar the gregorian calendar.
     */
    public BalineseDate(GregorianCalendar calendar)  {
        this(calendar, true);
    }

    private BalineseDate(GregorianCalendar calendar, boolean copy) {
        if (calendar == null) { throw new IllegalArgumentException(NULL_CALENDAR); }

        GregorianCalendar day = copy ? (GregorianCalendar) calendar.clone() : calendar;
        day.set(Calendar.HOUR_OF_DAY, 0);
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
        day.set(Calendar.MILLISECOND, 0);

        this.calendar           = day;
        this.pivot              = chooseBestPivot(this.calendar);

        int pDIY                = calcPawukonDayInYear(this.pivot, this.calendar);
        this.pawukon            = new BalineseDatePawukon(pDIY);

        int[] resultDate        = calcDate(this.pivot, this.calendar);

        this.date               = (resultDate[2] == 1) ? 
                                    new int[] {resultDate[0], resultDate[0] == 15 ? 1 : resultDate[0] + 1} : 
                                    new int[] {resultDate[0]};

        int[] resultSasih       = calcSasih(this.pivot, this.calendar);

        this.saka               = resultSasih[0];
        this.sasih              = calcSasihInfo(resultSasih);

        this.dateStatus         = calcDateStatus(resultDate, this.sasih, this.saka);
    }

    /**
     * Get the copy of gregorian calendar used internally by BalineseDate.
     * @return the gregorian representation of BalineseDate
     */
    public GregorianCalendar toCalendar() {
        return (GregorianCalendar) calendar.clone();
    }

    /**
     * Get Pawukon Information.
     * @return the pawukon information.
     */
    public BalineseDatePawukon getPawukon() {
        return pawukon;
    }

    /**
     * Get Date(s) (1 - 15) of Sasih.
     * Return 1 date in normal day, but return 2 dates in NgunaRatri day.
     * @return array of date(s).
     */
    public int[] getDate() {
        return date.clone();
    }

    /**
     * Get Date Status (Penanggal, Pangelong, Purnama, or Tilem).
     * @return the date status.
     */
    public BalineseDateConst.DateStatus getDateStatus() {
        return dateStatus;
    }

    /**
     * Get Saka Year.
     * @return the saka
     */
    public int getSaka() {
        return saka;
    }

    /**
     * Get Sasih.
     * @return the sasih
     */
    public BalineseDateConst.Sasih getSasih() {
        return sasih;
    }

    @Override
    public String toString() {
        String dateStr = String.valueOf(date[0]);
        if (date.length > 1) {
            dateStr = dateStr + "/" + date[1];
        }
        return pawukon.toString() + ", " + dateStatus.getName() + " "  + dateStr + ", Sasih " + sasih.getName() + ", Saka " + saka;
    }

    private static BalineseDateConst.BalineseDatePivot chooseBestPivot(GregorianCalendar calendar) {
        return (calendar.compareTo(DATE_TRANSITION_PAING) < 0) ? 
            BalineseDateConst.BalineseDatePivot.PIVOT_NG_PON : 
            BalineseDateConst.BalineseDatePivot.PIVOT_NG_PAING;
    }

    private static int calcPawukonDayInYear(
        BalineseDateConst.BalineseDatePivot pivot, 
        GregorianCalendar calendar) {

        int diff = getDeltaDay(pivot.getCalendar(), calendar);
        return mod(pivot.getPawukonDayInYear() + diff, BalineseDateConst.DAYS_IN_YEAR_PAWUKON);
    }

    private static int[] calcDate(BalineseDateConst.BalineseDatePivot pivot, GregorianCalendar calendar) {
        int[]   res     = new int[3];

        int dayDiff     = getDeltaDay(pivot.getCalendar(), calendar);
        int daySkip     = (int) Math.ceil((double) dayDiff / BalineseDateConst.NGUNARATRI);
        int dayTotal    = pivot.getDate() + dayDiff + daySkip;

        // calc date
        res[0]  = mod(dayTotal, 30);

        // calc if this pangelong
        res[1]  = (res[0] == 0 || res[0] > 15) ? 1 : 0;

        // calc if this ngunaratri
        res[2]  = mod(dayDiff, BalineseDateConst.NGUNARATRI) == 0 ? 1 : 0;

        // if date 0, change to date 15
        res[0] = mod(res[0], 15);
        res[0] = (res[0] == 0) ? 15 : res[0];

        return res;
    }

    private static BalineseDateConst.DateStatus calcDateStatus(int[] resultDate, BalineseDateConst.Sasih sasih, int saka) {

        int date                        = resultDate[0];
        boolean isPangelong             = resultDate[1] == 1;
        boolean isNgunaRatri            = resultDate[2] == 1;

        if (isPangelong) {
            if (date == 15 || (date == 14 && isNgunaRatri)) {
                return BalineseDateConst.DateStatus.TILEM;
            } else if (date        == 14 && 
                       isNgunaRatri     == false &&
                       sasih            == BalineseDateConst.Sasih.KAPITU &&
                       saka             == 1921) {
                // Disclaimer: the accuration is not confirmed for date between March 1999 - January 2000,
                // Because of transition from Eka Sungsang to Pon to Paing.
                // Author don't have enough references for this issue.
                return BalineseDateConst.DateStatus.TILEM;
            } else {
                return BalineseDateConst.DateStatus.PANGELONG;
            }
        } else {
            if (date == 15 || (date == 14 && isNgunaRatri)) {
                return BalineseDateConst.DateStatus.PURNAMA;
            } else {
                return BalineseDateConst.DateStatus.PENANGGAL;
            }
        }

    }

    private static int[] calcSasih(BalineseDateConst.BalineseDatePivot pivot, GregorianCalendar calendar) {

        int[]   res     = new int[3];

        int dayDiff     = getDeltaDay(pivot.getCalendar(), calendar);
        int daySkip     = (int) Math.ceil((double) dayDiff / BalineseDateConst.NGUNARATRI);
        int dayTotal    = pivot.getDate() + dayDiff + daySkip;

        // sometime pivot is tilem and also ngunaratri, so need to normalize.
        int pivotOffset = pivot.getDate() == 0 && pivot.getNgunaratriDay() == 0 ? 0 : 1;

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
                    currentSasih    = mod(currentSasih + 1, 12);
                } else {
                    totalSasih      = totalSasih - 1;
                }

                // Disclaimer: Special case in 1995 which nyepi held 1 day after tilem kedasa 
                // (normally 1 day after tilem kesanga). This happened because of another religion holy day.
                // Source: 
                // - Pendit, Nyoman.(2001). "Nyepi: kebangkitan, toleransi, dan kerukunan". Jakarta : Gramedia
                // - https://id.wikipedia.org/wiki/1995
                if (currentSasih == BalineseDateConst.Sasih.KADASA.getId() && nampihCount == 0) { 
                    currentSaka = currentSaka + 1;
                    if (currentSaka == 1917) {
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
                    currentSasih    = mod(currentSasih - 1, 12);
                } else {
                    totalSasih      = totalSasih + 1;
                }

                // Disclaimer: Special case in 1995 which nyepi held 1 day after tilem kedasa 
                // (normally 1 day after tilem kesanga). This happened because of another religion holy day.
                // Source: 
                // - Pendit, Nyoman.(2001). "Nyepi: kebangkitan, toleransi, dan kerukunan". Jakarta : Gramedia
                // - https://id.wikipedia.org/wiki/1995
                if (currentSasih == BalineseDateConst.Sasih.KADASA.getId() && nampihCount == 0) {
                    if (currentSaka == 1917) {
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
                        // Disclaimer: nampih desta is not happened in 2003 (transition year).
                        // Source: Ardhana, I.B.S.(2005). "Pokok-Pokok Wariga". Surabaya : Paramita.
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
                default:
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

    private static BalineseDateConst.Sasih calcSasihInfo(int[] resultSasih) {
        int saka                = resultSasih[0];
        int sasih               = resultSasih[1];
        boolean isNampihSasih   = resultSasih[2] == 1;
                
        if (isNampihSasih) {
            if (saka < 1914) {
                if (sasih == BalineseDateConst.Sasih.DESTHA.getId()) {
                    return BalineseDateConst.Sasih.MALA_DESTHA;
                } else if (sasih == BalineseDateConst.Sasih.SADHA.getId()) {
                    return BalineseDateConst.Sasih.MALA_SADHA;
                }
            } else {
                if (sasih == BalineseDateConst.Sasih.DESTHA.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_DESTHA;
                } else if (sasih == BalineseDateConst.Sasih.KATIGA.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_KATIGA;
                } else if (sasih == BalineseDateConst.Sasih.KASA.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_KASA;
                } else if (sasih == BalineseDateConst.Sasih.KADASA.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_KADASA;
                } else if (sasih == BalineseDateConst.Sasih.KARO.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_KARO;
                } else if (sasih == BalineseDateConst.Sasih.SADHA.getId()) {
                    return BalineseDateConst.Sasih.NAMPIH_SADHA;
                }
            }
        }

        return lookupSasih[sasih];
    }

    private static int getDeltaDay(GregorianCalendar a, GregorianCalendar b) {
        // try to fix precision error
        double deltaMillis = (double) (b.getTimeInMillis() - a.getTimeInMillis());
        return (int) Math.ceil(deltaMillis / 86400000L);
    }

    private static int mod(int a, int b) {
        // try to fix negative mod
        return ((a % b) + b) % b;
    }
	
}
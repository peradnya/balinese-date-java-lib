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

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import peradnya.lib.balinesedate.BalineseDate;
import peradnya.lib.balinesedate.AstaWara;
import peradnya.lib.balinesedate.CaturWara;
import peradnya.lib.balinesedate.DasaWara;
import peradnya.lib.balinesedate.DwiWara;
import peradnya.lib.balinesedate.EkaJalaRsi;
import peradnya.lib.balinesedate.EkaWara;
import peradnya.lib.balinesedate.Ingkel;
import peradnya.lib.balinesedate.Jejepan;
import peradnya.lib.balinesedate.Lintang;
import peradnya.lib.balinesedate.PancaSuda;
import peradnya.lib.balinesedate.PancaWara;
import peradnya.lib.balinesedate.Pararasan;
import peradnya.lib.balinesedate.PratithiSamutPada;
import peradnya.lib.balinesedate.Rakam;
import peradnya.lib.balinesedate.SadWara;
import peradnya.lib.balinesedate.SangaWara;
import peradnya.lib.balinesedate.SaptaWara;
import peradnya.lib.balinesedate.Sasih;
import peradnya.lib.balinesedate.SasihDayInfo;
import peradnya.lib.balinesedate.TriWara;
import peradnya.lib.balinesedate.WatekAlit;
import peradnya.lib.balinesedate.WatekMadya;
import peradnya.lib.balinesedate.Wuku;

/**
 * Utility class to support {@link BalineseDate}.
 * 
 * @see BalineseDate
 * @author Ida Bagus Putu Peradnya Dinata
 */
public final class BalineseDateUtil {

    private static final String NULL_DATE = "Date must not null.";
    private static final String NULL_LIST = "List of BalineseDate must not null.";
    private static final String NULL_ITEM = "BalineseDate item must not null.";

    /**
     * Filter class for use by static method inside {@link BalineseDateUtil}.
     * 
     * @see BalineseDateUtil
     * @author Ida Bagus Putu Peradnya Dinata
     */
    public static final class Filter {
        public Wuku wuku = null;
        public EkaWara ekaWara = null;
        public DwiWara dwiWara = null;
        public TriWara triWara = null;
        public CaturWara caturWara = null;
        public PancaWara pancaWara = null;
        public SadWara sadWara = null;
        public SaptaWara saptaWara = null;
        public AstaWara astaWara = null;
        public SangaWara sangaWara = null;
        public DasaWara dasaWara = null;
        public Ingkel ingkel = null;
        public Jejepan jejepan = null;
        public WatekAlit watekAlit = null;
        public WatekMadya watekMadya = null;
        public Lintang lintang = null;
        public PancaSuda pancaSuda = null;
        public Pararasan pararasan = null;
        public Rakam rakam = null;
        public EkaJalaRsi ekaJalaRsi = null;
        public Integer saka = null;
        public Sasih sasih = null;
        public List<Integer> sasihDay = null;
        public SasihDayInfo sasihDayInfo = null;
        public PratithiSamutPada pratithiSamutPada = null;
    }

    private BalineseDateUtil() {}

    /**
     * Returns the list of BalineseDate that match with selected filter, Start Date (inclusive), and End Date (inclusive). 
     * <p>
     * <b>Note:</b> This static method is <u>not thread-safe</u>.
     * 
     * @param filter the {@link Filter} to be match. Null for unfiltered result.
     * @param start  the Start Date of the search. Null is not allowed.
     * @param end    the End Date of the search. Null is not allowed.
     * 
     * @return the list of BalineseDate that match with selected filter, Start Date, and End Date
     * @throws IllegalArgumentException Date must not null.
     */
    public static List<BalineseDate> filterByDateRange(Filter filter, GregorianCalendar start, GregorianCalendar end)
            throws IllegalArgumentException {
        if (start == null || end == null) {
            throw new IllegalArgumentException(NULL_DATE);
        }

        List<BalineseDate> result = new LinkedList<BalineseDate>();
        GregorianCalendar now = (GregorianCalendar) start.clone();
        for (; now.compareTo(end) <= 0; now.add(GregorianCalendar.DATE, 1)) {
            BalineseDate x = filterByItem(filter, new BalineseDate(now));
            if (x != null) {
                result.add(x);
            }
        }

        return result;
    }

    /**
     * Returns the list of BalineseDate that match with selected filter. 
     * <p>
     * <b>Note:</b> This static method is <u>not thread-safe</u>.
     * 
     * @param filter the {@link Filter} to be match. Null for unfiltered result.
     * @param list  the list of BalineseDate to be search. Null is not allowed.
     * 
     * @return the list of BalineseDate that match with selected filter
     * @throws IllegalArgumentException List of BalineseDate must not null.
     */
    public static List<BalineseDate> filterByList(Filter filter, List<BalineseDate> list)
            throws IllegalArgumentException {
        if (list == null) {
            throw new IllegalArgumentException(NULL_LIST);
        }

        List<BalineseDate> result = new LinkedList<BalineseDate>();
        for (BalineseDate bd : list) {
            BalineseDate x = filterByItem(filter, bd);
            if (x != null) {
                result.add(x);
            }
        }

        return result;
    }

    /**
     * Returns the BalineseDate item that match with selected filter. 
     * <p>
     * <b>Note:</b> This static method is <u>not thread-safe</u>.
     * 
     * @param filter the {@link Filter} to be match. Null for unfiltered result.
     * @param item  the BalineseDate to be search. Null is not allowed.
     * 
     * @return the BalineseDate item that match with selected filter. If there is no match, then return null.
     * @throws IllegalArgumentException BalineseDate item must not null.
     */
    public static BalineseDate filterByItem(Filter filter, BalineseDate item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException(NULL_ITEM);
        }

        if (filter != null) {
            if (!check(filter.wuku, item.wuku())) {
                return null;
            }
            if (!check(filter.ekaWara, item.ekaWara())) {
                return null;
            }
            if (!check(filter.dwiWara, item.dwiWara())) {
                return null;
            }
            if (!check(filter.triWara, item.triWara())) {
                return null;
            }
            if (!check(filter.caturWara, item.caturWara())) {
                return null;
            }
            if (!check(filter.pancaWara, item.pancaWara())) {
                return null;
            }
            if (!check(filter.sadWara, item.sadWara())) {
                return null;
            }
            if (!check(filter.saptaWara, item.saptaWara())) {
                return null;
            }
            if (!check(filter.astaWara, item.astaWara())) {
                return null;
            }
            if (!check(filter.sangaWara, item.sangaWara())) {
                return null;
            }
            if (!check(filter.dasaWara, item.dasaWara())) {
                return null;
            }
            if (!check(filter.ingkel, item.ingkel())) {
                return null;
            }
            if (!check(filter.jejepan, item.jejepan())) {
                return null;
            }
            if (!check(filter.watekAlit, item.watekAlit())) {
                return null;
            }
            if (!check(filter.watekMadya, item.watekMadya())) {
                return null;
            }
            if (!check(filter.lintang, item.lintang())) {
                return null;
            }
            if (!check(filter.pancaSuda, item.pancaSuda())) {
                return null;
            }
            if (!check(filter.pararasan, item.pararasan())) {
                return null;
            }
            if (!check(filter.rakam, item.rakam())) {
                return null;
            }
            if (!check(filter.ekaJalaRsi, item.ekaJalaRsi())) {
                return null;
            }
            if (!check(filter.saka, item.saka())) {
                return null;
            }
            if (!check(filter.sasih, item.sasih())) {
                return null;
            }
            if (!check(filter.pratithiSamutPada, item.pratithiSamutPada())) {
                return null;
            }
            if (!checkSasihDay(filter.sasihDay, item.sasihDay())) {
                return null;
            }
            if (!checkSasihDayInfo(filter.sasihDayInfo, item.sasihDayInfo())) {
                return null;
            }
        }

        return item;
    }

    private static <I> boolean check(I expectation, I reality) {
        return (expectation != null) ? (expectation == reality) : true;
    }

    private static boolean checkSasihDay(List<Integer> expectation, List<Integer> reality) {
        if (expectation != null) {
            switch (expectation.size()) {
            case 1:
                if (reality.size() == 1) {
                    return (expectation.get(0) == reality.get(0));
                } else if (reality.size() == 2) {
                    return (expectation.get(0) == reality.get(0)) || (expectation.get(0) == reality.get(1));
                } else {
                    return false;
                }
            case 2:
                return (reality.size() == 2) ? expectation == reality : false;
            default:
                return false;
            }
        }

        return true;
    }

    private static boolean checkSasihDayInfo(SasihDayInfo expectation, SasihDayInfo reality) {
        if (expectation != null) {
            if (expectation == SasihDayInfo.PURNAMA || expectation == SasihDayInfo.TILEM) {
                return expectation == reality;
            } else {
                return expectation == reality.reference();
            }
        }

        return true;
    }

    static String titleCase(final String text) {
        char[] arr = text.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '_') {
                arr[i] = ' ';
            } else if (arr[i] >= 'A' && arr[i] <= 'Z' && arr[i - 1] != ' ') {
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }

}
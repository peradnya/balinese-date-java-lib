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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Utility class to support BalineseDate library
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public final class BalineseDateUtil {

    /**
     * Filter class for BalineseDateUtil class.
     * 
     * @author Ida Bagus Putu Peradnya Dinata
     */
    public static final class Filter {
        public BalineseDateConst.Ekawara            ekawara             = null;
        public BalineseDateConst.Dwiwara            dwiwara             = null;
        public BalineseDateConst.Triwara            triwara             = null;
        public BalineseDateConst.Caturwara          caturwara           = null;
        public BalineseDateConst.Pancawara          pancawara           = null;
        public BalineseDateConst.Sadwara            sadwara             = null;
        public BalineseDateConst.Saptawara          saptawara           = null;
        public BalineseDateConst.Astawara           astawara            = null;
        public BalineseDateConst.Sangawara          sangawara           = null;
        public BalineseDateConst.Dasawara           dasawara            = null;

        public BalineseDateConst.Ingkel             ingkel              = null;
        public BalineseDateConst.Jejapan            jejapan             = null;
        public BalineseDateConst.PawatekanAlit      watekAlit           = null;
        public BalineseDateConst.PawatekanMadya     watekMadya          = null;
        public BalineseDateConst.Lintang            lintang             = null;
        public BalineseDateConst.Pancasuda          pancasuda           = null;
        public BalineseDateConst.Pararasan          pararasan           = null;
        public BalineseDateConst.Rakam              rakam               = null;
        public BalineseDateConst.EkaJalaRsi         ekaJalaRsi          = null;

        public BalineseDateConst.Wuku               wuku                = null;

        public BalineseDateConst.Sasih              sasih               = null;
        public BalineseDateConst.SasihDayInfo       sasihDayInfo        = null;
        public int[]                                sasihDay            = null;
        public Integer                              saka                = null;
        public BalineseDateConst.PratithiSamutPada  pratithiSamutPada   = null;
    }

    private static final String NULL_CALENDAR = "Calendar value must not null.";    

    private static <I> boolean check(I filter, I date) {
        return (filter != null) ? (filter != date) : false;
    }

    private static boolean checkIntArr(int[] filter, int[] date) {
        if (filter != null) {
            if (filter.length == 1) {
                for (int y : date) {
                    if (filter[0] == y) { return false; }
                }
            } else if (filter.length == 2 && date.length == 2) {
                return !(filter[0] == date[0] && filter[1] == date[1]);
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkSasihDayInfo(
        BalineseDateConst.SasihDayInfo filter,
        BalineseDateConst.SasihDayInfo date) {

        if (filter != null) {
            if (filter == BalineseDateConst.SasihDayInfo.PURNAMA || 
                filter == BalineseDateConst.SasihDayInfo.TILEM) {

                return filter != date;
            } else {
                return filter.getGroup() != date.getGroup();
            }
        } else {
            return false;
        }
    }

    /**
     * Get BalineseDates that match with given filters and gregorian dates.
     * 
     * @param filter the filters for balinese date search (null similar to no filter).
     * @param start the start date of search (not null).
     * @param finish the end date of search (not null).
     * 
     * @return array of BalineseDate that matched with given filters and gregorian dates.
     * 
     * @see Filter
     * @see java.util.GregorianCalendar
     */
    public static BalineseDate[] getBalineseDateByDateRange(
        Filter filter, 
        GregorianCalendar start, 
        GregorianCalendar finish) {

        if (start == null || finish == null) { throw new IllegalArgumentException(NULL_CALENDAR); }

        LinkedList<BalineseDate> list = new LinkedList<BalineseDate>();

        GregorianCalendar now = null;
        for (now = (GregorianCalendar) start.clone(); now.compareTo(finish) <= 0; now.add(Calendar.DATE, 1)) {
            BalineseDate date           = new BalineseDate(now);
            BalineseDatePawukon pawukon = date.getPawukon();

            if (filter != null) {

                if (check(filter.ekawara, pawukon.getEkawara()))                    { continue; }
                if (check(filter.dwiwara, pawukon.getDwiwara()))                    { continue; }
                if (check(filter.triwara, pawukon.getTriwara()))                    { continue; }
                if (check(filter.caturwara, pawukon.getCaturwara()))                { continue; }
                if (check(filter.pancawara, pawukon.getPancawara()))                { continue; }
                if (check(filter.sadwara, pawukon.getSadwara()))                    { continue; }
                if (check(filter.saptawara, pawukon.getSaptawara()))                { continue; }
                if (check(filter.astawara, pawukon.getAstawara()))                  { continue; }
                if (check(filter.sangawara, pawukon.getSangawara()))                { continue; }
                if (check(filter.dasawara, pawukon.getDasawara()))                  { continue; }

                if (check(filter.ingkel, pawukon.getIngkel()))                      { continue; }
                if (check(filter.jejapan, pawukon.getJejapan()))                    { continue; }
                if (check(filter.watekAlit, pawukon.getWatekAlit()))                { continue; }
                if (check(filter.watekMadya, pawukon.getWatekMadya()))              { continue; }
                if (check(filter.lintang, pawukon.getLintang()))                    { continue; }
                if (check(filter.pancasuda, pawukon.getPancasuda()))                { continue; }
                if (check(filter.pararasan, pawukon.getPararasan()))                { continue; }
                if (check(filter.rakam, pawukon.getRakam()))                        { continue; }
                if (check(filter.ekaJalaRsi, pawukon.getEkaJalaRsi()))              { continue; }

                if (check(filter.wuku, pawukon.getWuku()))                          { continue; }

                if (check(filter.sasih, date.getSasih()))                           { continue; }
                if (checkSasihDayInfo(filter.sasihDayInfo, date.getSasihDayInfo())) { continue; }
                if (checkIntArr(filter.sasihDay, date.getSasihDay()))               { continue; }
                if (check(filter.saka, date.getSaka()))                             { continue; }
                if (check(filter.pratithiSamutPada, date.getPratithiSamutPada()))   { continue; }
            }

            list.add(date);
        }

        BalineseDate[] result = new BalineseDate[list.size()];
        list.toArray(result);

        return result;
    }

}

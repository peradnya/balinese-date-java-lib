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

/**
 * Enum that represent Lintang in Balinese Saka Calendar. The details of Lintang
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/lintang.htm'>Lintang at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Lintang {
    /** Id: 0 */
    GAJAH,
    /** Id: 1 */
    KIRIMAN,
    /** Id: 2 */
    JUNG_SARAT,
    /** Id: 3 */
    ATIWA_TIWA,
    /** Id: 4 */
    SANGKA_TIKEL,
    /** Id: 5 */
    BUBU_BOLONG,
    /** Id: 6 */
    SUNGENGE,
    /** Id: 7 */
    ULUKU,
    /** Id: 8 */
    PEDATI,
    /** Id: 9 */
    KUDA,
    /** Id: 10 */
    GAJAH_MINA,
    /** Id: 11 */
    BADE,
    /** Id: 12 */
    MAGELUT,
    /** Id: 13 */
    PAGELANGAN,
    /** Id: 14 */
    KALA_SUNGSANG,
    /** Id: 15 */
    KUKUS,
    /** Id: 16 */
    ASU,
    /** Id: 17 */
    KARTIKA,
    /** Id: 18 */
    NAGA,
    /** Id: 19 */
    ANGSA_ANGREM,
    /** Id: 20 */
    PANAH,
    /** Id: 21 */
    PATREM,
    /** Id: 22 */
    LEMBU,
    /** Id: 23 */
    DEPAT,
    /** Id: 24 */
    TANGIS,
    /** Id: 25 */
    SALAH_UKUR,
    /** Id: 26 */
    PERAHU_PEGAT,
    /** Id: 27 */
    PUWUH_ATARUNG,
    /** Id: 28 */
    LAWEAN,
    /** Id: 29 */
    KELAPA,
    /** Id: 30 */
    YUYU,
    /** Id: 31 */
    LUMBUNG,
    /** Id: 32 */
    KUMBA,
    /** Id: 33 */
    UDANG,
    /** Id: 34 */
    BEGOONG;

    /**
     * Returns the id of Lintang.
     * 
     * @return the id of Lintang
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of Lintang name.
     * 
     * @return the Lintang name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
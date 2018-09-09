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
 * Enum that represent EkaJalaRsi in Balinese Saka Calendar. The details of
 * EkaJalaRsi available at: <u>Ardhana, I.B.S. (2005). "Pokok-Pokok Wariga".
 * Surabaya : Paramita.</u>
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum EkaJalaRsi {
    /** Id: 0 */
    BAGNA_MAPASAH,
    /** Id: 1 */
    BAHU_PUTRA,
    /** Id: 2 */
    BUAT_ASTAWA,
    /** Id: 3 */
    BUAT_KINGKING,
    /** Id: 4 */
    BUAT_LARA,
    /** Id: 5 */
    BUAT_MERANG,
    /** Id: 6 */
    BUAT_SEBET,
    /** Id: 7 */
    BUAT_SUKA,
    /** Id: 8 */
    DAHAT_KINGKING,
    /** Id: 9 */
    KAMERANAN,
    /** Id: 10 */
    KAMRTAAN,
    /** Id: 11 */
    KASOBAGIAN,
    /** Id: 12 */
    KINASIHAN_AMRTA,
    /** Id: 13 */
    KINASIHAN_JANA,
    /** Id: 14 */
    LANGGENG_KAYOHANAAN,
    /** Id: 15 */
    LUWIH_BAGIA,
    /** Id: 16 */
    MANGGIH_BAGIA,
    /** Id: 17 */
    MANGGIH_SUKA,
    /** Id: 18 */
    PATINING_AMRTA,
    /** Id: 19 */
    RAHAYU,
    /** Id: 20 */
    SIDHA_KASOBAGIAN,
    /** Id: 21 */
    SUBAGIA,
    /** Id: 22 */
    SUKA_KAPANGGIH,
    /** Id: 23 */
    SUKA_PINANGGIH,
    /** Id: 24 */
    SUKA_RAHAYU,
    /** Id: 25 */
    TININGGALING_SUKA,
    /** Id: 26 */
    WREDHI_PUTRA,
    /** Id: 27 */
    WREDHI_SARWA_MULE;

    /**
     * Returns the id of EkaJalaRsi.
     * 
     * @return the id of EkaJalaRsi
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of EkaJalaRsi name.
     * 
     * @return the EkaJalaRsi name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
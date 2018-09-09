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
 * Enum that represent Pararasan in Balinese Saka Calendar. The details of
 * Pararasan available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/paarasan.htm'>Pararasan at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Pararasan {
    /** Id: 0 */
    LAKU_PANDITA_SAKTI,
    /** Id: 1 */
    ARAS_TUDING,
    /** Id: 2 */
    ARAS_KEMBANG,
    /** Id: 3 */
    LAKU_BINTANG,
    /** Id: 4 */
    LAKU_BULAN,
    /** Id: 5 */
    LAKU_SURYA,
    /** Id: 6 */
    LAKU_AIR,
    /** Id: 7 */
    LAKU_BUMI,
    /** Id: 8 */
    LAKU_API,
    /** Id: 9 */
    LAKU_ANGIN;

    /**
     * Returns the id of Pararasan.
     * 
     * @return the id of Pararasan
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of Pararasan name.
     * 
     * @return the Pararasan name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
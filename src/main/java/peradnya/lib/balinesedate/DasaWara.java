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
 * Enum that represent DasaWara in Balinese Saka Calendar. The details of
 * DasaWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/dasawara.htm'>DasaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum DasaWara {
    /** Id: 0, Urip: 5 */
    PANDITA(5),
    /** Id: 1, Urip: 7 */
    PATI(7),
    /** Id: 2, Urip: 10 */
    SUKA(10),
    /** Id: 3, Urip: 4 */
    DUKA(4),
    /** Id: 4, Urip: 6 */
    SRI(6),
    /** Id: 5, Urip: 2 */
    MANUH(2),
    /** Id: 6, Urip: 3 */
    MANUSA(3),
    /** Id: 7, Urip: 8 */
    RAJA(8),
    /** Id: 8, Urip: 9 */
    DEWA(9),
    /** Id: 9, Urip: 1 */
    RAKSASA(1);

    private final int urip;

    private DasaWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of DasaWara.
     * 
     * @return the id of DasaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of DasaWara.
     * 
     * @return the urip of DasaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of DasaWara name.
     * 
     * @return thw DasaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
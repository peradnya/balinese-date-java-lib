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
 * Enum that represent AstaWara in Balinese Saka Calendar. The details of
 * AstaWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/astawara.htm'>AstaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum AstaWara {
    /** Id: 0, Urip: 6 */
    SRI(6),
    /** Id: 1, Urip: 5 */
    INDRA(5),
    /** Id: 2, Urip: 8 */
    GURU(8),
    /** Id: 3, Urip: 9 */
    YAMA(9),
    /** Id: 4, Urip: 3 */
    LUDRA(3),
    /** Id: 5, Urip: 7 */
    BRAHMA(7),
    /** Id: 6, Urip: 1 */
    KALA(1),
    /** Id: 7, Urip: 4 */
    UMA(4);

    private final int urip;

    private AstaWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of AstaWara.
     * 
     * @return the id of AstaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of AstaWara.
     * 
     * @return the urip of AstaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of AstaWara name.
     * 
     * @return the AstaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
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
 * Enum that represent SadWara in Balinese Saka Calendar. The details of SadWara
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/sadwara.htm'>SadWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum SadWara {
    /** Id: 0, Urip: 7 */
    TUNGLEH(7),
    /** Id: 1, Urip: 6 */
    ARYANG(6),
    /** Id: 2, Urip: 5 */
    URUKUNG(5),
    /** Id: 3, Urip: 8 */
    PANIRON(8),
    /** Id: 4, Urip: 9 */
    WAS(9),
    /** Id: 5, Urip: 3 */
    MAULU(3);

    private final int urip;

    private SadWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of SadWara.
     * 
     * @return the id of SadWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of SadWara.
     * 
     * @return the urip of SadWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of SadWara name.
     * 
     * @return the SadWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
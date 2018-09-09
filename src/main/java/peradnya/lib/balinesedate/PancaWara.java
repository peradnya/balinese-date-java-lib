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
 * Enum that represent PancaWara in Balinese Saka Calendar. The details of
 * PancaWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/pancawara.htm'>PancaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum PancaWara {
    /** Id: 0, Urip: 9, Kupih: 3 */
    PAING(9, 3),
    /** Id: 1, Urip: 7, Kupih: 4 */
    PON(7, 4),
    /** Id: 2, Urip: 4, Kupih: 5 */
    WAGE(4, 5),
    /** Id: 3, Urip: 8, Kupih: 1 */
    KLIWON(8, 1),
    /** Id: 4, Urip: 5, Kupih: 2 */
    UMANIS(5, 2);

    private final int urip;
    private final int kupih;

    private PancaWara(int urip, int kupih) {
        this.urip = urip;
        this.kupih = kupih;
    }

    /**
     * Returns the id of PancaWara.
     * 
     * @return the id of PancaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of PancaWara.
     * 
     * @return the urip of PancaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the kupih of PancaWara.
     * 
     * @return the kupih of PancaWara
     */
    public int kupih() {
        return this.kupih;
    }

    /**
     * Returns the TitleCase format of PancaWara name.
     * 
     * @return then PancaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
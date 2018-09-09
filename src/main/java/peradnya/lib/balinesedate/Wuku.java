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
 * Enum that represent Wuku in Balinese Saka Calendar. The details of Wuku
 * available at:
 * <a target='_blank' href= 'http://www.babadbali.com/pewarigaan/wuku.htm'>Wuku
 * at babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Wuku {
    /** Id: 0, Urip: 7 */
    SINTA(7),
    /** Id: 1, Urip: 1 */
    LANDEP(1),
    /** Id: 2, Urip: 4 */
    UKIR(4),
    /** Id: 3, Urip: 6 */
    KULANTIR(6),
    /** Id: 4, Urip: 5 */
    TOLU(5),
    /** Id: 5, Urip: 8 */
    GUMBREG(8),
    /** Id: 6, Urip: 9 */
    WARIGA(9),
    /** Id: 7, Urip: 3 */
    WARIGADEAN(3),
    /** Id: 8, Urip: 7 */
    JULUNGWANGI(7),
    /** Id: 9, Urip: 1 */
    SUNGSANG(1),
    /** Id: 10, Urip: 4 */
    DUNGULAN(4),
    /** Id: 11, Urip: 6 */
    KUNINGAN(6),
    /** Id: 12, Urip: 5 */
    LANGKIR(5),
    /** Id: 13, Urip: 8 */
    MEDANGSIA(8),
    /** Id: 14, Urip: 9 */
    PUJUD(9),
    /** Id: 15, Urip: 3 */
    PAHANG(3),
    /** Id: 16, Urip: 7 */
    KRULUT(7),
    /** Id: 17, Urip: 1 */
    MERAKIH(1),
    /** Id: 18, Urip: 4 */
    TAMBIR(4),
    /** Id: 19, Urip: 6 */
    MEDANGKUNGAN(6),
    /** Id: 20, Urip: 5 */
    MATAL(5),
    /** Id: 21, Urip: 8 */
    UYE(8),
    /** Id: 22, Urip: 9 */
    MENAIL(9),
    /** Id: 23, Urip: 3 */
    PRANGBAKAT(3),
    /** Id: 24, Urip: 7 */
    BALA(7),
    /** Id: 25, Urip: 1 */
    UGU(1),
    /** Id: 26, Urip: 4 */
    WAYANG(4),
    /** Id: 27, Urip: 6 */
    KLAWU(6),
    /** Id: 28, Urip: 5 */
    DUKUT(5),
    /** Id: 29, Urip: 8 */
    WATUGUNUNG(8);

    private final int urip;

    private Wuku(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of Wuku.
     * 
     * @return the id of Wuku
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of Wuku.
     * 
     * @return the urip of Wuku
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of Wuku name.
     * 
     * @return the Wuku name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
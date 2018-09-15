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
 * Enum that represent SaptaWara in Balinese Saka Calendar. The details of
 * SaptaWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/saptawara.htm'>SaptaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum SaptaWara {
    /** Id: 0, Urip: 5, KertaAji: 6, Kupih: 3 */
    REDITE(5, 6, 3),
    /** Id: 1, Urip: 4, KertaAji: 4, Kupih: 4 */
    SOMA(4, 4, 4),
    /** Id: 2, Urip: 3, KertaAji: 3, Kupih: 5 */
    ANGGARA(3, 3, 5),
    /** Id: 3, Urip: 7, KertaAji: 6, Kupih: 6 */
    BUDHA(7, 6, 6),
    /** Id: 4, Urip: 8, KertaAji: 5, Kupih: 7 */
    WRASPATI(8, 5, 7),
    /** Id: 5, Urip: 6, KertaAji: 7, Kupih: 1 */
    SUKRA(6, 7, 1),
    /** Id: 6, Urip: 9, KertaAji: 8, Kupih: 2 */
    SANISCARA(9, 8, 2);

    private final int urip;
    private final int kertaAji;
    private final int kupih;

    private SaptaWara(int urip, int kertaAji, int kupih) {
        this.urip = urip;
        this.kertaAji = kertaAji;
        this.kupih = kupih;
    }

    /**
     * Returns the id of SaptaWara.
     * 
     * @return the id of SaptaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of SaptaWara.
     * 
     * @return the urip of SaptaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the kertaAji of SaptaWara.
     * 
     * @return the kertaAji of SaptaWara
     */
    public int kertaAji() {
        return this.kertaAji;
    }

    /**
     * Returns the kupih of SaptaWara.
     * 
     * @return the kupih of SaptaWara
     */
    public int kupih() {
        return this.kupih;
    }

    /**
     * Returns the TitleCase format of SaptaWara name.
     * 
     * @return the SaptaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
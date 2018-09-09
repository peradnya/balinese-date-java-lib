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
 * Enum that represent SangaWara in Balinese Saka Calendar. The details of
 * SangaWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/sangawara.htm'>SangaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum SangaWara {
    /** Id: 0, Urip: 5 */
    DANGU(5),
    /** Id: 1, Urip: 8 */
    JANGUR(8),
    /** Id: 2, Urip: 9 */
    GIGIS(9),
    /** Id: 3, Urip: 3 */
    NOHAN(3),
    /** Id: 4, Urip: 7 */
    OGAN(7),
    /** Id: 5, Urip: 1 */
    ERANGAN(1),
    /** Id: 6, Urip: 4 */
    URUNGAN(4),
    /** Id: 7, Urip: 6 */
    TULUS(6),
    /** Id: 8, Urip: 8 */
    DADI(8);

    private final int urip;

    private SangaWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of SangaWara.
     * 
     * @return the id of SangaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of SangaWara.
     * 
     * @return the urip of SangaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of SangaWara name.
     * 
     * @return the SangaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
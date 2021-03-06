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
 * Enum that represent Ingkel in Balinese Saka Calendar. The details of Ingkel
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/ingkel.htm'>Ingkel at babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Ingkel {
    /** Id: 0 */
    WONG,
    /** Id: 1 */
    SATO,
    /** Id: 2 */
    MINA,
    /** Id: 3 */
    MANUK,
    /** Id: 4 */
    TARU,
    /** Id: 5 */
    BUKU;

    /**
     * Returns the id of Ingkel.
     * 
     * @return the id of Ingkel
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of Ingkel name.
     * 
     * @return the Ingkel name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
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
 * Enum that represent Jejepan in Balinese Saka Calendar. The details of Jejepan
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/jejepan.htm'>Jejepan at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Jejepan {
    /** Id: 0 */
    MINA,
    /** Id: 1 */
    TARU,
    /** Id: 2 */
    SATO,
    /** Id: 3 */
    PATRA,
    /** Id: 4 */
    WONG,
    /** Id: 5 */
    PAKSI;

    /**
     * Returns the id of Jejepan.
     * 
     * @return the id of Jejepan
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of Jejepan name.
     * 
     * @return the Jejepan name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
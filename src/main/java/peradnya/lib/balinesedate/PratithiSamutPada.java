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
 * Enum that represent PratithiSamutPada in Balinese Saka Calendar. The details
 * of PratithiSamutPada available at: <u>Ardhana, I.B.S. (2005). "Pokok-Pokok
 * Wariga". Surabaya : Paramita.</u>
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum PratithiSamutPada {
    /** Id: 0 */
    TRESNA,
    /** Id: 1 */
    UPADANA,
    /** Id: 2 */
    BHAWA,
    /** Id: 3 */
    JATI,
    /** Id: 4 */
    JARAMARANA,
    /** Id: 5 */
    AWIDYA,
    /** Id: 6 */
    SASKARA,
    /** Id: 7 */
    WIDNYANA,
    /** Id: 8 */
    NAMARUPA,
    /** Id: 9 */
    SADAYATANA,
    /** Id: 10 */
    SEPARSA,
    /** Id: 11 */
    WEDANA;

    /**
     * Returns the id of PratithiSamutPada.
     * 
     * @return the id of PratithiSamutPada
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of PratithiSamutPada name.
     * 
     * @return the PratithiSamutPada name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
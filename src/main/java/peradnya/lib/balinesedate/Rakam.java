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
 * Enum that represent Rakam in Balinese Saka Calendar. The details of Rakam
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/rakam.htm'>Rakam at babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Rakam {
    /** Id: 0 */
    NUJU_PATI,
    /** Id: 1 */
    KALA_TINANTANG,
    /** Id: 2 */
    DEMANG_KANDHURUWAN,
    /** Id: 3 */
    SANGGAR_WARINGIN,
    /** Id: 4 */
    MANTRI_SINAROJA,
    /** Id: 5 */
    MACAN_KATAWAN;

    /**
     * Returns the id of Rakam.
     * 
     * @return the id of Rakam
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of Rakam name.
     * 
     * @return the Rakam name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
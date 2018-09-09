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
 * Enum that represent PancaSuda in Balinese Saka Calendar. The details of
 * PancaSuda available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/pancasuda.htm'>PancaSuda at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum PancaSuda {
    /** Id: 0 */
    LEBU_KATIUB_ANGIN,
    /** Id: 1 */
    WISESA_SEGARA,
    /** Id: 2 */
    TUNGGAK_SEMI,
    /** Id: 3 */
    SATRIA_WIBAWA,
    /** Id: 4 */
    SUMUR_SINABA,
    /** Id: 5 */
    SATRIA_WIRANG,
    /** Id: 6 */
    BUMI_KAPETAK;

    /**
     * Returns the id of PancaSuda.
     * 
     * @return the id of PancaSuda
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of PancaSuda name.
     * 
     * @return the PancaSuda name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
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
 * Enum that represent WatekAlit in Balinese Saka Calendar. The details of
 * WatekAlit available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/watek.htm'>WatekAlit at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum WatekAlit {
    /** Id: 0 */
    LINTAH,
    /** Id: 1 */
    ULER,
    /** Id: 2 */
    GAJAH,
    /** Id: 3 */
    LEMBU;

    /**
     * Returns the id of WatekAlit.
     * 
     * @return the id of WatekAlit
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the TitleCase format of WatekAlit name.
     * 
     * @return the WatekAlit name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
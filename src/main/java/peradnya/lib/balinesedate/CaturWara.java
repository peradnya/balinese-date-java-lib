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
 * Enum that represent CaturWara in Balinese Saka Calendar. The details of
 * CaturWara available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/caturwara.htm'>CaturWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum CaturWara {
    /** Id: 0, Urip: 6 */
    SRI(6),
    /** Id: 1, Urip: 5 */
    LABA(5),
    /** Id: 2, Urip: 1 */
    JAYA(1),
    /** Id: 3, Urip: 8 */
    MENALA(8);

    private final int urip;

    private CaturWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of CaturWara.
     * 
     * @return the id of CaturWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of CaturWara.
     * 
     * @return the urip of CaturWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of CaturWara name.
     * 
     * @return the CaturWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
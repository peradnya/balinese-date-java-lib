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
 * Enum that represent DwiWara in Balinese Saka Calendar. The details of DwiWara
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/dwiwara.htm'>DwiWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum DwiWara {
    /** Id: 0, Urip: 5 */
    MENGA(5),
    /** Id: 1, Urip: 4 */
    PEPET(4);

    private final int urip;

    private DwiWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of DwiWara.
     * 
     * @return the id of DwiWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of DwiWara.
     * 
     * @return the urip of DwiWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of DwiWara name.
     * 
     * @return the DwiWara name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
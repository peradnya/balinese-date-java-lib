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
 * Enum that represent EkaWara in Balinese Saka Calendar. The details of EkaWara
 * available at: <a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/ekawara.htm'>EkaWara at
 * babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum EkaWara {
    /** Id: 0, Urip: 0 */
    VOID(0),
    /** Id: 1, Urip: 1 */
    LUANG(1);

    private final int urip;

    private EkaWara(int urip) {
        this.urip = urip;
    }

    /**
     * Returns the id of EkaWara.
     * 
     * @return the id of EkaWara
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the urip of EkaWara.
     * 
     * @return the urip of EkaWara
     */
    public int urip() {
        return this.urip;
    }

    /**
     * Returns the TitleCase format of EkaWara name. For VOID enum, this method
     * return the empty string.
     * 
     * @return the EkaWara name in TitleCase format
     */
    @Override
    public String toString() {
        return (this.id() == 0) ? "" : BalineseDateUtil.titleCase(this.name());
    }
}
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
 * Enum that represent SasihDayInfo in Balinese Saka Calendar. The details of
 * SasihDayInfo available at: <u>Ardhana, I.B.S. (2005). "Pokok-Pokok Wariga".
 * Surabaya : Paramita.</u>
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum SasihDayInfo {
    /** Penanggal: 1-14, Reference: PENANGGAL */
    PENANGGAL(0),
    /** Pangelong: 1-14, Reference: PANGELONG */
    PANGELONG(1),
    /** Penanggal: 15, Reference: PENANGGAL */
    PURNAMA(0),
    /** Pangelong: 15, Reference: PANGELONG */
    TILEM(1);

    private final int reference;

    private SasihDayInfo(int reference) {
        this.reference = reference;
    }

    /**
     * Returns the reference of SasihDayInfo. this method is useful to get reference
     * of PURNAMA and TILEM.
     * 
     * @return the reference of SasihDayInfo
     */
    public SasihDayInfo reference() {
        return SasihDayInfo.values()[this.reference];
    }

    /**
     * Returns the TitleCase format of SasihDayInfo name.
     * 
     * @return the SasihDayInfo name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
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
 * Enum that represent Sasih in Balinese Saka Calendar. The details of Sasih
 * available at: <u>Ardhana, I.B.S. (2005). "Pokok-Pokok Wariga". Surabaya :
 * Paramita.</u>
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 */
public enum Sasih {
    /** Id: 0, Normal Sasih, Reference: {@link KASA} */
    KASA(0),
    /** Id: 1, Normal Sasih, Reference: {@link KARO} */
    KARO(1),
    /** Id: 2, Normal Sasih, Reference: {@link KATIGA} */
    KATIGA(2),
    /** Id: 3, Normal Sasih, Reference: {@link KAPAT} */
    KAPAT(3),
    /** Id: 4, Normal Sasih, Reference: {@link KALIMA} */
    KALIMA(4),
    /** Id: 5, Normal Sasih, Reference: {@link KANEM} */
    KANEM(5),
    /** Id: 6, Normal Sasih, Reference: {@link KAPITU} */
    KAPITU(6),
    /** Id: 7, Normal Sasih, Reference: {@link KAWOLU} */
    KAWOLU(7),
    /** Id: 8, Normal Sasih, Reference: {@link KASANGA} */
    KASANGA(8),
    /** Id: 9, Normal Sasih, Reference: {@link KADASA} */
    KADASA(9),
    /** Id: 10, Normal Sasih, Reference: {@link DESTHA} */
    DESTHA(10),
    /** Id: 11, Normal Sasih, Reference: {@link SADHA} */
    SADHA(11),
    /** Id: 12, Mala Sasih, Reference: {@link DESTHA} */
    MALA_DESTHA(10),
    /** Id: 13, Mala Sasih, Reference: {@link SADHA} */
    MALA_SADHA(11),
    /** Id: 14, Mala Sasih, Reference: {@link DESTHA} */
    NAMPIH_DESTHA(10),
    /** Id: 15, Nampih Sasih, Reference: {@link KATIGA} */
    NAMPIH_KATIGA(2),
    /** Id: 16, Nampih Sasih, Reference: {@link KASA} */
    NAMPIH_KASA(0),
    /** Id: 17, Nampih Sasih, Reference: {@link KADASA} */
    NAMPIH_KADASA(9),
    /** Id: 18, Nampih Sasih, Reference: {@link KARO} */
    NAMPIH_KARO(1),
    /** Id: 19, Nampih Sasih, Reference: {@link SADHA} */
    NAMPIH_SADHA(11);

    private final int reference;

    private Sasih(int reference) {
        this.reference = reference;
    }

    /**
     * Returns the id of Sasih.
     * 
     * @return the id of Sasih
     */
    public int id() {
        return this.ordinal();
    }

    /**
     * Returns the reference of Sasih. This method is useful to get the normal
     * Sasih from mala/nampih Sasih.
     * 
     * @return the reference of Sasih
     */
    public Sasih reference() {
        return Sasih.values()[this.reference];
    }

    /**
     * Returns the TitleCase format of Sasih name.
     * 
     * @return the Sasih name in TitleCase format
     */
    @Override
    public String toString() {
        return BalineseDateUtil.titleCase(this.name());
    }
}
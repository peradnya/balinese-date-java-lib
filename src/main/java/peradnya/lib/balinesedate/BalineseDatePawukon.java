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

import java.io.Serializable;

/**
 * BalineseDatePawukon provides representation of Pawukon used by BalineseDate.
 * <p>
 * BalineseDatePawukon provides information about:
 * <ul>
 *  <li>Wuku (Sinta - Watugunung)</li>
 *  <li>Wewaran (Ekawara - Dasawara)</li>
 *  <li>Paringkelan (Ingkel, Jejapan, Watek Alit, Watek Madya, Lintang, Pancasuda, Pararasan, Rakam)</li>
 *  <li>Eka Jala Rsi</li>
 * </ul>
 * <p>
 * Calculation of pawukon that used by this class, is based on documentation from : 
 * <a href='http://www.babadbali.com/pewarigaan/paringkelan.htm'>babadbali.com</a>.
 * <p>
 * Calculation of Eka Jala Rsi that used by this class, is based on : 
 * Ardhana, I.B.S.(2005). "Pokok-Pokok Wariga". Surabaya : Paramita.
 * @author Ida Bagus Putu Peradnya Dinata
 */
public final class BalineseDatePawukon implements Serializable {

    private static final long serialVersionUID = 1002L;
    private static final String INVALID_DAY_IN_YEAR = "Invalid day in year value. Value need in between 0 - 209.";

    private static final BalineseDateConst.Wuku[]           lookupWuku       = BalineseDateConst.Wuku.values();
    private static final BalineseDateConst.Ekawara[]        lookupEkawara    = BalineseDateConst.Ekawara.values();
    private static final BalineseDateConst.Dwiwara[]        lookupDwiwara    = BalineseDateConst.Dwiwara.values();
    private static final BalineseDateConst.Triwara[]        lookupTriwara    = BalineseDateConst.Triwara.values();
    private static final BalineseDateConst.Caturwara[]      lookupCaturwara  = BalineseDateConst.Caturwara.values();
    private static final BalineseDateConst.Pancawara[]      lookupPancawara  = BalineseDateConst.Pancawara.values();
    private static final BalineseDateConst.Sadwara[]        lookupSadwara    = BalineseDateConst.Sadwara.values();
    private static final BalineseDateConst.Saptawara[]      lookupSaptawara  = BalineseDateConst.Saptawara.values();
    private static final BalineseDateConst.Astawara[]       lookupAstawara   = BalineseDateConst.Astawara.values();
    private static final BalineseDateConst.Sangawara[]      lookupSangawara  = BalineseDateConst.Sangawara.values();
    private static final BalineseDateConst.Dasawara[]       lookupDasawara   = BalineseDateConst.Dasawara.values();

    private static final BalineseDateConst.Ingkel[]         lookupIngkel     = BalineseDateConst.Ingkel.values();
    private static final BalineseDateConst.Jejapan[]        lookupJejapan    = BalineseDateConst.Jejapan.values();
    private static final BalineseDateConst.PawatekanAlit[]  lookupWatekAlit  = BalineseDateConst.PawatekanAlit.values();
    private static final BalineseDateConst.PawatekanMadya[] lookupWatekMadya = BalineseDateConst.PawatekanMadya.values();
    private static final BalineseDateConst.Lintang[]        lookupLintang    = BalineseDateConst.Lintang.values();
    private static final BalineseDateConst.Pancasuda[]      lookupPancasuda  = BalineseDateConst.Pancasuda.values();
    private static final BalineseDateConst.Pararasan[]      lookupPararasan  = BalineseDateConst.Pararasan.values();
    private static final BalineseDateConst.Rakam[]          lookupRakam      = BalineseDateConst.Rakam.values();

    // Lookup table for ekajalarsi
    private static final BalineseDateConst.EkaJalaRsi[]     lookupEJR        = BalineseDateConst.EkaJalaRsi.values();

    // mapping of ekajalarsi
    // source: Ardhana, I.B.S.(2005). "Pokok-Pokok Wariga". Surabaya : Paramita.
    private static final int ekaJalaRsiMap[] = new int[] {
        23,7,17,7,23,23,17,
        9,7,13,26,24,23,20,
        13,7,13,25,19,5,2,
        14,26,17,20,25,22,0,
        10,5,15,23,7,17,23,
        17,25,4,23,2,2,2,
        12,12,4,14,12,26,26,
        1,23,23,15,25,15,5,
        9,25,18,25,11,15,21,
        25,25,12,0,17,13,0,
        15,23,12,7,16,25,18,
        24,12,12,5,7,5,26,
        7,5,12,7,25,2,12,
        25,25,14,15,26,7,12,
        20,7,5,25,25,5,13,
        25,17,13,23,5,26,20,
        25,25,23,7,18,18,17,
        7,17,7,4,26,17,5,
        9,12,12,13,25,18,18,
        5,2,25,25,2,25,17,
        20,14,27,23,17,8,25,
        17,5,17,7,6,15,18,
        25,2,7,13,25,20,7,
        15,15,23,7,8,24,2,
        12,9,24,24,17,24,20,
        7,12,12,14,18,25,20,
        4,18,4,20,26,12,23,
        18,17,17,25,15,2,24,
        3,2,23,25,18,25,20,
        14,3,2,25,7,25,17
    };

    private final int pawukonDay;
    private final int urip;

    private final BalineseDateConst.Wuku            wuku;

    private final BalineseDateConst.Ekawara         ekawara;
    private final BalineseDateConst.Dwiwara         dwiwara;
    private final BalineseDateConst.Triwara         triwara;
    private final BalineseDateConst.Caturwara       caturwara;
    private final BalineseDateConst.Pancawara       pancawara;
    private final BalineseDateConst.Sadwara         sadwara;
    private final BalineseDateConst.Saptawara       saptawara;
    private final BalineseDateConst.Astawara        astawara;
    private final BalineseDateConst.Sangawara       sangawara;
    private final BalineseDateConst.Dasawara        dasawara;

    private final BalineseDateConst.Ingkel          ingkel;
    private final BalineseDateConst.Jejapan         jejapan;
    private final BalineseDateConst.PawatekanAlit   watekAlit;
    private final BalineseDateConst.PawatekanMadya  watekMadya;
    private final BalineseDateConst.Lintang         lintang;
    private final BalineseDateConst.Pancasuda       pancasuda;
    private final BalineseDateConst.Pararasan       pararasan;
    private final BalineseDateConst.Rakam           rakam;

    private final BalineseDateConst.EkaJalaRsi      ekaJalaRsi;

    /**
     * Construct balinese pawukon.
     * 
     * @param pawukonDay number of day in 1 year (cycle) of pawukon. 
     *                   Number is from 0 (Redite Sinta) to 209 (Saniscara Watugunung).
     */
    public BalineseDatePawukon(int pawukonDay) {
        if (pawukonDay >= BalineseDateConst.DAYS_IN_YEAR_PAWUKON || pawukonDay < 0) { 
            throw new IllegalArgumentException(INVALID_DAY_IN_YEAR);
        }

        this.pawukonDay  = pawukonDay;
        wuku       = lookupWuku         [this.pawukonDay / 7];

        triwara    = lookupTriwara      [this.pawukonDay % 3];
        pancawara  = lookupPancawara    [this.pawukonDay % 5];
        sadwara    = lookupSadwara      [this.pawukonDay % 6];
        saptawara  = lookupSaptawara    [this.pawukonDay % 7];

        urip       = pancawara.getUrip() + saptawara.getUrip();
        ekawara    = lookupEkawara      [urip % 2];
        dwiwara    = lookupDwiwara      [urip % 2];
        dasawara   = lookupDasawara     [urip % 10];

        caturwara  = lookupCaturwara    [calcCaturwaraIdx(this.pawukonDay)];
        astawara   = lookupAstawara     [calcAstawaraIdx(this.pawukonDay)];
        sangawara  = lookupSangawara    [calcSangawaraIdx(this.pawukonDay)];

        ingkel     = lookupIngkel       [wuku.getId() % 6];
        jejapan    = lookupJejapan      [this.pawukonDay % 6];
        lintang    = lookupLintang      [this.pawukonDay % 35];

        watekAlit  = lookupWatekAlit    [urip % 4];
        watekMadya = lookupWatekMadya   [urip % 5];
        pararasan  = lookupPararasan    [urip % 10];
        
        pancasuda  = lookupPancasuda    [(saptawara.getKertaAji() + pancawara.getUrip()) % 7];
        rakam      = lookupRakam        [(saptawara.getKupih() + pancawara.getKupih()) % 6];

        ekaJalaRsi = lookupEJR          [ekaJalaRsiMap[this.pawukonDay]];
    }

    /**
     * Get number of day in 1 year (cycle) of pawukon.
     * 
     * @return number of day in 1 year (cycle) of pawukon. 
     *         Number is from 0 (Redite Sinta) to 209 (Saniscara Watugunung).
     */
    public int getPawukonDay() {
        return pawukonDay;
    }

    /**
     * Get Wuku.
     * 
     * @return the wuku
     */
    public BalineseDateConst.Wuku getWuku() {
        return wuku;
    }

    /**
     * Get Ekawara.
     * 
     * @return the ekawara
     */
    public BalineseDateConst.Ekawara getEkawara() {
        return ekawara;
    }

    /**
     * Get Dwiwara.
     * 
     * @return the dwiwara
     */
    public BalineseDateConst.Dwiwara getDwiwara() {
        return dwiwara;
    }

    /**
     * Get Triwara.
     * 
     * @return the triwara
     */
    public BalineseDateConst.Triwara getTriwara() {
        return triwara;
    }

    /**
     * Get Caturwara.
     * 
     * @return the caturwara
     */
    public BalineseDateConst.Caturwara getCaturwara() {
        return caturwara;
    }

    /**
     * Get Pancawara.
     * 
     * @return the pancawara
     */
    public BalineseDateConst.Pancawara getPancawara() {
        return pancawara;
    }

    /**
     * Get Sadwara.
     * 
     * @return the sadwara
     */
    public BalineseDateConst.Sadwara getSadwara() {
        return sadwara;
    }

    /**
     * Get Saptawara.
     * 
     * @return the saptawara
     */
    public BalineseDateConst.Saptawara getSaptawara() {
        return saptawara;
    }

    /**
     * Get Astawara.
     * 
     * @return the astawara
     */
    public BalineseDateConst.Astawara getAstawara() {
        return astawara;
    }

    /**
     * Get Sangawara.
     * 
     * @return the sangawara
     */
    public BalineseDateConst.Sangawara getSangawara() {
        return sangawara;
    }

    /**
     * Get Dasawara.
     * 
     * @return the dasawara
     */
    public BalineseDateConst.Dasawara getDasawara() {
        return dasawara;
    }

    /**
     * Get Ingkel.
     * 
     * @return the ingkel
     */
    public BalineseDateConst.Ingkel getIngkel() {
        return ingkel;
    }

    /**
     * Get Jejapan.
     * 
     * @return the jejapan
     */
    public BalineseDateConst.Jejapan getJejapan() {
        return jejapan;
    }

    /**
     * Get Pawatekan Alit.
     * 
     * @return the watek alit
     */
    public BalineseDateConst.PawatekanAlit getWatekAlit() {
        return watekAlit;
    }

    /**
     * Get Pewatekan Madya.
     * 
     * @return the watek madya
     */
    public BalineseDateConst.PawatekanMadya getWatekMadya() {
        return watekMadya;
    }

    /**
     * Get Lintang.
     * 
     * @return the lintang
     */
    public BalineseDateConst.Lintang getLintang() {
        return lintang;
    }

    /**
     * Get Pancasuda.
     * 
     * @return the pancasuda
     */
    public BalineseDateConst.Pancasuda getPancasuda() {
        return pancasuda;
    }

    /**
     * Get Pararasan.
     * 
     * @return the pararasan
     */
    public BalineseDateConst.Pararasan getPararasan() {
        return pararasan;
    }

    /**
     * Get Rakam.
     * 
     * @return the rakam
     */
    public BalineseDateConst.Rakam getRakam() {
        return rakam;
    }

    /**
     * Get Eka Jala Rsi.
     * 
     * @return the eka jala rsi
     */
    public BalineseDateConst.EkaJalaRsi getEkaJalaRsi() {
        return ekaJalaRsi;
    }

    /**
     * Get the sum of Urip Pancawara and Urip Saptawara.
     * 
     * @return the sum of urip pancawara and urip saptawara
     */
    public int getUrip() {
        return urip;
    }

    @Override
    public String toString() {
        return saptawara.getName() + " " + pancawara.getName() + ", Wuku " + wuku.getName();
    }

    private static int calcCaturwaraIdx(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 70) {
            idx = pawukonDay % 4;
        } else if (pawukonDay == 71 || pawukonDay == 72) {
            idx = BalineseDateConst.Caturwara.JAYA.getId();
        } else {
            idx = (pawukonDay - 2) % 4;
        }

        return idx;
    }

    private static int calcAstawaraIdx(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 70) {
            idx = pawukonDay % 8;
        } else if (pawukonDay == 71 || pawukonDay == 72) {
            idx = BalineseDateConst.Astawara.KALA.getId();
        } else {
            idx = (pawukonDay - 2) % 8;
        }

        return idx;
    }

    private static int calcSangawaraIdx(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 3) {
            idx = BalineseDateConst.Sangawara.DANGU.getId();
        } else {
            idx = (pawukonDay - 3) % 9;
        }

        return idx;
    }

}
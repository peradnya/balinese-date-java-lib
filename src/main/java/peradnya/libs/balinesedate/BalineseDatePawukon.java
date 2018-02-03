package peradnya.libs.balinesedate;

import java.io.Serializable;

/**
 * BalineseDatePawukon provides representation of Pawukon used by BalineseDate.
 * <p>
 * BalineseDatePawukon provides information about:
 * <ul>
 *  <li>Wuku (Sinta - Watugunung)</li>
 *  <li>Wewaran (Ekawara - Dasawara)</li>
 *  <li>Paringkelan (Ingkel, Jejapan, Watek, Lintang, Pancasuda, Pararasan, Rakam)</li>
 * </ul>
 * <p>
 * Calculation of pawukon that used by this class, is based on documentation from 
 * <a href='http://www.babadbali.com/pewarigaan/paringkelan.htm'>babadbali.com</a>.
 * 
 * @author Ida Bagus Putu Peradnya Dinata
 * @version 0.1.0-beta
 * @since 0.1.0-beta
 */
public final class BalineseDatePawukon implements Serializable, Cloneable {

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


    private final int dayInYear;
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

    /**
     * Construct balinese pawukon.
     * 
     * @param pawukonDayInYear number of day in 1 year (cycle) of pawukon. 
     *                         Number is from 0 (Redite Sinta) to 209 (Saniscara Watugunung).
     */
    public BalineseDatePawukon(int pawukonDayInYear) {
        if (pawukonDayInYear >= BalineseDateConst.DAYS_IN_YEAR_PAWUKON || pawukonDayInYear < 0) { 
            throw new IllegalArgumentException(INVALID_DAY_IN_YEAR);
        }

        dayInYear  = pawukonDayInYear;
        wuku       = lookupWuku         [dayInYear / 7];

        triwara    = lookupTriwara      [dayInYear % 3];
        pancawara  = lookupPancawara    [dayInYear % 5];
        sadwara    = lookupSadwara      [dayInYear % 6];
        saptawara  = lookupSaptawara    [dayInYear % 7];

        urip       = pancawara.getUrip() + saptawara.getUrip();
        ekawara    = lookupEkawara      [urip % 2];
        dwiwara    = lookupDwiwara      [urip % 2];
        dasawara   = lookupDasawara     [urip % 10];

        caturwara  = lookupCaturwara    [calcCaturwaraIdx(dayInYear)];
        astawara   = lookupAstawara     [calcAstawaraIdx(dayInYear)];
        sangawara  = lookupSangawara    [calcSangawaraIdx(dayInYear)];

        ingkel     = lookupIngkel       [wuku.getId() % 6];
        jejapan    = lookupJejapan      [dayInYear % 6];
        lintang    = lookupLintang      [dayInYear % 35];

        watekAlit  = lookupWatekAlit    [urip % 4];
        watekMadya = lookupWatekMadya   [urip % 5];
        pararasan  = lookupPararasan    [urip % 10];
        
        pancasuda  = lookupPancasuda    [(saptawara.getKertaAji() + pancawara.getUrip()) % 7];
        rakam      = lookupRakam        [(saptawara.getKupih() + pancawara.getKupih()) % 6];
    }

    /**
     * Get number of day in 1 year (cycle) of pawukon.
     * 
     * @return number of day in 1 year (cycle) of pawukon. 
     *         Number is from 0 (Redite Sinta) to 209 (Saniscara Watugunung).
     */
    public int getPawukonDayInYear() {
        return dayInYear;
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
     * Get sum of urip pancawara and urip saptawara.
     * 
     * @return the sum of urip pancawara and urip saptawara
     */
    public int GetUrip() {
        return urip;
    }

    @Override
    public Object clone() {
        return new BalineseDatePawukon(getPawukonDayInYear());
    }

    @Override
    public boolean equals(Object obj) {
        BalineseDatePawukon that = (BalineseDatePawukon) obj;
        return getPawukonDayInYear() == that.getPawukonDayInYear();
    }

    @Override
    public String toString() {
        return "";
    }

    private static int calcCaturwaraIdx(int pawukonDayInYear) {
        int idx = 0;
        if (pawukonDayInYear <= 70) {
            idx = pawukonDayInYear % 4;
        } else if (pawukonDayInYear == 71 || pawukonDayInYear == 72) {
            idx = BalineseDateConst.Caturwara.JAYA.getId();
        } else {
            idx = (pawukonDayInYear - 2) % 4;
        }

        return idx;
    }

    private static int calcAstawaraIdx(int pawukonDayInYear) {
        int idx = 0;
        if (pawukonDayInYear <= 70) {
            idx = pawukonDayInYear % 8;
        } else if (pawukonDayInYear == 71 || pawukonDayInYear == 72) {
            idx = BalineseDateConst.Astawara.KALA.getId();
        } else {
            idx = (pawukonDayInYear - 2) % 8;
        }

        return idx;
    }

    private static int calcSangawaraIdx(int pawukonDayInYear) {
        int idx = 0;
        if (pawukonDayInYear <= 3) {
            idx = BalineseDateConst.Sangawara.DANGU.getId();
        } else {
            idx = (pawukonDayInYear - 3) % 9;
        }

        return idx;
    }

}
package net.peradnya.balinesedate;

import java.io.Serializable;

public final class BalinesePawukon implements Serializable, Cloneable {

    private static final long serialVersionUID = 1002L;
    private static final String INVALID_DAY_IN_YEAR = "Invalid day in year value. Value need in between 0 - 209.";

    private static final Constants.Wuku[]           lookupWuku       = Constants.Wuku.values();
    private static final Constants.Ekawara[]        lookupEkawara    = Constants.Ekawara.values();
    private static final Constants.Dwiwara[]        lookupDwiwara    = Constants.Dwiwara.values();
    private static final Constants.Triwara[]        lookupTriwara    = Constants.Triwara.values();
    private static final Constants.Caturwara[]      lookupCaturwara  = Constants.Caturwara.values();
    private static final Constants.Pancawara[]      lookupPancawara  = Constants.Pancawara.values();
    private static final Constants.Sadwara[]        lookupSadwara    = Constants.Sadwara.values();
    private static final Constants.Saptawara[]      lookupSaptawara  = Constants.Saptawara.values();
    private static final Constants.Astawara[]       lookupAstawara   = Constants.Astawara.values();
    private static final Constants.Sangawara[]      lookupSangawara  = Constants.Sangawara.values();
    private static final Constants.Dasawara[]       lookupDasawara   = Constants.Dasawara.values();

    private static final Constants.Ingkel[]         lookupIngkel     = Constants.Ingkel.values();
    private static final Constants.Jejapan[]        lookupJejapan    = Constants.Jejapan.values();
    private static final Constants.PawatekanAlit[]  lookupWatekAlit  = Constants.PawatekanAlit.values();
    private static final Constants.PawatekanMadya[] lookupWatekMadya = Constants.PawatekanMadya.values();
    private static final Constants.Lintang[]        lookupLintang    = Constants.Lintang.values();
    private static final Constants.Pancasuda[]      lookupPancasuda  = Constants.Pancasuda.values();
    private static final Constants.Pararasan[]      lookupPararasan  = Constants.Pararasan.values();
    private static final Constants.Rakam[]          lookupRakam      = Constants.Rakam.values();


    private final int dayInYear;
    private final int urip;

    private final Constants.Wuku            wuku;

    private final Constants.Ekawara         ekawara;
    private final Constants.Dwiwara         dwiwara;
    private final Constants.Triwara         triwara;
    private final Constants.Caturwara       caturwara;
    private final Constants.Pancawara       pancawara;
    private final Constants.Sadwara         sadwara;
    private final Constants.Saptawara       saptawara;
    private final Constants.Astawara        astawara;
    private final Constants.Sangawara       sangawara;
    private final Constants.Dasawara        dasawara;

    private final Constants.Ingkel          ingkel;
    private final Constants.Jejapan         jejapan;
    private final Constants.PawatekanAlit   watekAlit;
    private final Constants.PawatekanMadya  watekMadya;
    private final Constants.Lintang         lintang;
    private final Constants.Pancasuda       pancasuda;
    private final Constants.Pararasan       pararasan;
    private final Constants.Rakam           rakam;

    public BalinesePawukon(int pawukonDayInYear) {
        if (pawukonDayInYear >= Constants.DAYS_IN_YEAR_PAWUKON || pawukonDayInYear < 0) { 
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

    public int getPawukonDayInYear() {
        return dayInYear;
    }

    public Constants.Wuku getWuku() {
        return wuku;
    }

    public Constants.Ekawara getEkawara() {
        return ekawara;
    }

    public Constants.Dwiwara getDwiwara() {
        return dwiwara;
    }

    public Constants.Triwara getTriwara() {
        return triwara;
    }

    public Constants.Caturwara getCaturwara() {
        return caturwara;
    }

    public Constants.Pancawara getPancawara() {
        return pancawara;
    }

    public Constants.Sadwara getSadwara() {
        return sadwara;
    }

    public Constants.Saptawara getSaptawara() {
        return saptawara;
    }

    public Constants.Astawara getAstawara() {
        return astawara;
    }

    public Constants.Sangawara getSangawara() {
        return sangawara;
    }

    public Constants.Dasawara getDasawara() {
        return dasawara;
    }

    public Constants.Ingkel getIngkel() {
        return ingkel;
    }

    public Constants.Jejapan getJejapan() {
        return jejapan;
    }

    public Constants.PawatekanAlit getWatekAlit() {
        return watekAlit;
    }

    public Constants.PawatekanMadya getWatekMadya() {
        return watekMadya;
    }

    public Constants.Lintang getLintang() {
        return lintang;
    }

    public Constants.Pancasuda getPancasuda() {
        return pancasuda;
    }

    public Constants.Pararasan getPararasan() {
        return pararasan;
    }

    public Constants.Rakam getRakam() {
        return rakam;
    }

    public int GetUrip() {
        return urip;
    }

    @Override
    public Object clone() {
        return new BalinesePawukon(getPawukonDayInYear());
    }

    @Override
    public boolean equals(Object obj) {
        BalinesePawukon that = (BalinesePawukon) obj;
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
            idx = Constants.Caturwara.JAYA.getId();
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
            idx = Constants.Astawara.KALA.getId();
        } else {
            idx = (pawukonDayInYear - 2) % 8;
        }

        return idx;
    }

    private static int calcSangawaraIdx(int pawukonDayInYear) {
        int idx = 0;
        if (pawukonDayInYear <= 3) {
            idx = Constants.Sangawara.DANGU.getId();
        } else {
            idx = (pawukonDayInYear - 3) % 9;
        }

        return idx;
    }

}
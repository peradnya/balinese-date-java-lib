package peradnya.libs.balinesedate;

import java.io.Serializable;

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

    public int getPawukonDayInYear() {
        return dayInYear;
    }

    public BalineseDateConst.Wuku getWuku() {
        return wuku;
    }

    public BalineseDateConst.Ekawara getEkawara() {
        return ekawara;
    }

    public BalineseDateConst.Dwiwara getDwiwara() {
        return dwiwara;
    }

    public BalineseDateConst.Triwara getTriwara() {
        return triwara;
    }

    public BalineseDateConst.Caturwara getCaturwara() {
        return caturwara;
    }

    public BalineseDateConst.Pancawara getPancawara() {
        return pancawara;
    }

    public BalineseDateConst.Sadwara getSadwara() {
        return sadwara;
    }

    public BalineseDateConst.Saptawara getSaptawara() {
        return saptawara;
    }

    public BalineseDateConst.Astawara getAstawara() {
        return astawara;
    }

    public BalineseDateConst.Sangawara getSangawara() {
        return sangawara;
    }

    public BalineseDateConst.Dasawara getDasawara() {
        return dasawara;
    }

    public BalineseDateConst.Ingkel getIngkel() {
        return ingkel;
    }

    public BalineseDateConst.Jejapan getJejapan() {
        return jejapan;
    }

    public BalineseDateConst.PawatekanAlit getWatekAlit() {
        return watekAlit;
    }

    public BalineseDateConst.PawatekanMadya getWatekMadya() {
        return watekMadya;
    }

    public BalineseDateConst.Lintang getLintang() {
        return lintang;
    }

    public BalineseDateConst.Pancasuda getPancasuda() {
        return pancasuda;
    }

    public BalineseDateConst.Pararasan getPararasan() {
        return pararasan;
    }

    public BalineseDateConst.Rakam getRakam() {
        return rakam;
    }

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
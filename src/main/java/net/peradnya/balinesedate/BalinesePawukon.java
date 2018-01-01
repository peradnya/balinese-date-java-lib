package net.peradnya.balinesedate;

import java.io.Serializable;

public class BalinesePawukon implements Serializable, Cloneable {

    private static final long serialVersionUID = 1002L;

    private static final Constants.Wuku[]      lookupWuku       = Constants.Wuku.values();
    private static final Constants.Ekawara[]   lookupEkawara    = Constants.Ekawara.values();
    private static final Constants.Dwiwara[]   lookupDwiwara    = Constants.Dwiwara.values();
    private static final Constants.Triwara[]   lookupTriwara    = Constants.Triwara.values();
    private static final Constants.Caturwara[] lookupCaturwara  = Constants.Caturwara.values();
    private static final Constants.Pancawara[] lookupPancawara  = Constants.Pancawara.values();
    private static final Constants.Sadwara[]   lookupSadwara    = Constants.Sadwara.values();
    private static final Constants.Saptawara[] lookupSaptawara  = Constants.Saptawara.values();
    private static final Constants.Astawara[]  lookupAstawara   = Constants.Astawara.values();
    private static final Constants.Sangawara[] lookupSangawara  = Constants.Sangawara.values();
    private static final Constants.Dasawara[]  lookupDasawara   = Constants.Dasawara.values();

    private static final Constants.Ingkel[]         lookupIngkel     = Constants.Ingkel.values();
    private static final Constants.Jejapan[]        lookupJejapan    = Constants.Jejapan.values();
    private static final Constants.PawatekanAlit[]  lookupWatekAlit  = Constants.PawatekanAlit.values();
    private static final Constants.PawatekanMadya[] lookupWatekMadya = Constants.PawatekanMadya.values();
    private static final Constants.Lintang[]        lookupLintang    = Constants.Lintang.values();
    private static final Constants.Pancasuda[]      lookupPancasuda  = Constants.Pancasuda.values();
    private static final Constants.Pararasan[]      lookupPararasan  = Constants.Pararasan.values();
    private static final Constants.Rakam[]          lookupRakam      = Constants.Rakam.values();


    private int dayInYear;

    private Constants.Wuku      wuku        = null;

    private Constants.Ekawara   ekawara     = null;
    private Constants.Dwiwara   dwiwara     = null;
    private Constants.Triwara   triwara     = null;
    private Constants.Caturwara caturwara   = null;
    private Constants.Pancawara pancawara   = null;
    private Constants.Sadwara   sadwara     = null;
    private Constants.Saptawara saptawara   = null;
    private Constants.Astawara  astawara    = null;
    private Constants.Sangawara sangawara   = null;
    private Constants.Dasawara  dasawara    = null;

    private Constants.Ingkel            ingkel      = null;
    private Constants.Jejapan           jejapan     = null;
    private Constants.PawatekanAlit     watekAlit   = null;
    private Constants.PawatekanMadya    watekMadya  = null;
    private Constants.Lintang           lintang     = null;
    private Constants.Pancasuda         pancasuda   = null;
    private Constants.Pararasan         pararasan   = null;
    private Constants.Rakam             rakam       = null;

    public BalinesePawukon(int pawukonDayInYear) throws BalinesePawukonException {
        if (pawukonDayInYear >= Constants.DAYS_IN_YEAR_PAWUKON) { 
            throw new BalinesePawukonException(BalinesePawukonException.INVALID_DAY_OF_YEAR);
        }

        this.dayInYear = pawukonDayInYear;
    }

    public int getPawukonDayInYear() {
        return this.dayInYear;
    }

    public Constants.Wuku getWuku() {
        if (wuku == null) {
            wuku = lookupWuku[getPawukonDayInYear() / 7];
        }

        return wuku;
    }

    public Constants.Ekawara getEkawara() {
        if (ekawara == null) {
            int idx = this.GetUrip() % 2;
            ekawara = lookupEkawara[idx];
        }

        return ekawara;
    }

    public Constants.Dwiwara getDwiwara() {
        if (dwiwara == null) {
            int idx = this.GetUrip() % 2;
            dwiwara = lookupDwiwara[idx];
        }

        return dwiwara;
    }

    public Constants.Triwara getTriwara() {
        if (triwara == null) {
            int idx = this.getPawukonDayInYear() % 3;
            triwara = lookupTriwara[idx];
        }

        return triwara;
    }

    public Constants.Caturwara getCaturwara() {
        if (caturwara == null) {
            int idx = 0;
            if (this.getPawukonDayInYear() <= 70) {
                idx = this.getPawukonDayInYear() % 4;
            } else if (this.getPawukonDayInYear() == 71 || this.getPawukonDayInYear() == 72) {
                idx = Constants.Caturwara.JAYA.getId();
            } else {
                idx = (this.getPawukonDayInYear() - 2) % 4;
            }

            caturwara = lookupCaturwara[idx];
        }

        return caturwara;
    }

    public Constants.Pancawara getPancawara() {
        if (pancawara == null) {
            int idx   = getPawukonDayInYear() % 5;
            pancawara = lookupPancawara[idx];
        }

        return pancawara;
    }

    public Constants.Sadwara getSadwara() {
        if (sadwara == null) {
            int idx = getPawukonDayInYear() % 6;
            sadwara = lookupSadwara[idx];
        }

        return sadwara;
    }

    public Constants.Saptawara getSaptawara() {
        if (saptawara == null) {
            int idx   = getPawukonDayInYear() % 7;
            saptawara = lookupSaptawara[idx];
        }

        return saptawara;
    }

    public Constants.Astawara getAstawara() {
        if (astawara == null) {
            int idx = 0;
            if (this.getPawukonDayInYear() <= 70) {
                idx = this.getPawukonDayInYear() % 8;
            } else if (this.getPawukonDayInYear() == 71 || this.getPawukonDayInYear() == 72) {
                idx = Constants.Astawara.KALA.getId();
            } else {
                idx = (this.getPawukonDayInYear() - 2) % 8;
            }
            
            astawara = lookupAstawara[idx];
        }

        return astawara;
    }

    public Constants.Sangawara getSangawara() {
        if (sangawara == null) {
            int idx = 0;
            if (this.getPawukonDayInYear() <= 3) {
                idx = Constants.Sangawara.DANGU.getId();
            } else {
                idx = (this.getPawukonDayInYear() - 3) % 9;
            }

            sangawara = lookupSangawara[idx];
        }

        return sangawara;
    }

    public Constants.Dasawara getDasawara() {
        if (dasawara == null) {
            int idx  = this.GetUrip() % 10;
            dasawara = lookupDasawara[idx];
        }

        return dasawara;
    }

    public Constants.Ingkel getIngkel() {
        if (ingkel == null) {
            int idx = this.getWuku().getId() % 6;
            ingkel  = lookupIngkel[idx];
        }

        return ingkel;
    }

    public Constants.Jejapan getJejapan() {
        if (jejapan == null) {
            int idx = this.getPawukonDayInYear() % 6;
            jejapan = lookupJejapan[idx];
        }

        return jejapan;
    }

    public Constants.PawatekanAlit getWatekAlit() {
        if (watekAlit == null) {
            int idx     = this.GetUrip() % 4;
            watekAlit   = lookupWatekAlit[idx];
        }

        return watekAlit;
    }

    public Constants.PawatekanMadya getWatekMadya() {
        if (watekMadya == null) {
            int idx     = this.GetUrip() % 5;
            watekMadya  = lookupWatekMadya[idx];
        }

        return watekMadya;
    }

    public Constants.Lintang getLintang() {
        if (lintang == null) {
            int idx = this.getPawukonDayInYear() % 35;
            lintang = lookupLintang[idx];
        }

        return lintang;
    }

    public Constants.Pancasuda getPancasuda() {
        if (pancasuda == null) {
            getSangawara();
            getPancawara();

            int idx   = (saptawara.getKertaAji() + pancawara.getUrip()) % 7;
            pancasuda = lookupPancasuda[idx];
        }

        return pancasuda;
    }

    public Constants.Pararasan getPararasan() {
        if (pararasan == null) {
            int idx    = this.GetUrip() % 10;
            pararasan  = lookupPararasan[idx];
        }

        return pararasan;
    }

    public Constants.Rakam getRakam() {
        if (rakam == null) {
            getPancawara();
            getSaptawara();

            int idx = (pancawara.getKupih() + saptawara.getKupih()) % 6;
            rakam   = lookupRakam[idx];
        }

        return rakam;
    }

    public int GetUrip() {
        getPancawara();
        getSaptawara();

        return pancawara.getUrip() + saptawara.getUrip();
    }

    @Override
    public Object clone() {
        try {
            return new BalinesePawukon(this.getPawukonDayInYear());
        } catch (BalinesePawukonException ex) {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        BalinesePawukon that = (BalinesePawukon) obj;
        return this.getPawukonDayInYear() == that.getPawukonDayInYear();
    }

    @Override
    public String toString() {
        return "";
    }

}
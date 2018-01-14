package net.peradnya.balinesedate;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

public class BalineseDateTest {

    @Test public void test_date_1969_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1969,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.LANGKIR, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KARTIKA, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SATRIA_WIBAWA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(12, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(true, bDate.isNgunaratri());
    }

    @Test public void test_date_1970_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1970,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.TOLU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.URUKUNG, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.SRI, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.GIGIS, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.SUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.SATO, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KUMBA, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_KEMBANG, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.TUNGGAK_SEMI, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(8, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());
    }

    @Test public void test_date_1999_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1999,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.MERAKIH, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SUKRA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.BUKU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.ANGSA_ANGREM, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SATRIA_WIRANG, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(13, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());
    }

    @Test public void test_date_1999_03_17() {
        GregorianCalendar date  = new GregorianCalendar(1999,03,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.DUKUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.TULUS, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.SUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.TANGIS, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_KEMBANG, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());
    }

    @Test public void test_date_1999_03_18() {
        GregorianCalendar date  = new GregorianCalendar(1999,03,18);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.DUKUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.URUKUNG, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.KALA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.DADI, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.RAJA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.SATO, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.SALAH_UKUR, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BUMI, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.LEBU_KATIUB_ANGIN, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());
    }

    @Test public void test_date_2000_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2000,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SANISCARA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.BEGOONG, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(9, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());
    }

    @Test public void test_date_2000_01_17() {
        GregorianCalendar date  = new GregorianCalendar(2000,01,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.LANGKIR, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.JANGUR, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.DUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.BUTA, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KUKUS, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BINTANG, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(11, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

    }
    
    @Test public void test_date_2017_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2017,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.KLAWU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.REDITE, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.URUNGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PANDITA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KALA_SUNGSANG, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_PANDITA_SAKTI, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(4, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

    }


}
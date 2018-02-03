package net.peradnya.balinesedate;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

public class BalineseDateTest {

    @Test public void test_date_1969_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1969,00,01);
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

        // Sasih
        assertEquals(1890, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1970_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1970,00,01);
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

        // Sasih
        assertEquals(1891, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1976_03_31() {
        GregorianCalendar date  = new GregorianCalendar(1976,02,31);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SINTA, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.KLIWON, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.DANGU, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.MANUH, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.TIWA_TIWA, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_SURYA, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.LEBU_KATIUB_ANGIN, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(true, bDate.isNgunaratri());

        // Sasih
        assertEquals(1897, bDate.getSaka());
        assertEquals(Constants.Sasih.KASANGA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1976_04_01() {
        GregorianCalendar date  = new GregorianCalendar(1976,03,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SINTA, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.LUDRA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.JANGUR, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.DUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.BUTA, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.SANGKA_TIKEL, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BINTANG, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SATRIA_WIBAWA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(2, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1898, bDate.getSaka());
        assertEquals(Constants.Sasih.KADASA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1978_05_08() {
        GregorianCalendar date  = new GregorianCalendar(1978,04,8);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.MATAL, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.MINA, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KIRIMAN, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1900, bDate.getSaka());
        assertEquals(Constants.Sasih.DESTHA, bDate.getSasih());
        assertEquals(true, bDate.isNampihSasih());
    }

    @Test public void test_date_1993_03_24() {
        GregorianCalendar date  = new GregorianCalendar(1993,02,24);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.KRULUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.INDRA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.MANUSA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.GAJAH_MINA, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_AIR, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.WISESA_SEGARA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1915, bDate.getSaka());
        assertEquals(Constants.Sasih.KADASA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1993_09_01() {
        GregorianCalendar date  = new GregorianCalendar(1993,8,1);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.TUNGLEH, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.DANGU, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.MINA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.LUMBUNG, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(14, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(true, bDate.isNgunaratri());

        // Sasih
        assertEquals(1915, bDate.getSaka());
        assertEquals(Constants.Sasih.KARO, bDate.getSasih());
        assertEquals(true, bDate.isNampihSasih());
    }

    @Test public void test_date_1999_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1999,00,01);
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

        // Sasih
        assertEquals(1920, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1999_03_17() {
        GregorianCalendar date  = new GregorianCalendar(1999,02,17);
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

        // Sasih
        assertEquals(1920, bDate.getSaka());
        assertEquals(Constants.Sasih.KASANGA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_1999_03_18() {
        GregorianCalendar date  = new GregorianCalendar(1999,02,18);
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

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(Constants.Sasih.KADASA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_2000_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2000,00,01);
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

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(Constants.Sasih.KANEM, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());
    }

    @Test public void test_date_2000_01_17() {
        GregorianCalendar date  = new GregorianCalendar(2000,00,17);
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

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());

    }

    @Test public void test_date_2001_08_18() {
        GregorianCalendar date  = new GregorianCalendar(2001,7,18);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.TOLU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SANISCARA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.BEGOONG, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(Constants.Sasih.KARO, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());

    }

    @Test public void test_date_2001_09_17() {
        GregorianCalendar date  = new GregorianCalendar(2001,8,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.SRI, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.TULUS, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.RAKSASA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KELAPA, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_ANGIN, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.TUNGGAK_SEMI, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(true, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(Constants.Sasih.KATIGA, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());

    }

    @Test public void test_date_2001_09_24() {
        GregorianCalendar date  = new GregorianCalendar(2001,8,24);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.DUNGULAN, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.MAULU, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.KALA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.ERANGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PAKSI, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KIRIMAN, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(7, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(Constants.Sasih.KATIGA, bDate.getSasih());
        assertEquals(true, bDate.isNampihSasih());

    }

    @Test public void test_date_2003_01_03() {
        GregorianCalendar date  = new GregorianCalendar(2003,0,3);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.KRULUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SUKRA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.URUNGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PANDITA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.MANGELUT, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.LAKU_PANDITA_SAKTI, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1924, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());

    }

    @Test public void test_date_2003_05_01() {
        GregorianCalendar date  = new GregorianCalendar(2001,8,24);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.DUNGULAN, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(Constants.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(Constants.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(Constants.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(Constants.Sadwara.MAULU, bDate.getPawukon().getSadwara());
        assertEquals(Constants.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(Constants.Astawara.KALA, bDate.getPawukon().getAstawara());
        assertEquals(Constants.Sangawara.ERANGAN, bDate.getPawukon().getSangawara());
        assertEquals(Constants.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(Constants.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(Constants.Jejapan.PAKSI, bDate.getPawukon().getJejapan());
        assertEquals(Constants.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(Constants.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(Constants.Lintang.KIRIMAN, bDate.getPawukon().getLintang());
        assertEquals(Constants.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(Constants.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(7, bDate.getPenanggal());
        assertEquals(false, bDate.isPangelong());
        assertEquals(false, bDate.isNgunaratri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(Constants.Sasih.KATIGA, bDate.getSasih());
        assertEquals(true, bDate.isNampihSasih());

    }
    
    @Test public void test_date_2017_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2017,00,01);
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

        // Sasih
        assertEquals(1938, bDate.getSaka());
        assertEquals(Constants.Sasih.KAPITU, bDate.getSasih());
        assertEquals(false, bDate.isNampihSasih());

    }


}
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

import org.junit.Test;

import peradnya.lib.balinesedate.BalineseDateConst.Pancawara;
import peradnya.lib.balinesedate.BalineseDateConst.PenanggalInfo;
import peradnya.lib.balinesedate.BalineseDateConst.Saptawara;
import peradnya.lib.balinesedate.BalineseDateConst.Sasih;
import peradnya.lib.balinesedate.BalineseDateConst.Wuku;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import javax.management.Query;

public class BalineseDateTest {

    @Test public void test_date_1969_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1969,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.LANGKIR, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KARTIKA, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SATRIA_WIBAWA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(12, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(true, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1890, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }

    @Test public void test_date_1970_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1970,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.TOLU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.URUKUNG, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.SRI, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.GIGIS, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.SUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.SATO, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KUMBA, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_KEMBANG, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.TUNGGAK_SEMI, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(8, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PANGELONG, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1891, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }

    @Test public void test_date_1976_03_31() {
        GregorianCalendar date  = new GregorianCalendar(1976,02,31);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.SINTA, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.KLIWON, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.DANGU, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.MANUH, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.TIWA_TIWA, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_SURYA, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.LEBU_KATIUB_ANGIN, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.TILEM, bDate.getPenanggalInfo());
        assertEquals(true, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1897, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KASANGA, bDate.getSasih());
    }

    @Test public void test_date_1976_04_01() {
        GregorianCalendar date  = new GregorianCalendar(1976,03,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.SINTA, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.LUDRA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.JANGUR, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.DUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.BUTA, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.SANGKA_TIKEL, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BINTANG, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SATRIA_WIBAWA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(2, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1898, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KADASA, bDate.getSasih());
    }

    @Test public void test_date_1978_05_08() {
        GregorianCalendar date  = new GregorianCalendar(1978,04,8);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.MATAL, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.MINA, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KIRIMAN, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1900, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.MALA_DESTHA, bDate.getSasih());
    }

    @Test public void test_date_1993_03_24() {
        GregorianCalendar date  = new GregorianCalendar(1993,02,24);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.KRULUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.INDRA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.MANUSA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.GAJAH_MINA, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_AIR, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.WISESA_SEGARA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1915, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KADASA, bDate.getSasih());
    }

    @Test public void test_date_1993_09_01() {
        GregorianCalendar date  = new GregorianCalendar(1993,8,1);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.TUNGLEH, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.DANGU, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.MINA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.LUMBUNG, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(14, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PURNAMA, bDate.getPenanggalInfo());
        assertEquals(true, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1915, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.NAMPIH_KARO, bDate.getSasih());
    }

    @Test public void test_date_1999_01_01() {
        GregorianCalendar date  = new GregorianCalendar(1999,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.MERAKIH, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SUKRA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.BUKU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.ANGSA_ANGREM, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SATRIA_WIRANG, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(13, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1920, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }

    @Test public void test_date_1999_03_17() {
        GregorianCalendar date  = new GregorianCalendar(1999,02,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.DUKUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.BUDA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.TULUS, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.SUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LINTAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.TANGIS, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_KEMBANG, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.TILEM, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1920, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KASANGA, bDate.getSasih());
    }

    @Test public void test_date_1999_03_18() {
        GregorianCalendar date  = new GregorianCalendar(1999,02,18);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.DUKUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.URUKUNG, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.WRESPATI, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.KALA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.DADI, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.RAJA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.SATO, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WATU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.SALAH_UKUR, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BUMI, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.LEBU_KATIUB_ANGIN, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KADASA, bDate.getSasih());
    }

    @Test public void test_date_2000_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2000,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.LABA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SANISCARA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.BRAHMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.NOHAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.BEGOONG, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(9, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PANGELONG, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KANEM, bDate.getSasih());
    }

    @Test public void test_date_2000_01_17() {
        GregorianCalendar date  = new GregorianCalendar(2000,00,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.LANGKIR, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PAING, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.ARYANG, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.JANGUR, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.DUKA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.WONG, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.TARU, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.BUTA, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KUKUS, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BINTANG, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(11, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1921, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }

    @Test public void test_date_2001_08_18() {
        GregorianCalendar date  = new GregorianCalendar(2001,7,18);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.TOLU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SANISCARA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.GURU, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.OGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.SRI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.BEGOONG, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_BULAN, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.BUMI_KAPETAK, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.TILEM, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KARO, bDate.getSasih());

    }

    @Test public void test_date_2001_09_17() {
        GregorianCalendar date  = new GregorianCalendar(2001,8,17);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.BETENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.SRI, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.WAS, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.SRI, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.TULUS, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.RAKSASA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.WONG, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.SUKU, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.ULER, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KELAPA, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_ANGIN, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.TUNGGAK_SEMI, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(15, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.TILEM, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KATIGA, bDate.getSasih());
    }

    @Test public void test_date_2001_09_24() {
        GregorianCalendar date  = new GregorianCalendar(2001,8,24);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.DUNGULAN, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.LUANG, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.PEPET, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.KAJENG, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.JAYA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.PON, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.MAULU, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SOMA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.KALA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.ERANGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PATI, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PAKSI, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.GAJAH, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.LEMBU, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KIRIMAN, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.ARAS_TUDING, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(7, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1923, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.NAMPIH_KATIGA, bDate.getSasih());
    }

    @Test public void test_date_2003_01_03() {
        GregorianCalendar date  = new GregorianCalendar(2003,0,3);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.KRULUT, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.WAGE, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.SUKRA, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.URUNGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PANDITA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.TARU, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.MANGELUT, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_PANDITA_SAKTI, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(1, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1924, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }
    
    @Test public void test_date_2017_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2017,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(BalineseDateConst.Wuku.KLAWU, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(BalineseDateConst.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(BalineseDateConst.Dwiwara.MENGA, bDate.getPawukon().getDwiwara());
        assertEquals(BalineseDateConst.Triwara.PASAH, bDate.getPawukon().getTriwara());
        assertEquals(BalineseDateConst.Caturwara.MENALA, bDate.getPawukon().getCaturwara());
        assertEquals(BalineseDateConst.Pancawara.UMANIS, bDate.getPawukon().getPancawara());
        assertEquals(BalineseDateConst.Sadwara.PANIRON, bDate.getPawukon().getSadwara());
        assertEquals(BalineseDateConst.Saptawara.REDITE, bDate.getPawukon().getSaptawara());
        assertEquals(BalineseDateConst.Astawara.YAMA, bDate.getPawukon().getAstawara());
        assertEquals(BalineseDateConst.Sangawara.URUNGAN, bDate.getPawukon().getSangawara());
        assertEquals(BalineseDateConst.Dasawara.PANDITA, bDate.getPawukon().getDasawara());

        // Another wewaran
        assertEquals(BalineseDateConst.Ingkel.MANUK, bDate.getPawukon().getIngkel());
        assertEquals(BalineseDateConst.Jejapan.PATRA, bDate.getPawukon().getJejapan());
        assertEquals(BalineseDateConst.PawatekanMadya.WONG, bDate.getPawukon().getWatekMadya());
        assertEquals(BalineseDateConst.PawatekanAlit.GAJAH, bDate.getPawukon().getWatekAlit());
        assertEquals(BalineseDateConst.Lintang.KALA_SUNGSANG, bDate.getPawukon().getLintang());
        assertEquals(BalineseDateConst.Pararasan.LAKU_PANDITA_SAKTI, bDate.getPawukon().getPararasan());
        assertEquals(BalineseDateConst.Pancasuda.SUMUR_SINABA, bDate.getPawukon().getPancasuda());

        // Penanggal
        assertEquals(4, bDate.getPenanggal());
        assertEquals(BalineseDateConst.PenanggalInfo.PENANGGAL, bDate.getPenanggalInfo());
        assertEquals(false, bDate.isNgunaRatri());

        // Sasih
        assertEquals(1938, bDate.getSaka());
        assertEquals(BalineseDateConst.Sasih.KAPITU, bDate.getSasih());
    }

    @Test public void test_date_2017_01_01_string() {
        GregorianCalendar date  = new GregorianCalendar(2017,00,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals("Klawu", bDate.getPawukon().getWuku().getName());

        // Wewaran
        assertEquals("Void", bDate.getPawukon().getEkawara().getName());
        assertEquals("Menga", bDate.getPawukon().getDwiwara().getName());
        assertEquals("Pasah", bDate.getPawukon().getTriwara().getName());
        assertEquals("Menala", bDate.getPawukon().getCaturwara().getName());
        assertEquals("Umanis", bDate.getPawukon().getPancawara().getName());
        assertEquals("Paniron", bDate.getPawukon().getSadwara().getName());
        assertEquals("Redite", bDate.getPawukon().getSaptawara().getName());
        assertEquals("Yama", bDate.getPawukon().getAstawara().getName());
        assertEquals("Urungan", bDate.getPawukon().getSangawara().getName());
        assertEquals("Pandita", bDate.getPawukon().getDasawara().getName());

        // Another wewaran
        assertEquals("Manuk", bDate.getPawukon().getIngkel().getName());
        assertEquals("Patra", bDate.getPawukon().getJejapan().getName());
        assertEquals("Wong", bDate.getPawukon().getWatekMadya().getName());
        assertEquals("Gajah", bDate.getPawukon().getWatekAlit().getName());
        assertEquals("Kala Sungsang", bDate.getPawukon().getLintang().getName());
        assertEquals("Laku Pandita Sakti", bDate.getPawukon().getPararasan().getName());
        assertEquals("Sumur Sinaba", bDate.getPawukon().getPancasuda().getName());

        // Penanggal
        assertEquals("Penanggal", bDate.getPenanggalInfo().getName());

        // Sasih
        assertEquals("Kapitu", bDate.getSasih().getName());
    }

    @Test public void test_query_1_year_watugunung() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku = Wuku.WATUGUNUNG;

        BalineseDate[] arr          = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 14);
    }

    @Test public void test_query_1_year_watugunung_kliwon() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.pancawara = Pancawara.KLIWON;

        BalineseDate[] arr          = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 4);
    }

    @Test public void test_query_1_year_watugunung_saniscara() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.saptawara = Saptawara.SANISCARA;

        BalineseDate[] arr          = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 2);
    }

    @Test public void test_query_1_year_watugunung_saniscara_kliwon() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.saptawara = Saptawara.SANISCARA;
        q.pancawara = Pancawara.KLIWON;

        BalineseDate[] arr          = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 0);
    }

    @Test public void test_query_1_month_agustus_ngunaratri() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.isNgunaRatri      = true;

        BalineseDate[] arr  = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 1);
    }

    @Test public void test_query_1_month_agustus_katiga() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.sasih      = Sasih.KATIGA;

        BalineseDate[] arr  = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 9);
    }

    @Test public void test_query_1_month_agustus_1() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.penanggal = 1;

        BalineseDate[] arr  = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 1);
    }

    @Test public void test_query_1_month_agustus_penanggal_9() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.penanggal = 9;
        q.penanggalInfo = PenanggalInfo.PENANGGAL;

        BalineseDate[] arr  = BalineseDateUtil.getBalineseDateByDate(q, start, finish);

        assertEquals(arr.length, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_exception_null_1() {
        new BalineseDate(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_exception_null_2() {
        BalineseDateUtil.getBalineseDateByDate(null, null, null);
    }


}
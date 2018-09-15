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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import peradnya.lib.balinesedate.AstaWara;
import peradnya.lib.balinesedate.CaturWara;
import peradnya.lib.balinesedate.DasaWara;
import peradnya.lib.balinesedate.DwiWara;
import peradnya.lib.balinesedate.EkaJalaRsi;
import peradnya.lib.balinesedate.EkaWara;
import peradnya.lib.balinesedate.Ingkel;
import peradnya.lib.balinesedate.Jejepan;
import peradnya.lib.balinesedate.Lintang;
import peradnya.lib.balinesedate.PancaSuda;
import peradnya.lib.balinesedate.PancaWara;
import peradnya.lib.balinesedate.Pararasan;
import peradnya.lib.balinesedate.PratithiSamutPada;
import peradnya.lib.balinesedate.SadWara;
import peradnya.lib.balinesedate.SangaWara;
import peradnya.lib.balinesedate.SaptaWara;
import peradnya.lib.balinesedate.Sasih;
import peradnya.lib.balinesedate.SasihDayInfo;
import peradnya.lib.balinesedate.TriWara;
import peradnya.lib.balinesedate.WatekAlit;
import peradnya.lib.balinesedate.WatekMadya;
import peradnya.lib.balinesedate.Wuku;
import peradnya.lib.balinesedate.BalineseDateUtil;

public class BalineseDateTest {

    @Test
    public void test_date_1969_01_01() {
        GregorianCalendar date = new GregorianCalendar(1969, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.LANGKIR, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.LABA, bDate.caturWara());
        assertEquals(PancaWara.WAGE, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.BUDA, bDate.saptaWara());
        assertEquals(AstaWara.BRAHMA, bDate.astaWara());
        assertEquals(SangaWara.NOHAN, bDate.sangaWara());
        assertEquals(DasaWara.PATI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.WONG, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.GAJAH, bDate.watekMadya());
        assertEquals(WatekAlit.LEMBU, bDate.watekAlit());
        assertEquals(Lintang.KARTIKA, bDate.lintang());
        assertEquals(Pararasan.ARAS_TUDING, bDate.pararasan());
        assertEquals(PancaSuda.SATRIA_WIBAWA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BUAT_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(12, 13), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.WIDNYANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1890, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_1970_01_01() {
        GregorianCalendar date = new GregorianCalendar(1970, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.TOLU, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.KAJENG, bDate.triWara());
        assertEquals(CaturWara.SRI, bDate.caturWara());
        assertEquals(PancaWara.WAGE, bDate.pancaWara());
        assertEquals(SadWara.URUKUNG, bDate.sadWara());
        assertEquals(SaptaWara.WRESPATI, bDate.saptaWara());
        assertEquals(AstaWara.SRI, bDate.astaWara());
        assertEquals(SangaWara.GIGIS, bDate.sangaWara());
        assertEquals(DasaWara.SUKA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.SATO, bDate.jejepan());
        assertEquals(WatekMadya.WATU, bDate.watekMadya());
        assertEquals(WatekAlit.LINTAH, bDate.watekAlit());
        assertEquals(Lintang.KUMBA, bDate.lintang());
        assertEquals(Pararasan.ARAS_KEMBANG, bDate.pararasan());
        assertEquals(PancaSuda.TUNGGAK_SEMI, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BUAT_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(8), bDate.sasihDay());
        assertEquals(SasihDayInfo.PANGELONG, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.WEDANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1891, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_1976_03_31() {
        GregorianCalendar date = new GregorianCalendar(1976, 02, 31);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.SINTA, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.MENALA, bDate.caturWara());
        assertEquals(PancaWara.KLIWON, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.BUDA, bDate.saptaWara());
        assertEquals(AstaWara.YAMA, bDate.astaWara());
        assertEquals(SangaWara.DANGU, bDate.sangaWara());
        assertEquals(DasaWara.MANUH, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.WONG, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.WONG, bDate.watekMadya());
        assertEquals(WatekAlit.LEMBU, bDate.watekAlit());
        assertEquals(Lintang.TIWA_TIWA, bDate.lintang());
        assertEquals(Pararasan.LAKU_SURYA, bDate.pararasan());
        assertEquals(PancaSuda.LEBU_KATIUB_ANGIN, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BUAT_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(15, 1), bDate.sasihDay());
        assertEquals(SasihDayInfo.TILEM, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1897, bDate.saka());
        assertEquals(Sasih.KASANGA, bDate.sasih());
    }

    @Test
    public void test_date_1976_04_01() {
        GregorianCalendar date = new GregorianCalendar(1976, 03, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.SINTA, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.SRI, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.WAS, bDate.sadWara());
        assertEquals(SaptaWara.WRESPATI, bDate.saptaWara());
        assertEquals(AstaWara.LUDRA, bDate.astaWara());
        assertEquals(SangaWara.JANGUR, bDate.sangaWara());
        assertEquals(DasaWara.DUKA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.WONG, bDate.ingkel());
        assertEquals(Jejepan.WONG, bDate.jejepan());
        assertEquals(WatekMadya.BUTA, bDate.watekMadya());
        assertEquals(WatekAlit.ULER, bDate.watekAlit());
        assertEquals(Lintang.SANGKA_TIKEL, bDate.lintang());
        assertEquals(Pararasan.LAKU_BINTANG, bDate.pararasan());
        assertEquals(PancaSuda.SATRIA_WIBAWA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.SUKA_PINANGGIH, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(2), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.NAMARUPA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1898, bDate.saka());
        assertEquals(Sasih.KADASA, bDate.sasih());
    }

    @Test
    public void test_date_1978_05_08() {
        GregorianCalendar date = new GregorianCalendar(1978, 04, 8);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.MATAL, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.MENALA, bDate.caturWara());
        assertEquals(PancaWara.PON, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.SOMA, bDate.saptaWara());
        assertEquals(AstaWara.YAMA, bDate.astaWara());
        assertEquals(SangaWara.NOHAN, bDate.sangaWara());
        assertEquals(DasaWara.PATI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.MINA, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.GAJAH, bDate.watekMadya());
        assertEquals(WatekAlit.LEMBU, bDate.watekAlit());
        assertEquals(Lintang.KIRIMAN, bDate.lintang());
        assertEquals(Pararasan.ARAS_TUDING, bDate.pararasan());
        assertEquals(PancaSuda.SUMUR_SINABA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.LANGGENG_KAYOHANAAN, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(1), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SEPARSA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1900, bDate.saka());
        assertEquals(Sasih.MALA_DESTHA, bDate.sasih());
    }

    @Test
    public void test_date_1993_03_24() {
        GregorianCalendar date = new GregorianCalendar(1993, 02, 24);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.KRULUT, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.LABA, bDate.caturWara());
        assertEquals(PancaWara.PAING, bDate.pancaWara());
        assertEquals(SadWara.ARYANG, bDate.sadWara());
        assertEquals(SaptaWara.BUDA, bDate.saptaWara());
        assertEquals(AstaWara.INDRA, bDate.astaWara());
        assertEquals(SangaWara.OGAN, bDate.sangaWara());
        assertEquals(DasaWara.MANUSA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.TARU, bDate.jejepan());
        assertEquals(WatekMadya.GAJAH, bDate.watekMadya());
        assertEquals(WatekAlit.LINTAH, bDate.watekAlit());
        assertEquals(Lintang.GAJAH_MINA, bDate.lintang());
        assertEquals(Pararasan.LAKU_AIR, bDate.pararasan());
        assertEquals(PancaSuda.WISESA_SEGARA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BUAT_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(1), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1915, bDate.saka());
        assertEquals(Sasih.KADASA, bDate.sasih());
    }

    @Test
    public void test_date_1993_09_01() {
        GregorianCalendar date = new GregorianCalendar(1993, 8, 1);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.SUNGSANG, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.JAYA, bDate.caturWara());
        assertEquals(PancaWara.PON, bDate.pancaWara());
        assertEquals(SadWara.TUNGLEH, bDate.sadWara());
        assertEquals(SaptaWara.BUDA, bDate.saptaWara());
        assertEquals(AstaWara.GURU, bDate.astaWara());
        assertEquals(SangaWara.DANGU, bDate.sangaWara());
        assertEquals(DasaWara.SRI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.MANUK, bDate.ingkel());
        assertEquals(Jejepan.MINA, bDate.jejepan());
        assertEquals(WatekMadya.SUKU, bDate.watekMadya());
        assertEquals(WatekAlit.GAJAH, bDate.watekAlit());
        assertEquals(Lintang.LUMBUNG, bDate.lintang());
        assertEquals(Pararasan.LAKU_BULAN, bDate.pararasan());
        assertEquals(PancaSuda.BUMI_KAPETAK, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BAGNA_MAPASAH, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(14, 15), bDate.sasihDay());
        assertEquals(SasihDayInfo.PURNAMA, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.UPADANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1915, bDate.saka());
        assertEquals(Sasih.NAMPIH_KARO, bDate.sasih());
    }

    @Test
    public void test_date_1999_01_01() {
        GregorianCalendar date = new GregorianCalendar(1999, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.MERAKIH, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.JAYA, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.WAS, bDate.sadWara());
        assertEquals(SaptaWara.SUKRA, bDate.saptaWara());
        assertEquals(AstaWara.GURU, bDate.astaWara());
        assertEquals(SangaWara.OGAN, bDate.sangaWara());
        assertEquals(DasaWara.PATI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.BUKU, bDate.ingkel());
        assertEquals(Jejepan.WONG, bDate.jejepan());
        assertEquals(WatekMadya.GAJAH, bDate.watekMadya());
        assertEquals(WatekAlit.LEMBU, bDate.watekAlit());
        assertEquals(Lintang.ANGSA_ANGREM, bDate.lintang());
        assertEquals(Pararasan.ARAS_TUDING, bDate.pararasan());
        assertEquals(PancaSuda.SATRIA_WIRANG, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.MANGGIH_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(13), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.WIDNYANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1920, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_1999_03_17() {
        GregorianCalendar date = new GregorianCalendar(1999, 02, 17);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.DUKUT, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.LABA, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.ARYANG, bDate.sadWara());
        assertEquals(SaptaWara.BUDA, bDate.saptaWara());
        assertEquals(AstaWara.BRAHMA, bDate.astaWara());
        assertEquals(SangaWara.TULUS, bDate.sangaWara());
        assertEquals(DasaWara.SUKA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.TARU, bDate.jejepan());
        assertEquals(WatekMadya.WATU, bDate.watekMadya());
        assertEquals(WatekAlit.LINTAH, bDate.watekAlit());
        assertEquals(Lintang.TANGIS, bDate.lintang());
        assertEquals(Pararasan.ARAS_KEMBANG, bDate.pararasan());
        assertEquals(PancaSuda.SUMUR_SINABA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.TININGGALING_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(15), bDate.sasihDay());
        assertEquals(SasihDayInfo.TILEM, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.JARAMARANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1920, bDate.saka());
        assertEquals(Sasih.KASANGA, bDate.sasih());
    }

    @Test
    public void test_date_1999_03_18() {
        GregorianCalendar date = new GregorianCalendar(1999, 02, 18);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.DUKUT, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.KAJENG, bDate.triWara());
        assertEquals(CaturWara.JAYA, bDate.caturWara());
        assertEquals(PancaWara.PAING, bDate.pancaWara());
        assertEquals(SadWara.URUKUNG, bDate.sadWara());
        assertEquals(SaptaWara.WRESPATI, bDate.saptaWara());
        assertEquals(AstaWara.KALA, bDate.astaWara());
        assertEquals(SangaWara.DADI, bDate.sangaWara());
        assertEquals(DasaWara.RAJA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.SATO, bDate.jejepan());
        assertEquals(WatekMadya.WATU, bDate.watekMadya());
        assertEquals(WatekAlit.ULER, bDate.watekAlit());
        assertEquals(Lintang.SALAH_UKUR, bDate.lintang());
        assertEquals(Pararasan.LAKU_BUMI, bDate.pararasan());
        assertEquals(PancaSuda.LEBU_KATIUB_ANGIN, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.PATINING_AMERTA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(1), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1921, bDate.saka());
        assertEquals(Sasih.KADASA, bDate.sasih());
    }

    @Test
    public void test_date_2000_01_01() {
        GregorianCalendar date = new GregorianCalendar(2000, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.SUNGSANG, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.LABA, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.SANISCARA, bDate.saptaWara());
        assertEquals(AstaWara.BRAHMA, bDate.astaWara());
        assertEquals(SangaWara.NOHAN, bDate.sangaWara());
        assertEquals(DasaWara.SRI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.MANUK, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.SUKU, bDate.watekMadya());
        assertEquals(WatekAlit.GAJAH, bDate.watekAlit());
        assertEquals(Lintang.BEGOONG, bDate.lintang());
        assertEquals(Pararasan.LAKU_BULAN, bDate.pararasan());
        assertEquals(PancaSuda.BUMI_KAPETAK, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BAGNA_MAPASAH, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(9), bDate.sasihDay());
        assertEquals(SasihDayInfo.PANGELONG, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1921, bDate.saka());
        assertEquals(Sasih.KANEM, bDate.sasih());
    }

    @Test
    public void test_date_2000_01_17() {
        GregorianCalendar date = new GregorianCalendar(2000, 00, 17);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.LANGKIR, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.MENALA, bDate.caturWara());
        assertEquals(PancaWara.PAING, bDate.pancaWara());
        assertEquals(SadWara.ARYANG, bDate.sadWara());
        assertEquals(SaptaWara.SOMA, bDate.saptaWara());
        assertEquals(AstaWara.YAMA, bDate.astaWara());
        assertEquals(SangaWara.JANGUR, bDate.sangaWara());
        assertEquals(DasaWara.DUKA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.WONG, bDate.ingkel());
        assertEquals(Jejepan.TARU, bDate.jejepan());
        assertEquals(WatekMadya.BUTA, bDate.watekMadya());
        assertEquals(WatekAlit.ULER, bDate.watekAlit());
        assertEquals(Lintang.KUKUS, bDate.lintang());
        assertEquals(Pararasan.LAKU_BINTANG, bDate.pararasan());
        assertEquals(PancaSuda.BUMI_KAPETAK, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.BUAT_SEBET, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(11), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1921, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_2001_08_18() {
        GregorianCalendar date = new GregorianCalendar(2001, 7, 18);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.TOLU, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.JAYA, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.WAS, bDate.sadWara());
        assertEquals(SaptaWara.SANISCARA, bDate.saptaWara());
        assertEquals(AstaWara.GURU, bDate.astaWara());
        assertEquals(SangaWara.OGAN, bDate.sangaWara());
        assertEquals(DasaWara.SRI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.WONG, bDate.jejepan());
        assertEquals(WatekMadya.SUKU, bDate.watekMadya());
        assertEquals(WatekAlit.GAJAH, bDate.watekAlit());
        assertEquals(Lintang.BEGOONG, bDate.lintang());
        assertEquals(Pararasan.LAKU_BULAN, bDate.pararasan());
        assertEquals(PancaSuda.BUMI_KAPETAK, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.SUKA_PINANGGIH, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(15), bDate.sasihDay());
        assertEquals(SasihDayInfo.TILEM, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SADAYATANA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1923, bDate.saka());
        assertEquals(Sasih.KARO, bDate.sasih());

    }

    @Test
    public void test_date_2001_09_17() {
        GregorianCalendar date = new GregorianCalendar(2001, 8, 17);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.SUNGSANG, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.BETENG, bDate.triWara());
        assertEquals(CaturWara.SRI, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.WAS, bDate.sadWara());
        assertEquals(SaptaWara.SOMA, bDate.saptaWara());
        assertEquals(AstaWara.SRI, bDate.astaWara());
        assertEquals(SangaWara.TULUS, bDate.sangaWara());
        assertEquals(DasaWara.RAKSASA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.MANUK, bDate.ingkel());
        assertEquals(Jejepan.WONG, bDate.jejepan());
        assertEquals(WatekMadya.SUKU, bDate.watekMadya());
        assertEquals(WatekAlit.ULER, bDate.watekAlit());
        assertEquals(Lintang.KELAPA, bDate.lintang());
        assertEquals(Pararasan.LAKU_ANGIN, bDate.pararasan());
        assertEquals(PancaSuda.TUNGGAK_SEMI, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.TININGGALING_SUKA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(15), bDate.sasihDay());
        assertEquals(SasihDayInfo.TILEM, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SEPARSA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1923, bDate.saka());
        assertEquals(Sasih.KATIGA, bDate.sasih());
    }

    @Test
    public void test_date_2001_09_24() {
        GregorianCalendar date = new GregorianCalendar(2001, 8, 24);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.DUNGULAN, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.LUANG, bDate.ekaWara());
        assertEquals(DwiWara.PEPET, bDate.dwiWara());
        assertEquals(TriWara.KAJENG, bDate.triWara());
        assertEquals(CaturWara.JAYA, bDate.caturWara());
        assertEquals(PancaWara.PON, bDate.pancaWara());
        assertEquals(SadWara.MAULU, bDate.sadWara());
        assertEquals(SaptaWara.SOMA, bDate.saptaWara());
        assertEquals(AstaWara.KALA, bDate.astaWara());
        assertEquals(SangaWara.ERANGAN, bDate.sangaWara());
        assertEquals(DasaWara.PATI, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.PAKSI, bDate.jejepan());
        assertEquals(WatekMadya.GAJAH, bDate.watekMadya());
        assertEquals(WatekAlit.LEMBU, bDate.watekAlit());
        assertEquals(Lintang.KIRIMAN, bDate.lintang());
        assertEquals(Pararasan.ARAS_TUDING, bDate.pararasan());
        assertEquals(PancaSuda.SUMUR_SINABA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.SUKA_PINANGGIH, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(7), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.NAMARUPA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1923, bDate.saka());
        assertEquals(Sasih.NAMPIH_KATIGA, bDate.sasih());
    }

    @Test
    public void test_date_2003_01_03() {
        GregorianCalendar date = new GregorianCalendar(2003, 0, 3);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.KRULUT, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.MENALA, bDate.caturWara());
        assertEquals(PancaWara.WAGE, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.SUKRA, bDate.saptaWara());
        assertEquals(AstaWara.YAMA, bDate.astaWara());
        assertEquals(SangaWara.URUNGAN, bDate.sangaWara());
        assertEquals(DasaWara.PANDITA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.TARU, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.WONG, bDate.watekMadya());
        assertEquals(WatekAlit.GAJAH, bDate.watekAlit());
        assertEquals(Lintang.MANGELUT, bDate.lintang());
        assertEquals(Pararasan.LAKU_PANDITA_SAKTI, bDate.pararasan());
        assertEquals(PancaSuda.SUMUR_SINABA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.PATINING_AMERTA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(1), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.SAMSKARA, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1924, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_2017_01_01() {
        GregorianCalendar date = new GregorianCalendar(2017, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals(Wuku.KLAWU, bDate.wuku());

        // WeWaran
        assertEquals(EkaWara.VOID, bDate.ekaWara());
        assertEquals(DwiWara.MENGA, bDate.dwiWara());
        assertEquals(TriWara.PASAH, bDate.triWara());
        assertEquals(CaturWara.MENALA, bDate.caturWara());
        assertEquals(PancaWara.UMANIS, bDate.pancaWara());
        assertEquals(SadWara.PANIRON, bDate.sadWara());
        assertEquals(SaptaWara.REDITE, bDate.saptaWara());
        assertEquals(AstaWara.YAMA, bDate.astaWara());
        assertEquals(SangaWara.URUNGAN, bDate.sangaWara());
        assertEquals(DasaWara.PANDITA, bDate.dasaWara());

        // Another weWaran
        assertEquals(Ingkel.MANUK, bDate.ingkel());
        assertEquals(Jejepan.PATRA, bDate.jejepan());
        assertEquals(WatekMadya.WONG, bDate.watekMadya());
        assertEquals(WatekAlit.GAJAH, bDate.watekAlit());
        assertEquals(Lintang.KALA_SUNGSANG, bDate.lintang());
        assertEquals(Pararasan.LAKU_PANDITA_SAKTI, bDate.pararasan());
        assertEquals(PancaSuda.SUMUR_SINABA, bDate.pancaSuda());

        assertEquals(EkaJalaRsi.PATINING_AMERTA, bDate.ekaJalaRsi());

        // Penanggal
        assertEquals(Arrays.asList(4), bDate.sasihDay());
        assertEquals(SasihDayInfo.PENANGGAL, bDate.sasihDayInfo());
        assertEquals(PratithiSamutPada.JATI, bDate.pratithiSamutPada());

        // Sasih
        assertEquals(1938, bDate.saka());
        assertEquals(Sasih.KAPITU, bDate.sasih());
    }

    @Test
    public void test_date_2017_01_01_string() {
        GregorianCalendar date = new GregorianCalendar(2017, 00, 01);
        BalineseDate bDate = new BalineseDate(date);

        // Wuku
        assertEquals("Klawu", bDate.wuku().toString());

        // WeWaran
        assertEquals("", bDate.ekaWara().toString());
        assertEquals("Menga", bDate.dwiWara().toString());
        assertEquals("Pasah", bDate.triWara().toString());
        assertEquals("Menala", bDate.caturWara().toString());
        assertEquals("Umanis", bDate.pancaWara().toString());
        assertEquals("Paniron", bDate.sadWara().toString());
        assertEquals("Redite", bDate.saptaWara().toString());
        assertEquals("Yama", bDate.astaWara().toString());
        assertEquals("Urungan", bDate.sangaWara().toString());
        assertEquals("Pandita", bDate.dasaWara().toString());

        // Another weWaran
        assertEquals("Manuk", bDate.ingkel().toString());
        assertEquals("Patra", bDate.jejepan().toString());
        assertEquals("Wong", bDate.watekMadya().toString());
        assertEquals("Gajah", bDate.watekAlit().toString());
        assertEquals("Kala Sungsang", bDate.lintang().toString());
        assertEquals("Laku Pandita Sakti", bDate.pararasan().toString());
        assertEquals("Sumur Sinaba", bDate.pancaSuda().toString());

        assertEquals("Patining AmErta", bDate.ekaJalaRsi().toString());

        // Penanggal
        assertEquals("Penanggal", bDate.sasihDayInfo().toString());
        assertEquals("Jati", bDate.pratithiSamutPada().toString());

        // Sasih
        assertEquals("Kapitu", bDate.sasih().toString());
    }

    @Test public void test_query_1_year_watugunung() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku = Wuku.WATUGUNUNG;

        List<BalineseDate> list = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 14);
    }

    @Test public void test_query_1_year_watugunung_kliwon() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.pancaWara = PancaWara.KLIWON;

        List<BalineseDate> list          = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 4);
    }

    @Test public void test_query_1_year_watugunung_saniscara() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.saptaWara = SaptaWara.SANISCARA;

        List<BalineseDate> list          = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 2);
    }

    @Test public void test_query_1_year_watugunung_saniscara_kliwon() {
        GregorianCalendar start     = new GregorianCalendar(2017,00,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.wuku      = Wuku.WATUGUNUNG;
        q.saptaWara = SaptaWara.SANISCARA;
        q.pancaWara = PancaWara.KLIWON;

        List<BalineseDate> list          = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 0);
    }

    @Test public void test_query_1_month_agustus_katiga() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.sasih      = Sasih.KATIGA;

        List<BalineseDate> list  = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 9);
    }

    @Test public void test_query_1_month_agustus_1() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.sasihDay = new ArrayList<Integer>();
        q.sasihDay.add(1);

        List<BalineseDate> list  = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 2);
    }

    @Test public void test_query_1_month_agustus_penanggal_9() {
        GregorianCalendar start     = new GregorianCalendar(2017,07,01);
        GregorianCalendar finish    = new GregorianCalendar(2017,07,31);
        BalineseDateUtil.Filter q    = new BalineseDateUtil.Filter();

        q.sasihDay = new ArrayList<Integer>();
        q.sasihDay.add(9);
        q.sasihDayInfo = SasihDayInfo.PENANGGAL;

        List<BalineseDate> list  = BalineseDateUtil.filterByDateRange(q, start, finish);

        assertEquals(list.size(), 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_exception_null_2() {
        BalineseDateUtil.filterByDateRange(null, null, null);
    }

}
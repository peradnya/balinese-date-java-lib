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

import java.util.GregorianCalendar;

public final class BalineseDateConst {

    public static final int NGUNARATRI              = 63;
    public static final int DAYS_IN_YEAR_PAWUKON    = 210;

    private static String toTitleCase(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '_') {
                arr[i] = ' ';
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (i >= 1 && arr[i - 1] != ' ') {
                    arr[i] = Character.toLowerCase(arr[i]);
                } 
            }
        }

        return new String(arr);
    }

    public enum Jejapan {
        MINA(0),
        TARU(1),
        SATO(2),
        PATRA(3),
        WONG(4),
        PAKSI(5);

        private final int id;

        private Jejapan(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Ingkel {
        WONG(0),
        SATO(1),
        MINA(2),
        MANUK(3),
        TARU(4),
        BUKU(5);

        private final int id;

        private Ingkel(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum PawatekanMadya {
        WONG(0),
        GAJAH(1),
        WATU(2),
        BUTA(3),
        SUKU(4);

        private final int id;
        
        private PawatekanMadya(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum PawatekanAlit {
        LINTAH(0),
        ULER(1),
        GAJAH(2),
        LEMBU(3);

        private final int id;
        
        private PawatekanAlit(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Lintang {
        GAJAH(0),
        KIRIMAN(1),
        PERAHU_SARAT(2),
        TIWA_TIWA(3),
        SANGKA_TIKEL(4),
        BUBU_BOLONG(5),
        SUNGENGE(6),
        ULUKU(7),
        PEDATI(8),
        KUDA(9),
        GAJAH_MINA(10),
        BADE(11),
        MANGELUT(12),
        PAGELANGAN(13),
        KALA_SUNGSANG(14),
        KUKUS(15),
        ASU(16),
        KARTIKA(17),
        NAGA(18),
        ANGSA_ANGREM(19),
        PANAH(20),
        PATREM(21),
        LEMBU(22),
        DEPAT(23),
        TANGIS(24),
        SALAH_UKUR(25),
        PERAHU_PEGAT(26),
        PUWUH_ATARUNG(27),
        LAWEAN(28),
        KELAPA(29),
        YUYU(30),
        LUMBUNG(31),
        KUMBA(32),
        UDANG(33),
        BEGOONG(34);

        private final int id;
        
        private Lintang(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Pancasuda {
        LEBU_KATIUB_ANGIN(0),
        WISESA_SEGARA(1),
        TUNGGAK_SEMI(2),
        SATRIA_WIBAWA(3),
        SUMUR_SINABA(4),
        SATRIA_WIRANG(5),
        BUMI_KAPETAK(6);

        private final int id;
        
        private Pancasuda(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Pararasan {
        LAKU_PANDITA_SAKTI(0),
        ARAS_TUDING(1),
        ARAS_KEMBANG(2),
        LAKU_BINTANG(3),
        LAKU_BULAN(4),
        LAKU_SURYA(5),
        LAKU_AIR(6),
        LAKU_BUMI(7),
        LAKU_API(8),
        LAKU_ANGIN(9);

        private final int id;
        
        private Pararasan(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Rakam {
        NUJU_PATI(0),
        KALA_TINANTANG(1),
        DEMANG_KANDHURUWAN(2),
        SANGGAR_WARINGIN(3),
        MANTRI_SINAROJA(4),
        MACAN_KATAWAN(5);

        private final int id;
        
        private Rakam(int id) {
            this.id = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum Wuku {
        SINTA           ( 0, 7),
        LANDEP          ( 1, 1),
        UKIR            ( 2, 4),
        KULANTIR        ( 3, 6),
        TOLU            ( 4, 5),
        GUMBREG         ( 5, 8),
        WARIGA          ( 6, 9),
        WARIGADEAN      ( 7, 3),
        JULUNGWANGI     ( 8, 7),
        SUNGSANG        ( 9, 1),
        DUNGULAN        (10, 4),
        KUNINGAN        (11, 6),
        LANGKIR         (12, 5),
        MEDANGSIA       (13, 8),
        PUJUD           (14, 9),
        PAHANG          (15, 3),
        KRULUT          (16, 7),
        MERAKIH         (17, 1),
        TAMBIR          (18, 4),
        MEDANGKUNGAN    (19, 6),
        MATAL           (20, 5),
        UYE             (21, 8),
        MENAIL          (22, 9),
        PRANGBAKAT      (23, 3),
        BALA            (24, 7),
        UGU             (25, 1),
        WAYANG          (26, 4),
        KLAWU           (27, 6),
        DUKUT           (28, 5),
        WATUGUNUNG      (29, 8);

        private final int id;
        private final int urip;

        private Wuku(int id, int urip) {
            this.id         = id;
            this.urip       = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
        
    }

    public enum Ekawara {
        VOID(0, 0),
        LUANG(1, 1);

        private final int id;
        private final int urip;

        private Ekawara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Dwiwara {
        MENGA(0, 5),
        PEPET(1, 4);

        private final int id;
        private final int urip;

        private Dwiwara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Triwara {
        PASAH(0, 9),
        BETENG(1, 4),
        KAJENG(2, 7);

        private final int id;
        private final int urip;

        private Triwara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Caturwara {
        SRI(0, 6),
        LABA(1, 5),
        JAYA(2, 1),
        MENALA(3, 8);

        private final int id;
        private final int urip;

        private Caturwara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Pancawara {
        PAING(0, 9, 3),
        PON(1, 7, 4),
        WAGE(2, 4, 5),
        KLIWON(3, 8, 1),
        UMANIS(4, 5, 2);

        private final int id;
        private final int urip;
        private final int kupih;

        private Pancawara(int id, int urip, int kupih) {
            this.id     = id;
            this.urip   = urip;
            this.kupih  = kupih;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }

        public int getKupih() { 
            return this.kupih; 
        }
    }

    public enum Sadwara {
        TUNGLEH(0, 7),
        ARYANG(1, 6),
        URUKUNG(2, 5),
        PANIRON(3, 8),
        WAS(4, 9),
        MAULU(5, 3);

        private final int id;
        private final int urip;

        private Sadwara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Saptawara {
        REDITE(0, 5, 6, 3),
        SOMA(1, 4, 4, 4),
        ANGGARA(2, 3, 3, 5),
        BUDA(3, 7, 6, 6),
        WRESPATI(4, 8, 5, 7),
        SUKRA(5, 6, 7, 1),
        SANISCARA(6, 9, 8, 2);

        private final int id;
        private final int urip;
        private final int kertaaji;
        private final int kupih;

        private Saptawara(
            int id, 
            int urip, 
            int kertaaji, 
            int kupih) {

            this.id         = id;
            this.urip       = urip;
            this.kertaaji   = kertaaji;
            this.kupih      = kupih;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }

        public int getKupih() { 
            return this.kupih; 
        }

        public int getKertaAji() { 
            return this.kertaaji; 
        }
    }

    public enum Astawara {
        SRI(0, 6),
        INDRA(1, 5),
        GURU(2, 8),
        YAMA(3, 9),
        LUDRA(4, 3),
        BRAHMA(5, 7),
        KALA(6, 1),
        UMA(7, 4);

        private final int id;
        private final int urip;

        private Astawara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Sangawara {
        DANGU(0, 5),
        JANGUR(1, 8),
        GIGIS(2, 9),
        NOHAN(3, 3),
        OGAN(4, 7),
        ERANGAN(5, 1),
        URUNGAN(6, 4),
        TULUS(7, 6),
        DADI(8, 8);

        private final int id;
        private final int urip;

        private Sangawara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Dasawara {
        PANDITA(0, 5),
        PATI(1, 7),
        SUKA(2, 10),
        DUKA(3, 4),
        SRI(4, 6),
        MANUH(5, 2),
        MANUSA(6, 3),
        RAJA(7, 8),
        DEWA(8, 9),
        RAKSASA(9, 1);

        private final int id;
        private final int urip;

        private Dasawara(int id, int urip) {
            this.id     = id;
            this.urip   = urip;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }

        public int getUrip() { 
            return this.urip; 
        }
    }

    public enum Sasih {
        // Standard
        KASA(0),
        KARO(1),
        KATIGA(2),
        KAPAT(3),
        KALIMA(4),
        KANEM(5),
        KAPITU(6),
        KAWOLU(7),
        KASANGA(8),
        KADASA(9),
        DESTHA(10),
        SADHA(11),

        // Nampih/Mala Sasih
        MALA_DESTHA(12),
        MALA_SADHA(13),
        NAMPIH_DESTHA(14),
        NAMPIH_KATIGA(15),
        NAMPIH_KASA(16),
        NAMPIH_KADASA(17),
        NAMPIH_KARO(18),
        NAMPIH_SADHA(19);


        private final int id;

        private Sasih(int id) {
            this.id     = id;
        }

        public int getId() { 
            return this.id; 
        }

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum PenanggalInfo {
        TILEM,
        PENANGGAL,
        PURNAMA,
        PANGELONG;

        public String getName() {
            return toTitleCase(this.name());
        }
    }

    public enum BalineseDatePivot {
        PIVOT_NG_PON(1971, 0, 27, 3, 0, 0, 1892, BalineseDateConst.Sasih.KAPITU, false),
        PIVOT_NG_PAING(2000, 0, 18, 86, 12, 0, 1921, BalineseDateConst.Sasih.KAPITU, false);

        private final GregorianCalendar calendar;

        private final int pawukonDayInYear;
        private final int penanggal;
        private final int ngunaratriDay;

        private final int saka;
        private final BalineseDateConst.Sasih sasih;
        private final boolean isNampihSasih;


        private BalineseDatePivot(
            int year, 
            int month, 
            int dayOfMonth, 
            int pawukonDayInYear, 
            int penanggal,
            int ngunaratriDay,
            int saka,
            BalineseDateConst.Sasih sasih,
            boolean isNampihSasih) {

            this.calendar           = new GregorianCalendar(year, month, dayOfMonth);
            this.pawukonDayInYear   = pawukonDayInYear;
            this.penanggal          = penanggal;
            this.ngunaratriDay      = ngunaratriDay;
            this.saka               = saka;
            this.sasih              = sasih;
            this.isNampihSasih      = isNampihSasih;
        }

        public GregorianCalendar getCalendar() {
            return calendar;
        }

        public int getPawukonDayInYear() {
            return pawukonDayInYear;
        }

        public int getPenanggal() {
            return penanggal;
        }

        public int getNgunaratriDay() {
            return ngunaratriDay;
        }

        /**
         * @return the saka
         */
        public int getSaka() {
            return saka;
        }

        /**
         * @return the sasih
         */
        public BalineseDateConst.Sasih getSasih() {
            return sasih;
        }

        /**
         * @return the isNampihSasih
         */
        public boolean isNampihSasih() {
            return isNampihSasih;
        }

    }



}
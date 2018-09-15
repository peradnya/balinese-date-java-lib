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
import java.util.List;

abstract class BalineseDateBase {

    private static final int DAY_NGUNARATRI = 63;
    private static final int DAY_PAWUKON = 210;

    // Start of Pengalantaka Eka Sungsang to Pon (need to be confirmed)
    // private static final GregorianCalendar DATE_TRANSITION_PON = new
    // GregorianCalendar(1971, 0, 27);

    // Start of Pengalantaka Eka Sungsang to Paing (need to be confirmed)
    private static final GregorianCalendar PANGALANTAKA_PAING = new GregorianCalendar(2000, 0, 6);

    // Start of Sasih Berkesinambungan (Kawolu, Caka 1914) (need to be confirmed)
    private static final GregorianCalendar SK_START = new GregorianCalendar(1993, 0, 24);

    // End of Sasih Berkesinambungan (Kawolu, Caka 1924) (need to be confirmed)
    private static final GregorianCalendar SK_END = new GregorianCalendar(2003, 0, 3);

    static final int EJRMap[] = new int[] { 23, 7, 17, 7, 23, 23, 17, 9, 7, 13, 26, 24, 23, 20, 13, 7, 13, 25, 19, 6, 2,
            14, 26, 17, 20, 25, 22, 0, 10, 6, 15, 23, 7, 17, 23, 17, 25, 5, 23, 2, 2, 2, 12, 12, 5, 14, 12, 26, 26, 1,
            23, 23, 15, 25, 15, 6, 9, 25, 18, 25, 11, 15, 21, 25, 25, 12, 0, 17, 13, 0, 15, 23, 12, 7, 16, 25, 18, 24,
            12, 12, 6, 7, 6, 26, 7, 6, 12, 7, 25, 2, 12, 25, 25, 14, 15, 26, 7, 12, 20, 7, 6, 25, 25, 6, 13, 25, 17, 13,
            23, 6, 26, 20, 25, 25, 23, 7, 18, 18, 17, 7, 17, 7, 5, 26, 17, 6, 9, 12, 12, 13, 25, 18, 18, 6, 2, 25, 25,
            2, 25, 17, 20, 14, 27, 23, 17, 8, 25, 17, 6, 17, 7, 3, 15, 18, 25, 2, 7, 13, 25, 20, 7, 15, 15, 23, 7, 8,
            24, 2, 12, 9, 24, 24, 17, 24, 20, 7, 12, 12, 14, 18, 25, 20, 5, 18, 5, 20, 26, 12, 23, 18, 17, 17, 25, 15,
            2, 24, 4, 2, 23, 25, 18, 25, 20, 14, 4, 2, 25, 7, 25, 17 };

    enum Pivot {
        PIVOT_1971(1971, 0, 27, 3, 0, 0, 1892, Sasih.KAPITU, false),
        PIVOT_2000(2000, 0, 18, 86, 12, 0, 1921, Sasih.KAPITU, false);

        private final GregorianCalendar calendar;
        private final int pawukonDay;
        private final int sasihDay;
        private final int ngunaRatriDay;
        private final int saka;
        private final Sasih sasih;
        private final boolean isNampihSasih;

        private Pivot(int year, int month, int dayOfMonth, int pawukonDay, int sasihDay, int ngunaRatriDay, int saka,
                Sasih sasih, boolean isNampihSasih) {
            this.calendar = new GregorianCalendar(year, month, dayOfMonth);
            this.pawukonDay = pawukonDay;
            this.sasihDay = sasihDay;
            this.ngunaRatriDay = ngunaRatriDay;
            this.saka = saka;
            this.sasih = sasih;
            this.isNampihSasih = isNampihSasih;
        }
    }

    static int deltaDay(GregorianCalendar a, GregorianCalendar b) {
        double deltaMillis = (double) (b.getTimeInMillis() - a.getTimeInMillis());
        return (int) Math.ceil(deltaMillis / 86400000);
    }

    static int mod(int a, int b) {
        return ((a % b) + b) % b;
    }

    static Pivot getBestPivot(GregorianCalendar calendar) {
        return (calendar.compareTo(PANGALANTAKA_PAING) < 0) ? Pivot.PIVOT_1971 : Pivot.PIVOT_2000;
    }

    static int getPawukonDay(Pivot pivot, GregorianCalendar calendar) {
        int diff = deltaDay(pivot.calendar, calendar);
        return mod(pivot.pawukonDay + diff, DAY_PAWUKON);
    }

    static CaturWara getCaturWara(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 70) {
            idx = pawukonDay % 4;
        } else if (pawukonDay == 71 || pawukonDay == 72) {
            idx = CaturWara.JAYA.id();
        } else {
            idx = (pawukonDay - 2) % 4;
        }
        return CaturWara.values()[idx];
    }

    static AstaWara getAstaWara(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 70) {
            idx = pawukonDay % 8;
        } else if (pawukonDay == 71 || pawukonDay == 72) {
            idx = AstaWara.KALA.id();
        } else {
            idx = (pawukonDay - 2) % 8;
        }
        return AstaWara.values()[idx];
    }

    static SangaWara getSangaWara(int pawukonDay) {
        int idx = 0;
        if (pawukonDay <= 3) {
            idx = SangaWara.DANGU.id();
        } else {
            idx = (pawukonDay - 3) % 9;
        }
        return SangaWara.values()[idx];
    }

    static int[] getSasihDay(Pivot pivot, GregorianCalendar calendar) {
        int[] res = new int[3];
        int dayDiff = deltaDay(pivot.calendar, calendar);
        int daySkip = (int) Math.ceil((double) dayDiff / DAY_NGUNARATRI);
        int dayTotal = pivot.sasihDay + dayDiff + daySkip;

        res[0] = mod(dayTotal, 30); // calc date
        res[1] = (res[0] == 0 || res[0] > 15) ? 1 : 0; // calc if this pangelong
        res[2] = (mod(dayDiff, DAY_NGUNARATRI) == 0) ? 1 : 0; // calc if this ngunaratri
        res[0] = mod(res[0], 15);
        res[0] = (res[0] == 0) ? 15 : res[0]; // if date 0, change to date 15

        return res;
    }

    static SasihDayInfo getSasihDayInfo(int[] resSasihDay, Sasih sasih, int saka) {
        int date = resSasihDay[0];
        boolean isPangelong = resSasihDay[1] == 1;
        boolean isNgunaRatri = resSasihDay[2] == 1;

        if (isPangelong) {
            if (date == 15 || (date == 14 && isNgunaRatri)) {
                return SasihDayInfo.TILEM;
            } else if (date == 14 && sasih == Sasih.KAPITU && saka == 1921) {
                // Note: the dates between March 1999 to January 2000 are not verified,
                // because of transition from Eka Sungsang Pon to Paing.
                return SasihDayInfo.TILEM;
            } else {
                return SasihDayInfo.PANGELONG;
            }
        } else {
            if (date == 15 || (date == 14 && isNgunaRatri)) {
                return SasihDayInfo.PURNAMA;
            } else {
                return SasihDayInfo.PENANGGAL;
            }
        }
    }

    static int[] getSasihInfo(Pivot pivot, GregorianCalendar calendar) {
        int[] res = new int[3];
        int dayDiff = deltaDay(pivot.calendar, calendar);
        int daySkip = (int) Math.ceil((double) dayDiff / DAY_NGUNARATRI);
        int dayTotal = pivot.sasihDay + dayDiff + daySkip;

        // sometime pivot is tilem and also ngunaratri, so need to normalize.
        int pivotOffset = (pivot.sasihDay == 0 && pivot.ngunaRatriDay == 0) ? 0 : 1;

        // calc number of sasih
        int totalSasih = (int) Math.ceil((double) dayTotal / 30) - pivotOffset;

        int currentSasih = pivot.sasih.id();
        int currentSaka = pivot.saka - ((currentSasih == Sasih.KADASA.id()) ? 1 : 0);
        int nampihCount = pivot.isNampihSasih ? 1 : 0;

        // flags
        boolean nyepiFix = false;

        // in Sasih Kesinambungan (SK) period (1993 - 2002)
        boolean inSK = false;
        if (pivot.calendar.compareTo(SK_START) >= 0 && pivot.calendar.compareTo(SK_END) < 0) {
            inSK = true;
        }

        while (totalSasih != 0) {
            if (dayDiff >= 0) {
                if (nampihCount == 0 || nampihCount == 2) {
                    nampihCount = 0;
                    totalSasih = totalSasih - 1;
                    currentSasih = mod(currentSasih + 1, 12);
                } else {
                    totalSasih = totalSasih - 1;
                }

                // Note: Special case in 1995 which nyepi held 1 day after tilem kedasa
                // (normally 1 day after tilem kesanga). This happened because of another
                // religion holy day.
                // Source:
                // - Pendit, Nyoman.(2001). "Nyepi: kebangkitan, toleransi, dan kerukunan".
                // Jakarta : Gramedia
                // - https://id.wikipedia.org/wiki/1995
                if (currentSasih == Sasih.KADASA.id() && nampihCount == 0) {
                    currentSaka = currentSaka + 1;
                    if (currentSaka == 1917) {
                        currentSaka = currentSaka - 1;
                        nyepiFix = true;
                    }
                } else if (currentSasih == Sasih.DESTHA.id() && nampihCount == 0 && nyepiFix) {
                    currentSaka = currentSaka + 1;
                    nyepiFix = false;
                }

                if (currentSasih == Sasih.KAWOLU.id() && currentSaka == 1914) {
                    inSK = true;
                } else if (currentSasih == Sasih.KAWOLU.id() && currentSaka == 1924) {
                    inSK = false;
                }
            } else if (dayDiff < 0) {
                if (nampihCount == 0 || nampihCount == 2) {
                    nampihCount = 0;
                    totalSasih = totalSasih + 1;
                    currentSasih = mod(currentSasih - 1, 12);
                } else {
                    totalSasih = totalSasih + 1;
                }

                // Note: Special case in 1995 which nyepi held 1 day after tilem kedasa
                // (normally 1 day after tilem kesanga). This happened because of another
                // religion holy day.
                // Source:
                // - Pendit, Nyoman.(2001). "Nyepi: kebangkitan, toleransi, dan kerukunan".
                // Jakarta : Gramedia
                // - https://id.wikipedia.org/wiki/1995
                if (currentSasih == Sasih.KADASA.id() && nampihCount == 0) {
                    if (currentSaka == 1917) {
                        currentSaka = currentSaka - 1;
                        nyepiFix = true;
                    }
                } else if (currentSasih == Sasih.KASANGA.id() && nampihCount == 0) {
                    if (!nyepiFix) {
                        currentSaka = currentSaka - 1;
                    } else {
                        nyepiFix = false;
                    }
                }

                if (currentSasih == Sasih.KAPITU.id() && currentSaka == 1914) {
                    inSK = false;
                } else if (currentSasih == Sasih.KAPITU.id() && currentSaka == 1924) {
                    inSK = true;
                }
            }

            switch (currentSaka % 19) {
            case 0:
            case 6:
            case 11:
                if (currentSasih == Sasih.DESTHA.id() && !inSK) {
                    // Note : nampih desta is not happened in 2003 (transition year).
                    // Source: Ardhana, I.B.S.(2005). "Pokok-Pokok Wariga". Surabaya : Paramita.
                    if (currentSaka != 1925) {
                        nampihCount++;
                    }
                }
                break;
            case 3:
            case 8:
            case 14:
            case 16:
                if (currentSasih == Sasih.SADHA.id() && !inSK) {
                    nampihCount++;
                }
                break;
            case 2:
            case 10:
                if (currentSasih == Sasih.DESTHA.id() && inSK) {
                    nampihCount++;
                }
                break;
            case 4:
                if (currentSasih == Sasih.KATIGA.id() && inSK) {
                    nampihCount++;
                }
                break;
            case 7:
                if (currentSasih == Sasih.KASA.id() && inSK) {
                    nampihCount++;
                }
                break;
            case 13:
                if (currentSasih == Sasih.KADASA.id() && inSK) {
                    nampihCount++;
                }
                break;
            case 15:
                if (currentSasih == Sasih.KARO.id() && inSK) {
                    nampihCount++;
                }
                break;
            case 18:
                if (currentSasih == Sasih.SADHA.id() && inSK) {
                    nampihCount++;
                }
                break;
            default:
                break;
            }
        }

        res[0] = currentSaka;
        res[1] = currentSasih;

        if (dayTotal >= 0) {
            res[2] = nampihCount == 2 ? 1 : 0;
        } else {
            res[2] = nampihCount == 1 ? 1 : 0;
        }

        return res;
    }

    static Sasih getSasih(int[] resSasih) {
        int saka = resSasih[0];
        int sasih = resSasih[1];
        Sasih res = Sasih.values()[sasih];

        if (resSasih[2] == 1) {
            if (res == Sasih.DESTHA) {
                res = (saka < 1914) ? Sasih.MALA_DESTHA : Sasih.NAMPIH_DESTHA;
            } else if (res == Sasih.KATIGA) {
                return Sasih.NAMPIH_KATIGA;
            } else if (res == Sasih.KASA) {
                return Sasih.NAMPIH_KASA;
            } else if (res == Sasih.KADASA) {
                return Sasih.NAMPIH_KADASA;
            } else if (res == Sasih.KARO) {
                return Sasih.NAMPIH_KARO;
            } else if (res == Sasih.SADHA) {
                return (saka < 1914) ? Sasih.MALA_SADHA : Sasih.NAMPIH_SADHA;
            }
        }

        return res;
    }

    static PratithiSamutPada getPratithiSamutPada(List<Integer> sasihDay, SasihDayInfo sasihDayInfo, Sasih sasih,
            GregorianCalendar calendar) {
        int move = 0;
        boolean isNG = sasihDay.size() > 1;
        int day = isNG ? sasihDay.get(1) : sasihDay.get(0);

        if (sasihDayInfo.reference() == SasihDayInfo.PENANGGAL) {
            if (day == 1 && isNG) {
                move = 0; // Penanggal to Pangelong.
            } else {
                if (day >= 1 && day <= 8) {
                    move = day - 1;
                } else if (day >= 9 && day <= 13) {
                    move = day - 2;
                } else if (day == 14) {
                    move = 11;
                } else if (day == 15) {
                    move = 0;
                }
            }
        } else {
            if (day == 1 && isNG) {
                GregorianCalendar temp = (GregorianCalendar) calendar.clone();
                temp.add(GregorianCalendar.DATE, 1);

                BalineseDate nextDay = new BalineseDate(temp);
                if (nextDay.sasih().reference() != sasih.reference()) {
                    move = -1; // to the next penanggal
                }
            } else {
                move = (day >= 13) ? day - 11 : day - 1;
            }
        }

        PratithiSamutPada start = PratithiSamutPada.values()[sasih.reference().id()];
        int newId = mod(start.id() - move, 12);

        return PratithiSamutPada.values()[newId];
    }

    static void getDewasaBySaptaWaraWuku(SaptaWara saptaWara, Wuku wuku, List<Dewasa> list) {
        if (wuku == Wuku.SINTA) {
            list.add(Dewasa.BASAH_GEDE);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANCARAN);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_PRAWANI);
                list.add(Dewasa.KALA_RAU);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SAMPAR_WANGKE);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.ANGGARA) {    
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BANU_MILIR);
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_MINA);
            }
        } else if (wuku == Wuku.LANDEP) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_SIYUNG);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_GRAHA);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_GARUDA);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.KALA_GURU);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_PRAWANI);
                list.add(Dewasa.KALA_SUDANGASTRA);
                list.add(Dewasa.KALA_WISESA);
                list.add(Dewasa.TALI_WANGKE);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BABI_MUNGGAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_KUTILA);
            }
        } else if (wuku == Wuku.UKIR) {
            list.add(Dewasa.LANUS);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_NGUNA);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SAPUHAU);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.LUTUNG_MAGANDONG);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_DEMIT);
                list.add(Dewasa.KALA_PEGAT);
                list.add(Dewasa.KALA_RAU);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            }
        } else if (wuku == Wuku.KULANTIR) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.BASAH_GEDE);
            list.add(Dewasa.KALA_INGSOR);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BANU_MILIR);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_MUAS);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_BANGKUNG);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SRIGATI_JENEK);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SARIK_AGUNG);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {

            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_GUMARANG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_RAU);
            }
        } else if (wuku == Wuku.TOLU) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.KALA_PATI);
            list.add(Dewasa.WAS_PENGANTEN);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MATAMPAK);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SRIGATI_TURUN);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANCARAN);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_MINA);
                list.add(Dewasa.KALA_PACEKAN);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_GRAHA);
                list.add(Dewasa.KALA_WISESA);
            }
        } else if (wuku == Wuku.GUMBREG) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.SALAH_WADI);
            list.add(Dewasa.TANPA_GURU);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUWUNG);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_RAU);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_SUDANGASTRA);
            }
        } else if (wuku == Wuku.WARIGA) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.KALA_SARANG);
            list.add(Dewasa.RANGDA_TIGA);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BABI_MUNGGAH);
                list.add(Dewasa.KALA_PANENENG);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SAMPAR_WANGKE);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SRIGATI_MUNGGAH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_BUINGRAU);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_PAGER);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KALA_EMPAS);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BANCARAN);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MATAMPAK);
            }
        } else if (wuku == Wuku.WARIGADEAN) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.RANGDA_TIGA);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_BUINGRAU);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.BANU_MILIR);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.LUTUNG_MAGANDONG);
                list.add(Dewasa.SRIGATI_JENEK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_MINA);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_DANGU);
            }
        } else if (wuku == Wuku.JULUNGWANGI) {
            list.add(Dewasa.BASAH_GEDE);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_WISESA);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.SRIGATI_TURUN);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_SOR);
            }
        } else if (wuku == Wuku.SUNGSANG) {
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_PATI);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_NGERUDA);
                list.add(Dewasa.KALA_SIYUNG);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_NGERUDA);
            }
        } else if (wuku == Wuku.DUNGULAN) {
            list.add(Dewasa.KALA_PATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.SALAH_WADI);
            list.add(Dewasa.WAS_PENGANTEN);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_LUANG);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_ISINAN);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BABI_MUNGGAH);
                list.add(Dewasa.KALA_BANCARAN);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MINA);
                list.add(Dewasa.KALA_NGADEG);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SARIK_AGUNG);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.KALA_WISESA);
            }
        } else if (wuku == Wuku.KUNINGAN) {
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.TANPA_GURU);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.KALA_TUMAPEL);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_NGADEG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUDANGASTRA);
                list.add(Dewasa.KALA_TUMAPEL);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BANCARAN);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_NGADEG);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.TALI_WANGKE);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.SRIGATI_JENEK);
            }
        } else if (wuku == Wuku.LANGKIR) {
            list.add(Dewasa.BASAH_CENIK);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MATAMPAK);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SAMPAR_WANGKE);
                list.add(Dewasa.TALI_WANGKE);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.COROK_KODONG);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.LUTUNG_MAGANDONG);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BANU_MILIR);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SRIGATI_TURUN);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_SUWUNG);
            }
        } else if (wuku == Wuku.MEDANGSIA) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.KALA_INGSOR);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KAJENG_SUSUNAN);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_BANGKUNG);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_RUMPUH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.KALA_TEMAH);
            }
        } else if (wuku == Wuku.PUJUD) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.RANGDA_TIGA);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_NGADEG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SOMA) {

            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_WISESA);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_GUMARANG);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.TITI_BUWUK);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BABI_MUNGGAH);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            }
        } else if (wuku == Wuku.PAHANG) {
            list.add(Dewasa.LANUS);
            list.add(Dewasa.RANGDA_TIGA);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {

            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_MATAMPAK);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.WRASPATI) {

            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KAJENG_LULUNAN);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MUAS);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.TITI_BUWUK);
            }
        } else if (wuku == Wuku.KRULUT) {
            list.add(Dewasa.KALA_SARANG);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.WAS_PENGANTEN);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_ANGIN);
                list.add(Dewasa.KALA_NGADEG);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_ISINAN);
                list.add(Dewasa.KALA_KILANGKILUNG);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_WAS);
                list.add(Dewasa.SRIGATI_JENEK);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_NGARABIN);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.BANU_URUNG);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.TALI_WANGKE);
            }
        } else if (wuku == Wuku.MERAKIH) {
            list.add(Dewasa.LANUS);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.SRIGATI_TURUN);
                list.add(Dewasa.TITI_BUWUK);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MINA);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.SARIK_AGUNG);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.LUTUNG_MAGANDONG);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_WISESA);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
                list.add(Dewasa.KALA_NGARABIN);
                list.add(Dewasa.KALA_PEGAT);
                list.add(Dewasa.KALA_RAU);
            }
        } else if (wuku == Wuku.TAMBIR) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_NGADEG);
                list.add(Dewasa.SAMPAR_WANGKE);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_GACOKAN);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_KILANGKILUNG);
                list.add(Dewasa.KALA_MACAN);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_PRAWANI);
                list.add(Dewasa.KALA_SUDANGASTRA);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_GUMARANG);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.BABI_MUNGGAH);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BANGKUNG);
            }
        } else if (wuku == Wuku.MEDANGKUNGAN) {
            list.add(Dewasa.BASAH_GEDE);
            list.add(Dewasa.SALAH_WADI);
            list.add(Dewasa.TANPA_GURU);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_MRETYU);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {

            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.KALA_DANGU);
            }
        } else if (wuku == Wuku.MATAL) {
            list.add(Dewasa.BASAH_GEDE);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BANU_URUNG); 
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.SRIGATI_JENEK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_MINA);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_DANGU);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TITI_BUWUK);
                list.add(Dewasa.TUTUT_MASIH);
            }
        } else if (wuku == Wuku.UYE) {
            list.add(Dewasa.LANUS);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_DANGU);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_WISESA);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.SRIGATI_TURUN);
            } else if (saptaWara == SaptaWara.BUDHA) {

            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                
            }
        } else if (wuku == Wuku.MENAIL) {
            list.add(Dewasa.KALA_PATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.RANGDA_TIGA);
            list.add(Dewasa.WAS_PENGANTEN);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BRAHMA);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_NGERUDA);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.LUTUNG_MAGANDONG);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_CAKRA);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.TITI_BUWUK);
            }
        } else if (wuku == Wuku.PRANGBAKAT) {
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.KALA_INGSOR);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.RANGDA_TIGA);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_GUMARANG);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_SUDANGASTRA);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.BOJOG_MUNGGAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_PRAWANI);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_CAPLOKAN);
                list.add(Dewasa.KALA_OLIH);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.TITI_BUWUK);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_MATAMPAK);
            }
        } else if (wuku == Wuku.BALA) {
            list.add(Dewasa.BASAH_CENIK);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_ANGIN);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_MINA);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.SAMPAR_WANGKE);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.SARIK_AGUNG);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_WISESA);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.SRIGATI_JENEK);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_DANGU);
            }
        } else if (wuku == Wuku.UGU) {
            list.add(Dewasa.BASAH_GEDE);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_KUTILA);
                list.add(Dewasa.TITI_BUWUK);
                list.add(Dewasa.TUTUR_MANDI);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_REBUTAN);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.BABI_TURUN);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_RUMPUH);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.SRIGATI_TURUN);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_SUDUKAN);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.GUNTUR_GRAHA);
                list.add(Dewasa.KALA_BUINGRAU);
            }
        } else if (wuku == Wuku.WAYANG) {
            list.add(Dewasa.BASAH_GEDE);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.KALA_SUNGSANG);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_MUAS);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_MRETYU);
                list.add(Dewasa.KALA_PATI);
                list.add(Dewasa.KALA_SAPUHAU);
                list.add(Dewasa.KALA_SUDUKAN);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TALI_WANGKE);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.ASUAJAG_MUNGGAH);
                list.add(Dewasa.KALA_RUMPUH);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.SAMPI_GUMARANG_TURUN);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.TUTUT_MASIH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_SOR);
            }
        } else if (wuku == Wuku.KLAWU) {
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.KALA_PATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.TANPA_GURU);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_ANGIN);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_NGADEG);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_SUDANGASTRA);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.BABI_MUNGGAH);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_MINA);
                list.add(Dewasa.KALA_SAPUHAU);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BOJOG_TURUN);
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.LUTUNG_MAGANDONG);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.ASUASA);
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_SIYUNG);
                list.add(Dewasa.KALA_SOR);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SRIGATI_MUNGGAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_TEMAH);
            }
        } else if (wuku == Wuku.DUKUT) {
            list.add(Dewasa.KALA_PATI);
            list.add(Dewasa.LANUS);
            list.add(Dewasa.WAS_PENGANTEN);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_MATAMPAK);
                list.add(Dewasa.KALA_NGERUDA);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.KALA_WISESA);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_EMPAS);
                list.add(Dewasa.KALA_SIYUNG);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_KUTILA);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.ASUAJAG_TURUN);
                list.add(Dewasa.KALA_JENGKING);
                list.add(Dewasa.KALA_LUANG);
                list.add(Dewasa.KALA_RAJA);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BANU_URUNG);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.SAMPI_GUMARANG_MUNGGAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.KALA_BANGKUNG);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.KALA_TEMAH);
                list.add(Dewasa.TITI_BUWUK);
            }
        } else if (wuku == Wuku.WATUGUNUNG) {
            list.add(Dewasa.BASAH_GEDE);
            list.add(Dewasa.CARIK_WALANGATI);
            list.add(Dewasa.SALAH_WADI);
            if (saptaWara == SaptaWara.REDITE) {
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_KUTILA_MANIK);
                list.add(Dewasa.KALA_RUMPUH);
                list.add(Dewasa.SRIGATI_JENEK);
                list.add(Dewasa.TITI_BUWUK);
            } else if (saptaWara == SaptaWara.SOMA) {
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.ANGGARA) {
                list.add(Dewasa.KALA_LUANG);
            } else if (saptaWara == SaptaWara.BUDHA) {
                list.add(Dewasa.KALA_GUMARANG);
                list.add(Dewasa.KALA_ISINAN);
                list.add(Dewasa.KALA_MERENG);
                list.add(Dewasa.KALA_SOR);
            } else if (saptaWara == SaptaWara.WRASPATI) {
                list.add(Dewasa.BABI_TURUN);
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_MATAMPAK);
            } else if (saptaWara == SaptaWara.SUKRA) {
                list.add(Dewasa.BOJOG_MUNGGAH);
                list.add(Dewasa.KALA_BESER);
                list.add(Dewasa.KALA_BRAHMA);
                list.add(Dewasa.KALA_BUINGRAU);
                list.add(Dewasa.KALA_NGADEG);
                list.add(Dewasa.KALA_PANENENG);
                list.add(Dewasa.KALA_SAPUHAU);
                list.add(Dewasa.KALA_SUWUNG);
                list.add(Dewasa.KALA_TEMAH);
            } else if (saptaWara == SaptaWara.SANISCARA) {
                list.add(Dewasa.JIWA_MANGANTI);
                list.add(Dewasa.KAJENG_RENDETAN);
                list.add(Dewasa.KALA_DANGU);
                list.add(Dewasa.SRIGATI_TURUN);
            }
        }
    }

    public abstract Wuku wuku();

    public abstract EkaWara ekaWara();

    public abstract DwiWara dwiWara();

    public abstract TriWara triWara();

    public abstract CaturWara caturWara();

    public abstract PancaWara pancaWara();

    public abstract SadWara sadWara();

    public abstract SaptaWara saptaWara();

    public abstract AstaWara astaWara();

    public abstract SangaWara sangaWara();

    public abstract DasaWara dasaWara();

    public abstract Ingkel ingkel();

    public abstract Jejepan jejepan();

    public abstract WatekAlit watekAlit();

    public abstract WatekMadya watekMadya();

    public abstract Lintang lintang();

    public abstract PancaSuda pancaSuda();

    public abstract Pararasan pararasan();

    public abstract Rakam rakam();

    public abstract EkaJalaRsi ekaJalaRsi();

    public abstract List<Integer> sasihDay();

    public abstract SasihDayInfo sasihDayInfo();

    public abstract Sasih sasih();

    public abstract int saka();

    public abstract PratithiSamutPada pratithiSamutPada();

    public abstract List<Dewasa> dewasa();

}
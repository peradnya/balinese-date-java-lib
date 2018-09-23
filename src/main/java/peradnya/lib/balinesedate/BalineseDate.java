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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * BalineseDate provide the implementation of Balinese Saka Calendar.
 * <p>
 * BalineseDate is designed to be <u>immutable</u> and <u>thread-safe</u>.
 * BalineseDate have several balinese calendar features like:
 * <ul>
 * <li><a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/kalender-pawukon.htm'>Pawukon</a></li>
 * <li><a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/pawewaran.htm'>Pawewaran</a></li>
 * <li><a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/paringkelan.htm'>Paringkelan</a></li>
 * <li>Eka Jala Rsi</li>
 * <li>Pratithi Samut Pada</li>
 * <li>Dewasa</li>
 * <li>Sasih</li>
 * <li><a target='_blank' href=
 * 'http://www.babadbali.com/pewarigaan/kalender-saka.htm'>Saka</a></li>
 * </ul>
 * <p>
 * <b>References</b> used by BalineseDate:
 * <ul>
 * <li><a target='_blank' href='http://www.babadbali.com/'>Babadbali.com
 * (Yayasan Bali Galang).</a></li>
 * <li>Ardhana, I.B.S. (2005). "Pokok-Pokok Wariga". Surabaya : Paramita.</li>
 * <li>Pendit, Nyoman. (2001). "Nyepi: kebangkitan, toleransi, dan kerukunan".
 * Jakarta : Gramedia.</li>
 * </ul>
 *
 * @author Ida Bagus Putu Peradnya Dinata
 */
public final class BalineseDate extends BalineseDateBase implements Serializable {

    private static final long serialVersionUID = -6078268949688388003L;

    private final int year, month, day;
    private final Wuku wuku;
    private final EkaWara ekaWara;
    private final DwiWara dwiWara;
    private final TriWara triWara;
    private final CaturWara caturWara;
    private final PancaWara pancaWara;
    private final SadWara sadWara;
    private final SaptaWara saptaWara;
    private final AstaWara astaWara;
    private final SangaWara sangaWara;
    private final DasaWara dasaWara;
    private final Ingkel ingkel;
    private final Jejepan jejepan;
    private final WatekAlit watekAlit;
    private final WatekMadya watekMadya;
    private final Lintang lintang;
    private final PancaSuda pancaSuda;
    private final Pararasan pararasan;
    private final Rakam rakam;
    private final EkaJalaRsi ekaJalaRsi;
    private final int saka;
    private final List<Integer> sasihDay;
    private final SasihDayInfo sasihDayInfo;
    private final Sasih sasih;
    private final PratithiSamutPada pratithiSamutPada;
    private final List<Dewasa> dewasa;

    /**
     * Construct BalineseDate with current date.
     */
    public BalineseDate() {
        this(null);
    }

    /**
     * Construct BalineseDate with specific date. The date will be cloned to prevent
     * modification from outside. Providing null value in constructor parameter will
     * construct BalineseDate with current date.
     * 
     * @param date the date in GregorianCalendar.
     */
    public BalineseDate(GregorianCalendar date) {
        GregorianCalendar calendar = (date == null) ? new GregorianCalendar() : (GregorianCalendar) date.clone();
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
        calendar.set(GregorianCalendar.MINUTE, 0);
        calendar.set(GregorianCalendar.SECOND, 0);
        calendar.set(GregorianCalendar.MILLISECOND, 0);

        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        Pivot pivot = getBestPivot(calendar);

        int pawukonDay = getPawukonDay(pivot, calendar);
        wuku = Wuku.values()[pawukonDay / 7];
        triWara = TriWara.values()[pawukonDay % 3];
        pancaWara = PancaWara.values()[pawukonDay % 5];
        sadWara = SadWara.values()[pawukonDay % 6];
        saptaWara = SaptaWara.values()[pawukonDay % 7];
        jejepan = Jejepan.values()[pawukonDay % 6];
        lintang = Lintang.values()[pawukonDay % 35];
        pancaSuda = PancaSuda.values()[(saptaWara.kertaAji() + pancaWara.urip()) % 7];
        rakam = Rakam.values()[(saptaWara.kupih() + pancaWara.kupih()) % 6];
        ekaJalaRsi = EkaJalaRsi.values()[EJRMap[pawukonDay]];
        ingkel = Ingkel.values()[wuku.id() % 6];

        int urip = pancaWara.urip() + saptaWara.urip();
        ekaWara = EkaWara.values()[urip % 2];
        dwiWara = DwiWara.values()[urip % 2];
        dasaWara = DasaWara.values()[urip % 10];
        watekAlit = WatekAlit.values()[urip % 4];
        watekMadya = WatekMadya.values()[urip % 5];
        pararasan = Pararasan.values()[urip % 10];
        caturWara = getCaturWara(pawukonDay);
        astaWara = getAstaWara(pawukonDay);
        sangaWara = getSangaWara(pawukonDay);

        int[] resSasih = getSasihInfo(pivot, calendar);
        int[] resSasihDay = getSasihDay(pivot, calendar);
        saka = resSasih[0];
        sasih = getSasih(resSasih);
        sasihDayInfo = getSasihDayInfo(resSasihDay, sasih, saka);

        List<Integer> tempSasihDay = new ArrayList<Integer>();
        tempSasihDay.add(resSasihDay[0]);
        if (resSasihDay[2] == 1) {
            int extra = (resSasihDay[0] == 15) ? 1 : resSasihDay[0] + 1;
            tempSasihDay.add(extra);
        }
        sasihDay = Collections.unmodifiableList(tempSasihDay);
        pratithiSamutPada = getPratithiSamutPada(sasihDay, sasihDayInfo, sasih, calendar);

        List<Dewasa> tempDewasa = new ArrayList<Dewasa>();
        getDewasaByWuku(wuku, saptaWara, tempDewasa);

        dewasa = Collections.unmodifiableList(tempDewasa);
    }

    /**
     * Returns the {@link Wuku} of BalineseDate.
     * 
     * @return the {@link Wuku} of BalineseDate
     */
    @Override
    public Wuku wuku() {
        return wuku;
    }

    /**
     * Returns the {@link EkaWara} of BalineseDate.
     * 
     * @return the {@link EkaWara} of BalineseDate
     */
    @Override
    public EkaWara ekaWara() {
        return ekaWara;
    }

    /**
     * Returns the {@link DwiWara} of BalineseDate.
     * 
     * @return the {@link DwiWara} of BalineseDate
     */
    @Override
    public DwiWara dwiWara() {
        return dwiWara;
    }

    /**
     * Returns the {@link TriWara} of BalineseDate.
     * 
     * @return the {@link TriWara} of BalineseDate
     */
    @Override
    public TriWara triWara() {
        return triWara;
    }

    /**
     * Returns the {@link CaturWara} of BalineseDate.
     * 
     * @return the {@link CaturWara} of BalineseDate
     */
    @Override
    public CaturWara caturWara() {
        return caturWara;
    }

    /**
     * Returns the {@link PancaWara} of BalineseDate.
     * 
     * @return the {@link PancaWara} of BalineseDate
     */
    @Override
    public PancaWara pancaWara() {
        return pancaWara;
    }

    /**
     * Returns the {@link SadWara} of BalineseDate.
     * 
     * @return the {@link SadWara} of BalineseDate
     */
    @Override
    public SadWara sadWara() {
        return sadWara;
    }

    /**
     * Returns the {@link SaptaWara} of BalineseDate.
     * 
     * @return the {@link SaptaWara} of BalineseDate
     */
    @Override
    public SaptaWara saptaWara() {
        return saptaWara;
    }

    /**
     * Returns the {@link AstaWara} of BalineseDate.
     * 
     * @return the {@link AstaWara} of BalineseDate
     */
    @Override
    public AstaWara astaWara() {
        return astaWara;
    }

    /**
     * Returns the {@link SangaWara} of BalineseDate.
     * 
     * @return the {@link SangaWara} of BalineseDate
     */
    @Override
    public SangaWara sangaWara() {
        return sangaWara;
    }

    /**
     * Returns the {@link DasaWara} of BalineseDate.
     * 
     * @return the {@link DasaWara} of BalineseDate
     */
    @Override
    public DasaWara dasaWara() {
        return dasaWara;
    }

    /**
     * Returns the {@link Ingkel} of BalineseDate.
     * 
     * @return the {@link Ingkel} of BalineseDate
     */
    @Override
    public Ingkel ingkel() {
        return ingkel;
    }

    /**
     * Returns the {@link Jejepan} of BalineseDate.
     * 
     * @return the {@link Jejepan} of BalineseDate
     */
    @Override
    public Jejepan jejepan() {
        return jejepan;
    }

    /**
     * Returns the {@link WatekAlit} of BalineseDate.
     * 
     * @return the {@link WatekAlit} of BalineseDate
     */
    @Override
    public WatekAlit watekAlit() {
        return watekAlit;
    }

    /**
     * Returns the {@link WatekMadya} of BalineseDate.
     * 
     * @return the {@link WatekMadya} of BalineseDate
     */
    @Override
    public WatekMadya watekMadya() {
        return watekMadya;
    }

    /**
     * Returns the {@link Lintang} of BalineseDate.
     * 
     * @return the {@link Lintang} of BalineseDate
     */
    @Override
    public Lintang lintang() {
        return lintang;
    }

    /**
     * Returns the {@link PancaSuda} of BalineseDate.
     * 
     * @return the {@link PancaSuda} of BalineseDate
     */
    @Override
    public PancaSuda pancaSuda() {
        return pancaSuda;
    }

    /**
     * Returns the {@link Pararasan} of BalineseDate.
     * 
     * @return the {@link Pararasan} of BalineseDate
     */
    @Override
    public Pararasan pararasan() {
        return pararasan;
    }

    /**
     * Returns the {@link Rakam} of BalineseDate.
     * 
     * @return the {@link Rakam} of BalineseDate
     */
    @Override
    public Rakam rakam() {
        return rakam;
    }

    /**
     * Returns the {@link EkaJalaRsi} of BalineseDate.
     * 
     * @return the {@link EkaJalaRsi} of BalineseDate
     */
    @Override
    public EkaJalaRsi ekaJalaRsi() {
        return ekaJalaRsi;
    }

    /**
     * Returns the list of integer (value from 1 to 15) that represent sasihDay of
     * BalineseDate. There are 2 possible return value of sasihDay:
     * <ul>
     * <li>In Normal day, sasihDay is consist of 1 integer value</li>
     * <li>In NgunaRatri day, sasihDay are consist of 2 integer values</li>
     * </ul>
     * <p>
     * <b>Note:</b> The return value of this method is protected by
     * {@code Collections.unmodifiableList()} to prevent list modification from
     * outside.
     * 
     * @return the sasihDay of BalineseDate
     */
    @Override
    public List<Integer> sasihDay() {
        return sasihDay;
    }

    /**
     * Returns the {@link SasihDayInfo} of BalineseDate.
     * 
     * @return the {@link SasihDayInfo} of BalineseDate
     */
    @Override
    public SasihDayInfo sasihDayInfo() {
        return sasihDayInfo;
    }

    /**
     * Returns the {@link Sasih} of BalineseDate.
     * 
     * @return the {@link Sasih} of BalineseDate
     */
    @Override
    public Sasih sasih() {
        return sasih;
    }

    /**
     * Returns the Saka Year of BalineseDate.
     * 
     * @return the Saka Year of BalineseDate
     */
    @Override
    public int saka() {
        return saka;
    }

    /**
     * Returns the {@link PratithiSamutPada} of BalineseDate.
     * 
     * @return the {@link PratithiSamutPada} of BalineseDate
     */
    @Override
    public PratithiSamutPada pratithiSamutPada() {
        return pratithiSamutPada;
    }

    /**
     * Returns the list of {@link Dewasa} of BalineseDate.
     * <p>
     * <b>Note:</b> The return value of this method is protected by
     * {@code Collections.unmodifiableList()} to prevent list modification from
     * outside.
     * 
     * @return the list of {@link Dewasa} of BalineseDate
     */
    @Override
    public List<Dewasa> dewasa() {
        return dewasa;
    }

    /**
     * Returns the string representation of BalineseDate.
     * 
     * @return the string representation of BalineseDate
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(saptaWara);
        sb.append(' ');
        sb.append(pancaWara);
        sb.append(' ');
        sb.append(wuku);
        sb.append(", ");
        sb.append(sasihDayInfo.reference());
        sb.append(' ');
        sb.append(sasihDay.get(0));
        if (sasihDay.size() > 1) {
            sb.append('/');
            sb.append(sasihDay.get(1));
        }
        sb.append(" Sasih ");
        sb.append(sasih);
        sb.append(" Saka ");
        sb.append(saka);

        return sb.toString();
    }

    /**
     * Returns the copy of date that used internally by BalineseDate.
     * 
     * @return the copy of date that used internally by BalineseDate
     */
    public GregorianCalendar toDate() {
        return new GregorianCalendar(year, month, day);
    }

}
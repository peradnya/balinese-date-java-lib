import org.junit.Test;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import net.peradnya.balinesedate.*;

public class BalineseDateTest {

    @Test public void testDate_2000_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2000,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        // Wuku
        assertEquals(Constants.Wuku.SUNGSANG, bDate.getPawukon().getWuku());

        // Wewaran
        assertEquals(Constants.Ekawara.VOID, bDate.getPawukon().getEkawara());
        assertEquals(Constants.Dwiwara.MANGA, bDate.getPawukon().getDwiwara());
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
    }
    
    @Test public void testDate_2017_01_01() {
        GregorianCalendar date  = new GregorianCalendar(2017,01,01);
        BalineseDate bDate      = new BalineseDate(date);

        assertEquals(Constants.Wuku.KLAWU, bDate.getPawukon().getWuku());
    }


}
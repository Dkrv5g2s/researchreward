package Utils;
import Utils.verifyDuplicatePaper.VerifyUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class testVerifyDuplicatePaperUtils {
    private VerifyUtils Util;

    @Before
    public void setUp(){
        Util = new VerifyUtils();
    }

    @Test
    public void ComparePaperTest(){
        String paperChiTitle = "從ERDs到跨維度查詢之推薦－以維度資料地圖為指引";
        String paperEngTitle = "5G mobile telecommunication network-Technical requirement of 5G security";

//        Assert.assertEquals(true, Util.isInputaDuplicatePaperTitle(paperChiTitle));
//        Assert.assertEquals(false, Util.isInputaDuplicatePaperTitle(paperEngTitle));
    }




}

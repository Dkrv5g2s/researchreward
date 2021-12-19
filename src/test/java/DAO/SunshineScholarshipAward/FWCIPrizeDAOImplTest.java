package DAO.SunshineScholarshipAward;

import Bean.SunshineScholarshipAward.FWCIPrizeInfomation;
import Dao.SunshineScholarshipAward.FWCIPrizeDAO;
import Dao.SunshineScholarshipAward.Impl.FWCIPrizeDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FWCIPrizeDAOImplTest {
    FWCIPrizeDAO fwciPrizeDAO;
    @Before
    public void setUp(){
        fwciPrizeDAO = new FWCIPrizeDAOImpl();
    }
    @Test
    public void testGetFwciPrize(){
        FWCIPrizeInfomation fwciPrizeInfomation = fwciPrizeDAO.get();
        Assert.assertEquals("10000", fwciPrizeInfomation.getUnderOnePointThreePrize());
        Assert.assertEquals("14000", fwciPrizeInfomation.getUnderOnePointFivePrize());
        Assert.assertEquals("18000", fwciPrizeInfomation.getUnderOnePointEightPrize());
        Assert.assertEquals("22000", fwciPrizeInfomation.getUnderTwoPointTwoPrize());
        Assert.assertEquals("26000", fwciPrizeInfomation.getOverTwoPointTwoPrize());
    }

}

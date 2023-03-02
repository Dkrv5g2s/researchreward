package Service;

import Bean.Award.Award;
import Service.Admin.AwardTimeLimitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class testAwardTimeLimitService {
    private AwardTimeLimitService service;

    @Before
    public void setUp(){
        service = new AwardTimeLimitService();
    }

    @Test
    public void testGetOpeningReward(){
        List<Award> openingRewards = service.getOpeningReward();
        openingRewards.stream().forEach(i -> System.out.println(i.getAwardNameWithApplicationPeriod()));
    }
    @Test
    public void testIsRewardOpening(){
        String applyRewardType = "陽光獎助金論文獎勵";
        Assert.assertTrue(service.isRewardOpening(applyRewardType));
    }
}

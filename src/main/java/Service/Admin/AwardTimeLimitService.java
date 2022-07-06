package Service.Admin;

import Bean.Admin.AwardTimeLimit;
import Bean.Award.Award;
import Dao.Admin.AwardTimeLimitDAO;
import Dao.Admin.Impl.AwardTimeLimitDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class AwardTimeLimitService {

    private AwardTimeLimitDAO awardTimeLimitDAO = new AwardTimeLimitDAOImpl();

    public void save(JSONObject jsonObject){
        AwardTimeLimit awardTimeLimit = new AwardTimeLimit(new Date(jsonObject.getDate("s1").getTime()),
                new Date(jsonObject.getDate("s2").getTime()),
                new Date(jsonObject.getDate("s3").getTime()),
                new Date(jsonObject.getDate("s4").getTime()),
                new Date(jsonObject.getDate("s5").getTime()),
                new Date(jsonObject.getDate("s6").getTime()),
                new Date(jsonObject.getDate("s7").getTime()),
                new Date(jsonObject.getDate("s8").getTime()),
                new Date(jsonObject.getDate("l1").getTime()),
                new Date(jsonObject.getDate("l2").getTime()),
                new Date(jsonObject.getDate("l3").getTime()),
                new Date(jsonObject.getDate("l4").getTime()),
                new Date(jsonObject.getDate("l5").getTime()),
                new Date(jsonObject.getDate("l6").getTime()),
                new Date(jsonObject.getDate("l7").getTime()),
                new Date(jsonObject.getDate("l8").getTime()),
                jsonObject.getDouble("fwciOfFiveYear"));
        awardTimeLimit.setFwciOfThreeYear(jsonObject.getDouble("fwciOfThreeYear"));
        awardTimeLimit.setH5Index(jsonObject.getDouble("h5Index"));
        awardTimeLimitDAO.save(awardTimeLimit);
    }

    public JSONObject get(){
        AwardTimeLimit result = awardTimeLimitDAO.get();

        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public List<Award> getOpeningReward(){

        List<Award> rewards = new ArrayList<>();
        AwardTimeLimit result = awardTimeLimitDAO.get();
        long systemTime = System.currentTimeMillis();
        if(result.getS1().getTime() < systemTime && systemTime < result.getL1().getTime()){
            rewards.add(new Award("獎助研究及產學績優教師聘任研究人員辦法",result.getS1(),result.getL1())); // after 2022/07/06 , first word display normally.
        }
        if(result.getS2().getTime() < systemTime && systemTime < result.getL2().getTime()){
            rewards.add(new Award("講座教授",result.getS2(),result.getL2()));
        }
        if(result.getS3().getTime() < systemTime && systemTime < result.getL3().getTime()){
            rewards.add(new Award("特聘教授",result.getS3(),result.getL3()));
        }
        if(result.getS4().getTime() < systemTime && systemTime < result.getL4().getTime()){
            rewards.add(new Award("傑出研究獎",result.getS4(),result.getL4()));
        }
        if(result.getS5().getTime() < systemTime && systemTime < result.getL5().getTime()){
            rewards.add(new Award("年輕學者研究獎",result.getS5(),result.getL5()));
        }
        if(result.getS6().getTime() < systemTime && systemTime < result.getL6().getTime()){
            rewards.add(new Award("獎勵特殊優秀研究人才",result.getS6(),result.getL6()));
        }
        if(result.getS7().getTime() < systemTime && systemTime < result.getL7().getTime()){
            rewards.add(new Award("獎勵新聘特殊優秀研究人才",result.getS7(),result.getL7()));
            rewards.add(new Award("(續撥)獎勵新聘特殊優秀研究人才",result.getS7(),result.getL7()));
        }
        if(result.getS8().getTime() < systemTime && systemTime < result.getL8().getTime()){
            rewards.add(new Award("陽光獎助金論文獎勵",result.getS8(),result.getL8()));
        }

        return rewards;

    }


    public boolean isRewardOpening(String rewardType) {
        long systemTime = System.currentTimeMillis();

        List<Award> openingRewards = this.getOpeningReward();

        for (Award award : openingRewards) {
            if (award.getAwardName().equals(rewardType)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
}

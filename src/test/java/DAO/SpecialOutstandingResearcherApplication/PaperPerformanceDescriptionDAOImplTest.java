package DAO.SpecialOutstandingResearcherApplication;

import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ListIterator;

public class PaperPerformanceDescriptionDAOImplTest {
    private String userName;
    private String paperTitle;
    private String reward_type;
    private PaperPerformanceDescriptionDAO dao;

    @Before
    public void setUp(){
        dao = new PaperPerformanceDescriptionDAOImpl();

    }
    @Test
    public void testQueryUserNameByPaperTitle(){
        paperTitle = "fsdfds";
        userName = "林老師";
        Assert.assertEquals(userName,  dao.queryUserNameByPaperTitle(paperTitle));
    }

    @Test
    public void testTotalPaperSentenceInSpecifiedReward(){
        reward_type = "陽光獎助金論文獎勵";
        List<String> totalPaperSentenceList = dao.query_total_paper_sentence_in_specified_reward(reward_type);
        ListIterator<String> it = totalPaperSentenceList.listIterator();
        System.out.println("ListSize :"+totalPaperSentenceList.size());
        while (it.hasNext()) {
            String item = it.next();
            System.out.println("queryItem :"+item);
        }

    }
}

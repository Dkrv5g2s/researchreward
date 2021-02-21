package DAO.SpecialOutstandingResearcherApplication;

import Bean.Project.RewardProject;
import Constants.ProgressConstant;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;
import java.util.ListIterator;

public class PaperPerformanceDescriptionDAOImplTest {
    private String userName;
    private String paperTitle;
    private PaperPerformanceDescriptionDAO dao;

    @Before
    public void setUp(){
        dao = new PaperPerformanceDescriptionDAOImpl();

    }
    @Test
    public void TestqueryUserNameByPaperTitle(){
        paperTitle = "從ERDs到跨維度查詢之推薦－以維度資料地圖為指引";
        userName = "林老師";
        Assert.assertEquals(userName,  dao.queryUserNameByPaperTitle(paperTitle));
    }

}

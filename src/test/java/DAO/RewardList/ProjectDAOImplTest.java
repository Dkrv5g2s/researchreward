package DAO.RewardList;


import Bean.Project.RewardProject;
import Constants.ProgressConstant;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;
import java.util.ListIterator;

// ?: cause of DAO測試的隱含問題 待引入in-memory DAO unit test後再引入 避免資料庫汙染
public class ProjectDAOImplTest {
    private String staffCode;
    private String reward;
    private String initStatus;
    private String afterStatus;
    private ProjectDAO projectDAO;

    @Before
    public void setUp(){
        projectDAO = new ProjectDAOImpl();
        staffCode = "Test_Staff_Code";
        reward = "傑出研究獎";
        initStatus = ProgressConstant.DRAFT;
        afterStatus = ProgressConstant.SUBMIT_COLLEGE_FOR_REVIEW;
    }
    @Test
    public void insertNewRewardProjectTest(){
        projectDAO.insertNewProject(staffCode,initStatus ,reward);
        List<RewardProject> list = projectDAO.getProjects(staffCode, initStatus);
        ListIterator<RewardProject> it = list.listIterator();
        while (it.hasNext()) {
            RewardProject project = it.next();
            Assert.assertEquals(staffCode, project.getStaff_code());
            Assert.assertEquals(reward, project.getReward_type());
            Assert.assertEquals(initStatus, project.getStatus());
            projectDAO.deleteProject(project.getProject_id(),project.getStaff_code());
        }


    }
    @Test
    public void updateRewardProjectTest(){
        projectDAO.insertNewProject(staffCode,initStatus ,reward);

        List<RewardProject> list = projectDAO.getProjects(staffCode, initStatus);
        RewardProject newone = null;
        ListIterator<RewardProject> it = list.listIterator();
        while (it.hasNext()) {
            RewardProject project = it.next();
            Assert.assertEquals(staffCode, project.getStaff_code());
            Assert.assertEquals(reward, project.getReward_type());
            Assert.assertEquals(initStatus, project.getStatus());
            newone = new RewardProject(project.getProject_id(),staffCode,afterStatus, "陽光獎助金論文獎勵") ;
        }
        projectDAO.UpdateProjectStatus(newone);

        List<RewardProject> updated_list = projectDAO.getProjects(staffCode, afterStatus);
        ListIterator<RewardProject> it_update = updated_list.listIterator();
        while (it_update.hasNext()) {
            RewardProject project = it_update.next();
            Assert.assertEquals(staffCode, project.getStaff_code());
            Assert.assertEquals(reward, project.getReward_type());
            Assert.assertEquals(afterStatus, project.getStatus());
            projectDAO.deleteProject(project.getProject_id(),project.getStaff_code());
        }

    }





}

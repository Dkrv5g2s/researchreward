package Service.Admin;

import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;

public class ApproveApplyService {
    private ProjectDAO projectdao = new ProjectDAOImpl();

    public void updateReviewerAndReviewTime(int project_id, String userrole, String username) {
        projectdao.updateReviewInfo(project_id, userrole, username);
    }
}

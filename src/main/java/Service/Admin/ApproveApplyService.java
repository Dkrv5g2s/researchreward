package Service.Admin;

import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;

public class ApproveApplyService {
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public void updateReviewerAndReviewTime(int project_id, String userRole, String userName) {
        projectDAO.updateReviewInfo(project_id, userRole, userName);
    }
}

package Service.Admin;

import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;

public class ReasonForReturnService {
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public void updateReasonForReturn(int projectId, String reason_for_return){
        projectDAO.updateProjectStatus(projectId, 0);
        projectDAO.updateReasonForReturn(projectId, reason_for_return);
    }
}

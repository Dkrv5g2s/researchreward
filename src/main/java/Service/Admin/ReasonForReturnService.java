package Service.Admin;

import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;

import java.sql.Date;

public class ReasonForReturnService {
    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public void updateReasonForReturn(int projectId, String reason_for_return){
        updateRewardStatusToPrevious(projectId);
        projectDAO.updateReasonForReturn(projectId, reason_for_return);
    }

    public void updateRewardStatusToPrevious(int projectId){
        int statusId = projectDAO.getStatusIdByProjectId(projectId);
        if (statusId > 0 ){
            if (statusId == 2)
                projectDAO.updateProjectStatus(projectId, 0);
            else
                projectDAO.updateProjectStatus(projectId, --statusId);
        }
        projectDAO.updateProjectLastStatusIdChangedDirection(projectId, "returned");
    }
}

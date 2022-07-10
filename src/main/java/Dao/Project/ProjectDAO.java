package Dao.Project;

import Bean.Project.RewardProject;

import java.sql.Date;
import java.util.List;

public interface ProjectDAO {
    public void insertNewProject( String staff_code, int status_id, String reward_type ) ;
    public int insertNewProjectAndReturnProjectID( String staff_code, int status_id, String reward_type ); // Dfone, added for auto fill in.
    public void deleteProject( int project_id ,String staff_code) ;
    public void updateProjectStatus(int project_id, int status_id) ;
    public void updateProjectHistoryHighestStatus(int project_id, int status_id);
    public void updateProjectLastStatusIdChangedDirection(int project_id, String direction);
    public void initializeProjectReviewState(int project_id);
    public void applyProject(int project_id, Date apply_date) ;
    public List<RewardProject> getPersonalProjects(String staffCode, int begin_status_id, int end_status_id);
    public int getStatusIdByProjectId(int project_id);
    public int getHistoryHighestStatusIdByProjectId(int project_id);
    public List<RewardProject> getPendingProjects(int status_id, String direction);
    public List<RewardProject> getReviewedProjects(int status_id);
    public String getRewardType(int project_id);
    public int getMaxStatusId();
    public void updateReasonForReturn(int project_id, String reason_for_return);
    public void updateReviewInfo(int project_id, String userRole, String userName);
}

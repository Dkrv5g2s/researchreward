package Dao.Project;

import Bean.Project.RewardProject;

import java.util.List;

public interface ProjectDAO {
    public void insertNewProject( String staff_code, int status_id, String reward_type ) ;
    public void deleteProject( int project_id ,String staff_code) ;
    public void updateProjectStatus(int project_id, int status_id) ;
    public List<RewardProject> getPersonalProjects(String staffCode, int begin_status_id, int end_status_id);
    public int getStatusIdByProjectId(int project_id);
    public List<RewardProject> adminsGetPendingProjects(int status_id);
    public String getRewardType(int project_id);
    public int getMaxStatusId();
}

package Dao.Project;

import Bean.Project.RewardProject;

import java.util.List;

public interface ProjectDAO {
    public void insertNewProject( String staff_code,String status, String reward_type ) ;
    public void deleteProject( int project_id ,String staff_code) ;
    public void UpdateProjectStatus(int project_id,String status) ;
    public List<RewardProject> getProjects(String staffCode,String status);
    public List<RewardProject> adminsGetProjects(String status);
    public String getRewardType(int project_id);
}

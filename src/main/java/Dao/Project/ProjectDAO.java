package Dao.Project;

import Bean.Project.RewardProject;

public interface ProjectDAO {
    public void insertNewProject( String staff_code,String status, String reward_type ) ;
    public void deleteProject( int project_id ) ;
    public void updateProject(RewardProject rewardProject) ;
}

package Dao.Project;

import Bean.Project.ProjectFillRate;

import java.util.List;

public interface ProjectFillRateDAO {
    List<ProjectFillRate> query(int projectId);
    void save(ProjectFillRate projectFillRate);
}

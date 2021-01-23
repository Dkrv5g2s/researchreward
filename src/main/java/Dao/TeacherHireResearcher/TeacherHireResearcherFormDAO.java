package Dao.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherForm;

public interface TeacherHireResearcherFormDAO {
    void save(TeacherHireResearcherForm object);
    TeacherHireResearcherForm get(int projectId);
}

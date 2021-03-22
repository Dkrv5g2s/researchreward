package Dao.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherTableC;

public interface TeacherHireResearcherTableCDAO {
    void save(TeacherHireResearcherTableC teacherHireResearcherTableC);
    TeacherHireResearcherTableC get(int projectId);
}

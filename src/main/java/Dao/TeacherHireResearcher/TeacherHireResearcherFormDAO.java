package Dao.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherForm;

public interface TeacherHireResearcherFormDAO {
    void save(TeacherHireResearcherForm object);
    void updateDepartmentReviewData(TeacherHireResearcherForm teacherHireResearcherForm);
    void updateCollegeReviewData(TeacherHireResearcherForm teacherHireResearcherForm);
    void updateRADOReviewData(TeacherHireResearcherForm teacherHireResearcherForm);
    TeacherHireResearcherForm get(int projectId);
}

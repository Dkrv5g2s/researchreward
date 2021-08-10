package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationForm;
import Bean.OutstandingResearchAward.OutstandingResearchAward;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationFormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LectureProfessorApplicationFormDAOImpl implements LectureProfessorApplicationFormDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureprofessorapplicationform WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessorapplicationform (projectID,userNumber,name,job,serviceSchoolAndDepartment,certificatenum,workStartDate,seniority,email,researchroomext,cellphone,applicationrequirements1,applicationrequirements2,applicationrequirements3,applicationrequirements4,applicationrequirements5,applicationrequirements6,applicationrequirements7,applicationrequirements8,applicationrequirements9,applicationrequirements10,applicationrequirements11,applicationrequirements12,applicationrequirements13,applicationrequirements14,applicationrequirements15,applicationrequirementsCheck, lectureCategoryExp,lectureCategoryInv,lectureCategoryLif,additionalInfo)"+
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE lectureprofessorapplicationform "
                    + "SET userNumber = ?,name = ?,job = ?,serviceSchoolAndDepartment = ?,certificatenum = ?,workStartDate = ?,seniority = ?,email = ?,researchroomext = ?,cellphone = ?," +
                    "applicationrequirements1 = ?,applicationrequirements2 = ?,applicationrequirements3 = ?,applicationrequirements4 = ?,applicationrequirements5 = ?,applicationrequirements6 = ?,applicationrequirements7 = ?,applicationrequirements8 = ?,applicationrequirements9 = ?,applicationrequirements10 = ?,applicationrequirements11 = ?,applicationrequirements12 = ?,applicationrequirements13 = ?,applicationrequirements14 = ?,applicationrequirements15 = ?,applicationrequirementsCheck = ?, lectureCategoryExp = ?, lectureCategoryInv = ?, lectureCategoryLif = ?, additionalInfo = ?"+
                    " WHERE projectID = ?";

    private static final String UPDATE_DEPARTMENT_DATA =
            "UPDATE lectureprofessorapplicationform "+
                    "SET department_academic_year = ?,department_semester = ?,department_conference_times = ?, department_sign_date = ? " +
                    "WHERE projectID = ?";
    private static final String UPDATE_COLLEGE_DATA =
            "UPDATE lectureprofessorapplicationform "+
                    "SET college_academic_year = ?,college_semester = ?,college_conference_times = ?, college_sign_date = ? " +
                    "WHERE projectID = ?";
    private static final String UPDATE_RADO_DATA =
            "UPDATE lectureprofessorapplicationform "+
                    "SET research_and_development_office_sign_year = ?,research_and_development_office_sign_month = ?,research_and_development_office_sign_date = ?" +
                    "WHERE projectID = ?";


    @Override
    public void save(LectureProfessorApplicationForm object,String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();

            int size = 0;

            while(resultSet.next()) {
                size++;
            }

            if(size == 0) {
                insert(connection,object,projectID);
            }
            else {
                update(connection,object,projectID);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public LectureProfessorApplicationForm show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorApplicationForm lpaf = null;
                lpaf = new LectureProfessorApplicationForm(
                        Integer.valueOf(projectID),
                        resultSet.getString("userNumber"),
                        resultSet.getString("name"),
                        resultSet.getString("job"),
                        resultSet.getString("serviceSchoolAndDepartment"),
                        resultSet.getString("certificatenum"),
                        resultSet.getString("workStartDate"),
                        resultSet.getString("seniority"),
                        resultSet.getString("email"),
                        resultSet.getString("researchroomext"),
                        resultSet.getString("cellphone"),
                        resultSet.getBoolean("applicationrequirements1"),
                        resultSet.getBoolean("applicationrequirements2"),
                        resultSet.getBoolean("applicationrequirements3"),
                        resultSet.getBoolean("applicationrequirements4"),
                        resultSet.getBoolean("applicationrequirements5"),
                        resultSet.getBoolean("applicationrequirements6"),
                        resultSet.getBoolean("applicationrequirements7"),
                        resultSet.getBoolean("applicationrequirements8"),
                        resultSet.getBoolean("applicationrequirements9"),
                        resultSet.getBoolean("applicationrequirements10"),
                        resultSet.getBoolean("applicationrequirements11"),
                        resultSet.getBoolean("applicationrequirements12"),
                        resultSet.getBoolean("applicationrequirements13"),
                        resultSet.getBoolean("applicationrequirements14"),
                        resultSet.getBoolean("applicationrequirements15"),
                        resultSet.getBoolean("applicationrequirementsCheck"),
                        resultSet.getBoolean("lectureCategoryExp"),
                        resultSet.getBoolean("lectureCategoryInv"),
                        resultSet.getBoolean("lectureCategoryLif"),
                        resultSet.getString("additionalInfo"));

                return lpaf;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,LectureProfessorApplicationForm object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getUsernum());
            preparedStatement.setString(3,object.getName());
            preparedStatement.setString(4,object.getJob());
            preparedStatement.setString(5,object.getServiceSchoolAndDepartment());
            preparedStatement.setString(6,object.getCertificatenum());
            preparedStatement.setString(7,object.getWorkStartDate());
            preparedStatement.setString(8,object.getSeniority());
            preparedStatement.setString(9,object.getEmail());
            preparedStatement.setString(10,object.getResearchroomext());
            preparedStatement.setString(11,object.getCellphone());
            preparedStatement.setBoolean(12,object.getApplicationrequirements1());
            preparedStatement.setBoolean(13,object.getApplicationrequirements2());
            preparedStatement.setBoolean(14,object.getApplicationrequirements3());
            preparedStatement.setBoolean(15,object.getApplicationrequirements4());
            preparedStatement.setBoolean(16,object.getApplicationrequirements5());
            preparedStatement.setBoolean(17,object.getApplicationrequirements6());
            preparedStatement.setBoolean(18,object.getApplicationrequirements7());
            preparedStatement.setBoolean(19,object.getApplicationrequirements8());
            preparedStatement.setBoolean(20,object.getApplicationrequirements9());
            preparedStatement.setBoolean(21,object.getApplicationrequirements10());
            preparedStatement.setBoolean(22,object.getApplicationrequirements11());
            preparedStatement.setBoolean(23,object.getApplicationrequirements12());
            preparedStatement.setBoolean(24,object.getApplicationrequirements13());
            preparedStatement.setBoolean(25,object.getApplicationrequirements14());
            preparedStatement.setBoolean(26,object.getApplicationrequirements15());
            preparedStatement.setBoolean(27,object.getApplicationrequirementsCheck());
            preparedStatement.setBoolean(28,object.getLectureCategoryExp());
            preparedStatement.setBoolean(29,object.getLectureCategoryInv());
            preparedStatement.setBoolean(30,object.getLectureCategoryLif());
            preparedStatement.setString(31,object.getAdditionalInfo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,LectureProfessorApplicationForm object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getUsernum());
            preparedStatement.setString(2,object.getName());
            preparedStatement.setString(3,object.getJob());
            preparedStatement.setString(4,object.getServiceSchoolAndDepartment());
            preparedStatement.setString(5,object.getCertificatenum());
            preparedStatement.setString(6,object.getWorkStartDate());
            preparedStatement.setString(7,object.getSeniority());
            preparedStatement.setString(8,object.getEmail());
            preparedStatement.setString(9,object.getResearchroomext());
            preparedStatement.setString(10,object.getCellphone());
            preparedStatement.setBoolean(11,object.getApplicationrequirements1());
            preparedStatement.setBoolean(12,object.getApplicationrequirements2());
            preparedStatement.setBoolean(13,object.getApplicationrequirements3());
            preparedStatement.setBoolean(14,object.getApplicationrequirements4());
            preparedStatement.setBoolean(15,object.getApplicationrequirements5());
            preparedStatement.setBoolean(16,object.getApplicationrequirements6());
            preparedStatement.setBoolean(17,object.getApplicationrequirements7());
            preparedStatement.setBoolean(18,object.getApplicationrequirements8());
            preparedStatement.setBoolean(19,object.getApplicationrequirements9());
            preparedStatement.setBoolean(20,object.getApplicationrequirements10());
            preparedStatement.setBoolean(21,object.getApplicationrequirements11());
            preparedStatement.setBoolean(22,object.getApplicationrequirements12());
            preparedStatement.setBoolean(23,object.getApplicationrequirements13());
            preparedStatement.setBoolean(24,object.getApplicationrequirements14());
            preparedStatement.setBoolean(25,object.getApplicationrequirements15());
            preparedStatement.setBoolean(26,object.getApplicationrequirementsCheck());
            preparedStatement.setBoolean(27,object.getLectureCategoryExp());
            preparedStatement.setBoolean(28,object.getLectureCategoryInv());
            preparedStatement.setBoolean(29,object.getLectureCategoryLif());
            preparedStatement.setString(30,object.getAdditionalInfo());
            preparedStatement.setString(31,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateDepartmentData(LectureProfessorApplicationForm lectureProfessorApplicationForm) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_DATA))
        {
            preparedStatement.setString(1,lectureProfessorApplicationForm.getDepartmentAcademicYear());
            preparedStatement.setString(2,lectureProfessorApplicationForm.getDepartmentSemester());
            preparedStatement.setString(3,lectureProfessorApplicationForm.getDepartmentConferenceTimes());
            preparedStatement.setDate(4,lectureProfessorApplicationForm.getDepartmentSignDate());
            preparedStatement.setString(5,Integer.toString(lectureProfessorApplicationForm.getProject_id()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollegeData(LectureProfessorApplicationForm lectureProfessorApplicationForm) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_DATA))
        {
            preparedStatement.setString(1,lectureProfessorApplicationForm.getCollegeAcademicYear());
            preparedStatement.setString(2,lectureProfessorApplicationForm.getCollegeSemester());
            preparedStatement.setString(3,lectureProfessorApplicationForm.getCollegeConferenceTimes());
            preparedStatement.setDate(4,lectureProfessorApplicationForm.getCollegeSignDate());
            preparedStatement.setString(5,Integer.toString(lectureProfessorApplicationForm.getProject_id()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRADOData(LectureProfessorApplicationForm lectureProfessorApplicationForm) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RADO_DATA))
        {
            preparedStatement.setString(1,lectureProfessorApplicationForm.getResearchAndDevelopmentOfficeSignYear());
            preparedStatement.setString(2,lectureProfessorApplicationForm.getResearchAndDevelopmentOfficeSignMonth());
            preparedStatement.setString(3,lectureProfessorApplicationForm.getResearchAndDevelopmentOfficeSignDate());
            preparedStatement.setString(4,Integer.toString(lectureProfessorApplicationForm.getProject_id()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Dao.DistinguishedProfessor.Impl;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorFormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistinguishedProfessorFormDAOImpl implements DistinguishedProfessorFormDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM distinguishedprofessorform WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO distinguishedprofessorform (projectID,userNumber,name,department,hireddate,certificatenum,upgradedate,seniority,email,researchroomext,cellphone," +
            "applicationrequirements1,applicationrequirements2,applicationrequirements3,applicationrequirements4,applicationrequirements5,applicationrequirements6,applicationrequirements7,applicationrequirements8,applicationrequirements9)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE distinguishedprofessorform "
    		+ "SET userNumber = ?,name = ?,department = ?,hireddate = ?,certificatenum = ?,upgradedate = ?,seniority = ?,email = ?,researchroomext = ?,cellphone = ?," +
            "applicationrequirements1 = ?,applicationrequirements2 = ?,applicationrequirements3 = ?,applicationrequirements4 = ?,applicationrequirements5 = ?,applicationrequirements6 = ?,applicationrequirements7 = ?,applicationrequirements8 = ?,applicationrequirements9 = ?"+
    		" WHERE projectID = ?";
    private static final String UPDATE_DEPARTMENT_DATA =
            "UPDATE distinguishedprofessorform "+
                    "SET department_academic_year = ?,department_semester = ?,department_conference_times = ?, department_sign_date = ? " +
                    "WHERE projectID = ?";
    private static final String UPDATE_COLLEGE_DATA =
            "UPDATE distinguishedprofessorform "+
                    "SET college_academic_year = ?,college_semester = ?,college_conference_times = ?, college_sign_date = ? " +
                    "WHERE projectID = ?";
    private static final String UPDATE_RADO_DATA =
            "UPDATE distinguishedprofessorform "+
                    "SET research_and_development_office_sign_year = ?,research_and_development_office_sign_month = ?,research_and_development_office_sign_date = ?" +
                    "WHERE projectID = ?";
    @Override
    public void save(DistinguishedProfessorForm object,String projectID) {
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

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public DistinguishedProfessorForm show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		DistinguishedProfessorForm dpf = null;
        		dpf = new DistinguishedProfessorForm(
        				resultSet.getString("userNumber"),
        				resultSet.getString("name"),
        				resultSet.getString("department"),
        				resultSet.getString("hireddate"),
        				resultSet.getString("certificatenum"),
        				resultSet.getString("upgradedate"),
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
                        resultSet.getString("department_academic_year"),
                        resultSet.getString("department_semester"),
                        resultSet.getString("department_conference_times"),
                        resultSet.getString("department_sign_date"),
                        resultSet.getString("college_academic_year"),
                        resultSet.getString("college_semester"),
                        resultSet.getString("college_conference_times"),
                        resultSet.getString("college_sign_date"),
                        resultSet.getString("research_and_development_office_sign_year"),
                        resultSet.getString("research_and_development_office_sign_month"),
                        resultSet.getString("research_and_development_office_sign_date"));
         	
            	return dpf;
        	}
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }

    @Override
    public void saveDepartmentData(DistinguishedProfessorForm object,String projectID) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_DATA))
        {
            preparedStatement.setString(1,object.getDepartmentAcademicYear());
            preparedStatement.setString(2,object.getDepartmentSemester());
            preparedStatement.setString(3,object.getDepartmentConferenceTimes());
            preparedStatement.setString(4,object.getDepartmentSignDate());
            preparedStatement.setString(5,projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCollegeData(DistinguishedProfessorForm object, String projectID) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_DATA))
        {
            preparedStatement.setString(1,object.getCollegeAcademicYear());
            preparedStatement.setString(2,object.getCollegeSemester());
            preparedStatement.setString(3,object.getCollegeConferenceTimes());
            preparedStatement.setString(4,object.getCollegeSignDate());
            preparedStatement.setString(5,projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRADOData(DistinguishedProfessorForm object, String projectID) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RADO_DATA))
        {
            preparedStatement.setString(1,object.getResearchAndDevelopmentOfficeSignYear());
            preparedStatement.setString(2,object.getResearchAndDevelopmentOfficeSignMonth());
            preparedStatement.setString(3,object.getResearchAndDevelopmentOfficeSignDate());
            preparedStatement.setString(4,projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Connection connection,DistinguishedProfessorForm object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
    		preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getUsernum());
            preparedStatement.setString(3,object.getName());
            preparedStatement.setString(4,object.getDepartment());
            preparedStatement.setString(5,object.getHireddate());
            preparedStatement.setString(6,object.getCertificatenum());
            preparedStatement.setString(7,object.getUpgradedate());
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


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,DistinguishedProfessorForm object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		preparedStatement.setString(1,object.getUsernum());
            preparedStatement.setString(2,object.getName());
            preparedStatement.setString(3,object.getDepartment());
            preparedStatement.setString(4,object.getHireddate());
            preparedStatement.setString(5,object.getCertificatenum());
            preparedStatement.setString(6,object.getUpgradedate());
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
            preparedStatement.setString(20,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

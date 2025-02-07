package Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.EduProject;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.EduProjectDAO;

public class EduProjectDAOImpl implements EduProjectDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM eduproject WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO eduproject (projectID,edu_project_count1,edu_project_count2,edu_project_count3,edu_project_count4,edu_project_count5,edu_project_count_total," +
            "edu_project_money1,edu_project_money2,edu_project_money3,edu_project_money4,edu_project_money5,edu_project_money_total,edu_project_point1,edu_project_point2," +
            "edu_project_point3,edu_project_point4,edu_project_point5,edu_project_point_total)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE eduproject "
    		+ "SET edu_project_count1 = ?,edu_project_count2 = ?,edu_project_count3 = ?,edu_project_count4 = ?,edu_project_count5 = ?,edu_project_count_total = ?," +
            "edu_project_money1 = ?,edu_project_money2 = ?,edu_project_money3 = ?,edu_project_money4 = ?,edu_project_money5 = ?,edu_project_money_total = ?," +
            "edu_project_point1 = ?,edu_project_point2 = ?,edu_project_point3 = ?,edu_project_point4 = ?,edu_project_point5 = ?,edu_project_point_total = ?  "+
    		" WHERE projectID = ?";
    @Override
    public void save(EduProject object,String projectID) {
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
    public EduProject show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		EduProject ep = null;
        		ep = new EduProject(
        				resultSet.getString("edu_project_count1"),
        				resultSet.getString("edu_project_count2"),
        				resultSet.getString("edu_project_count3"),
        				resultSet.getString("edu_project_count4"),
        				resultSet.getString("edu_project_count5"),
        				resultSet.getString("edu_project_count_total"),
        				resultSet.getString("edu_project_money1"),
        				resultSet.getString("edu_project_money2"),
        				resultSet.getString("edu_project_money3"),
        				resultSet.getString("edu_project_money4"),
        				resultSet.getString("edu_project_money5"),
        				resultSet.getString("edu_project_money_total"),
        				resultSet.getString("edu_project_point1"),
        				resultSet.getString("edu_project_point2"),
        				resultSet.getString("edu_project_point3"),
        				resultSet.getString("edu_project_point4"),
        				resultSet.getString("edu_project_point5"),
        				resultSet.getString("edu_project_point_total"));
        				
         	
            	return ep;
        	}
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,EduProject object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getEdu_project_count1());
            preparedStatement.setString(3,object.getEdu_project_count2());
            preparedStatement.setString(4,object.getEdu_project_count3());
            preparedStatement.setString(5,object.getEdu_project_count4());
            preparedStatement.setString(6,object.getEdu_project_count5());
            preparedStatement.setString(7,object.getEdu_project_count_total());
            preparedStatement.setString(8,object.getEdu_project_money1());
            preparedStatement.setString(9,object.getEdu_project_money2());
            preparedStatement.setString(10,object.getEdu_project_money3());
            preparedStatement.setString(11,object.getEdu_project_money4());
            preparedStatement.setString(12,object.getEdu_project_money5());
            preparedStatement.setString(13,object.getEdu_project_money_total());
            preparedStatement.setString(14,object.getEdu_project_point1());
            preparedStatement.setString(15,object.getEdu_project_point2());
            preparedStatement.setString(16,object.getEdu_project_point3());
            preparedStatement.setString(17,object.getEdu_project_point4());
            preparedStatement.setString(18,object.getEdu_project_point5());
            preparedStatement.setString(19,object.getEdu_project_point_total());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,EduProject object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		
            preparedStatement.setString(1,object.getEdu_project_count1());
            preparedStatement.setString(2,object.getEdu_project_count2());
            preparedStatement.setString(3,object.getEdu_project_count3());
            preparedStatement.setString(4,object.getEdu_project_count4());
            preparedStatement.setString(5,object.getEdu_project_count5());
            preparedStatement.setString(6,object.getEdu_project_count_total());
            preparedStatement.setString(7,object.getEdu_project_money1());
            preparedStatement.setString(8,object.getEdu_project_money2());
            preparedStatement.setString(9,object.getEdu_project_money3());
            preparedStatement.setString(10,object.getEdu_project_money4());
            preparedStatement.setString(11,object.getEdu_project_money5());
            preparedStatement.setString(12,object.getEdu_project_money_total());
            preparedStatement.setString(13,object.getEdu_project_point1());
            preparedStatement.setString(14,object.getEdu_project_point2());
            preparedStatement.setString(15,object.getEdu_project_point3());
            preparedStatement.setString(16,object.getEdu_project_point4());
            preparedStatement.setString(17,object.getEdu_project_point5());
            preparedStatement.setString(18,object.getEdu_project_point_total());
            preparedStatement.setString(19,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


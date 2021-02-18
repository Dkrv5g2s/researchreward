package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleTT;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleTTDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleTTDAOImpl implements ArticleTTDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM articlett WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO articlett (projectID,t_article_count1,t_article_count2,t_article_count3,t_article_count4,t_article_count5,t_article_count_total,t_point1,t_point2,t_point3," +
            "t_point4,t_point5,t_point_total)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE articlett "
    		+ "SET t_article_count1 = ?,t_article_count2 = ?,t_article_count3 = ?,t_article_count4 = ?,t_article_count5 = ?,t_article_count_total = ?,t_point1 = ?,t_point2 = ?," +
            "t_point3 = ?,t_point4 = ?,t_point5 = ?,t_point_total = ? "+
    		" WHERE projectID = ?";
    @Override
    public void save(ArticleTT object,String projectID) {
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
    public ArticleTT show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		ArticleTT att = null;
        		att = new ArticleTT(
        				resultSet.getString("t_article_count1"),
        				resultSet.getString("t_article_count2"),
        				resultSet.getString("t_article_count3"),
        				resultSet.getString("t_article_count4"),
        				resultSet.getString("t_article_count5"),
        				resultSet.getString("t_article_count_total"),
        				resultSet.getString("t_point1"),
        				resultSet.getString("t_point2"),
        				resultSet.getString("t_point3"),
        				resultSet.getString("t_point4"),
        				resultSet.getString("t_point5"),
        				resultSet.getString("t_point_total"));
        				
         	
            	return att;
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,ArticleTT object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getT_article_count1());
            preparedStatement.setString(3,object.getT_article_count2());
            preparedStatement.setString(4,object.getT_article_count3());
            preparedStatement.setString(5,object.getT_article_count4());
            preparedStatement.setString(6,object.getT_article_count5());
            preparedStatement.setString(7,object.getT_article_count_total());
            preparedStatement.setString(8,object.getT_point1());
            preparedStatement.setString(9,object.getT_point2());
            preparedStatement.setString(10,object.getT_point3());
            preparedStatement.setString(11,object.getT_point4());
            preparedStatement.setString(12,object.getT_point5());
            preparedStatement.setString(13,object.getT_point_total());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,ArticleTT object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		
            preparedStatement.setString(1,object.getT_article_count1());
            preparedStatement.setString(2,object.getT_article_count2());
            preparedStatement.setString(3,object.getT_article_count3());
            preparedStatement.setString(4,object.getT_article_count4());
            preparedStatement.setString(5,object.getT_article_count5());
            preparedStatement.setString(6,object.getT_article_count_total());
            preparedStatement.setString(7,object.getT_point1());
            preparedStatement.setString(8,object.getT_point2());
            preparedStatement.setString(9,object.getT_point3());
            preparedStatement.setString(10,object.getT_point4());
            preparedStatement.setString(11,object.getT_point5());
            preparedStatement.setString(12,object.getT_point_total());
            preparedStatement.setString(13,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

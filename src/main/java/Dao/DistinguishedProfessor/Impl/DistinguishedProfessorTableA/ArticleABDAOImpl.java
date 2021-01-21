package Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleAB;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleABDAO;

public class ArticleABDAOImpl implements ArticleABDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM articleab WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO articleab (projectID,a_book_count1,a_book_count2,a_book_count3,a_book_count4,a_book_count5,a_book_count_total,a_book_point1,a_book_point2,a_book_point3," +
            "a_book_point4,a_book_point5,a_book_point_total)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE articleab "
    		+ "SET a_book_count1 = ?,a_book_count2 = ?,a_book_count3 = ?,a_book_count4 = ?,a_book_count5 = ?,a_book_count_total = ?,a_book_point1 = ?,a_book_point2 = ?," +
            "a_book_point3 = ?,a_book_point4 = ?,a_book_point5 = ?,a_book_point_total = ? "+
    		" WHERE projectID = ?";
    @Override
    public void save(ArticleAB object,String projectID) {
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
    public ArticleAB show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		ArticleAB aab = null;
        		aab = new ArticleAB(
        				resultSet.getString("a_book_count1"),
        				resultSet.getString("a_book_count2"),
        				resultSet.getString("a_book_count3"),
        				resultSet.getString("a_book_count4"),
        				resultSet.getString("a_book_count5"),
        				resultSet.getString("a_book_count_total"),
        				resultSet.getString("a_book_point1"),
        				resultSet.getString("a_book_point2"),
        				resultSet.getString("a_book_point3"),
        				resultSet.getString("a_book_point4"),
        				resultSet.getString("a_book_point5"),
        				resultSet.getString("a_book_point_total"));
        				
         	
            	return aab;
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,ArticleAB object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getA_book_count1());
            preparedStatement.setString(3,object.getA_book_count2());
            preparedStatement.setString(4,object.getA_book_count3());
            preparedStatement.setString(5,object.getA_book_count4());
            preparedStatement.setString(6,object.getA_book_count5());
            preparedStatement.setString(7,object.getA_book_count_total());
            preparedStatement.setString(8,object.getA_book_point1());
            preparedStatement.setString(9,object.getA_book_point2());
            preparedStatement.setString(10,object.getA_book_point3());
            preparedStatement.setString(11,object.getA_book_point4());
            preparedStatement.setString(12,object.getA_book_point5());
            preparedStatement.setString(13,object.getA_book_point_total());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,ArticleAB object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		
            preparedStatement.setString(1,object.getA_book_count1());
            preparedStatement.setString(2,object.getA_book_count2());
            preparedStatement.setString(3,object.getA_book_count3());
            preparedStatement.setString(4,object.getA_book_count4());
            preparedStatement.setString(5,object.getA_book_count5());
            preparedStatement.setString(6,object.getA_book_count_total());
            preparedStatement.setString(7,object.getA_book_point1());
            preparedStatement.setString(8,object.getA_book_point2());
            preparedStatement.setString(9,object.getA_book_point3());
            preparedStatement.setString(10,object.getA_book_point4());
            preparedStatement.setString(11,object.getA_book_point5());
            preparedStatement.setString(12,object.getA_book_point_total());
            preparedStatement.setString(13,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.OtherData;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.OtherDataDAO;

public class OtherDataDAOImpl implements OtherDataDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM otherdata WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO otherdata (projectID,year1,year2,year3,year4,year5,other_data,commit_date)" +
    		" values(?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE otherdata "
    		+ "SET year1 = ?,year2 = ?,year3 = ?,year4 = ?,year5 = ?,other_data = ?,commit_date = ?"+
    		" WHERE projectID = ?";
    @Override
    public void save(OtherData object,String projectID) {
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
        		insert(connection,object);
        	}
        	else {
        		update(connection,object);
        	}

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public OtherData show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		OtherData od = null;
        		od = new OtherData(
        				resultSet.getString("year1"),
        				resultSet.getString("year2"),
        				resultSet.getString("year3"),
        				resultSet.getString("year4"),
        				resultSet.getString("year5"),
        				resultSet.getString("projectID"),
        				resultSet.getString("other_data"),
        				resultSet.getString("commit_date"));
         	
            	return od;
        	}
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,OtherData object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,object.getProjectID());
            preparedStatement.setString(2,object.getYear1());
            preparedStatement.setString(3,object.getYear2());
            preparedStatement.setString(4,object.getYear3());
            preparedStatement.setString(5,object.getYear4());
            preparedStatement.setString(6,object.getYear5());
            preparedStatement.setString(7,object.getOther_data());
            preparedStatement.setString(8,object.getCommit_date());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,OtherData object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		preparedStatement.setString(1,object.getYear1());
            preparedStatement.setString(2,object.getYear2());
            preparedStatement.setString(3,object.getYear3());
            preparedStatement.setString(4,object.getYear4());
            preparedStatement.setString(5,object.getYear5());
            preparedStatement.setString(6,object.getOther_data());
            preparedStatement.setString(7,object.getCommit_date());
            preparedStatement.setString(8,object.getProjectID());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
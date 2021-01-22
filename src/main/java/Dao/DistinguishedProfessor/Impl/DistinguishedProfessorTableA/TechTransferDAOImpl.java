package Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.TechTransfer;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.TechTransferDAO;

public class TechTransferDAOImpl implements TechTransferDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM techtransfer WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO techtransfer (projectID,tech_transfer_count1,tech_transfer_count2,tech_transfer_count3,tech_transfer_count4,tech_transfer_count5,tech_transfer_count_total,tech_transfer_management1,tech_transfer_management2,tech_transfer_management3," +
            "tech_transfer_management4,tech_transfer_management5,tech_transfer_management_total,tech_transfer_money1,tech_transfer_money2,tech_transfer_money3,tech_transfer_money4,tech_transfer_money5,tech_transfer_money_total,tech_transfer_point1,tech_transfer_point2," +
            "tech_transfer_point3,tech_transfer_point4,tech_transfer_point5,tech_transfer_point_total)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE techtransfer "
    		+ "SET tech_transfer_count1 = ?,tech_transfer_count2 = ?,tech_transfer_count3 = ?,tech_transfer_count4 = ?,tech_transfer_count5 = ?,tech_transfer_count_total = ?,tech_transfer_management1 = ?,tech_transfer_management2 = ?," +
            "tech_transfer_management3 = ?,tech_transfer_management4 = ?,tech_transfer_management5 = ?,tech_transfer_management_total = ?,tech_transfer_money1 = ?,tech_transfer_money2 = ?,tech_transfer_money3 = ?,tech_transfer_money4 = ?," +
            "tech_transfer_money5 = ?,tech_transfer_money_total = ?,tech_transfer_point1 = ?,tech_transfer_point2 = ?,tech_transfer_point3 = ?,tech_transfer_point4 = ?,tech_transfer_point5 = ?,tech_transfer_point_total = ?  "+
    		" WHERE projectID = ?";
    @Override
    public void save(TechTransfer object,String projectID) {
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
    public TechTransfer show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		TechTransfer tt = null;
        		tt = new TechTransfer(
        				resultSet.getString("tech_transfer_count1"),
        				resultSet.getString("tech_transfer_count2"),
        				resultSet.getString("tech_transfer_count3"),
        				resultSet.getString("tech_transfer_count4"),
        				resultSet.getString("tech_transfer_count5"),
        				resultSet.getString("tech_transfer_count_total"),
        				resultSet.getString("tech_transfer_management1"),
        				resultSet.getString("tech_transfer_management2"),
        				resultSet.getString("tech_transfer_management3"),
        				resultSet.getString("tech_transfer_management4"),
        				resultSet.getString("tech_transfer_management5"),
        				resultSet.getString("tech_transfer_management_total"),
        				resultSet.getString("tech_transfer_money1"),
        				resultSet.getString("tech_transfer_money2"),
        				resultSet.getString("tech_transfer_money3"),
        				resultSet.getString("tech_transfer_money4"),
        				resultSet.getString("tech_transfer_money5"),
        				resultSet.getString("tech_transfer_money_total"),
        				resultSet.getString("tech_transfer_point1"),
        				resultSet.getString("tech_transfer_point2"),
        				resultSet.getString("tech_transfer_point3"),
        				resultSet.getString("tech_transfer_point4"),
        				resultSet.getString("tech_transfer_point5"),
        				resultSet.getString("tech_transfer_point_total"));
        				
         	
            	return tt;
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,TechTransfer object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getTech_transfer_count1());
            preparedStatement.setString(3,object.getTech_transfer_count2());
            preparedStatement.setString(4,object.getTech_transfer_count3());
            preparedStatement.setString(5,object.getTech_transfer_count4());
            preparedStatement.setString(6,object.getTech_transfer_count5());
            preparedStatement.setString(7,object.getTech_transfer_count_total());
            preparedStatement.setString(8,object.getTech_transfer_management1());
            preparedStatement.setString(9,object.getTech_transfer_management2());
            preparedStatement.setString(10,object.getTech_transfer_management3());
            preparedStatement.setString(11,object.getTech_transfer_management4());
            preparedStatement.setString(12,object.getTech_transfer_management5());
            preparedStatement.setString(13,object.getTech_transfer_management_total());
            preparedStatement.setString(14,object.getTech_transfer_money1());
            preparedStatement.setString(15,object.getTech_transfer_money2());
            preparedStatement.setString(16,object.getTech_transfer_money3());
            preparedStatement.setString(17,object.getTech_transfer_money4());
            preparedStatement.setString(18,object.getTech_transfer_money5());
            preparedStatement.setString(19,object.getTech_transfer_money_total());
            preparedStatement.setString(20,object.getTech_transfer_point1());
            preparedStatement.setString(21,object.getTech_transfer_point2());
            preparedStatement.setString(22,object.getTech_transfer_point3());
            preparedStatement.setString(23,object.getTech_transfer_point4());
            preparedStatement.setString(24,object.getTech_transfer_point5());
            preparedStatement.setString(25,object.getTech_transfer_point_total());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,TechTransfer object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
    		
            preparedStatement.setString(1,object.getTech_transfer_count1());
            preparedStatement.setString(2,object.getTech_transfer_count2());
            preparedStatement.setString(3,object.getTech_transfer_count3());
            preparedStatement.setString(4,object.getTech_transfer_count4());
            preparedStatement.setString(5,object.getTech_transfer_count5());
            preparedStatement.setString(6,object.getTech_transfer_count_total());
            preparedStatement.setString(7,object.getTech_transfer_management1());
            preparedStatement.setString(8,object.getTech_transfer_management2());
            preparedStatement.setString(9,object.getTech_transfer_management3());
            preparedStatement.setString(10,object.getTech_transfer_management4());
            preparedStatement.setString(11,object.getTech_transfer_management5());
            preparedStatement.setString(12,object.getTech_transfer_management_total());
            preparedStatement.setString(13,object.getTech_transfer_money1());
            preparedStatement.setString(14,object.getTech_transfer_money2());
            preparedStatement.setString(15,object.getTech_transfer_money3());
            preparedStatement.setString(16,object.getTech_transfer_money4());
            preparedStatement.setString(17,object.getTech_transfer_money5());
            preparedStatement.setString(18,object.getTech_transfer_money_total());
            preparedStatement.setString(19,object.getTech_transfer_point1());
            preparedStatement.setString(20,object.getTech_transfer_point2());
            preparedStatement.setString(21,object.getTech_transfer_point3());
            preparedStatement.setString(22,object.getTech_transfer_point4());
            preparedStatement.setString(23,object.getTech_transfer_point5());
            preparedStatement.setString(24,object.getTech_transfer_point_total());
            preparedStatement.setString(25,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

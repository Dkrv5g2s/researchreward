package Dao.DistinguishedProfessor.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.DistinguishedProfessor.DistinguishedProfessorAppDocInstructions;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorAppDocInstructionsDAO;

public class DistinguishedProfessorAppDocInstructionsDAOImpl implements DistinguishedProfessorAppDocInstructionsDAO{
	private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM distinguishedprofessorappdocinstructions WHERE projectID = ?"; 
    private static final String INSERT = 
    		"INSERT INTO distinguishedprofessorappdocinstructions (projectID,userNumber,technologyTransferContractName,technologyTransferDepartment,contractDate,technologyTransferFund,technologyTransferFundBringInDate)"+
    		" values(?,?,?,?,?,?,?)";
    private static final String DELETE = 
    		"DELETE FROM distinguishedprofessorappdocinstructions "+
    		" WHERE projectID = ?";
    @Override
    public void save(List<DistinguishedProfessorAppDocInstructions> object, String userNumber,String projectID) {
        Connection connection = dbConnection.getConnection();
        
        delete(connection,projectID);
        if(!object.isEmpty()) {
            insert(connection,object,projectID);
        }
        	
    }

    @Override
    public List<DistinguishedProfessorAppDocInstructions> show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        List<DistinguishedProfessorAppDocInstructions> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,projectID);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		DistinguishedProfessorAppDocInstructions dpadi = null;
        		dpadi = new DistinguishedProfessorAppDocInstructions(
        				resultSet.getString("userNumber"),
        				resultSet.getString("technologyTransferContractName"),
        				resultSet.getString("technologyTransferDepartment"),
        				resultSet.getString("contractDate"),
        				resultSet.getString("technologyTransferFund"),
        				resultSet.getString("technologyTransferFundBringInDate"));
        		list.add(dpadi);
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return list;
    }
    
    public void insert(Connection connection,List<DistinguishedProfessorAppDocInstructions> object,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            for(int i = 0;i<object.size();i++) {
            	preparedStatement.setString(1,projectID);
            	preparedStatement.setString(2,object.get(i).getUserNumber());
                preparedStatement.setString(3,object.get(i).getTechnologyTransferContractName());
                preparedStatement.setString(4,object.get(i).getTechnologyTransferDepartment());
                preparedStatement.setString(5,object.get(i).getContractDate());
                preparedStatement.setString(6,object.get(i).getTechnologyTransferFund());
                preparedStatement.setString(7,object.get(i).getTechnologyTransferFundBringInDate());
                
                preparedStatement.addBatch();
            }		
            preparedStatement.executeBatch();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Connection connection,String projectID) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
    
    		preparedStatement.setString(1,projectID);
 		
    		preparedStatement.executeUpdate();
    		
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

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
    private static final String SELECT = "SELECT * FROM distinguishedprofessorform WHERE usernum = ?"; 
    private static final String INSERT = 
    		"INSERT INTO distinguishedprofessorform (usernum,name,department,hireddate,certificatenum,upgradedate,seniority,email,researchroomext,cellphone," +
            "applicationrequirements1,applicationrequirements2,applicationrequirements3,applicationrequirements4,applicationrequirements5,applicationrequirements6,applicationrequirements7,applicationrequirements8,applicationrequirements9)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = 
    		"UPDATE distinguishedprofessorform "
    		+ "SET name = ?,department = ?,hireddate = ?,certificatenum = ?,upgradedate = ?,seniority = ?,email = ?,researchroomext = ?,cellphone = ?," +
            "applicationrequirements1 = ?,applicationrequirements2 = ?,applicationrequirements3 = ?,applicationrequirements4 = ?,applicationrequirements5 = ?,applicationrequirements6 = ?,applicationrequirements7 = ?,applicationrequirements8 = ?,applicationrequirements9 = ?"+
    		" WHERE usernum = ?";
    @Override
    public void save(DistinguishedProfessorForm object) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,object.getUsernum());
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


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public DistinguishedProfessorForm show(String userNumber) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setString(1,userNumber);
        	
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		DistinguishedProfessorForm dpf = null;
        		dpf = new DistinguishedProfessorForm(
        				resultSet.getString("usernum"),
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
        				resultSet.getBoolean("applicationrequirements9"));
         	
            	return dpf;
        	}

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    public void insert(Connection connection,DistinguishedProfessorForm object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
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


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection,DistinguishedProfessorForm object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getName());
            preparedStatement.setString(2,object.getDepartment());
            preparedStatement.setString(3,object.getHireddate());
            preparedStatement.setString(4,object.getCertificatenum());
            preparedStatement.setString(5,object.getUpgradedate());
            preparedStatement.setString(6,object.getSeniority());
            preparedStatement.setString(7,object.getEmail());
            preparedStatement.setString(8,object.getResearchroomext());
            preparedStatement.setString(9,object.getCellphone());
            preparedStatement.setBoolean(10,object.getApplicationrequirements1());
            preparedStatement.setBoolean(11,object.getApplicationrequirements2());
            preparedStatement.setBoolean(12,object.getApplicationrequirements3());
            preparedStatement.setBoolean(13,object.getApplicationrequirements4());
            preparedStatement.setBoolean(14,object.getApplicationrequirements5());
            preparedStatement.setBoolean(15,object.getApplicationrequirements6());
            preparedStatement.setBoolean(16,object.getApplicationrequirements7());
            preparedStatement.setBoolean(17,object.getApplicationrequirements8());
            preparedStatement.setBoolean(18,object.getApplicationrequirements9());
            preparedStatement.setString(19,object.getUsernum());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

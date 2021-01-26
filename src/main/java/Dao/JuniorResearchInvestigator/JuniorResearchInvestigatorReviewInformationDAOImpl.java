package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JuniorResearchInvestigatorReviewInformationDAOImpl implements JuniorResearchInvestigatorReviewInformationDAO{
	private DBConnection dbConnection = new DBConnectionImpl();  //TODO
    private static final String SELECT = "SELECT * FROM junior_research_investigator_review_information WHERE projectId = ?";
    private static final String INSERT = 
    		"INSERT INTO junior_research_investigator_review_information (projectId, userNumber,technologyTransferContractName,technologyTransferDepartment,contractDate,technologyTransferFund,technologyTransferFundBringInDate)"+
    		" values(?,?,?,?,?,?,?)";
    private static final String DELETE = 
    		"DELETE FROM junior_research_investigator_review_information "+
    		" WHERE projectId = ?";

    @Override
    public void save(List<JuniorResearchInvestigatorReviewInformation> object, int projectId) {
        Connection connection = dbConnection.getConnection();
        delete(connection,projectId);
        if(!object.isEmpty()) {
            insert(connection,object);
        }
    }

    @Override
    public List<JuniorResearchInvestigatorReviewInformation> show(int projectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        List<JuniorResearchInvestigatorReviewInformation> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setInt(1,projectId);
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
                JuniorResearchInvestigatorReviewInformation juniorResearchInvestigatorReviewInformation = new JuniorResearchInvestigatorReviewInformation(
                    resultSet.getInt("projectId"),
                    resultSet.getInt("userNumber"),
                    resultSet.getString("technologyTransferContractName"),
                    resultSet.getString("technologyTransferDepartment"),
                    resultSet.getDate("contractDate"),
                    resultSet.getString("technologyTransferFund"),
                    resultSet.getDate("technologyTransferFundBringInDate")
                );
        		list.add(juniorResearchInvestigatorReviewInformation);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void insert(Connection connection,List<JuniorResearchInvestigatorReviewInformation> object) {
        System.out.println("insert");
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            for(int i = 0;i<object.size();i++) {
                preparedStatement.setInt(1,object.get(i).getProjectId());
                preparedStatement.setInt(2,object.get(i).getUserNumber());
                preparedStatement.setString(3,object.get(i).getTechnologyTransferContractName());
                preparedStatement.setString(4,object.get(i).getTechnologyTransferDepartment());
                preparedStatement.setDate(5,object.get(i).getContractDate());
                preparedStatement.setString(6,object.get(i).getTechnologyTransferFund());
                preparedStatement.setDate(7,object.get(i).getTechnologyTransferFundBringInDate());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Connection connection,int projectId) {
        System.out.println("delete");
    	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
    		preparedStatement.setInt(1,projectId);
    		preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

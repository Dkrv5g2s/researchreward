package Dao.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAwardReviewInformation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OutstandingResearchAwardReviewInformationDAOImpl implements OutstandingResearchAwardReviewInformationDAO {
	private DBConnection dbConnection = new DBConnectionImpl();  //TODO
    private static final String SELECT = "SELECT * FROM outstanding_research_award_review_info WHERE projectId = ?";
    private static final String INSERT = 
    		"INSERT INTO outstanding_research_award_review_info (projectID, userNumber,technologyTransferContractName,technologyTransferDepartment,contractDate,technologyTransferFund,technologyTransferFundBringInDate)"+
    		" values(?,?,?,?,?,?,?)";
    private static final String DELETE = 
    		"DELETE FROM outstanding_research_award_review_info "+
    		" WHERE projectID = ?";

    @Override
    public void save(List<OutstandingResearchAwardReviewInformation> object, int projectId) {
        Connection connection = dbConnection.getConnection();
        delete(connection,projectId);
        if(!object.isEmpty()) {
            insert(connection,object);
        }
    }

    @Override
    public List<OutstandingResearchAwardReviewInformation> get(int projectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        List<OutstandingResearchAwardReviewInformation> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
        	preparedStatement.setInt(1,projectId);
        	resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
                OutstandingResearchAwardReviewInformation juniorResearchInvestigatorReviewInformation = new OutstandingResearchAwardReviewInformation(
                    resultSet.getInt("projectID"),
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
    
    public void insert(Connection connection,List<OutstandingResearchAwardReviewInformation> object) {
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
    	try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
    		preparedStatement.setInt(1,projectId);
    		preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

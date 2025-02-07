package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.RecruitDescription;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.RecruitDescriptionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruitDescriptionDAOImpl implements RecruitDescriptionDAO {

    private static final String DELETE_OBJECT = "DELETE FROM recruitdescription WHERE projectId = ?";
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO recruitdescription (recruitReason,recruitContent,expect,analysis,researchProduction,award,other,contribution,projectId) values(?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "recruitReason=?,recruitContent=?,expect=?,analysis=?,researchProduction=?,award=?,other=?,contribution=?";
    private static final String GET_OBJECT = "SELECT * FROM recruitdescription WHERE projectId = ?";

    @Override
    public void save(RecruitDescription object) {
        delete(object.getProjectId());
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getRecruitReason());
            preparedStatement.setString(2,object.getRecruitContent());
            preparedStatement.setString(3,object.getExpect());
            preparedStatement.setString(4,object.getAnalysis());
            preparedStatement.setString(5,object.getResearchProduction());
            preparedStatement.setString(6,object.getAward());
            preparedStatement.setString(7,object.getOther());
            preparedStatement.setString(8,object.getContribution());
            preparedStatement.setInt(9,object.getProjectId());
            preparedStatement.setString(10,object.getRecruitReason());
            preparedStatement.setString(11,object.getRecruitContent());
            preparedStatement.setString(12,object.getExpect());
            preparedStatement.setString(13,object.getAnalysis());
            preparedStatement.setString(14,object.getResearchProduction());
            preparedStatement.setString(15,object.getAward());
            preparedStatement.setString(16,object.getOther());
            preparedStatement.setString(17,object.getContribution());


            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RecruitDescription get(int projectId) {
        Connection connection = dbConnection.getConnection();
        RecruitDescription recruitDescription = new RecruitDescription();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    recruitDescription.setRecruitReason(resultSet.getString("recruitReason"));
                    recruitDescription.setRecruitContent(resultSet.getString("recruitContent"));
                    recruitDescription.setExpect(resultSet.getString("expect"));
                    recruitDescription.setAnalysis(resultSet.getString("analysis"));
                    recruitDescription.setResearchProduction(resultSet.getString("researchProduction"));
                    recruitDescription.setAward(resultSet.getString("award"));
                    recruitDescription.setOther(resultSet.getString("other"));
                    recruitDescription.setContribution(resultSet.getString("contribution"));
                    recruitDescription.setProjectId(resultSet.getInt("projectId"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recruitDescription;
    }

    private void delete(int projectId){

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_OBJECT))
        {
            preparedStatement.setInt(1,projectId);

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

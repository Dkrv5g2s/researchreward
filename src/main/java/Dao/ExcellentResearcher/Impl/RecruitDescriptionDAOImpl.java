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

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO recruitdescription (recruitReason,recruitContent,expect,analysis,researchProduction,award,other,contribution,userNumber) values(?,?,?,?,?,?,?,?,?)";
    private static final String GET_OBJECT = "SELECT * FROM recruitdescription WHERE userNumber = ?";

    @Override
    public void save(RecruitDescription object) {
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
            preparedStatement.setString(9,object.getUserNumber());



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RecruitDescription get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        RecruitDescription recruitDescription = new RecruitDescription();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setString(1,userNumber);

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
                    recruitDescription.setUserNumber(resultSet.getString("userNumber"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recruitDescription;
    }
}

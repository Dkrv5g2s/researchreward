package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.RecruitDescription;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.RecruitDescriptionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecruitDescriptionDAOImpl implements RecruitDescriptionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO recruitdescription (recruitReason,recruitContent,expect,analysis,researchProduction,award,other,contribution,userNumber) values(?,?,?,?,?,?,?,?,?)";
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
        return null;
    }
}

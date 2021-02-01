package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.Impl;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleAA;
import DBConnection.DBConnection;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleAADAO;

import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleAADAOImpl implements ArticleAADAO {

    private DBConnection dbConnection = new DBConnectionImpl();//TODO change database table
    private static final String SELECT = "SELECT * FROM articleaa WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO articleaa (projectID,a_article_count1,a_article_count2,a_article_count3,a_article_count_total,a_article_point1,a_article_point2,a_article_point3,a_article_point_total)"+
                    " values(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE articleaa "
                    + "SET a_article_count1 = ?,a_article_count2 = ?,a_article_count3 = ?,a_article_count_total = ?,a_article_point1 = ?,a_article_point2 = ?," +
                    "a_article_point3 = ?,a_article_point_total = ? "+
                    " WHERE projectID = ?";

    @Override
    public void save(ArticleAA object, String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
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
    public ArticleAA show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                ArticleAA aaa = null;
                aaa = new ArticleAA(
                        resultSet.getString("a_article_count1"),
                        resultSet.getString("a_article_count2"),
                        resultSet.getString("a_article_count3"),
                        resultSet.getString("a_article_count_total"),
                        resultSet.getString("a_article_point1"),
                        resultSet.getString("a_article_point2"),
                        resultSet.getString("a_article_point3"),
                        resultSet.getString("a_article_point_total"));
                return aaa;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,ArticleAA object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getA_article_count1());
            preparedStatement.setString(3,object.getA_article_count2());
            preparedStatement.setString(4,object.getA_article_count3());
            preparedStatement.setString(5,object.getA_article_count_total());
            preparedStatement.setString(6,object.getA_article_point1());
            preparedStatement.setString(7,object.getA_article_point2());
            preparedStatement.setString(8,object.getA_article_point3());
            preparedStatement.setString(9,object.getA_article_point_total());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,ArticleAA object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getA_article_count1());
            preparedStatement.setString(2,object.getA_article_count2());
            preparedStatement.setString(3,object.getA_article_count3());
            preparedStatement.setString(4,object.getA_article_count_total());
            preparedStatement.setString(5,object.getA_article_point1());
            preparedStatement.setString(6,object.getA_article_point2());
            preparedStatement.setString(7,object.getA_article_point3());
            preparedStatement.setString(8,object.getA_article_point_total());
            preparedStatement.setString(9,projectID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

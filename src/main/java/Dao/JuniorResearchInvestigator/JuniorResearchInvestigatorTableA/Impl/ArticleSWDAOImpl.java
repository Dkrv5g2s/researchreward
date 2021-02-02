package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.Impl;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleSW;
import DBConnection.DBConnection;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleSWDAO;

import java.sql.Connection;
import DBConnection.DBConnectionImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleSWDAOImpl implements ArticleSWDAO {
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM jri_articlesw WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO jri_articlesw (projectID,sw_article_count1,sw_article_count2,sw_article_count3,sw_article_count_total," +
                    "sw_point1,sw_point2,sw_point3,sw_point_total,fwci_value_past_three_year,a_plus_b_total_point)"+
                    " values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE jri_articlesw "
                    + "SET sw_article_count1 = ?,sw_article_count2 = ?,sw_article_count3 = ?,sw_article_count_total = ?," +
                    "sw_point1 = ?,sw_point2 = ?,sw_point3 = ?,sw_point_total = ?,fwci_value_past_three_year = ?,a_plus_b_total_point = ? "+
                    " WHERE projectID = ?";
    @Override
    public void save(ArticleSW object, String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection,object,projectID);
            }
            else {
                insert(connection,object,projectID);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArticleSW show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                ArticleSW asw = null;
                asw = new ArticleSW(
                        resultSet.getString("sw_article_count1"),
                        resultSet.getString("sw_article_count2"),
                        resultSet.getString("sw_article_count3"),
                        resultSet.getString("sw_article_count_total"),
                        resultSet.getString("sw_point1"),
                        resultSet.getString("sw_point2"),
                        resultSet.getString("sw_point3"),
                        resultSet.getString("sw_point_total"),
                        resultSet.getString("fwci_value_past_three_year"),
                        resultSet.getString("a_plus_b_total_point"));
                return asw;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Connection connection,ArticleSW object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getSw_article_count1());
            preparedStatement.setString(3,object.getSw_article_count2());
            preparedStatement.setString(4,object.getSw_article_count3());
            preparedStatement.setString(5,object.getSw_article_count_total());
            preparedStatement.setString(6,object.getSw_point1());
            preparedStatement.setString(7,object.getSw_point2());
            preparedStatement.setString(8,object.getSw_point3());
            preparedStatement.setString(9,object.getSw_point_total());
            preparedStatement.setString(10,object.getFwci_value_past_three_year());
            preparedStatement.setString(11,object.getA_plus_b_total_point());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,ArticleSW object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getSw_article_count1());
            preparedStatement.setString(2,object.getSw_article_count2());
            preparedStatement.setString(3,object.getSw_article_count3());
            preparedStatement.setString(4,object.getSw_article_count_total());
            preparedStatement.setString(5,object.getSw_point1());
            preparedStatement.setString(6,object.getSw_point2());
            preparedStatement.setString(7,object.getSw_point3());
            preparedStatement.setString(8,object.getSw_point_total());
            preparedStatement.setString(9,object.getFwci_value_past_three_year());
            preparedStatement.setString(10,object.getA_plus_b_total_point());
            preparedStatement.setString(11,projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.PersonalInformation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.PersonalInformationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalInformationDAOImpl implements PersonalInformationDAO {

    private static final String DELETE_OBJECT = "DELETE FROM personalinformation WHERE projectId=?";
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO personalinformation (college,department,hiredYear,hiredMonth,cName,eName,title,country,gender,qualification1," +
            "qualification2,level,price,projectId,workContent,pastPrice) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_OBJECT = "SELECT * FROM personalinformation WHERE projectId=?";
    private static final String UPDATE_DEPARTMENT_REVIEW_DATA =
            "UPDATE personalinformation " +
                    "SET departmentDirectorSignDate = ? " +
                    "WHERE projectId = ?";
    private static final String UPDATE_COLLEGE_REVIEW_DATA =
            "UPDATE personalinformation " +
                    "SET collegeReviewedDate = ?, reviewedResult = ?, " +
                    "collegeRecommendationRank = ?, collegeDirectorSignDate = ? " +
                    "WHERE projectId = ?";

    @Override
    public void save(PersonalInformation object) {
        delete(object.getProjectId());
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getCollege());
            preparedStatement.setString(2,object.getDepartment());
            preparedStatement.setString(3,object.getHiredYear());
            preparedStatement.setString(4,object.getHiredMonth());
            preparedStatement.setString(5,object.getcName());
            preparedStatement.setString(6,object.geteName());
            preparedStatement.setString(7,object.getTitle());
            preparedStatement.setString(8,object.getCountry());
            preparedStatement.setString(9,object.getGender());
            preparedStatement.setBoolean(10,object.getQualification1());
            preparedStatement.setBoolean(11,object.getQualification2());
            preparedStatement.setString(12,object.getLevel());
            preparedStatement.setString(13,object.getPrice());
            preparedStatement.setInt(14,object.getProjectId());
            preparedStatement.setString(15,object.getWorkContent());
            preparedStatement.setString(16,object.getPastPrice());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public PersonalInformation get(int projectId) {

        Connection connection = dbConnection.getConnection();
        PersonalInformation result = new PersonalInformation();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    result.setCollege(rs.getString("college"));
                    result.setDepartment(rs.getString("department"));
                    result.setHiredYear(rs.getString("hiredYear"));
                    result.setHiredMonth(rs.getString("hiredMonth"));
                    result.setcName(rs.getString("cName"));
                    result.seteName(rs.getString("eName"));
                    result.setTitle(rs.getString("title"));
                    result.setCountry(rs.getString("country"));
                    result.setGender(rs.getString("gender"));
                    result.setQualification1(rs.getBoolean("qualification1"));
                    result.setQualification2(rs.getBoolean("qualification2"));
                    result.setLevel(rs.getString("level"));
                    result.setPrice(rs.getString("price"));
                    result.setProjectId(rs.getInt("projectId"));
                    result.setWorkContent(rs.getString("workContent"));
                    result.setPastPrice(rs.getString("pastPrice"));
                    result.setCollegeReviewedDate(rs.getDate("collegeReviewedDate"));
                    result.setReviewedResult(rs.getString("reviewedResult"));
                    result.setCollegeRecommendationRank(rs.getString("collegeRecommendationRank"));
                    result.setDepartmentDirectorSignDate(rs.getDate("departmentDirectorSignDate"));
                    result.setCollegeDirectorSignDate(rs.getDate("collegeDirectorSignDate"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void updateDepartmentReviewData(PersonalInformation object){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_REVIEW_DATA))
        {
            preparedStatement.setDate(1, object.getDepartmentDirectorSignDate());
            preparedStatement.setInt(2, object.getProjectId());

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollegeReviewData(PersonalInformation object){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_REVIEW_DATA))
        {
            preparedStatement.setDate(1, object.getCollegeReviewedDate());
            preparedStatement.setString(2, object.getReviewedResult());
            preparedStatement.setString(3, object.getCollegeRecommendationRank());
            preparedStatement.setDate(4, object.getCollegeDirectorSignDate());
            preparedStatement.setInt(5, object.getProjectId());

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

package Dao.SunshineScholarshipAward.Impl;


import Bean.SunshineScholarshipAward.FWCIUserInputInfomation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.SunshineScholarshipAward.FWCIUserInputDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FWCIUserInputDAOImpl implements FWCIUserInputDAO {
    final private DBConnection dbConnection = new DBConnectionImpl();

    private static final String GET_OBJECT = "SELECT * FROM sunshine_scholarship_award_fwci_user_input WHERE project_id=?";

    private static final String INSERT_OBJECT = "INSERT INTO sunshine_scholarship_award_fwci_user_input " +
            "(sw_article_count_one,sw_point_one,user_fwci_value,teacher_form_check,commit_date,project_id) " +
            "values(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "sw_article_count_one=?,sw_point_one=?,user_fwci_value=?,teacher_form_check=?,commit_date=?,project_id=?;";

    @Override
    public void save(FWCIUserInputInfomation object){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getSwArticleCountOne());
            preparedStatement.setString(2,object.getSwPointOne());
            preparedStatement.setString(3,object.getFwciValueOfUser());
            preparedStatement.setBoolean(4,object.isTeacherFormCheck());
            preparedStatement.setString(5,object.getCommitDate());
            preparedStatement.setInt(6,object.getProjectId());
            preparedStatement.setString(7,object.getSwArticleCountOne());
            preparedStatement.setString(8,object.getSwPointOne());
            preparedStatement.setString(9,object.getFwciValueOfUser());
            preparedStatement.setBoolean(10,object.isTeacherFormCheck());
            preparedStatement.setString(11,object.getCommitDate());
            preparedStatement.setInt(12,object.getProjectId());
//            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FWCIUserInputInfomation get(int projectId){

        Connection connection = dbConnection.getConnection();
        FWCIUserInputInfomation result = new FWCIUserInputInfomation();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setInt(1,projectId);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    result.setSwArticleCountOne(rs.getString("sw_article_count_one"));
                    result.setSwPointOne(rs.getString("sw_point_one"));
                    result.setFwciValueOfUser(rs.getString("user_fwci_value"));
                    result.setTeacherFormCheck(rs.getBoolean("teacher_form_check"));
                    result.setCommitDate(rs.getString("commit_date"));
                    result.setProjectId(rs.getInt("project_id"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("result:"+result);
        return result;
    }
}

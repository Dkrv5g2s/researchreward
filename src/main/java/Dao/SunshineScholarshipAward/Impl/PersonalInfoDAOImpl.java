package Dao.SunshineScholarshipAward.Impl;




import Bean.SunshineScholarshipAward.PersonalInformation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.SunshineScholarshipAward.PersonalInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalInfoDAOImpl implements PersonalInfoDAO {
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO sunshine_scholarship_award_personal_info " +
            "(chinese_name,english_name,national_ID_number,department,titles,levels,resigned_time," +
            "extension_number,cellphone_number,email_address,project_id) values(?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "chinese_name=?,english_name=?,national_ID_number=?,department=?,titles=?,levels=?,resigned_time=?,extension_number=?,cellphone_number=?,email_address=?;";

    private static final String GET_OBJECT = "SELECT * FROM sunshine_scholarship_award_personal_info WHERE project_id=?";

    @Override
    public void save(PersonalInformation object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getChinese_name());
            preparedStatement.setString(2,object.getEnglish_name());
            preparedStatement.setString(3,object.getNational_ID_number());
            preparedStatement.setString(4,object.getDepartment());
            preparedStatement.setString(5,object.getTitles());
            preparedStatement.setString(6,object.getLevels());
            preparedStatement.setString(7,object.getResigned_time());
            preparedStatement.setString(8,object.getExtension_number());
            preparedStatement.setString(9,object.getCellphone_number());
            preparedStatement.setString(10,object.getEmail_address());
            preparedStatement.setInt(11,object.getProjectId());
            preparedStatement.setString(12,object.getChinese_name());
            preparedStatement.setString(13,object.getEnglish_name());
            preparedStatement.setString(14,object.getNational_ID_number());
            preparedStatement.setString(15,object.getDepartment());
            preparedStatement.setString(16,object.getTitles());
            preparedStatement.setString(17,object.getLevels());
            preparedStatement.setString(18,object.getResigned_time());
            preparedStatement.setString(19,object.getExtension_number());
            preparedStatement.setString(20,object.getCellphone_number());
            preparedStatement.setString(21,object.getEmail_address());
//            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public PersonalInformation get(int projectId) {
//        System.out.println("daoimpl:"+projectId);
        Connection connection = dbConnection.getConnection();
        PersonalInformation result = new PersonalInformation();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setInt(1,projectId);
//            System.out.println(preparedStatement.toString());
            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    result.setChinese_name(rs.getString("chinese_name"));
                    result.setEnglish_name(rs.getString("english_name"));
                    result.setNational_ID_number(rs.getString("national_ID_number"));
                    result.setDepartment(rs.getString("department"));
                    result.setTitles(rs.getString("titles"));
                    result.setLevels(rs.getString("levels"));
                    result.setResigned_time(rs.getString("resigned_time"));
                    result.setExtension_number(rs.getString("extension_number"));
                    result.setCellphone_number(rs.getString("cellphone_number"));
                    result.setEmail_address(rs.getString("email_address"));
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

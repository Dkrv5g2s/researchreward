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
            preparedStatement.setString(1,object.getChineseName());
            preparedStatement.setString(2,object.getEnglishName());
            preparedStatement.setString(3,object.getNationalIDNumber());
            preparedStatement.setString(4,object.getDepartment());
            preparedStatement.setString(5,object.getTitles());
            preparedStatement.setString(6,object.getLevels());
            preparedStatement.setString(7,object.getResignedTime());
            preparedStatement.setString(8,object.getExtensionNumber());
            preparedStatement.setString(9,object.getCellphoneNumber());
            preparedStatement.setString(10,object.getEmailAddress());
            preparedStatement.setInt(11,object.getProjectId());

            preparedStatement.setString(12,object.getChineseName());
            preparedStatement.setString(13,object.getEnglishName());
            preparedStatement.setString(14,object.getNationalIDNumber());
            preparedStatement.setString(15,object.getDepartment());
            preparedStatement.setString(16,object.getTitles());
            preparedStatement.setString(17,object.getLevels());
            preparedStatement.setString(18,object.getResignedTime());
            preparedStatement.setString(19,object.getExtensionNumber());
            preparedStatement.setString(20,object.getCellphoneNumber());
            preparedStatement.setString(21,object.getEmailAddress());
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
                    result.setChineseName(rs.getString("chinese_name"));
                    result.setEnglishName(rs.getString("english_name"));
                    result.setNationalIDNumber(rs.getString("national_ID_number"));
                    result.setDepartment(rs.getString("department"));
                    result.setTitles(rs.getString("titles"));
                    result.setLevels(rs.getString("levels"));
                    result.setResignedTime(rs.getString("resigned_time"));
                    result.setExtensionNumber(rs.getString("extension_number"));
                    result.setCellphoneNumber(rs.getString("cellphone_number"));
                    result.setEmailAddress(rs.getString("email_address"));
                    result.setProjectId(rs.getInt("project_id"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

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

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO personalinformation (college,department,hiredYear,hiredMonth,cName,eName,title,country,gender,qualification1," +
            "qualification2,level,price,projectId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "college=?,department=?,hiredYear=?,hiredMonth=?,cName=?,eName=?,title=?,country=?,gender=?,qualification1=?,qualification2=?,level=?,price=?";
    private static final String GET_OBJECT = "SELECT * FROM personalinformation WHERE projectId=?";

    @Override
    public void save(PersonalInformation object) {
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
            preparedStatement.setString(15,object.getCollege());
            preparedStatement.setString(16,object.getDepartment());
            preparedStatement.setString(17,object.getHiredYear());
            preparedStatement.setString(18,object.getHiredMonth());
            preparedStatement.setString(19,object.getcName());
            preparedStatement.setString(20,object.geteName());
            preparedStatement.setString(21,object.getTitle());
            preparedStatement.setString(22,object.getCountry());
            preparedStatement.setString(23,object.getGender());
            preparedStatement.setBoolean(24,object.getQualification1());
            preparedStatement.setBoolean(25,object.getQualification2());
            preparedStatement.setString(26,object.getLevel());
            preparedStatement.setString(27,object.getPrice());

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
}

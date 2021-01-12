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
            "qualification2,level,price,userNumber) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_OBJECT = "SELECT * FROM personalinformation WHERE userNumber=?";

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
            preparedStatement.setString(14,object.getUserNumber());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public PersonalInformation get(String userNumber) {

        Connection connection = dbConnection.getConnection();
        PersonalInformation result = new PersonalInformation();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet rs = preparedStatement.executeQuery()){
                rs.next();
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
                result.setUserNumber(rs.getString("userNumber"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

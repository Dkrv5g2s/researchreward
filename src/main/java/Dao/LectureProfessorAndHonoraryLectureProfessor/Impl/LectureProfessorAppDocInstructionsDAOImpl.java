package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructions;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructionsDAO;

public class LectureProfessorAppDocInstructionsDAOImpl implements LectureProfessorAppDocInstructionsDAO{
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureprofessorappdocinstructions WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessorappdocinstructions (projectID,userNumber,technologyTransferContractName,technologyTransferDepartment,contractDate,technologyTransferFund,technologyTransferFundBringInDate)"+
            " values(?,?,?,?,?,?,?)";
    private static final String DELETE =
            "DELETE FROM lectureprofessorappdocinstructions "+
            " WHERE projectID = ?";
    @Override
    public void save(List<LectureProfessorAppDocInstructions> object, String userNumber,String projectID) {
        Connection connection = dbConnection.getConnection();
        
        delete(connection,projectID);
        if(!object.isEmpty()) {
            insert(connection,object,projectID);
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<LectureProfessorAppDocInstructions> show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        List<LectureProfessorAppDocInstructions> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorAppDocInstructions lpadi = null;
                lpadi = new LectureProfessorAppDocInstructions(
                        resultSet.getString("userNumber"),
                        resultSet.getString("technologyTransferContractName"),
                        resultSet.getString("technologyTransferDepartment"),
                        resultSet.getString("contractDate"),
                        resultSet.getString("technologyTransferFund"),
                        resultSet.getString("technologyTransferFundBringInDate"));
                list.add(lpadi);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }

    public void insert(Connection connection,List<LectureProfessorAppDocInstructions> object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            for(int i = 0;i<object.size();i++) {
                preparedStatement.setString(1,projectID);
                preparedStatement.setString(2,object.get(i).getUserNumber());
                preparedStatement.setString(3,object.get(i).getTechnologyTransferContractName());
                preparedStatement.setString(4,object.get(i).getTechnologyTransferDepartment());
                preparedStatement.setString(5,object.get(i).getContractDate());
                preparedStatement.setString(6,object.get(i).getTechnologyTransferFund());
                preparedStatement.setString(7,object.get(i).getTechnologyTransferFundBringInDate());

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Connection connection,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {

            preparedStatement.setString(1,projectID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

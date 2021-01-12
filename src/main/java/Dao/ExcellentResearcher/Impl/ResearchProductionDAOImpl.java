package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.ResearchProduction.Patent;
import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import Bean.ExcellentResearcher.ResearchProduction.Technology;
import Bean.ExcellentResearcher.ResearchProduction.WorkAuthorization;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.ResearchProductionDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ResearchProductionDAOImpl implements ResearchProductionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_PATENT = "INSERT INTO patent (patentClass,patentName,country,patentNumber,patentee,mstPlanNumber,approvalDate,userNumber,inventor) values (?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_TECHNOLOGY = "INSERT INTO technology (authorizedUnit,patentName,contractDate,mstPlanNumber,technologyName,toAuthorizedUnit,userNumber) values (?,?,?,?,?,?,?)";
    private static final String INSERT_WORK_AUTHORIZATION = "INSERT INTO workauthorization (agent,author,authorizationClass,copyrightOwner,mstPlanNumber,patentClass,userNumber) values (?,?,?,?,?,?,?)";

    @Override
    public void save(ResearchProduction object) {

        Connection connection = dbConnection.getConnection();
        this.savePatents(connection, object.getPatentList());
        this.saveTechnology(connection, object.getTechnologyList());
        this.saveWorkAuthorization(connection, object.getWorkAuthorizationList());
    }

    @Override
    public ResearchProduction get(String userNumber) {
        return null;
    }

    private void savePatents(Connection connection, List<Patent> patientList){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATENT))
        {

            for(Patent patent: patientList){
                preparedStatement.setString(1,patent.getPatentClass());
                preparedStatement.setString(2,patent.getPatentName());
                preparedStatement.setString(3,patent.getCountry());
                preparedStatement.setString(4,patent.getPatentNumber());
                preparedStatement.setString(5,patent.getPatentee());
                preparedStatement.setString(6,patent.getMstPlanNumber());
                preparedStatement.setDate(7,patent.getApprovalDate() == null ? null:new Date(patent.getApprovalDate().getTime()));
                preparedStatement.setString(8,patent.getUserNumber());
                preparedStatement.setString(9,patent.getInventor());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void saveTechnology(Connection connection, List<Technology> technologyList){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TECHNOLOGY))
        {
            for(Technology technology: technologyList){
                preparedStatement.setString(1,technology.getAuthorizedUnit());
                preparedStatement.setString(2,technology.getPatentName());
                preparedStatement.setDate(3,technology.getContractDate() == null ? null:new Date(technology.getContractDate().getTime()));
                preparedStatement.setString(4,technology.getMstPlanNumber());
                preparedStatement.setString(5,technology.getTechnologyName());
                preparedStatement.setString(6,technology.getToAuthorizedUnit());
                preparedStatement.setString(7,technology.getUserNumber());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void saveWorkAuthorization(Connection connection, List<WorkAuthorization> workAuthorizationList){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORK_AUTHORIZATION))
        {
            for(WorkAuthorization workAuthorization: workAuthorizationList){
                preparedStatement.setString(1,workAuthorization.getAgent());
                preparedStatement.setString(2,workAuthorization.getAuthor());
                preparedStatement.setString(3,workAuthorization.getAuthorizationClass());
                preparedStatement.setString(4,workAuthorization.getCopyrightOwner());
                preparedStatement.setString(5,workAuthorization.getMstPlanNumber());
                preparedStatement.setString(6,workAuthorization.getWorkName());
                preparedStatement.setString(7,workAuthorization.getUserNumber());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

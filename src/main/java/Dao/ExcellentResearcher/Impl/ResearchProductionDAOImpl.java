package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.MOSTPlan;
import Bean.ExcellentResearcher.ResearchProduction.Patent;
import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import Bean.ExcellentResearcher.ResearchProduction.Technology;
import Bean.ExcellentResearcher.ResearchProduction.WorkAuthorization;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.ResearchProductionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResearchProductionDAOImpl implements ResearchProductionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_PATENT = "INSERT INTO patent (patentClass,patentName,country,patentNumber,patentee,mstPlanNumber,approvalDate,inventor,projectId) values (?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_TECHNOLOGY = "INSERT INTO technology (authorizedUnit,patentName,contractDate,mstPlanNumber,technologyName,toAuthorizedUnit,projectId) values (?,?,?,?,?,?,?)";
    private static final String INSERT_WORK_AUTHORIZATION = "INSERT INTO workauthorization (agent,author,authorizationClass,copyrightOwner,mstPlanNumber,workName,projectId) values (?,?,?,?,?,?,?)";

    private static final String GET_PATENT = "SELECT * FROM patent WHERE projectId = ?";
    private static final String GET_TECHNOLOGY = "SELECT * FROM technology WHERE projectId = ?";
    private static final String GET_WORK_AUTHORIZATION = "SELECT * FROM workauthorization WHERE projectId = ?";

    private static final String DELETE_PATENT = "DELETE FROM patent WHERE projectId = ?";
    private static final String DELETE_TECHNOLOGY = "DELETE FROM technology WHERE projectId = ?";
    private static final String DELETE_WORK_AUTHORIZATION = "DELETE FROM workauthorization WHERE projectId = ?";

    @Override
    public void save(ResearchProduction object) {

        Connection connection = dbConnection.getConnection();
        this.deletePatents(object.getProjectId());
        this.deleteTechnology(object.getProjectId());
        this.deleteWorkAuthorization(object.getProjectId());
        this.savePatents(connection, object.getPatentList());
        this.saveTechnology(connection, object.getTechnologyList());
        this.saveWorkAuthorization(connection, object.getWorkAuthorizationList());
    }

    @Override
    public ResearchProduction get(int projectId) {
        Connection connection = dbConnection.getConnection();
        ResearchProduction result = new ResearchProduction();

        result.setPatentList(getPatents(connection,projectId));
        result.setTechnologyList(getTechnology(connection,projectId));
        result.setWorkAuthorizationList(getWorkAuthorization(connection,projectId));

        return result;
    }

    private List<Patent> getPatents(Connection connection,int projectId){
        List<Patent> patentList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PATENT))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Patent patent = new Patent();
                    patent.setPatentClass(resultSet.getString("patentClass"));
                    patent.setPatentName(resultSet.getString("patentName"));
                    patent.setCountry(resultSet.getString("country"));
                    patent.setPatentNumber(resultSet.getString("patentNumber"));
                    patent.setPatentee(resultSet.getString("patentee"));
                    patent.setMstPlanNumber(resultSet.getString("mstPlanNumber"));
                    patent.setApprovalDate(resultSet.getDate("approvalDate"));
                    patent.setProjectId(resultSet.getInt("projectId"));
                    patent.setInventor(resultSet.getString("inventor"));
                    patentList.add(patent);
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patentList;
    }
    private List<Technology> getTechnology(Connection connection,int projectId){
        List<Technology> technologyList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_TECHNOLOGY))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Technology technology = new Technology();
                    technology.setAuthorizedUnit(resultSet.getString("authorizedUnit"));
                    technology.setPatentName(resultSet.getString("patentName"));
                    technology.setContractDate(resultSet.getDate("contractDate"));
                    technology.setMstPlanNumber(resultSet.getString("mstPlanNumber"));
                    technology.setTechnologyName(resultSet.getString("technologyName"));
                    technology.setToAuthorizedUnit(resultSet.getString("toAuthorizedUnit"));
                    technology.setProjectId(resultSet.getInt("projectId"));
                    technologyList.add(technology);
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return technologyList;
    }
    private List<WorkAuthorization> getWorkAuthorization(Connection connection,int projectId){
        List<WorkAuthorization> workAuthorizationList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_WORK_AUTHORIZATION))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    WorkAuthorization workAuthorization = new WorkAuthorization();
                    workAuthorization.setAgent(resultSet.getString("agent"));
                    workAuthorization.setAuthor(resultSet.getString("author"));
                    workAuthorization.setAuthorizationClass(resultSet.getString("authorizationClass"));
                    workAuthorization.setCopyrightOwner(resultSet.getString("copyrightOwner"));
                    workAuthorization.setMstPlanNumber(resultSet.getString("mstPlanNumber"));
                    workAuthorization.setWorkName(resultSet.getString("workName"));
                    workAuthorization.setProjectId(resultSet.getInt("projectId"));
                    workAuthorizationList.add(workAuthorization);
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workAuthorizationList;
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
                preparedStatement.setString(8,patent.getInventor());
                preparedStatement.setInt(9,patent.getProjectId());
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
                preparedStatement.setInt(7,technology.getProjectId());
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
                preparedStatement.setInt(7,workAuthorization.getProjectId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletePatents(int projectId){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PATENT))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void deleteTechnology(int projectId){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TECHNOLOGY))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void deleteWorkAuthorization(int projectId){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WORK_AUTHORIZATION))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

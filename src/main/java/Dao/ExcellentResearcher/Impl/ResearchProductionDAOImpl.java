package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.ResearchProductionDAO;

public class ResearchProductionDAOImpl implements ResearchProductionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_PATENT = "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,userNumber) values (?,?,?,?,?,?)";
    private static final String INSERT_TECHNOLOGY = "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,userNumber) values (?,?,?,?,?,?)";
    private static final String INSERT_WORK_AUTHORIZATION = "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,userNumber) values (?,?,?,?,?,?)";

    @Override
    public void save(ResearchProduction object) {

    }

    @Override
    public ResearchProduction get(String userNumber) {
        return null;
    }
}

package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.ResearchProduction.Second.*;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.AggregateDAO;

import java.sql.*;
import java.util.List;

public class AggregateDAOImpl implements AggregateDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_REWARD = "INSERT INTO researreward (rewardName,organization,rewardDate,reason,projectId) values (?,?,?,?,?)";
    private static final String INSERT_BOOK = "INSERT INTO researbook (number,year,bookName,publisher,publishYear,ISBN,projectId) values (?,?,?,?,?,?,?)";
    private static final String INSERT_PLAN = "INSERT INTO researplan (number,year,planName,planNumber,startTime,lastTime,projectId) values (?,?,?,?,?,?,?)";
    private static final String INSERT_PAPER = "INSERT INTO researpaper (number,year,paperName,journal,author,projectId) values (?,?,?,?,?,?)";

    private static final String GET_REWARD = "SELECT * FROM researreward WHERE projectId = ?";
    private static final String GET_BOOK = "SELECT * FROM researbook WHERE projectId = ?";
    private static final String GET_PLAN = "SELECT * FROM researplan WHERE projectId = ?";
    private static final String GET_PAPER = "SELECT * FROM researpaper WHERE projectId = ?";

    private static final String DELETE_REWARD = "DELETE FROM researreward WHERE projectId = ?";
    private static final String DELETE_BOOK = "DELETE FROM researbook WHERE projectId = ?";
    private static final String DELETE_PLAN = "DELETE FROM researplan WHERE projectId = ?";
    private static final String DELETE_PAPER = "DELETE FROM researpaper WHERE projectId = ?";

    @Override
    public void save(Aggregate object) {
        try (Connection connection = dbConnection.getConnection()){
            this.deleteAll(object.getProjectId());
            this.saveBook(connection, object.getBookList());
            this.savePaper(connection, object.getPaperList());
            this.savePlan(connection, object.getPlanList());
            this.saveReward(connection, object.getRewardList());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Aggregate get(int projectId) {
        Aggregate aggregate = new Aggregate();
        try (Connection connection = dbConnection.getConnection()){
            this.getBook(connection, projectId, aggregate);
            this.getPaper(connection, projectId, aggregate);
            this.getPlan(connection, projectId, aggregate);
            this.getReward(connection, projectId, aggregate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aggregate;

    }

    private void getPlan(Connection connection, int projectId, Aggregate aggregate){
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PLAN))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Plan plan = new Plan();

                    plan.setNumber(resultSet.getString("number"));
                    plan.setYear(resultSet.getString("year"));
                    plan.setPlanName(resultSet.getString("planName"));
                    plan.setPlanNumber(resultSet.getString("planNumber"));
                    plan.setStartTime(resultSet.getDate("startTime"));
                    plan.setLastTime(resultSet.getDate("lastTime"));
                    plan.setProjectId(resultSet.getInt("projectId"));

                    aggregate.addPlan(plan);
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getBook(Connection connection, int projectId, Aggregate aggregate){
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Book book = new Book();

                    book.setNumber(resultSet.getString("number"));
                    book.setYear(resultSet.getString("year"));
                    book.setBookName(resultSet.getString("bookName"));
                    book.setPublisher(resultSet.getString("publisher"));
                    book.setPublishYear(resultSet.getString("publishYear"));
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setProjectId(resultSet.getInt("projectId"));

                    aggregate.addBook(book);

                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getPaper(Connection connection, int projectId, Aggregate aggregate){
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PAPER))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Paper paper = new Paper();

                    paper.setNumber(resultSet.getString("number"));
                    paper.setYear(resultSet.getString("year"));
                    paper.setPaperName(resultSet.getString("paperName"));
                    paper.setJournal(resultSet.getString("journal"));
                    paper.setAuthor(resultSet.getString("author"));
                    paper.setProjectId(resultSet.getInt("projectId"));

                    aggregate.addPaper(paper);
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getReward(Connection connection, int projectId, Aggregate aggregate){
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_REWARD))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    Reward reward = new Reward();

                    reward.setRewardName(resultSet.getString("rewardName"));
                    reward.setOrganization(resultSet.getString("organization"));
                    reward.setRewardDate(resultSet.getDate("rewardDate"));
                    reward.setReason(resultSet.getString("reason"));
                    reward.setProjectId(resultSet.getInt("projectId"));

                    aggregate.addReward(reward);

                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveReward(Connection connection, List<Reward> object){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REWARD)){
            for(Reward reward : object){
                preparedStatement.setString(1,reward.getRewardName());
                preparedStatement.setString(2,reward.getOrganization());
                preparedStatement.setDate(3,reward.getRewardDate() == null ? null:new Date(reward.getRewardDate().getTime()));
                preparedStatement.setString(4,reward.getReason());
                preparedStatement.setInt(5,reward.getProjectId());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void savePaper(Connection connection, List<Paper> object){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAPER)){
            for(Paper paper: object){
                preparedStatement.setString(1, paper.getNumber());
                preparedStatement.setString(2, paper.getYear());
                preparedStatement.setString(3, paper.getPaperName());
                preparedStatement.setString(4, paper.getJournal());
                preparedStatement.setString(5, paper.getAuthor());
                preparedStatement.setInt(6, paper.getProjectId());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void savePlan(Connection connection, List<Plan> object){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAN)){
            for(Plan plan: object){
                preparedStatement.setString(1, plan.getNumber());
                preparedStatement.setString(2, plan.getYear());
                preparedStatement.setString(3, plan.getPlanName());
                preparedStatement.setString(4, plan.getPlanNumber());
                preparedStatement.setDate(5, plan.getStartTime() == null ? null: new Date(plan.getStartTime().getTime()));
                preparedStatement.setDate(6, plan.getLastTime() == null ? null: new Date(plan.getLastTime().getTime()));
                preparedStatement.setInt(7, plan.getProjectId());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void saveBook(Connection connection, List<Book> object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {
            for(Book book: object){
                preparedStatement.setString(1, book.getNumber());
                preparedStatement.setString(2, book.getYear());
                preparedStatement.setString(3, book.getBookName());
                preparedStatement.setString(4, book.getPublisher());
                preparedStatement.setString(5, book.getPublishYear());
                preparedStatement.setString(6, book.getISBN());
                preparedStatement.setInt(7, book.getProjectId());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void deleteAll(int projectId){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAN))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REWARD))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PAPER))
        {
            preparedStatement.setInt(1,projectId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}

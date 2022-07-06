package DBSynchronize;

import DBConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalPaperSynchronize {

    private DBConnection TEdbConnection = new TeacherEvaluationDBConnectionImpl();
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_staff_cname_by_staff_code = "SELECT staff_cname FROM db.staff WHERE staff_code = ?;";
    private static final String SELECT_rch_journals = "SELECT seq_num, staff_code, thesis_name, journal_name, volume, pages, issue_date, corresponding FROM cbh.rch_journal;";
    private static final String INSERT_journal_papers = "INSERT INTO journal_paper(seq_num, staff_code, staff_cname, thesis_name, journal_name, volume, pages ,public_year , w2_corresponding) VALUES (?,?,?,?,?,?,?,?,?) " +
            "ON DUPLICATE KEY UPDATE seq_num = ?;";

    private String select_cname_by_code(String staffcode) {
        Connection TEcon = TEdbConnection.getConnection();
        try (PreparedStatement preparedStatement = TEcon.prepareStatement(SELECT_staff_cname_by_staff_code))
        {
            preparedStatement.setString(1, staffcode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("staff_cname");
            }
            TEcon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void insert_journal_paper(int seq_num, String staffcode, String staffcname, String thesis_name, String journal_name, String volume, String pages, String public_year, String W2_corresponding) throws SQLException {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_journal_papers))
        {
            preparedStatement.setInt(1, seq_num);
            preparedStatement.setString(2, staffcode);
            preparedStatement.setString(3, staffcname);
            preparedStatement.setString(4, thesis_name);
            preparedStatement.setString(5, journal_name);
            preparedStatement.setString(6, volume);
            preparedStatement.setString(7, pages);
            preparedStatement.setString(8, public_year);
            preparedStatement.setString(9, W2_corresponding);
            preparedStatement.setInt(10, seq_num);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String synchronize_all_journal_papers_from_TEDB() throws SQLException {
        String update_msg = "";
        int total_updated_journal_number = 0;
        int total_null_staff_cname = 0;
        Connection TEcon = TEdbConnection.getConnection();
        try (PreparedStatement preparedStatement = TEcon.prepareStatement(SELECT_rch_journals))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int seq_num = resultSet.getInt("seq_num");
                String staffcode = resultSet.getString("staff_code");
                String staffcname = select_cname_by_code(staffcode);
                if(staffcname!=null) {
                    String thesis_name = resultSet.getString("thesis_name");
                    String journal_name = resultSet.getString("journal_name");
                    String volume = resultSet.getString("volume");
                    String pages = resultSet.getString("pages");
                    String public_year = resultSet.getString("issue_date");
                    public_year = public_year.split("-")[0];
                    String W2_corresponding = resultSet.getString("corresponding");
                    insert_journal_paper(seq_num, staffcode, staffcname, thesis_name, journal_name, volume, pages, public_year, W2_corresponding);
                    total_updated_journal_number++;
                }
                else {
                    total_null_staff_cname++;
                }
            }
            TEcon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        total_updated_journal_number -= total_null_staff_cname;
        update_msg += "Update with "+ total_updated_journal_number +" journal papers, total null staff_cname is " +total_null_staff_cname;
        return update_msg;
    }
}

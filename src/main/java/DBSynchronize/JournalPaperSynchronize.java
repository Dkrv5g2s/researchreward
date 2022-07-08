package DBSynchronize;

import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import DBConnection.TeacherEvaluationDBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JournalPaperSynchronize {

    private DBConnection TEdbConnection = new TeacherEvaluationDBConnectionImpl();
    private DBConnection dbConnection = new DBConnectionImpl();
    private Map<String, String> code_name_map = new HashMap<>();
    private static final String SELECT_staff_cname = "SELECT staff_code, staff_cname FROM db.staff;";
    private static final String SELECT_rch_journals = "SELECT seq_num, staff_code, thesis_name, journal_name, volume, pages, issue_date, authors, corresponding FROM cbh.rch_journal;";
    private static final String INSERT_journal_papers = "INSERT INTO journal_paper(seq_num, staff_code, staff_cname, thesis_name, journal_name, volume, pages ,public_year, w2_author_order, w3_corresponding) VALUES (?,?,?,?,?,?,?,?,?,?) " + "ON DUPLICATE KEY UPDATE seq_num = ?;";

    private void set_code_name_map() {
        Connection TEcon = TEdbConnection.getConnection();
        try (PreparedStatement preparedStatement = TEcon.prepareStatement(SELECT_staff_cname))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("staff_code");
                String cname = resultSet.getString("staff_cname");
                this.code_name_map.put(code, cname);
            }
            TEcon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String get_name_by_number(String code) {
        if (this.code_name_map.containsKey(code)) {
            return code_name_map.get(code);
        }
        return null;
    }

    private void insert_journal_paper(PreparedStatement preparedStatement, int seq_num, String staff_code, String staff_cname, String thesis_name, String journal_name, String volume, String pages, String public_year, int W2_author_order, String W3_corresponding) throws SQLException {
        preparedStatement.setInt(1, seq_num);
        preparedStatement.setString(2, staff_code);
        preparedStatement.setString(3, staff_cname);
        preparedStatement.setString(4, thesis_name);
        preparedStatement.setString(5, journal_name);
        preparedStatement.setString(6, volume);
        preparedStatement.setString(7, pages);
        preparedStatement.setString(8, public_year);
        preparedStatement.setInt(9, W2_author_order);
        preparedStatement.setString(10, W3_corresponding);
        preparedStatement.setInt(11, seq_num);
        preparedStatement.executeUpdate();
    }

    public String synchronize_all_journal_papers_from_TEDB() throws SQLException {
        set_code_name_map();
        String update_msg = "";
        int total_updated_journal_number = 0;
        int total_staff_with_no_journal = 0;
        Connection TEcon = TEdbConnection.getConnection();
        try (PreparedStatement TEpreparedStatement = TEcon.prepareStatement(SELECT_rch_journals))
        {
            ResultSet resultSet = TEpreparedStatement.executeQuery();
            Connection connection = dbConnection.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_journal_papers))
            {
                while(resultSet.next()) {
                    int seq_num = resultSet.getInt("seq_num");
                    String staff_code = resultSet.getString("staff_code");
                    String staff_cname = get_name_by_number(staff_code);
                    if(staff_cname!=null) {
                        String thesis_name = resultSet.getString("thesis_name");
                        String journal_name = resultSet.getString("journal_name");
                        String volume = resultSet.getString("volume");
                        String pages = resultSet.getString("pages");
                        String public_year = resultSet.getString("issue_date");
                        public_year = public_year.split("-")[0];
                        int W2_author_order = resultSet.getInt("authors");
                        String W3_corresponding = resultSet.getString("corresponding");
                        insert_journal_paper(preparedStatement, seq_num, staff_code, staff_cname, thesis_name, journal_name, volume, pages, public_year, W2_author_order, W3_corresponding);
                        total_updated_journal_number++;
                    }
                    else {
                        total_staff_with_no_journal++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException TEe) {
            TEe.printStackTrace();
        }
        TEcon.close();
        total_updated_journal_number -= total_staff_with_no_journal;
        update_msg += "Update with "+ total_updated_journal_number +" journal papers, total staff with no journal is " +total_staff_with_no_journal;
        return update_msg;
    }
}

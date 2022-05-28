package Dao.RchJournal;

import Bean.RchJournal.RchJournal;
import DBConnection.DBConnection;
import DBConnection.TeacherEvaluationDBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RchJournalDAOImpl implements RchJournalDAO{

    private DBConnection TEbdConnection = new TeacherEvaluationDBConnectionImpl();
    private static final String SELECT_RchJournals_with_staff_code = "SELECT * FROM cbh.rch_journal WHERE staff_code = ? ORDER BY seq_num;";
    private static final String SELECT_staff_cname_with_staff_code = "SELECT * FROM db.staff WHERE staff_code = ?;";

    private List<RchJournal> query_rch_journals_with_staff_code(String staff_code) {
        String staff_cname = getStaffCname(staff_code);
        if(staff_cname!=null) {
            Connection connection = TEbdConnection.getConnection();
            List<RchJournal> rchJournals = new ArrayList<>();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RchJournals_with_staff_code))
            {
                preparedStatement.setString(1, staff_code);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    String thesis_name = resultSet.getString("thesis_name");
                    String journal_name = resultSet.getString("journal_name");
                    String volume = resultSet.getString("volume");
                    String pages = resultSet.getString("pages");
                    String public_year = resultSet.getString("issue_date");
                    public_year = public_year.split("-")[0];
                    String W2_corresponding = resultSet.getString("corresponding");
                    RchJournal rchJournal = new RchJournal(staff_cname, thesis_name, journal_name, volume, pages, public_year, W2_corresponding);
                    rchJournals.add(rchJournal);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rchJournals;
        }
        return null;
    }

    private String getStaffCname(String staff_code) {
        Connection connection = TEbdConnection.getConnection();
        String cname = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_staff_cname_with_staff_code))
        {
            preparedStatement.setString(1, staff_code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cname = resultSet.getString("staff_cname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cname;
    }

    @Override
    public List<RchJournal> query_rch_journals(String staff_code) {
        return query_rch_journals_with_staff_code(staff_code);
    }
}

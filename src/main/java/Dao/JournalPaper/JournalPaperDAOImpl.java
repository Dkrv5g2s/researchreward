package Dao.JournalPaper;

import Bean.JournalPaper.JournalPaper;
import DBConnection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JournalPaperDAOImpl implements JournalPaperDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_journal_papers_by_staff_code = "SELECT * FROM researchreward.journal_paper WHERE staff_code = ?;";

    @Override
    public List<JournalPaper> query_journal_papers(String staff_code) {
        Connection connection = dbConnection.getConnection();
        List<JournalPaper> journalPapers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_journal_papers_by_staff_code))
        {
            preparedStatement.setString(1, staff_code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String staff_cname = resultSet.getString("staff_cname");
                String thesis_name = resultSet.getString("thesis_name");
                String journal_name = resultSet.getString("journal_name");
                String volume = resultSet.getString("volume");
                String pages = resultSet.getString("pages");
                String public_year = resultSet.getString("public_year");
                String W2_corresponding = resultSet.getString("w2_corresponding");
                JournalPaper journalPaper = new JournalPaper(staff_cname, thesis_name, journal_name, volume, pages, public_year, W2_corresponding);
                journalPapers.add(journalPaper);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journalPapers;
    }
}

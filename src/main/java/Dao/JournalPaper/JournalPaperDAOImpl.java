package Dao.JournalPaper;

import Bean.JournalPaper.JournalPaper;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JournalPaperDAOImpl implements JournalPaperDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_journal_papers = "SELECT * FROM journal_paper WHERE staff_code = ?;";
    private static final String SELECT_limited_years_journal_papers = "SELECT * FROM journal_paper WHERE staff_code = ? AND public_year >=?;";


    @Override
    public List<JournalPaper> query_journal_papers(String staff_code) {
        Connection connection = dbConnection.getConnection();
        List<JournalPaper> journalPapers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_journal_papers))
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
                int W2_author_order = resultSet.getInt("w2_author_order");
                String W3_corresponding = resultSet.getString("w3_corresponding");
                JournalPaper journalPaper = new JournalPaper(staff_cname, thesis_name, journal_name, volume, pages, public_year, W2_author_order, W3_corresponding);
                journalPapers.add(journalPaper);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journalPapers;
    }

    @Override
    public List<JournalPaper> queryJournalPapersWithLimitedRewardPeriod(String staff_code, String reward_type) {
        Connection connection = dbConnection.getConnection();
        List<JournalPaper> journalPapers = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_limited_years_journal_papers))
        {
            preparedStatement.setString(1, staff_code);
            int start_year = getRewardLimitStartPaperYears(reward_type);
            System.out.println("querying journals that publish after "+start_year);
            preparedStatement.setInt(2, start_year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String staff_cname = resultSet.getString("staff_cname");
                String thesis_name = resultSet.getString("thesis_name");
                String journal_name = resultSet.getString("journal_name");
                String volume = resultSet.getString("volume");
                String pages = resultSet.getString("pages");
                String public_year = resultSet.getString("public_year");
                int W2_author_order = resultSet.getInt("w2_author_order");
                String W3_corresponding = resultSet.getString("w3_corresponding");
                JournalPaper journalPaper = new JournalPaper(staff_cname, thesis_name, journal_name, volume, pages, public_year, W2_author_order, W3_corresponding);
                journalPapers.add(journalPaper);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return journalPapers;
    }

    private int getRewardLimitStartPaperYears(String reward_type) {
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int current_year = Integer.parseInt(getYearFormat.format(date));
        switch (reward_type){

            case "獎勵新聘特殊優秀研究人才":
            case "獎勵新聘特殊優秀研究人才(N類-新)": // 2022/09/01 研發處將_獎勵新聘特殊優秀研究人才_改名為此
            case "(續撥)獎勵新聘特殊優秀研究人才":
            case "(續撥)獎勵新聘特殊優秀研究人才(N類-續)": // 2022/09/01 研發處將_(續撥)獎勵新聘特殊優秀研究人才_改名為此
                return current_year+1; // 無論文績效說明表

            case "年輕學者研究獎":
            case "傑出研究獎":
                return current_year-3; // 近3年論文績效說明表

            case "特聘教授":
            case "獎勵特殊優秀研究人才":
            case "獎勵特殊優秀研究人才(A類)": // 2022/09/01 研發處將_獎勵特殊優秀研究人才_改名為此
            case "陽光獎助金論文獎勵":
            case "奬助研究及產學績優教師聘任研究人員辦法": // 第一個字會顯示 '?'
            case "獎助研究及產學績優教師聘任研究人員辦法": // 改名過後的 獎助績優, 第一個字不會再顯示 '?'
            case "講座教授":
            case "講座教授/榮譽講座教授": // 因 講座教授 內可以在 講座教授/榮譽講座教授 內二擇一申請, 故標示清楚
                return current_year-5; // 近5年論文績效說明表

            default:
                return current_year+1;
        }
    }
}

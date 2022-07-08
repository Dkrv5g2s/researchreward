package DAO.JournalPaper;

import Bean.JournalPaper.JournalPaper;
import Dao.JournalPaper.JournalPaperDAO;
import Dao.JournalPaper.JournalPaperDAOImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class JournalPaperDAOImplTest {

    private JournalPaperDAO dao;

    @BeforeEach
    void setUp() {
        dao = new JournalPaperDAOImpl();
    }

    @Test
    void testQueryJournalPapersWithEmptyCode() {
        Assert.assertEquals(0, dao.query_journal_papers("").size());
    }

    @Test
    void testQueryJournalPapersWithNotExistCode() {
        Assert.assertEquals(0, dao.query_journal_papers("xxxx").size());
    }

    @Test
    void testQueryJournalPapersWithNormalCode() {
        List<JournalPaper> journalPaperList = dao.query_journal_papers("11247");
        Assert.assertEquals("郭忠義", journalPaperList.get(0).getStaff_cname());
        Assert.assertEquals("Evolutionary Agents for Intelligent Transport Systems", journalPaperList.get(0).getThesis_name());
        Assert.assertEquals("International Journal of Fuzzy Systems", journalPaperList.get(0).getJournal_name());
        Assert.assertEquals("7", journalPaperList.get(0).getVolume());
        Assert.assertEquals("85-93", journalPaperList.get(0).getPages());
        Assert.assertEquals("2005", journalPaperList.get(0).getPublic_year());
        Assert.assertEquals("1", journalPaperList.get(0).getW3_corresponding());
    }

    @Test
    void testGetThreeYearsJournalPapers() {
        List<JournalPaper> journalPaperList = dao.query_journal_papers_of_reward_limited_years("11247", "年輕學者研究獎");
        Assert.assertEquals("郭忠義", journalPaperList.get(0).getStaff_cname());
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int current_year = Integer.parseInt(getYearFormat.format(date));
        for (JournalPaper paper : journalPaperList) {
            Assert.assertTrue(Integer.parseInt(paper.getPublic_year())>=(current_year-3));
        }
    }

    @Test
    void testGetFiveYearsJournalPapers() {
        List<JournalPaper> journalPaperList = dao.query_journal_papers_of_reward_limited_years("11247", "特聘教授");
        Assert.assertEquals("郭忠義", journalPaperList.get(0).getStaff_cname());
        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        int current_year = Integer.parseInt(getYearFormat.format(date));
        for (JournalPaper paper : journalPaperList) {
            Assert.assertTrue(Integer.parseInt(paper.getPublic_year())>=(current_year-5));
        }
    }

    @Test
    void testGetNoJournalPaper() {
        Assert.assertEquals(0, dao.query_journal_papers_of_reward_limited_years("11247", "XXXX").size());
    }
}
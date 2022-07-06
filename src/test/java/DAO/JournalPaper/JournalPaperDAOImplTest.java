package DAO.JournalPaper;

import Bean.JournalPaper.JournalPaper;
import Dao.JournalPaper.JournalPaperDAO;
import Dao.JournalPaper.JournalPaperDAOImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class JournalPaperDAOImplTest {

    private JournalPaperDAO dao;

    @BeforeEach
    void setUp() {
        dao = new JournalPaperDAOImpl();
    }

    @Test
    void testQueryRchJournalsWithEmptyCode() {
        Assert.assertNull(dao.query_journal_papers(""));
    }

    @Test
    void testQueryRchJournalsWithNotExistCode() {
        Assert.assertNull(dao.query_journal_papers("xxxx"));
    }

    @Test
    void testQueryRchJournalsWithNormalCode() {
        List<JournalPaper> journalPaperList = dao.query_journal_papers("11247");
        Assert.assertEquals("郭忠義", journalPaperList.get(0).getStaff_cname());
        Assert.assertEquals("Evolutionary Agents for Intelligent Transport Systems", journalPaperList.get(0).getThesis_name());
        Assert.assertEquals("International Journal of Fuzzy Systems", journalPaperList.get(0).getJournal_name());
        Assert.assertEquals("7", journalPaperList.get(0).getVolume());
        Assert.assertEquals("85-93", journalPaperList.get(0).getPages());
        Assert.assertEquals("2005", journalPaperList.get(0).getPublic_year());
        Assert.assertEquals("1", journalPaperList.get(0).getW2_corresponding());
    }
}
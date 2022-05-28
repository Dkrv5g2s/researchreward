package DAO.RchJournal;

import Bean.RchJournal.RchJournal;
import Dao.RchJournal.RchJournalDAO;
import Dao.RchJournal.RchJournalDAOImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RchJournalDAOImplTest {

    private RchJournalDAO dao;

    @BeforeEach
    void setUp() {
        dao = new RchJournalDAOImpl();
    }

    @Test
    void testQueryRchJournalsWithEmptyCode() {
        Assert.assertNull(dao.query_rch_journals(""));
    }

    @Test
    void testQueryRchJournalsWithNotExistCode() {
        Assert.assertNull(dao.query_rch_journals("xxxx"));
    }

    @Test
    void testQueryRchJournalsWithNormalCode() {
        List<RchJournal> rchJournalList = dao.query_rch_journals("11247");
        Assert.assertEquals("郭忠義", rchJournalList.get(0).getStaff_cname());
        Assert.assertEquals("Evolutionary Agents for Intelligent Transport Systems", rchJournalList.get(0).getThesis_name());
        Assert.assertEquals("International Journal of Fuzzy Systems", rchJournalList.get(0).getJournal_name());
        Assert.assertEquals("7", rchJournalList.get(0).getVolume());
        Assert.assertEquals("85-93", rchJournalList.get(0).getPages());
        Assert.assertEquals("2005", rchJournalList.get(0).getPublic_year());
        Assert.assertEquals("1", rchJournalList.get(0).getW2_corresponding());
    }
}
package DBSynchronize;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class JournalPaperSynchronizeTest {

    @Test
    public void testSynchronizeJuornalPaper() throws SQLException {
        JournalPaperSynchronize journalPaperSynchronize = new JournalPaperSynchronize();
        Assert.assertEquals("Update with 19115 journal papers, total staff with no journal is 0", journalPaperSynchronize.synchronize_all_journal_papers_from_TEDB());
    }
}

package Dao.JournalPaper;

import Bean.JournalPaper.JournalPaper;

import java.util.List;

public interface JournalPaperDAO {
    public List<JournalPaper> query_journal_papers(String staff_code);
}
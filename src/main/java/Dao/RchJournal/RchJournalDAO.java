package Dao.RchJournal;

import Bean.RchJournal.RchJournal;

import java.util.List;

public interface RchJournalDAO {
    public List<RchJournal> query_rch_journals(String staff_code);
}
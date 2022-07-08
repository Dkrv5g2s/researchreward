package Bean.JournalPaper;

public class JournalPaper {
    private String staff_cname;
    private String thesis_name;
    private String journal_name;
    private String volume;
    private String pages;
    private String public_year;
    private int w2_author_order;
    private String w3_corresponding;

    public JournalPaper(String staff_cname, String thesis_name, String journal_name, String volume, String pages, String public_year, int W2_author_order, String W3_corresponding) {
        this.staff_cname = staff_cname;
        this.thesis_name = thesis_name;
        this.journal_name = journal_name;
        this.volume = volume;
        this.pages = pages;
        this.public_year = public_year;
        this.w2_author_order = W2_author_order;
        this.w3_corresponding = W3_corresponding;
    }

    public String getStaff_cname() {
        return staff_cname;
    }

    public String getThesis_name() {
        return thesis_name;
    }

    public String getJournal_name() {
        return journal_name;
    }

    public String getVolume() {
        return volume;
    }

    public String getPages() {
        return pages;
    }

    public String getPublic_year() {
        return public_year;
    }

    public int getW2_author_order() {
        return w2_author_order;
    }

    public String getW3_corresponding() {
        return w3_corresponding;
    }
}

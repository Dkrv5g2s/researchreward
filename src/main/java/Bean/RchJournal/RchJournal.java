package Bean.RchJournal;

public class RchJournal {
    private String staff_cname;
    private String thesis_name;
    private String journal_name;
    private String volume;
    private String pages;
    private String public_year;
    private String W2_corresponding;

    public RchJournal(String staff_cname, String thesis_name, String journal_name, String volume, String pages, String public_year, String W2_corresponding) {
        this.staff_cname = staff_cname;
        this.thesis_name = thesis_name;
        this.journal_name = journal_name;
        this.volume = volume;
        this.pages = pages;
        this.public_year = public_year;
        this.W2_corresponding = W2_corresponding;
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

    public String getW2_corresponding() {
        return W2_corresponding;
    }
}

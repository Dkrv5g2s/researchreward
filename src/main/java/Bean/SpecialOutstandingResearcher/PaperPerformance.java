package Bean.SpecialOutstandingResearcher;

public class PaperPerformance {
    private String author_name;
    private String book_name ;
    private String scholarly_journals_name ;
    private String total_roll ;
    private String total_page ;
    private String publish_time ;
    private String rank_of_scholarly_journals ;
    private String author_order ;
    private String communication_author_count ;
    private String additional_weight ;
    private String cal_point ;

    public PaperPerformance(String author_name, String book_name, String scholarly_journals_name, String total_roll, String total_page, String publish_time, String rank_of_scholarly_journals, String author_order, String communication_author_count, String additional_weight, String cal_point) {
        this.author_name = author_name;
        this.book_name = book_name;
        this.scholarly_journals_name = scholarly_journals_name;
        this.total_roll = total_roll;
        this.total_page = total_page;
        this.publish_time = publish_time;
        this.rank_of_scholarly_journals = rank_of_scholarly_journals;
        this.author_order = author_order;
        this.communication_author_count = communication_author_count;
        this.additional_weight = additional_weight;
        this.cal_point = cal_point;
    }

    public PaperPerformance() {
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getScholarly_journals_name() {
        return scholarly_journals_name;
    }

    public void setScholarly_journals_name(String scholarly_journals_name) {
        this.scholarly_journals_name = scholarly_journals_name;
    }

    public String getTotal_roll() {
        return total_roll;
    }

    public void setTotal_roll(String total_roll) {
        this.total_roll = total_roll;
    }

    public String getTotal_page() {
        return total_page;
    }

    public void setTotal_page(String total_page) {
        this.total_page = total_page;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getRank_of_scholarly_journals() {
        return rank_of_scholarly_journals;
    }

    public void setRank_of_scholarly_journals(String rank_of_scholarly_journals) {
        this.rank_of_scholarly_journals = rank_of_scholarly_journals;
    }

    public String getAuthor_order() {
        return author_order;
    }

    public void setAuthor_order(String author_order) {
        this.author_order = author_order;
    }

    public String getCommunication_author_count() {
        return communication_author_count;
    }

    public void setCommunication_author_count(String communication_author_count) {
        this.communication_author_count = communication_author_count;
    }

    public String getAdditional_weight() {
        return additional_weight;
    }

    public void setAdditional_weight(String additional_weight) {
        this.additional_weight = additional_weight;
    }

    public String getCal_point() {
        return cal_point;
    }

    public void setCal_point(String cal_point) {
        this.cal_point = cal_point;
    }
}

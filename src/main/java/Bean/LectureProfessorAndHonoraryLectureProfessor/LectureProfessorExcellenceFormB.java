package Bean.LectureProfessorAndHonoraryLectureProfessor;

import java.util.ArrayList;
import java.util.List;

public class LectureProfessorExcellenceFormB {
    private String userNumber;
    private String author;
    private String book_name;
    private String article_name;
    private String total_roll;
    private String total_page;
    private String publish_time;
    private boolean rank_condition_one;
    private boolean rank_condition_two;
    private boolean rank_condition_three;
    private boolean rank_condition_four;
    private boolean rank_condition_five;
    private boolean rank_condition_six;
    private boolean rank_condition_seven;
    private boolean author_order_one;
    private boolean author_order_two;
    private boolean author_order_three;
    private boolean author_order_four;
    private boolean author_order_five;
    private boolean author_order_six;
    private boolean communication_author_count_one;
    private boolean communication_author_count_two;
    private boolean additional_weight_one;
    private boolean additional_weight_two;
    private boolean additional_weight_three;
    private boolean additional_weight_four;
    private boolean additional_weight_five;
    private boolean additional_weight_six;
    private boolean additional_weight_seven;
    private String total;
    private List<LectureProfessorExcellenceFormB> lectureProfessorExcellenceFormBList = new ArrayList<>();

    public LectureProfessorExcellenceFormB(String userNumber
            , String author
            , String book_name
            , String article_name
            , String total_roll
            , String total_page
            , String publish_time
            , boolean rank_condition_one
            , boolean rank_condition_two
            , boolean rank_condition_three
            , boolean rank_condition_four
            , boolean rank_condition_five
            , boolean rank_condition_six
            , boolean rank_condition_seven
            , boolean author_order_one
            , boolean author_order_two
            , boolean author_order_three
            , boolean author_order_four
            , boolean author_order_five
            , boolean author_order_six
            , boolean communication_author_count_one
            , boolean communication_author_count_two
            , boolean additional_weight_one
            , boolean additional_weight_two
            , boolean additional_weight_three
            , boolean additional_weight_four
            , boolean additional_weight_five
            , boolean additional_weight_six
            , boolean additional_weight_seven
            , String total) {
        this.userNumber = userNumber;
        this.author = author;
        this.book_name = book_name;
        this.article_name = article_name;
        this.total_roll = total_roll;
        this.total_page = total_page;
        this.publish_time = publish_time;
        this.rank_condition_one = rank_condition_one;
        this.rank_condition_two = rank_condition_two;
        this.rank_condition_three = rank_condition_three;
        this.rank_condition_four = rank_condition_four;
        this.rank_condition_five = rank_condition_five;
        this.rank_condition_six = rank_condition_six;
        this.rank_condition_seven = rank_condition_seven;
        this.author_order_one = author_order_one;
        this.author_order_two = author_order_two;
        this.author_order_three = author_order_three;
        this.author_order_four = author_order_four;
        this.author_order_five = author_order_five;
        this.author_order_six = author_order_six;
        this.communication_author_count_one = communication_author_count_one;
        this.communication_author_count_two = communication_author_count_two;
        this.additional_weight_one = additional_weight_one;
        this.additional_weight_two = additional_weight_two;
        this.additional_weight_three = additional_weight_three;
        this.additional_weight_four = additional_weight_four;
        this.additional_weight_five = additional_weight_five;
        this.additional_weight_six = additional_weight_six;
        this.additional_weight_seven = additional_weight_seven;
        this.total = total;
    }

    public LectureProfessorExcellenceFormB() {}

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
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

    public boolean isRank_condition_one() {
        return rank_condition_one;
    }

    public void setRank_condition_one(boolean rank_condition_one) {
        this.rank_condition_one = rank_condition_one;
    }

    public boolean isRank_condition_two() {
        return rank_condition_two;
    }

    public void setRank_condition_two(boolean rank_condition_two) {
        this.rank_condition_two = rank_condition_two;
    }

    public boolean isRank_condition_three() {
        return rank_condition_three;
    }

    public void setRank_condition_three(boolean rank_condition_three) {
        this.rank_condition_three = rank_condition_three;
    }

    public boolean isRank_condition_four() {
        return rank_condition_four;
    }

    public void setRank_condition_four(boolean rank_condition_four) {
        this.rank_condition_four = rank_condition_four;
    }

    public boolean isRank_condition_five() {
        return rank_condition_five;
    }

    public void setRank_condition_five(boolean rank_condition_five) {
        this.rank_condition_five = rank_condition_five;
    }

    public boolean isRank_condition_six() {
        return rank_condition_six;
    }

    public void setRank_condition_six(boolean rank_condition_six) {
        this.rank_condition_six = rank_condition_six;
    }

    public boolean isRank_condition_seven() {
        return rank_condition_seven;
    }

    public void setRank_condition_seven(boolean rank_condition_seven) {
        this.rank_condition_seven = rank_condition_seven;
    }

    public boolean isAuthor_order_one() {
        return author_order_one;
    }

    public void setAuthor_order_one(boolean author_order_one) {
        this.author_order_one = author_order_one;
    }

    public boolean isAuthor_order_two() {
        return author_order_two;
    }

    public void setAuthor_order_two(boolean author_order_two) {
        this.author_order_two = author_order_two;
    }

    public boolean isAuthor_order_three() {
        return author_order_three;
    }

    public void setAuthor_order_three(boolean author_order_three) {
        this.author_order_three = author_order_three;
    }

    public boolean isAuthor_order_four() {
        return author_order_four;
    }

    public void setAuthor_order_four(boolean author_order_four) {
        this.author_order_four = author_order_four;
    }

    public boolean isAuthor_order_five() {
        return author_order_five;
    }

    public void setAuthor_order_five(boolean author_order_five) {
        this.author_order_five = author_order_five;
    }

    public boolean isAuthor_order_six() {
        return author_order_six;
    }

    public void setAuthor_order_six(boolean author_order_six) {
        this.author_order_six = author_order_six;
    }

    public boolean isCommunication_author_count_one() {
        return communication_author_count_one;
    }

    public void setCommunication_author_count_one(boolean communication_author_count_one) {
        this.communication_author_count_one = communication_author_count_one;
    }

    public boolean isCommunication_author_count_two() {
        return communication_author_count_two;
    }

    public void setCommunication_author_count_two(boolean communication_author_count_two) {
        this.communication_author_count_two = communication_author_count_two;
    }

    public boolean isAdditional_weight_one() {
        return additional_weight_one;
    }

    public void setAdditional_weight_one(boolean additional_weight_one) {
        this.additional_weight_one = additional_weight_one;
    }

    public boolean isAdditional_weight_two() {
        return additional_weight_two;
    }

    public void setAdditional_weight_two(boolean additional_weight_two) {
        this.additional_weight_two = additional_weight_two;
    }

    public boolean isAdditional_weight_three() {
        return additional_weight_three;
    }

    public void setAdditional_weight_three(boolean additional_weight_three) {
        this.additional_weight_three = additional_weight_three;
    }

    public boolean isAdditional_weight_four() {
        return additional_weight_four;
    }

    public void setAdditional_weight_four(boolean additional_weight_four) {
        this.additional_weight_four = additional_weight_four;
    }

    public boolean isAdditional_weight_five() {
        return additional_weight_five;
    }

    public void setAdditional_weight_five(boolean additional_weight_five) {
        this.additional_weight_five = additional_weight_five;
    }

    public boolean isAdditional_weight_six() {
        return additional_weight_six;
    }

    public void setAdditional_weight_six(boolean additional_weight_six) {
        this.additional_weight_six = additional_weight_six;
    }

    public boolean isAdditional_weight_seven() {
        return additional_weight_seven;
    }

    public void setAdditional_weight_seven(boolean additional_weight_seven) {
        this.additional_weight_seven = additional_weight_seven;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<LectureProfessorExcellenceFormB> getLectureProfessorExcellenceFormBList() {
        return lectureProfessorExcellenceFormBList;
    }

    public void setLectureProfessorExcellenceFormBList(List<LectureProfessorExcellenceFormB> lectureProfessorExcellenceFormBList) {
        this.lectureProfessorExcellenceFormBList = lectureProfessorExcellenceFormBList;
    }
}



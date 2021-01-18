package Bean.SpecialOutstandingResearcher;

import java.util.Date;
import java.util.List;

public class ReviewSupportingInformationForm {
    private int project_id ;
    private List<ReviewSupportingInformation> review_supporting_information_list ;


    public ReviewSupportingInformationForm(int project_id, List<ReviewSupportingInformation> review_supporting_information_list) {
        this.project_id = project_id;
        this.review_supporting_information_list = review_supporting_information_list;
    }

    public ReviewSupportingInformationForm() {
    }

    public ReviewSupportingInformationForm(int project_id) {
        this.project_id = project_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public List<ReviewSupportingInformation> getReview_supporting_information_list() {
        return review_supporting_information_list;
    }

    public void setReview_supporting_information_list(List<ReviewSupportingInformation> review_supporting_information_list) {
        this.review_supporting_information_list = review_supporting_information_list;
    }
}

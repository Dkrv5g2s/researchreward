package Bean.Project;

public class RewardProject {
    private int project_id;
    private String staff_code ;
    private String status ;
    private String reward_type ;

    public RewardProject(int project_id, String staff_code, String status, String reward_type) {
        this.project_id = project_id;
        this.staff_code = staff_code;
        this.status = status;
        this.reward_type = reward_type;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReward_type() {
        return reward_type;
    }

    public void setReward_type(String reward_type) {
        this.reward_type = reward_type;
    }
}

package Bean.SpecialOutstandingResearcher;

public class SpecialOutstandingResearcherStandard {
    private String level_num ;
    private String standard;
    private String sub_standard;

    public SpecialOutstandingResearcherStandard(String level_num, String standard, String sub_standard) {
        this.level_num = level_num;
        this.standard = standard;
        this.sub_standard = sub_standard;
    }

    public String getLevel_num() {
        return level_num;
    }

    public void setLevel_num(String level_num) {
        this.level_num = level_num;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSub_standard() {
        return sub_standard;
    }

    public void setSub_standard(String sub_standard) {
        this.sub_standard = sub_standard;
    }
}

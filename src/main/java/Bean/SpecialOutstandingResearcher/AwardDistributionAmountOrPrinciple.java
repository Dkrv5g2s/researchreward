package Bean.SpecialOutstandingResearcher;

public class AwardDistributionAmountOrPrinciple {

    private String applicant_type ;
    private String name ;
    private String college_and_department ;
    private String job ;
    private String year ;
    private String month ;
    private String principle ;

    public AwardDistributionAmountOrPrinciple() {
    }

    public AwardDistributionAmountOrPrinciple(String applicant_type, String name, String college_and_department, String job, String year, String month, String principle) {
        this.applicant_type = applicant_type;
        this.name = name;
        this.college_and_department = college_and_department;
        this.job = job;
        this.year = year;
        this.month = month;
        this.principle = principle;
    }

    public String getApplicant_type() {
        return applicant_type;
    }

    public void setApplicant_type(String applicant_type) {
        this.applicant_type = applicant_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege_and_department() {
        return college_and_department;
    }

    public void setCollege_and_department(String college_and_department) {
        this.college_and_department = college_and_department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }
}

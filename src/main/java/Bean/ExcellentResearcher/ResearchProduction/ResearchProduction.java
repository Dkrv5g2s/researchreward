package Bean.ExcellentResearcher.ResearchProduction;

import java.util.ArrayList;
import java.util.List;

public class ResearchProduction {

    private List<Patent> patentList = new ArrayList<>();
    private List<Technology> technologyList = new ArrayList<>();;
    private List<WorkAuthorization> workAuthorizationList= new ArrayList<>();
    private String userNumber;


    public ResearchProduction(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<Patent> getPatentList() {
        return patentList;
    }

    public void setPatentList(List<Patent> patentList) {
        this.patentList = patentList;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }

    public List<WorkAuthorization> getWorkAuthorizationList() {
        return workAuthorizationList;
    }

    public void setWorkAuthorizationList(List<WorkAuthorization> workAuthorizationList) {
        this.workAuthorizationList = workAuthorizationList;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public void addWorkAuthorization(WorkAuthorization workAuthorization){
        workAuthorizationList.add(workAuthorization);
    }

    public void addTechnology(Technology technology){
        technologyList.add(technology);
    }

    public void addPatent(Patent patent){
        patentList.add(patent);
    }


}

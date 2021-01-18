package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.CatalogOfWork;
import Bean.ExcellentResearcher.PersonalInformation.*;
import Bean.ExcellentResearcher.RecruitDescription;
import Bean.ExcellentResearcher.ResearchProduction.Patent;
import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import Bean.ExcellentResearcher.ResearchProduction.Technology;
import Bean.ExcellentResearcher.ResearchProduction.WorkAuthorization;
import Dao.ExcellentResearcher.*;
import Dao.ExcellentResearcher.Impl.*;
import Utils.RewardFormDocument;

import java.io.IOException;

public class PDFGenerator {

    private CatalogOfWorkDAO catalogOfWorkDAO = new CatalogOfWorkDAOImpl();
    private PersonalInformationDAO personalInformationDAO = new PersonalInformationDAOImpl();
    private SeniorityDAO seniorityDAO = new SeniorityDAOImpl();
    private MOSTPlanDAO mostPlanDAO = new MOSTPlanDAOImpl();
    private EducationDAO educationDAO = new EducationDAOImpl();
    private ExperimentDAO experimentDAO = new ExperimentDAOImpl();
    private RecruitDescriptionDAO recruitDescriptionDAO = new RecruitDescriptionDAOImpl();
    private ResearchProductionDAO researchProductionDAO = new ResearchProductionDAOImpl();


    public void generateExcellentResearcherPDF(String docxPath, String fileName, String userNumber) throws IOException {
        CatalogOfWork catalogOfWork = catalogOfWorkDAO.get(userNumber);
        PersonalInformation personalInformation = personalInformationDAO.get(userNumber);
        Seniority seniority = seniorityDAO.get(userNumber);
        MOSTPlan mostPlan = mostPlanDAO.get(userNumber);
        Education education = educationDAO.get(userNumber);
        Experiment experiment = experimentDAO.get(userNumber);
        RecruitDescription recruitDescription = recruitDescriptionDAO.get(userNumber);
        ResearchProduction researchProduction = researchProductionDAO.get(userNumber);

        RewardFormDocument document = new RewardFormDocument(docxPath + fileName);

        document.setContentInTableCell(0,1,1,personalInformation.getCollege()+"學院"+personalInformation.getDepartment()+"系(所)");
        document.setContentInTableCell(0,1,3,personalInformation.getHiredYear()+"年"+personalInformation.getHiredMonth()+"月");
        document.setContentInTableCell(0,2,3,seniority.getYear()+"年"+seniority.getMonth()+"個月");
        document.setContentInTableCell(0,3,1,personalInformation.getcName());
        document.setContentInTableCell(0,3,3,personalInformation.geteName());
        document.setContentInTableCell(0,4,1,personalInformation.getTitle());
        document.setContentInTableCell(0,4,3,personalInformation.getCountry());
        document.setContentInTableCell(0,4,5,personalInformation.getGender());
        document.setContentInTableCell(0,6,1,education.getSchoolName());
        document.setContentInTableCell(0,6,2,education.getMajor());
        document.setContentInTableCell(0,6,3,education.getDegree());
        document.setContentInTableCell(0,6,4,education.getGraduateYear()+"年"+education.getGraduateMonth()+"月");
        document.setContentInTableCell(0,8,1, experiment.getServiceOrganization());
        document.setContentInTableCell(0,8,2,experiment.getServiceDepartment());
        document.setContentInTableCell(0,8,3,experiment.getPastTitle());
        document.setContentInTableCell(0,8,4, experiment.getPastYear()+"/"+experiment.getPastMonth());
        document.setContentInTableCell(0,12,1,"計畫名稱:"+mostPlan.getPlanName());
        document.setContentInTableCell(0,13,1,"計畫編號:"+mostPlan.getPlanNumber());
        document.setContentInTableCell(0,13,2,mostPlan.getStartTime()+"至"+mostPlan.getLastTime());


        document.removeParagraph(0,14,1,2);
        document.removeParagraph(0,14,1,1);
        document.appendContentInTableCell(0,14,1,(personalInformation.getQualification1() ? "■" : "□") + "非曾任或非現任國內學術研究機構編制內之專任教學、研究人員。");
        document.appendContentInTableCell(0,14,1,(personalInformation.getQualification2() ? "■" : "□") + "於正式納編前五年間均任職於國外學術研究機構。");


        document.removeParagraph(0,15,1,2);
        document.removeParagraph(0,15,1,1);
        document.removeParagraph(0,15,1,0);

        switch(personalInformation.getLevel()){
            case "prof":
                document.appendContentInTableCell(0,15,1,"■" + "教    授 級：每月獎勵額度新台幣"+personalInformation.getPrice()+"萬元。");
                document.appendContentInTableCell(0,15,1,"□" + "副 教 授 級：每月獎勵額度新台幣     萬元。");
                document.appendContentInTableCell(0,15,1,"□" + "助理教授 級：每月獎勵額度新台幣     萬元。");
                break;
            case "ap":
                document.appendContentInTableCell(0,15,1,"□" + "教    授 級：每月獎勵額度新台幣     萬元。");
                document.appendContentInTableCell(0,15,1,"■" + "副 教 授 級：每月獎勵額度新台幣"+personalInformation.getPrice()+"萬元。");
                document.appendContentInTableCell(0,15,1,"□" + "助理教授 級：每月獎勵額度新台幣     萬元。");
                break;
            case "asst":
                document.appendContentInTableCell(0,15,1,"□" + "教    授 級：每月獎勵額度新台幣     萬元。");
                document.appendContentInTableCell(0,15,1,"□" + "副 教 授 級：每月獎勵額度新台幣     萬元。");
                document.appendContentInTableCell(0,15,1,"■" + "助理教授 級：每月獎勵額度新台幣"+personalInformation.getPrice()+"萬元。");
                break;
            default:
                throw new RuntimeException("申請獎勵等級錯誤");
        }

        document.appendContentInTableCell(1,0,0,"(一)"+recruitDescription.getRecruitReason());
        document.appendContentInTableCell(1,0,0,"(二)"+recruitDescription.getRecruitContent());
        document.appendContentInTableCell(1,0,0,"(三)"+recruitDescription.getExpect());
        document.appendContentInTableCell(1,0,0,"(四)"+recruitDescription.getAnalysis());

        document.appendContentInTableCell(2,0,0,"(一)"+recruitDescription.getResearchProduction());
        document.appendContentInTableCell(2,0,0,"(二)"+recruitDescription.getAward());
        document.appendContentInTableCell(2,0,0,"(三)"+recruitDescription.getOther());
        document.appendContentInTableCell(2,0,0,"(四)"+recruitDescription.getContribution());

        document.appendContentInTableCell(3,0,0,catalogOfWork.getWork());

        for(Patent patent: researchProduction.getPatentList()){
            document.addRow(4,1);
            document.setContentInTableCell(4,1,0,patent.getPatentClass());
            document.setContentInTableCell(4,1,1,patent.getPatentName());
            document.setContentInTableCell(4,1,2,patent.getCountry());
            document.setContentInTableCell(4,1,3,patent.getPatentNumber());
            document.setContentInTableCell(4,1,4,patent.getInventor());
            document.setContentInTableCell(4,1,5,patent.getPatentee());
            document.setContentInTableCell(4,1,6,patent.getApprovalDate().toString());
            document.setContentInTableCell(4,1,7,patent.getMstPlanNumber());
        }

        for(Technology technology: researchProduction.getTechnologyList()){
            document.addRow(5,1);
            document.setContentInTableCell(5,1,0,technology.getTechnologyName());
            document.setContentInTableCell(5,1,1,technology.getPatentName());
            document.setContentInTableCell(5,1,2,technology.getAuthorizedUnit());
            document.setContentInTableCell(5,1,3,technology.getToAuthorizedUnit());
            document.setContentInTableCell(5,1,4,technology.getContractDate().toString());
            document.setContentInTableCell(5,1,5,technology.getMstPlanNumber());

        }

        for(WorkAuthorization workAuthorization: researchProduction.getWorkAuthorizationList()){

            document.addRow(6,1);
            document.setContentInTableCell(6,1,0,workAuthorization.getWorkName());
            document.setContentInTableCell(6,1,1,workAuthorization.getAuthorizationClass());
            document.setContentInTableCell(6,1,2,workAuthorization.getAuthor());
            document.setContentInTableCell(6,1,3,workAuthorization.getCopyrightOwner());
            document.setContentInTableCell(6,1,4,workAuthorization.getAgent());
            document.setContentInTableCell(6,1,5,workAuthorization.getMstPlanNumber());

        }

        document.saveFile(docxPath+userNumber+"_"+fileName);
        document.close();
    }
}

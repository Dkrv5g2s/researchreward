package Service.TeacherHireResearcher;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.*;
import Dao.Admin.AwardYearDAO;
import Dao.Admin.Impl.AwardYearDAOImpl;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.*;
import Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA.*;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class TeacherHireResearcherTableAService {
    private ArticleAADAO articleAADAO = new ArticleAADAOImpl();
    private ArticleABDAO articleABDAO = new ArticleABDAOImpl();
    private ArticleSWDAO articleSWDAO = new ArticleSWDAOImpl();
    private ArticleTTDAO articleTTDAO = new ArticleTTDAOImpl();
    private OtherDataDAO otherDataDAO = new OtherDataDAOImpl();
    private TechProjectDAO techProjectDAO = new TechProjectDAOImpl();
    private AwardYearDAO awardYearDAO = new AwardYearDAOImpl();

    public void save(JSONObject jsonObject, String projectID){
        ArticleAA aaa = new ArticleAA(
                jsonObject.getString("a_article_count1"),
                jsonObject.getString("a_article_count2"),
                jsonObject.getString("a_article_count3"),
                jsonObject.getString("a_article_count4"),
                jsonObject.getString("a_article_count5"),
                jsonObject.getString("a_article_count_total"),
                jsonObject.getString("a_article_point1"),
                jsonObject.getString("a_article_point2"),
                jsonObject.getString("a_article_point3"),
                jsonObject.getString("a_article_point4"),
                jsonObject.getString("a_article_point5"),
                jsonObject.getString("a_article_point_total"));

        ArticleAB aab = new ArticleAB(
                jsonObject.getString("a_book_count1"),
                jsonObject.getString("a_book_count2"),
                jsonObject.getString("a_book_count3"),
                jsonObject.getString("a_book_count4"),
                jsonObject.getString("a_book_count5"),
                jsonObject.getString("a_book_count_total"),
                jsonObject.getString("a_book_point1"),
                jsonObject.getString("a_book_point2"),
                jsonObject.getString("a_book_point3"),
                jsonObject.getString("a_book_point4"),
                jsonObject.getString("a_book_point5"),
                jsonObject.getString("a_book_point_total"));

        ArticleSW asw = new ArticleSW(
                jsonObject.getString("sw_article_count1"),
                jsonObject.getString("sw_article_count2"),
                jsonObject.getString("sw_article_count3"),
                jsonObject.getString("sw_article_count4"),
                jsonObject.getString("sw_article_count5"),
                jsonObject.getString("sw_article_count_total"),
                jsonObject.getString("sw_point1"),
                jsonObject.getString("sw_point2"),
                jsonObject.getString("sw_point3"),
                jsonObject.getString("sw_point4"),
                jsonObject.getString("sw_point5"),
                jsonObject.getString("sw_point_total"),
                jsonObject.getString("fwci_value"),
                jsonObject.getString("h5_index"),
                jsonObject.getString("a_plus_b_total_point"));

        ArticleTT att = new ArticleTT(
                jsonObject.getString("t_article_count1"),
                jsonObject.getString("t_article_count2"),
                jsonObject.getString("t_article_count3"),
                jsonObject.getString("t_article_count4"),
                jsonObject.getString("t_article_count5"),
                jsonObject.getString("t_article_count_total"),
                jsonObject.getString("t_point1"),
                jsonObject.getString("t_point2"),
                jsonObject.getString("t_point3"),
                jsonObject.getString("t_point4"),
                jsonObject.getString("t_point5"),
                jsonObject.getString("t_point_total"));

        OtherData od = new OtherData(
                projectID,
                "",
                jsonObject.getString("commit_date"));

        TechProject tp = new TechProject(
                jsonObject.getString("tech_project_count1"),
                jsonObject.getString("tech_project_count2"),
                jsonObject.getString("tech_project_count3"),
                jsonObject.getString("tech_project_count4"),
                jsonObject.getString("tech_project_count5"),
                jsonObject.getString("tech_project_count_total"),
                jsonObject.getString("tech_project_money1"),
                jsonObject.getString("tech_project_money2"),
                jsonObject.getString("tech_project_money3"),
                jsonObject.getString("tech_project_money4"),
                jsonObject.getString("tech_project_money5"),
                jsonObject.getString("tech_project_money_total"),
                jsonObject.getString("tech_project_point1"),
                jsonObject.getString("tech_project_point2"),
                jsonObject.getString("tech_project_point3"),
                jsonObject.getString("tech_project_point4"),
                jsonObject.getString("tech_project_point5"),
                jsonObject.getString("tech_project_point_total"));

        articleAADAO.save(aaa, projectID);
        articleABDAO.save(aab, projectID);
        articleSWDAO.save(asw, projectID);
        articleTTDAO.save(att, projectID);
        otherDataDAO.save(od, projectID);
        techProjectDAO.save(tp, projectID);
    }

    public JSONObject get(String projectID) {
        ArticleAA aaa = articleAADAO.show(projectID);
        ArticleAB aab = articleABDAO.show(projectID);
        ArticleSW asw = articleSWDAO.show(projectID);
        ArticleTT att = articleTTDAO.show(projectID);
        OtherData od = otherDataDAO.show(projectID);
        TechProject tp = techProjectDAO.show(projectID);
        JSONObject awardYear = awardYearDAO.getSpecificAwardYears("TeacherHireResearcher");

        if(od == null) {
            aaa = new ArticleAA("0","0","0","0","0","0","0","0","0","0","0","0");
            aab = new ArticleAB("0","0","0","0","0","0","0","0","0","0","0","0");
            asw = new ArticleSW("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
            att = new ArticleTT("0","0","0","0","0","0","0","0","0","0","0","0");
            od = new OtherData(projectID,"","");
            tp = new TechProject("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,aaa);
            addBeanPropertyToJson(object,aab);
            addBeanPropertyToJson(object,asw);
            addBeanPropertyToJson(object,att);
            addBeanPropertyToJson(object,od);
            addBeanPropertyToJson(object,tp);
            object.putAll(awardYear);
        }catch(IllegalAccessException e){

        }
        return object;
    }
}

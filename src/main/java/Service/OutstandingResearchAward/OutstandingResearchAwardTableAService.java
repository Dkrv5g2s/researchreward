package Service.OutstandingResearchAward;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.*;
import Dao.DistinguishedProfessor.Impl.DistinguishedProfessorTableA.*;
import Dao.DistinguishedProfessor.DistinguishedProfessorTableA.*;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.time.LocalDateTime;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class OutstandingResearchAwardTableAService {
    private ArticleAADAO articleAADAO = new ArticleAADAOImpl();
    private ArticleABDAO articleABDAO = new ArticleABDAOImpl();
    private ArticleSWDAO articleSWDAO = new ArticleSWDAOImpl();
    private ArticleTTDAO articleTTDAO = new ArticleTTDAOImpl();
    private CoopProjectDAO coopProjectDAO = new CoopProjectDAOImpl();
    private OtherDataDAO otherDataDAO = new OtherDataDAOImpl();
    private TechProjectDAO techProjectDAO = new TechProjectDAOImpl();
    private TechTransferDAO techTransferDAO = new TechTransferDAOImpl();

    public void save(JSONObject jsonObject, String projectID){
        ArticleAA aaa = new ArticleAA(
                jsonObject.getString("a_article_count1"),
                jsonObject.getString("a_article_count2"),
                jsonObject.getString("a_article_count3"),
                null,
                null,
                jsonObject.getString("a_article_count_total"),
                jsonObject.getString("a_article_point1"),
                jsonObject.getString("a_article_point2"),
                jsonObject.getString("a_article_point3"),
                null,
                null,
                jsonObject.getString("a_article_point_total")
        );
        ArticleAB aab = new ArticleAB(
                jsonObject.getString("a_book_count1"),
                jsonObject.getString("a_book_count2"),
                jsonObject.getString("a_book_count3"),
                null,
                null,
                jsonObject.getString("a_book_count_total"),
                jsonObject.getString("a_book_point1"),
                jsonObject.getString("a_book_point2"),
                jsonObject.getString("a_book_point3"),
                null,
                null,
                jsonObject.getString("a_book_point_total")
        );
        ArticleSW asw = new ArticleSW(
                jsonObject.getString("sw_article_count1"),
                jsonObject.getString("sw_article_count2"),
                jsonObject.getString("sw_article_count3"),
                null,
                null,
                jsonObject.getString("sw_article_count_total"),
                jsonObject.getString("sw_point1"),
                jsonObject.getString("sw_point2"),
                jsonObject.getString("sw_point3"),
                null,
                null,
                jsonObject.getString("sw_point_total"),
                jsonObject.getString("fwci_value_past_three_year"),
                jsonObject.getString("a_plus_b_total_point")
        );
        ArticleTT att = new ArticleTT(
                jsonObject.getString("t_article_count1"),
                jsonObject.getString("t_article_count2"),
                jsonObject.getString("t_article_count3"),
                null,
                null,
                jsonObject.getString("t_article_count_total"),
                jsonObject.getString("t_point1"),
                jsonObject.getString("t_point2"),
                jsonObject.getString("t_point3"),
                null,
                null,
                jsonObject.getString("t_point_total")
        );
        CoopProject cp = new CoopProject(
                jsonObject.getString("coop_project_count1"),
                jsonObject.getString("coop_project_count2"),
                jsonObject.getString("coop_project_count3"),
                null,
                null,
                jsonObject.getString("coop_project_count_total"),
                jsonObject.getString("coop_project_management1"),
                jsonObject.getString("coop_project_management2"),
                jsonObject.getString("coop_project_management3"),
                null,
                null,
                jsonObject.getString("coop_project_management_total"),
                jsonObject.getString("coop_project_money1"),
                jsonObject.getString("coop_project_money2"),
                jsonObject.getString("coop_project_money3"),
                null,
                null,
                jsonObject.getString("coop_project_money_total"),
                jsonObject.getString("coop_project_point1"),
                jsonObject.getString("coop_project_point2"),
                jsonObject.getString("coop_project_point3"),
                null,
                null,
                jsonObject.getString("coop_project_point_total")
        );
        OtherData od = new OtherData(
                jsonObject.getString("year1"),
                jsonObject.getString("year2"),
                jsonObject.getString("year3"),
                null,
                null,
                projectID,
                jsonObject.getString("other_data"),
//                jsonObject.getBoolean("declaration"),
                jsonObject.getString("commit_date")
        );
        TechProject tp = new TechProject(
                jsonObject.getString("tech_project_count1"),
                jsonObject.getString("tech_project_count2"),
                jsonObject.getString("tech_project_count3"),
                null,
                null,
                jsonObject.getString("tech_project_count_total"),
                jsonObject.getString("tech_project_money1"),
                jsonObject.getString("tech_project_money2"),
                jsonObject.getString("tech_project_money3"),
                null,
                null,
                jsonObject.getString("tech_project_money_total"),
                jsonObject.getString("tech_project_point1"),
                jsonObject.getString("tech_project_point2"),
                jsonObject.getString("tech_project_point3"),
                null,
                null,
                jsonObject.getString("tech_project_point_total")
        );
        TechTransfer tt = new TechTransfer(
                jsonObject.getString("tech_transfer_count1"),
                jsonObject.getString("tech_transfer_count2"),
                jsonObject.getString("tech_transfer_count3"),
                null,
                null,
                jsonObject.getString("tech_transfer_count_total"),
                jsonObject.getString("tech_transfer_management1"),
                jsonObject.getString("tech_transfer_management2"),
                jsonObject.getString("tech_transfer_management3"),
                null,
                null,
                jsonObject.getString("tech_transfer_management_total"),
                jsonObject.getString("tech_transfer_money1"),
                jsonObject.getString("tech_transfer_money2"),
                jsonObject.getString("tech_transfer_money3"),
                null,
                null,
                jsonObject.getString("tech_transfer_money_total"),
                jsonObject.getString("tech_transfer_point1"),
                jsonObject.getString("tech_transfer_point2"),
                jsonObject.getString("tech_transfer_point3"),
                null,
                null,
                jsonObject.getString("tech_transfer_point_total")
        );

        articleAADAO.save(aaa, projectID);
        articleABDAO.save(aab, projectID);
        articleSWDAO.save(asw, projectID);
        articleTTDAO.save(att, projectID);
        coopProjectDAO.save(cp, projectID);
        otherDataDAO.save(od, projectID);
        techProjectDAO.save(tp, projectID);
        techTransferDAO.save(tt, projectID);
    }

    public JSONObject get(String projectID) {
        ArticleAA aaa = articleAADAO.show(projectID);
        ArticleAB aab = articleABDAO.show(projectID);
        ArticleSW asw = articleSWDAO.show(projectID);
        ArticleTT att = articleTTDAO.show(projectID);
        CoopProject cp = coopProjectDAO.show(projectID);
        OtherData od = otherDataDAO.show(projectID);
        TechProject tp = techProjectDAO.show(projectID);
        TechTransfer tt = techTransferDAO.show(projectID);

        LocalDateTime dt = LocalDateTime.now();
        int year = dt.getYear()-1912;

        if(od == null) {
            aaa = new ArticleAA("0","0","0","0","0","0","0","0","0","0","0","0");
            aab = new ArticleAB("0","0","0","0","0","0","0","0","0","0","0","0");
            asw = new ArticleSW("0","0","0","0","0","0","0","0","0","0","0","0","0","0");
            att = new ArticleTT("0","0","0","0","0","0","0","0","0","0","0","0");
            cp = new CoopProject("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
            od = new OtherData(Integer.toString(year-4),Integer.toString(year-3),Integer.toString(year-2),Integer.toString(year-1),Integer.toString(year),projectID,"","");
            tp = new TechProject("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
            tt = new TechTransfer("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        }
        JSONObject object = new JSONObject();
        try {
            addBeanPropertyToJson(object,aaa);
            addBeanPropertyToJson(object,aab);
            addBeanPropertyToJson(object,asw);
            addBeanPropertyToJson(object,att);
            addBeanPropertyToJson(object,cp);
            addBeanPropertyToJson(object,od);
            addBeanPropertyToJson(object,tp);
            addBeanPropertyToJson(object,tt);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }
}
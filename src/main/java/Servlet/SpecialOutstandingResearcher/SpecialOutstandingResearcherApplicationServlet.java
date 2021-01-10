package Servlet.SpecialOutstandingResearcher;


import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SpecialOutstandingResearcherApplicationServlet extends ServletEntryPoint {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            //doPost(req, resp);
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProjectDAO dao = new ProjectDAOImpl() ;
        dao.insertNewProject("108598065", "草稿", "優秀人才申請");
        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/Special_Outstanding_Researcher_Application_Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post recieved!");
        HttpSession session = req.getSession();
        SpecialOutstandingResearcherApplicationService service = new SpecialOutstandingResearcherApplicationService() ;

        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        //service.save(jsonObject, (String)session.getAttribute("userNumber")); /正式
        System.out.println(jsonObject.getString("applicant_name") );
        service.save(jsonObject, "108598065");

//        jsonDataList = "[" + jsonDataList + "]";
//        List<SimultaneousClass> dataList = new Gson().fromJson(jsonDataList, new TypeToken<List<SimultaneousClass>>() {
//        }.getType());

//        super.doPost(req, resp);
    }
}

package Servlet.ExcellentResearcher.First;


import Service.ExcellentResearcher.PersonalInformationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PersonalInformationServlet extends ServletEntryPoint {

    private PersonalInformationService personalInformationService= new PersonalInformationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",personalInformationService.get(Integer.valueOf((String)session.getAttribute("projectId"))));

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/personalinformation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));
        personalInformationService.saveAtFirstTimeApplying(json,Integer.valueOf((String)session.getAttribute("projectId")));

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/RecruitDescription.jsp").forward(req, resp);
    }


}

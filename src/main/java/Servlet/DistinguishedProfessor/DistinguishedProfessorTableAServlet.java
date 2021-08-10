package Servlet.DistinguishedProfessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.Admin.AwardTimeLimitService;
import Service.DistinguishedProfessor.DistinguishedProfessorTableAService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DistinguishedProfessorTableAServlet extends ServletEntryPoint {

	private DistinguishedProfessorTableAService distinguishedProfessorTableAService = new DistinguishedProfessorTableAService();
	private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		getForm(req);

        String userRole = session.getAttribute("userRole").toString();
        req.setAttribute("role", userRole);
		req.setAttribute("readonly",session.getAttribute("readonly"));
		req.setAttribute("fwci", awardTimeLimitService.get().getDouble("fwciOfFiveYear"));
        req.setAttribute("h5Index", awardTimeLimitService.get().getDouble("h5Index"));
		req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorTableA.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
       
        getForm(req);
        
        String jsonString = readJSONString(req);
        
        if(!jsonString.equals("")) {
        	JSONObject json = new JSONObject(jsonString);
        	String projectId = session.getAttribute("projectId").toString();
        	distinguishedProfessorTableAService.save(json, projectId);
        	if(session.getAttribute("userRole").toString().compareTo("teacher") == 0){
                ProjectFillRateService projectFillRateService = new ProjectFillRateService();
                projectFillRateService.save(Integer.valueOf(projectId), "DistinguishedProfessorTableA", json.getDouble("fill_rate"));
            }
        }
        
    }
    
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
    	HttpSession session = req.getSession();
    	
    	req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",distinguishedProfessorTableAService.show((String)session.getAttribute("projectId")));		
		
    }

}
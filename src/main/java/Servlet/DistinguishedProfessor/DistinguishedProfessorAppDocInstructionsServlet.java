package Servlet.DistinguishedProfessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.DistinguishedProfessor.DistinguishedProfessorAppDocInstructionsService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DistinguishedProfessorAppDocInstructionsServlet extends ServletEntryPoint {

	DistinguishedProfessorAppDocInstructionsService distinguishedProfessorAppDocInstructionsService = new DistinguishedProfessorAppDocInstructionsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	
    	getForm(req);

        String userRole = session.getAttribute("userRole").toString();
        req.setAttribute("role", userRole);
    	req.setAttribute("readonly",session.getAttribute("readonly"));
        req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorAppDocInstructions.jsp").forward(req, resp);
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        getForm(req);
        
        String jsonString = readJSONString(req);
        
        if(!jsonString.equals("")) {
        	JSONArray json = new JSONArray(jsonString);
        	distinguishedProfessorAppDocInstructionsService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));

        }
        
    }
    
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
    	HttpSession session = req.getSession();
    	
    	req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",distinguishedProfessorAppDocInstructionsService.show((String)session.getAttribute("projectId")));		
		
    }
}
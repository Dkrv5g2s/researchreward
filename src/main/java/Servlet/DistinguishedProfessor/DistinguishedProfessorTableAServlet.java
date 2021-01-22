package Servlet.DistinguishedProfessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.DistinguishedProfessor.DistinguishedProfessorTableAService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DistinguishedProfessorTableAServlet extends ServletEntryPoint {

	private DistinguishedProfessorTableAService distinguishedProfessorTableAService = new DistinguishedProfessorTableAService();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getForm(req);
		
		req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorTableA.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if((String)session.getAttribute("userNumber") != "") {
        	getForm(req);
        }
        
        String jsonString = readJSONString(req);
        
        if(!jsonString.equals("")) {
        	JSONObject json = new JSONObject(jsonString);
        	distinguishedProfessorTableAService.save(json,(String)session.getAttribute("projectId"));

            req.getRequestDispatcher("/distinguishedProfessorTableB").forward(req, resp);
        }
        else {
        	req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorTableA.jsp").forward(req, resp);
        }
        
    }
    
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
    	HttpSession session = req.getSession();
    	
    	req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",distinguishedProfessorTableAService.show((String)session.getAttribute("projectId")));		
		
    }

}
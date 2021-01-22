package Servlet.DistinguishedProfessor;

import Service.DistinguishedProfessor.DistinguishedProfessorFormService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DistinguishedProfessorFormServlet extends ServletEntryPoint {

	private DistinguishedProfessorFormService distinguishedProfessorFormService = new DistinguishedProfessorFormService();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getForm(req);
		
		req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorForm.jsp").forward(req, resp);
        
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
            distinguishedProfessorFormService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));

            req.getRequestDispatcher("/DistinguishedProfessorAppDocInstructions").forward(req, resp);
        }
        else {
        	req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorForm.jsp").forward(req, resp);
        }
        
    }
    
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
    	HttpSession session = req.getSession();
    	
    	req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",distinguishedProfessorFormService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));		
		
    }
    
}
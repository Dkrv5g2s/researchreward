package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Utils.DocxToPdfUtil.wordToPDF;

public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //wordToPDF("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.docx","C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.pdf");
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/ResearchProduction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //wordToPDF("C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.docx","C:\\Users\\z\\Desktop\\ResearchRewardSystem\\src\\doc\\1.pdf");
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/ResearchProduction.jsp").forward(req, resp);
    }
}

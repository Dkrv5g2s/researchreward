package Service.Login;

import Bean.User.User;
import Dao.User.UserDAOImpl;
import Dao.User.UserDAO;

import javax.servlet.http.HttpSession;

public class RoleAuthorizationServiceImpl implements RoleAuthorizationService{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public String validateRole(HttpSession session, String account, String password) {
        User user = userDAO.get(account,password);
        if(user != null) {
            session.setAttribute("userNumber",user.getStaff_code());
            session.setAttribute("userRole",user.getRole());
            return user.getRole();
        }
        else
            return "";
    }

    @Override
    public boolean isUserRoleReviewerLevel(HttpSession session){
        String userRole = (String)session.getAttribute("userRole");
        switch (userRole){
            case "teacher":
                return false;
            case "admin":
            case "department":
            case "college":
            case "researchAndDevelopmentOffice":
            case "industryLiaisonOffice":
            default:
                return true;
        }
    }
    @Override
    public boolean isResearchAndDevelopmentOffice(HttpSession session){
        String userRole = (String)session.getAttribute("userRole");
        switch (userRole){
            case "researchAndDevelopmentOffice":
                return true;
            default:
                return false;
        }
    }
}

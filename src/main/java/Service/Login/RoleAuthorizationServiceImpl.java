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
            return user.getRole();
        }
        else
            return "";
    }
}

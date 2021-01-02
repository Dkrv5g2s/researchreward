package Service.Login;

import Bean.User.User;
import Dao.User.UserDAOImpl;
import Dao.User.UserDAO;

public class RoleAuthorizationServiceImpl implements RoleAuthorizationService{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public String validateRole(String account, String password) {
        User user = userDAO.get(account,password);
        if(user != null)
            return user.getRole();
        else
            return "";
    }
}

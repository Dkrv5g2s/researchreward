package Service.Login;

import Bean.User.User;
import Dao.ExcellentResearcher.Impl.UserDAOImpl;
import Dao.ExcellentResearcher.UserDAO;

public class RoleAuthorizationServiceImpl implements RoleAuthorizationService{

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean validateRole(String account, String password) {
        User user = userDAO.get(account,password);

        switch (user.getRole()){
            case "teacher":
            case "admin":
                return true;
            default:
                return false;
        }
    }
}

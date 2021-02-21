package Service.Login;

import javax.servlet.http.HttpSession;

public interface RoleAuthorizationService {

    public String validateRole(HttpSession session, String account, String password);
    public boolean isUserRoleReviewerLevel(HttpSession session);
}

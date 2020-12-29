package Service.Login;

public interface RoleAuthorizationService {

    public boolean validateRole(String account, String password);
}

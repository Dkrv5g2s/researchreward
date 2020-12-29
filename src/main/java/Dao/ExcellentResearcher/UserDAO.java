package Dao.ExcellentResearcher;

import Bean.User.User;

public interface UserDAO {
    public User get(String account, String password);
}

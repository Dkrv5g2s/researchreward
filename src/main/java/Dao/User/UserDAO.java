package Dao.User;

import Bean.User.User;

public interface UserDAO {
    public User get(String account, String password);
}

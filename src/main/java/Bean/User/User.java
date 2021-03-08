package Bean.User;

public class User {

    private String account = "";
    private String password = "";
    private String role = "";
    private String staff_code = "";

    private String name = "";

    public User(String account, String password, String role, String staff_code) {
        this.account = account;
        this.password = password;
        this.role = role;
        this.staff_code = staff_code;
    }

    public User() {
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

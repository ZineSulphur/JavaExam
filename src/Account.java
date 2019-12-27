import java.sql.SQLException;

public class Account {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public boolean changeUserName(String userName) throws SQLException {
        AccountData data = new AccountData();
        if(data.checkUserName(userName)) {
            data.setUserName(this.userName, userName);
            this.userName = userName;
            return true;
        }
        return false;
    }

    public void changePassword(String password) throws SQLException {
        AccountData data = new AccountData();
        data.setPassword(userName, password);
    }

    public boolean login(String userName, String password) throws SQLException {
        this.userName = userName;
        AccountData data = new AccountData();
        String uPassword = data.getPassword(userName);
        return password.equals(uPassword);
    }
}
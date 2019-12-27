import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountData {
    public String getPassword(String userName) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT password FROM account WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("password");
        } else {
            return "";
        }
    }

    public int getID(String userName) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT id FROM account WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getInt("id");
        } else {
            return 0;
        }
    }

    public void setUserName(String oldUserName, String newUserName) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE account SET username = ? WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newUserName);
        preparedStatement.setString(2, oldUserName);
        preparedStatement.execute();
    }

    public void setPassword(String userName, String password) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE account SET password = ? WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, userName);
        preparedStatement.execute();
    }

    public boolean newAccount(String userName, String password, int id) throws SQLException {
        if(checkUserName(userName)) {
            Connection connection = DataBase.getConnection();
            String sql = "INSERT INTO account (username, password, id) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            return true;
        }
        return false;
    }

    public boolean checkUserName(String userName) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT * FROM account WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return !resultSet.next();
    }
}
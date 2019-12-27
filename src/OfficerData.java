import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficerData {
    public void setName(int id, String name) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE dean SET dname = ? WHERE dno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setFaulty(int id, String faulty) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE dean SET dfaulty = ? WHERE dno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, faulty);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public String getName(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT dname FROM dean WHERE dno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("dname");
        } else {
            return "";
        }
    }

    public String getFaulty(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT dfaulty FROM dean WHERE dno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("dfaulty");
        } else {
            return "";
        }
    }

    public boolean newOfficer(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT * FROM dean WHERE dno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return false;
        }
        String sql2 = "INSERT INTO dean (dno) VALUES (?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setInt(1, id);
        preparedStatement1.execute();
        return true;
    }
}

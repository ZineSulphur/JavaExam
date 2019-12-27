import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherData {
    public void setName(int id, String name) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE teacher SET tname = ? WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setFaulty(int id, String faulty) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE teacher SET tfaulty = ? WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, faulty);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setDepartment(int id, String department) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE teacher SET tdepartment = ? WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, department);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public String getName(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT tname FROM teacher WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("tname");
        } else {
            return "";
        }
    }

    public String getFaulty(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT tfaulty FROM teacher WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("tfaulty");
        } else {
            return "";
        }
    }

    public String getDepartment(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT tdepartment FROM teacher WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("tdepartment");
        } else {
            return "";
        }
    }

    public boolean newTeacher(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT * FROM teacher WHERE tno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return false;
        }
        String sql2 = "INSERT INTO teacher (tno) VALUES (?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setInt(1, id);
        preparedStatement1.execute();
        return true;
    }
}

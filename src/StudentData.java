import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentData {
    public void setFaulty(int id, String faulty) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE student SET sfaulty = ? WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, faulty);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setName(int id, String name) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE student SET sname = ? WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setBirthday(int id, int month, int year) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE student SET sbirthy = ?, sbirthm = ? WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, year);
        preparedStatement.setInt(2, month);
        preparedStatement.setInt(3, id);
        preparedStatement.execute();
    }

    public void setSex(int id, String sex) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE student SET ssex = ? WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, sex);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setMajor(int id, String major) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE student SET smajor = ? WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, major);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public String getName(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT sname FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("sname");
        } else {
            return "";
        }
    }

    public String getFaulty(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT sfaulty FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("sfaulty");
        } else {
            return "";
        }
    }

    public String getSex(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT ssex FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("ssex");
        } else {
            return "";
        }
    }

    public int getBirthdayY(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT sbirthy FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("sbirthy");
        } else {
            return 0;
        }
    }

    public int getBirthdayM(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT sbirthm FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("sbirthm");
        } else {
            return 0;
        }
    }

    public String getMajor(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT smajor FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("smajor");
        } else {
            return "";
        }
    }

    public boolean newStudent(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT * FROM student WHERE sno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return false;
        }
        String sql2 = "INSERT INTO student (sno) VALUES (?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setInt(1, id);
        preparedStatement1.execute();
        return true;
    }
}

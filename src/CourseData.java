import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseData {
    public int newCourse() throws SQLException {
        int max = 0, tmp;
        Connection connection = DataBase.getConnection();
        String sql = "SELECT cno FROM course";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            tmp = resultSet.getInt("cno");
            if(tmp > max) {
                max = tmp;
            }
        }
        String sql2 = "INSERT INTO course (cno) VALUES (?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setInt(1, max + 1);
        preparedStatement1.execute();
        return max + 1;
    }

    public String getCourseName(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT cname FROM course WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("cname");
        } else {
            return "";
        }
    }

    public int getClassHour(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT ctime FROM course WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getInt("ctime");
        } else {
            return 0;
        }
    }

    public int getCredit(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT credit FROM course WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getInt("credit");
        } else {
            return 0;
        }
    }

    public void setCourseName(int id, String name) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE course SET cname = ? WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setCredit(int id, int credit) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE course SET credit = ? WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, credit);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setClassHour(int id, int classHour) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE course SET ctime = ? WHERE cno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, classHour);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }
}

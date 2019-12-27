import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeData {
    public int newGrade() throws SQLException {
        int max = 0, tmp;
        Connection connection = DataBase.getConnection();
        String sql = "SELECT scno FROM sc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            tmp = resultSet.getInt("scno");
            if(tmp > max) {
                max = tmp;
            }
        }
        String sql2 = "INSERT INTO sc (scno) VALUES (?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.setInt(1, max + 1);
        preparedStatement1.execute();
        return max + 1;
    }

    public String getStudent(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT sstudent FROM sc WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("sstudent");
        } else {
            return "";
        }
    }

    public String getCourse(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT scourse FROM sc WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("scourse");
        } else {
            return "";
        }
    }

    public String getTeacher(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT steacher FROM sc WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getString("steacher");
        } else {
            return "";
        }
    }

    public int getGrade(int id) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "SELECT degree FROM sc WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return resultSet.getInt("degree");
        } else {
            return 0;
        }
    }

    public void setStudent(int id, String student) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE sc SET sstudent = ? WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setCourse(int id, String course) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE sc SET scourse = ? WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, course);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setTeacher(int id, String teacher) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE sc SET steacher = ? WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, teacher);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public void setGrade(int id, int grade) throws SQLException {
        Connection connection = DataBase.getConnection();
        String sql = "UPDATE sc SET degree = ? WHERE scno = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, grade);
        preparedStatement.setInt(2, id);
        preparedStatement.execute();
    }

    public ArrayList<Integer> getAllGrade(String course) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();
        Connection connection = DataBase.getConnection();
        String sql = "SELECT scno FROM sc WHERE scourse = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, course);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("scno"));
        }
        return ids;
    }
}

import java.sql.SQLException;

public class Admin extends Person {
    public boolean newAccount(String userName, String password, int id) throws SQLException {
        AccountData data = new AccountData();
        return data.newAccount(userName, password, id);
    }

    public Student newStudent(int id) throws SQLException {
        StudentData data = new StudentData();
        if(!data.newStudent(id)) {
            return null;
        }
        Student student = new Student();
        student.setId(id, true);
        return student;
    }

    public Teacher newTeacher(int id) throws SQLException {
        TeacherData data = new TeacherData();
        if(!data.newTeacher(id)) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(id, true);
        return teacher;
    }

    public Officer newOfficer(int id) throws SQLException {
        OfficerData data = new OfficerData();
        if(!data.newOfficer(id)) {
            return null;
        }
        Officer officer = new Officer();
        officer.setId(id, true);
        return officer;
    }

    public Course newCourse() throws SQLException {
        CourseData data = new CourseData();
        int id = data.newCourse();
        Course course = new Course();
        course.setId(id);
        return course;
    }

    public Grade newGrade() throws SQLException {
        GradeData data = new GradeData();
        int id = data.newGrade();
        Grade grade = new Grade();
        grade.setId(id);
        return grade;
    }

    public boolean changeAccount(String userName, String newUserName, String password) throws SQLException {
        AccountData data = new AccountData();
        if(!newUserName.isEmpty()) {
            if(data.checkUserName(newUserName)) {
                data.setUserName(userName, newUserName);
            } else {
                return false;
            }
        }
        if(!password.isEmpty()) {
            data.setPassword(userName, password);
        }
        return true;
    }

    public Student changeStudent(int id) throws SQLException {
        Student student = new Student();
        student.setId(id, false);
        return student;
    }

    public Teacher changeTeacher(int id) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(id, false);
        return teacher;
    }

    public Officer changeOfficer(int id) throws SQLException {
        Officer officer = new Officer();
        officer.setId(id, false);
        return officer;
    }

    public void changeCourse(Course course) throws SQLException {
        CourseData data = new CourseData();
        int id = course.getId();
        data.setCourseName(id, course.getCourseName());
        data.setClassHour(id, course.getClassHour());
        data.setCredit(id, course.getCredit());
    }

    public void changeGrade(Grade grade) throws SQLException {
        GradeData data = new GradeData();
        int id = grade.getId();
        data.setStudent(id, grade.getStudent());
        data.setTeacher(id, grade.getTeacher());
        data.setCourse(id, grade.getCourse());
        data.setGrade(id, grade.getGrade());
    }
}
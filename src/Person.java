import java.sql.SQLException;

class Person extends Account {
    private String name;
    private String faulty;

    public String getName() {
        return name;
    }

    public String getFaulty() {
        return faulty;
    }

    public void setName(String name) throws SQLException {
        this.name = name;
    }

    public void setFaulty(String faulty) throws SQLException {
        this.faulty = faulty;
    }

    public Course queryCourse(int id) throws SQLException {
        Course course = new Course();
        CourseData data = new CourseData();
        course.setId(id);
        course.setCourseName(data.getCourseName(id));
        course.setClassHour(data.getClassHour(id));
        course.setCredit(data.getCredit(id));
        return course;
    }

    public Grade queryGrade(int id) throws SQLException {
        Grade grade = new Grade();
        GradeData data = new GradeData();
        grade.setId(id);
        grade.setStudent(data.getStudent(id));
        grade.setCourse(data.getCourse(id));
        grade.setTeacher(data.getTeacher(id));
        grade.setGrade(data.getGrade(id));
        return grade;
    }
}
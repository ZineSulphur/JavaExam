public class Grade {
    private int gradeId;
    private String course;
    private String teacher;
    private String student;
    private int grade;

    public int getId() {
        return gradeId;
    }

    public String getCourse() {
        return course;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getStudent() {
        return student;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(int Id) {
        this.gradeId = Id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
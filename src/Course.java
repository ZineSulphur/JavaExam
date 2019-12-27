 public class Course {
    private int courseId;
    private String courseName;
    private int credit;
    private int classHour;

    public int getId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredit() {
        return credit;
    }

    public int getClassHour() {
        return classHour;
    }

     public void setId(int Id) {
         this.courseId = Id;
     }

     public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }
}
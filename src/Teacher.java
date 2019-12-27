import java.sql.SQLException;

public class Teacher extends Person {
     private int teacherId;
     private String department;

     public int getId() {
         return teacherId;
     }

     public String getDepartment() {
         return department;
     }

     public void setId(int teacherId, boolean isNew) throws SQLException {
         this.teacherId = teacherId;
         if(!isNew) {
             TeacherData data1 = new TeacherData();
             super.setName(data1.getName(teacherId));
             super.setFaulty(data1.getFaulty(teacherId));
             department = data1.getDepartment(teacherId);
         }
     }

     public void setDepartment(String department) throws SQLException {
         this.department = department;
         TeacherData data = new TeacherData();
         data.setDepartment(teacherId, department);
     }

     @Override
     public void setName(String name) throws SQLException {
         super.setName(name);
         TeacherData data = new TeacherData();
         data.setName(teacherId, name);
     }

     @Override
     public void setFaulty(String faulty) throws SQLException {
         super.setFaulty(faulty);
         TeacherData data = new TeacherData();
         data.setFaulty(teacherId, faulty);
     }

     public void recordCourse(Course course, boolean isNew) throws SQLException {
         CourseData data = new CourseData();
         int id;
         if (isNew) {
             id = data.newCourse();
             course.setId(id);
         } else {
             id = course.getId();
         }
         data.setCourseName(id, course.getCourseName());
         data.setClassHour(id, course.getClassHour());
         data.setCredit(id, course.getCredit());
     }

     public void recordGrade(Grade grade, boolean isNew) throws SQLException {
         GradeData data = new GradeData();
         int id;
         if(isNew) {
             id = data.newGrade();
             grade.setId(id);
         } else {
             id = grade.getId();
         }
         data.setStudent(id, grade.getStudent());
         data.setTeacher(id, grade.getTeacher());
         data.setCourse(id, grade.getCourse());
         data.setGrade(id, grade.getGrade());
     }

     @Override
     public boolean login(String userName, String password) throws SQLException {
         if (super.login(userName, password)) {
             AccountData data = new AccountData();
             setId(data.getID(userName), false);
             return true;
         }
         return false;
     }
 }
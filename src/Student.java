import java.sql.SQLException;

public class Student extends Person {
     private int studentId;
     private String sex;
     private int year;
     private int month;
     private String major;

     public int getId() {
         return studentId;
     }

     public String getSex() {
         return sex;
     }

     public int getBirthdayY() {
         return year;
     }

     public int getBirthdayM() {
         return month;
     }

     public String getMajor() {
         return major;
     }

     public void setId(int studentId, boolean isNew) throws SQLException {
         this.studentId = studentId;
         if(!isNew) {
             StudentData data1 = new StudentData();
             super.setName(data1.getName(studentId));
             super.setFaulty(data1.getFaulty(studentId));
             sex = data1.getSex(studentId);
             year = data1.getBirthdayY(studentId);
             month = data1.getBirthdayM(studentId);
             major = data1.getMajor(studentId);
         }
     }

     public void setBirthday(int year, int month) throws SQLException {
         this.year = year;
         this.month = month;
         StudentData data = new StudentData();
         data.setBirthday(studentId, month, year);
     }

     public void setSex(String sex) throws SQLException {
         this.sex = sex;
         StudentData data = new StudentData();
         data.setSex(studentId, sex);
     }

     public void setMajor(String major) throws SQLException {
         this.major = major;
         StudentData data = new StudentData();
         data.setMajor(studentId, major);
     }

     @Override
     public void setName(String name) throws SQLException {
         super.setName(name);
         StudentData data = new StudentData();
         data.setName(studentId, name);
     }

     @Override
     public void setFaulty(String faulty) throws SQLException {
         super.setFaulty(faulty);
         StudentData data = new StudentData();
         data.setFaulty(studentId, faulty);
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
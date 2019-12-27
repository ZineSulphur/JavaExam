import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Officer extends Person {
    private int officerId;

    public int getId() {
        return officerId;
    }

    public void setId(int officerId, boolean isNew) throws SQLException {
        this.officerId = officerId;
        if(!isNew) {
            OfficerData data1 = new OfficerData();
            super.setName(data1.getName(officerId));
            super.setFaulty(data1.getFaulty(officerId));
        }
    }

    @Override
    public void setName(String name) throws SQLException {
        super.setName(name);
        OfficerData data = new OfficerData();
        data.setName(officerId, name);
    }

    @Override
    public void setFaulty(String faulty) throws SQLException {
        super.setFaulty(faulty);
        OfficerData data = new OfficerData();
        data.setFaulty(officerId, faulty);
    }

    public Course newCourse() throws SQLException {
        CourseData data = new CourseData();
        Course course = new Course();
        int id = data.newCourse();
        course.setId(id);
        return course;
    }

    public void changeCourse(Course course) throws SQLException {
        CourseData data = new CourseData();
        int id = course.getId();
        data.setCourseName(id, course.getCourseName());
        data.setClassHour(id, course.getClassHour());
        data.setCredit(id, course.getCredit());
    }

    public double statistic(String course) throws SQLException {
        GradeData data = new GradeData();
        ArrayList<Integer> ids = data.getAllGrade(course);
        int average = 0, length = ids.size();
        if(length == 0) {
            return 0;
        }
        for (Integer id: ids) {
            average += data.getGrade(id);
        }
        return average / (double)length;
    }

    public Grade[] ranking(String course) throws SQLException {
        GradeData data = new GradeData();
        ArrayList<Integer> ids = data.getAllGrade(course);
        ArrayList<Grade> grades = new ArrayList<>();
        for (Integer id : ids) {
            Grade grade = queryGrade(id);
            grades.add(grade);
        }
        Grade[] grades1 = (Grade[]) grades.toArray();
        Comparator<Grade> gradeComparator = new Comparator<Grade>() {
            @Override
            public int compare(Grade o1, Grade o2) {
                if (o1.getGrade() > o2.getGrade()) {
                    return -1;
                } else if (o1.getGrade() < o2.getGrade()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(grades1, gradeComparator);
        return grades1;
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
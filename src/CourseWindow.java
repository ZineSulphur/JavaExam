import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CourseWindow extends JFrame {
    public CourseWindow(StudentMenu studentMenu, Student student){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入课程编号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("课程编号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名称");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学分");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学时");
        majorLabel.setBounds(190,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(220,40,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = student.queryCourse(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(course.getCourseName());
                    schoolTextField.setText(String.valueOf(course.getCredit()));
                    majorTextField.setText(String.valueOf(course.getClassHour()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentMenu.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public CourseWindow(TeacherMenu teacherMenu, Teacher teacher){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入课程编号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("课程编号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名称");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学分");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学时");
        majorLabel.setBounds(190,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(220,40,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newCButton = new JButton("新建");
        buttonPanel.add(newCButton);
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        newCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setCourseName(nameTextField.getText());
                course.setCredit(Integer.parseInt(schoolTextField.getText()));
                course.setClassHour(Integer.parseInt(majorTextField.getText()));
                try {
                    teacher.recordCourse(course, true);
                    numTextField.setText(String.valueOf(course.getId()));
                    TipWindow tipWindow = new TipWindow("新建成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = teacher.queryCourse(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(course.getCourseName());
                    schoolTextField.setText(String.valueOf(course.getCredit()));
                    majorTextField.setText(String.valueOf(course.getClassHour()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setId(Integer.parseInt(numTextField.getText()));
                course.setCourseName(nameTextField.getText());
                course.setCredit(Integer.parseInt(schoolTextField.getText()));
                course.setClassHour(Integer.parseInt(majorTextField.getText()));
                try {
                    teacher.recordCourse(course, false);
                    TipWindow tipWindow = new TipWindow("保存成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherMenu.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public CourseWindow(DeanMenu deanMenu, Officer officer) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入课程编号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("课程编号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名称");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学分");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学时");
        majorLabel.setBounds(190,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(220,40,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newCButton = new JButton("新建");
        buttonPanel.add(newCButton);
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        newCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = officer.newCourse();
                    course.setCourseName(nameTextField.getText());
                    course.setCredit(Integer.parseInt(schoolTextField.getText()));
                    course.setClassHour(Integer.parseInt(majorTextField.getText()));
                    officer.changeCourse(course);
                    numTextField.setText(String.valueOf(course.getId()));
                    TipWindow tipWindow = new TipWindow("新建成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = officer.queryCourse(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(course.getCourseName());
                    schoolTextField.setText(String.valueOf(course.getCredit()));
                    majorTextField.setText(String.valueOf(course.getClassHour()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setId(Integer.parseInt(numTextField.getText()));
                course.setCourseName(nameTextField.getText());
                course.setCredit(Integer.parseInt(schoolTextField.getText()));
                course.setClassHour(Integer.parseInt(majorTextField.getText()));
                try {
                    officer.changeCourse(course);
                    TipWindow tipWindow = new TipWindow("保存成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deanMenu.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public CourseWindow(ManagerMenu managerMenu, Admin admin) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入课程编号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("课程编号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名称");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学分");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学时");
        majorLabel.setBounds(190,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(220,40,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newCButton = new JButton("新建");
        buttonPanel.add(newCButton);
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        newCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = admin.newCourse();
                    course.setCourseName(nameTextField.getText());
                    course.setCredit(Integer.parseInt(schoolTextField.getText()));
                    course.setClassHour(Integer.parseInt(majorTextField.getText()));
                    admin.changeCourse(course);
                    numTextField.setText(String.valueOf(course.getId()));
                    TipWindow tipWindow = new TipWindow("新建成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course course = admin.queryCourse(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(course.getCourseName());
                    schoolTextField.setText(String.valueOf(course.getCredit()));
                    majorTextField.setText(String.valueOf(course.getClassHour()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setId(Integer.parseInt(numTextField.getText()));
                course.setCourseName(nameTextField.getText());
                course.setCredit(Integer.parseInt(schoolTextField.getText()));
                course.setClassHour(Integer.parseInt(majorTextField.getText()));
                try {
                    admin.changeCourse(course);
                    TipWindow tipWindow = new TipWindow("保存成功");
                    tipWindow.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerMenu.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

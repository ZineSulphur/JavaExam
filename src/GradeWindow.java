import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GradeWindow extends JFrame {
    public GradeWindow(StudentMenu studentMenu, Student student){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入成绩单号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("成绩单号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("课程");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("教师");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,100,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学生");
        majorLabel.setBounds(170,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(200,40,100,20);
        midPanel.add(majorTextField);
        JLabel courseLabel = new JLabel("成绩");
        courseLabel.setBounds(305,40,30,20);
        midPanel.add(courseLabel);
        JTextField courseTextField = new JTextField();
        courseTextField.setBounds(335,40,25,20);
        midPanel.add(courseTextField);
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
                    Grade grade = student.queryGrade(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(grade.getCourse());
                    schoolTextField.setText(grade.getTeacher());
                    majorTextField.setText(grade.getStudent());
                    courseTextField.setText(String.valueOf(grade.getGrade()));
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

    public GradeWindow(TeacherMenu teacherMenu, Teacher teacher){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入成绩单号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("成绩单号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("课程");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("教师");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,100,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学生");
        majorLabel.setBounds(170,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(200,40,100,20);
        midPanel.add(majorTextField);
        JLabel courseLabel = new JLabel("成绩");
        courseLabel.setBounds(305,40,30,20);
        midPanel.add(courseLabel);
        JTextField courseTextField = new JTextField();
        courseTextField.setBounds(335,40,25,20);
        midPanel.add(courseTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newGButton = new JButton("新建");
        buttonPanel.add(newGButton);
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        newGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grade grade = new Grade();
                grade.setCourse(nameTextField.getText());
                grade.setTeacher(schoolTextField.getText());
                grade.setStudent(majorTextField.getText());
                grade.setGrade(Integer.parseInt(courseTextField.getText()));
                try {
                    teacher.recordGrade(grade, true);
                    numTextField.setText(String.valueOf(grade.getId()));
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
                    Grade grade = teacher.queryGrade(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(grade.getCourse());
                    schoolTextField.setText(grade.getTeacher());
                    majorTextField.setText(grade.getStudent());
                    courseTextField.setText(String.valueOf(grade.getGrade()));
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
                Grade grade = new Grade();
                grade.setId(Integer.parseInt(numTextField.getText()));
                grade.setCourse(nameTextField.getText());
                grade.setTeacher(schoolTextField.getText());
                grade.setStudent(majorTextField.getText());
                grade.setGrade(Integer.parseInt(courseTextField.getText()));
                try {
                    teacher.recordGrade(grade, false);
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

    public GradeWindow(ManagerMenu managerMenu, Admin admin) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入成绩单号查询");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("成绩单号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("课程");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("教师");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,40,100,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("学生");
        majorLabel.setBounds(170,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
        majorTextField.setBounds(200,40,100,20);
        midPanel.add(majorTextField);
        JLabel courseLabel = new JLabel("成绩");
        courseLabel.setBounds(305,40,30,20);
        midPanel.add(courseLabel);
        JTextField courseTextField = new JTextField();
        courseTextField.setBounds(335,40,25,20);
        midPanel.add(courseTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newGButton = new JButton("新建");
        buttonPanel.add(newGButton);
        JButton searchButton = new JButton("查询");
        buttonPanel.add(searchButton);
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        newGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Grade grade = admin.newGrade();
                    grade.setCourse(nameTextField.getText());
                    grade.setTeacher(schoolTextField.getText());
                    grade.setStudent(majorTextField.getText());
                    grade.setGrade(Integer.parseInt(courseTextField.getText()));
                    admin.changeGrade(grade);
                    numTextField.setText(String.valueOf(grade.getId()));
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
                    Grade grade = admin.queryGrade(Integer.parseInt(numTextField.getText()));
                    nameTextField.setText(grade.getCourse());
                    schoolTextField.setText(grade.getTeacher());
                    majorTextField.setText(grade.getStudent());
                    courseTextField.setText(String.valueOf(grade.getGrade()));
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
                Grade grade = new Grade();
                grade.setId(Integer.parseInt(numTextField.getText()));
                grade.setCourse(nameTextField.getText());
                grade.setTeacher(schoolTextField.getText());
                grade.setStudent(majorTextField.getText());
                grade.setGrade(Integer.parseInt(courseTextField.getText()));
                try {
                    admin.changeGrade(grade);
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

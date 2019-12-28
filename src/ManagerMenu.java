import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ManagerMenu extends JFrame {
    private Admin admin;

    public ManagerMenu(Admin admin){
        this.admin = admin;

        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 300);

        JLabel label = new JLabel("欢迎使用学生成绩管理系统！");
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,1));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("退出登录");
        JButton newAccount = new JButton("新建账户");
        JButton changeAccount = new JButton("修改账户");
        JButton changeStudent = new JButton("管理学生信息");
        JButton changeTeacher = new JButton("管理教师信息");
        JButton changeOfficer = new JButton("管理教务员信息");
        JButton changeCourse = new JButton("管理课程信息");
        JButton changeGrade = new JButton("管理成绩信息");
        Dimension preferredSize = new Dimension(125, 25);
        backButton.setPreferredSize(preferredSize);
        newAccount.setPreferredSize(preferredSize);
        changeAccount.setPreferredSize(preferredSize);
        changeStudent.setPreferredSize(preferredSize);
        changeTeacher.setPreferredSize(preferredSize);
        changeOfficer.setPreferredSize(preferredSize);
        changeCourse.setPreferredSize(preferredSize);
        changeGrade.setPreferredSize(preferredSize);
        buttonPanel.add(newAccount);
        buttonPanel.add(changeAccount);
        buttonPanel.add(changeStudent);
        buttonPanel.add(changeTeacher);
        buttonPanel.add(changeOfficer);
        buttonPanel.add(changeCourse);
        buttonPanel.add(changeGrade);
        buttonPanel.add(backButton);
        container.add(buttonPanel);

        newAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountWindow accountWindow = new AccountWindow(getThis(), getAdmin(), true);
                accountWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AccountWindow accountWindow = new AccountWindow(getThis(), getAdmin(), false);
                accountWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoWindow infoWindow = new InfoWindow(getThis(), getAdmin(), 1);
                infoWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoWindow infoWindow = new InfoWindow(getThis(), getAdmin(), 2);
                infoWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeOfficer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoWindow infoWindow = new InfoWindow(getThis(), getAdmin(), 3);
                infoWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseWindow courseWindow = new CourseWindow(getThis(), getAdmin());
                courseWindow.setVisible(true);
                closeThisWindow();
            }
        });

        changeGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GradeWindow gradeWindow = new GradeWindow(getThis(), getAdmin());
                gradeWindow.setVisible(true);
                closeThisWindow();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public ManagerMenu getThis() {
        return this;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

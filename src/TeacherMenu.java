import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMenu extends JFrame {
    public TeacherMenu() {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 200);

        JLabel label = new JLabel("欢迎使用学生成绩管理系统！");
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel);

        JButton personalButton = new JButton("个人信息维护");
        JButton courseButton = new JButton("课程登录");
        JButton gradeButton = new JButton("成绩登录");
        JButton backButton = new JButton("退出登录");
        JPanel buttonPanel = new JPanel();
        Dimension preferredSize = new Dimension(120, 25);
        personalButton.setPreferredSize(preferredSize);
        courseButton.setPreferredSize(preferredSize);
        gradeButton.setPreferredSize(preferredSize);
        backButton.setPreferredSize(preferredSize);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(personalButton);
        buttonPanel.add(courseButton);
        buttonPanel.add(gradeButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel);

        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherInfoWindow teacherInfoWindow = new TeacherInfoWindow(getThis());
                teacherInfoWindow.setVisible(true);
                closeThisWindow();
            }
        });

        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        gradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public void closeThisWindow() {
        this.dispose();
    }

    public TeacherMenu getThis() {
        return this;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeanMenu extends JFrame {
    private Officer officer;

    public DeanMenu(Officer officer){
        this.officer = officer;

        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 200);

        JLabel label = new JLabel("欢迎使用学生成绩管理系统！");
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton accountButton = new JButton("管理账号");
        JButton personalButton = new JButton("个人信息维护");
        JButton courseButton = new JButton("课程管理");
        JButton statisticsButton = new JButton("综合统计");
        JButton printButton = new JButton("排名及报表打印");
        JButton backButton = new JButton("退出登录");
        Dimension preferredSize = new Dimension(120,25);
        accountButton.setPreferredSize(preferredSize);
        personalButton.setPreferredSize(preferredSize);
        courseButton.setPreferredSize(preferredSize);
        statisticsButton.setPreferredSize(preferredSize);
        printButton.setPreferredSize(preferredSize);
        backButton.setPreferredSize(preferredSize);
        panel2.add(accountButton);
        panel2.add(personalButton);
        panel2.add(courseButton);
        panel2.add(statisticsButton);
        panel2.add(printButton);
        panel2.add(backButton);
        container.add(panel2,"Center");

        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountWindow accountWindow = new AccountWindow(getThis(), getOfficer());
                accountWindow.setVisible(true);
                closeThisWindow();
            }
        });

        personalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoWindow infoWindow = new InfoWindow(getThis(), getOfficer());
                infoWindow.setVisible(true);
                closeThisWindow();
            }
        });

        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseWindow courseWindow = new CourseWindow(getThis(), getOfficer());
                courseWindow.setVisible(true);
                closeThisWindow();
            }
        });

        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticWindow statisticWindow = new StatisticWindow(getThis(), getOfficer());
                statisticWindow.setVisible(true);
                closeThisWindow();
            }
        });

        printButton.addActionListener(new ActionListener() {
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

    public DeanMenu getThis() { return this; }

    public Officer getOfficer() {
        return officer;
    }
}

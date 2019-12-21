import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeWindow extends JFrame {
    public GradeWindow(StudentMenu studentMenu){
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

    public GradeWindow(TeacherMenu teacherMenu){
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
        JButton saveButton = new JButton("保存");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    public void closeThisWindow() {
        this.dispose();
    }
}

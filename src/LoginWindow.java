import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    public LoginWindow() {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 240);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JLabel label = new JLabel("登录");
        JLabel usernameLabel = new JLabel("用户名");
        JLabel passwordLabel = new JLabel("密  码");
        JLabel selectLabel = new JLabel("用户类型");
        JTextField usernameTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("登录");
        JButton backButton = new JButton("返回");
        JComboBox userKindComboBox = new JComboBox();

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(label);
        container.add(titlePanel, "North");

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        usernameLabel.setBounds(50, 20, 50, 20);
        passwordLabel.setBounds(50, 60, 50, 20);
        selectLabel.setBounds(50, 100, 50, 20);
        fieldPanel.add(usernameLabel);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(selectLabel);
        usernameTextField.setBounds(110, 20, 120, 20);
        passwordField.setBounds(110, 60, 120, 20);
        fieldPanel.add(usernameTextField);
        fieldPanel.add(passwordField);
        userKindComboBox.addItem("学生");
        userKindComboBox.addItem("教师");
        userKindComboBox.addItem("教务员");
        userKindComboBox.addItem("系统管理员");
        userKindComboBox.setBounds(110, 100, 100, 20);
        fieldPanel.add(userKindComboBox);
        container.add(fieldPanel, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel, "South");

        loginButton.addActionListener(new ActionListener() {//登录
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String selected = String.valueOf(userKindComboBox.getSelectedItem());
                if (selected.equals("学生")) {
                    StudentMenu studentMenu = new StudentMenu();
                    studentMenu.setVisible(true);
                    closeThisWindow();
                } else if (selected.equals("教师")) {
                    LoginErrWindow loginErrWindow = new LoginErrWindow();
                    loginErrWindow.setVisible(true);
                    System.out.println(selected + 2);
                } else if (selected.equals("教务员")) {
                    System.out.println(selected + 3);
                } else {
                    System.out.println(selected + 4);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {//返回
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeWindow welcomeWindow = new WelcomeWindow();
                welcomeWindow.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public void closeThisWindow() {
        this.dispose();
    }

    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
}

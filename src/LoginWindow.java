import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class LoginWindow extends JFrame {
    public LoginWindow(){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,300,200);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JLabel label = new JLabel("登录");
        JLabel usernameLabel = new JLabel("用户名");
        JLabel passwordLabel = new JLabel("密  码");
        JTextField usernameTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("登录");
        JButton backButton = new JButton("返回");

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(label);
        container.add(titlePanel,"North");

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        usernameLabel.setBounds(50,20,50,20);
        passwordLabel.setBounds(50,60,50,20);
        fieldPanel.add(usernameLabel);
        fieldPanel.add(passwordLabel);
        usernameTextField.setBounds(110,20,120,20);
        passwordField.setBounds(110,60,120,20);
        fieldPanel.add(usernameTextField);
        fieldPanel.add(passwordField);
        container.add(fieldPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeWindow welcomeWindow = new WelcomeWindow();
                welcomeWindow.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public void closeThisWindow(){
        this.dispose();
    }

    public static void main(String[] args){
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
}

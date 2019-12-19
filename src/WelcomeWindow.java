import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeWindow extends JFrame{
    public WelcomeWindow(){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,300,200);
        JLabel label = new JLabel("欢迎使用学生成绩管理系统！");
        JButton loginButton = new JButton("登录");
        JButton exitButton = new JButton("退出");

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setSize(600,400);
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(label);
        panel2.add(loginButton);
        panel2.add(exitButton);
        container.add(panel1,"North");
        container.add(panel2,"Center");

        loginButton.addActionListener(new ActionListener() {//进入登录界面
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
                closeThisWindow();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void closeThisWindow() {
        this.dispose();
    }

    public static void main(String[] args){
        WelcomeWindow frame = new WelcomeWindow();
        frame.setVisible(true);
        frame.pack();
    }
}

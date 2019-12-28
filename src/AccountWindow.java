import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AccountWindow extends JFrame {
    public AccountWindow(StudentMenu studentMenu, Student student) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 250);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("账号管理");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel, "North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("用 户 名");
        usernameLabel.setBounds(50, 20, 50, 20);
        midPanel.add(usernameLabel);
        JTextField usernameTextField = new JTextField(student.getUserName());
        usernameTextField.setBounds(110, 20, 120, 20);
        usernameTextField.setEnabled(false);
        midPanel.add(usernameTextField);
        JLabel newUsernameLabel = new JLabel("新用户名");
        newUsernameLabel.setBounds(50, 60, 50, 20);
        midPanel.add(newUsernameLabel);
        JTextField newUsernameTextField = new JTextField();
        newUsernameTextField.setBounds(110, 60, 120, 20);
        midPanel.add(newUsernameTextField);
        JLabel passwordLabel = new JLabel("密    码");
        passwordLabel.setBounds(50, 100, 50, 20);
        midPanel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 100, 120, 20);
        midPanel.add(passwordField);
        container.add(midPanel, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("更改");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel, "South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!newUsernameTextField.getText().isEmpty()) {
                        if (student.changeUserName(newUsernameTextField.getText())) {
                            usernameTextField.setText(student.getUserName());
                            TipWindow tipWindow = new TipWindow("更改用户名成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("用户名已存在");
                            tipWindow.setVisible(true);
                        }
                    }
                    if(!String.valueOf(passwordField.getPassword()).isEmpty()) {
                        student.changePassword(String.valueOf(passwordField.getPassword()));
                        TipWindow tipWindow = new TipWindow("更改密码成功");
                        tipWindow.setVisible(true);
                    }
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

    public AccountWindow(TeacherMenu teacherMenu, Teacher teacher) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 250);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("账号管理");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel, "North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("用 户 名");
        usernameLabel.setBounds(50, 20, 50, 20);
        midPanel.add(usernameLabel);
        JTextField usernameTextField = new JTextField(teacher.getUserName());
        usernameTextField.setBounds(110, 20, 120, 20);
        usernameTextField.setEnabled(false);
        midPanel.add(usernameTextField);
        JLabel newUsernameLabel = new JLabel("新用户名");
        newUsernameLabel.setBounds(50, 60, 50, 20);
        midPanel.add(newUsernameLabel);
        JTextField newUsernameTextField = new JTextField();
        newUsernameTextField.setBounds(110, 60, 120, 20);
        midPanel.add(newUsernameTextField);
        JLabel passwordLabel = new JLabel("密    码");
        passwordLabel.setBounds(50, 100, 50, 20);
        midPanel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 100, 120, 20);
        midPanel.add(passwordField);
        container.add(midPanel, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("更改");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel, "South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!newUsernameTextField.getText().isEmpty()) {
                        if (teacher.changeUserName(newUsernameTextField.getText())) {
                            usernameTextField.setText(teacher.getUserName());
                            TipWindow tipWindow = new TipWindow("更改用户名成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("用户名已存在");
                            tipWindow.setVisible(true);
                        }
                    }
                    if(!String.valueOf(passwordField.getPassword()).isEmpty()) {
                        teacher.changePassword(String.valueOf(passwordField.getPassword()));
                        TipWindow tipWindow = new TipWindow("更改密码成功");
                        tipWindow.setVisible(true);
                    }
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

    public AccountWindow(DeanMenu deanMenu, Officer officer) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 250);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("账号管理");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel, "North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("用 户 名");
        usernameLabel.setBounds(50, 20, 50, 20);
        midPanel.add(usernameLabel);
        JTextField usernameTextField = new JTextField(officer.getUserName());
        usernameTextField.setBounds(110, 20, 120, 20);
        usernameTextField.setEnabled(false);
        midPanel.add(usernameTextField);
        JLabel newUsernameLabel = new JLabel("新用户名");
        newUsernameLabel.setBounds(50, 60, 50, 20);
        midPanel.add(newUsernameLabel);
        JTextField newUsernameTextField = new JTextField();
        newUsernameTextField.setBounds(110, 60, 120, 20);
        midPanel.add(newUsernameTextField);
        JLabel passwordLabel = new JLabel("密    码");
        passwordLabel.setBounds(50, 100, 50, 20);
        midPanel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(110, 100, 120, 20);
        midPanel.add(passwordField);
        container.add(midPanel, "Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("更改");
        buttonPanel.add(saveButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel, "South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!newUsernameTextField.getText().isEmpty()) {
                        if (officer.changeUserName(newUsernameTextField.getText())) {
                            usernameTextField.setText(officer.getUserName());
                            TipWindow tipWindow = new TipWindow("更改用户名成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("用户名已存在");
                            tipWindow.setVisible(true);
                        }
                    }
                    if(!String.valueOf(passwordField.getPassword()).isEmpty()) {
                        officer.changePassword(String.valueOf(passwordField.getPassword()));
                        TipWindow tipWindow = new TipWindow("更改密码成功");
                        tipWindow.setVisible(true);
                    }
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

    public AccountWindow(ManagerMenu managerMenu, Admin admin, boolean isNew) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 300, 250);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("账号管理");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel, "North");

        if (isNew) {
            JPanel midPanel = new JPanel();
            midPanel.setLayout(null);
            JLabel usernameLabel = new JLabel("用户名");
            usernameLabel.setBounds(50, 20, 50, 20);
            midPanel.add(usernameLabel);
            JTextField usernameTextField = new JTextField();
            usernameTextField.setBounds(110, 20, 120, 20);
            midPanel.add(usernameTextField);
            JLabel passwordLabel = new JLabel("密  码");
            passwordLabel.setBounds(50, 60, 50, 20);
            midPanel.add(passwordLabel);
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(110, 60, 120, 20);
            midPanel.add(passwordField);
            JLabel idLabel = new JLabel("编  号");
            idLabel.setBounds(50, 100, 50, 20);
            midPanel.add(idLabel);
            JTextField idTextField = new JTextField();
            idTextField.setBounds(110, 100, 120, 20);
            midPanel.add(idTextField);
            container.add(midPanel, "Center");

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            JButton newAButton = new JButton("新建");
            buttonPanel.add(newAButton);
            JButton backButton = new JButton("返回");
            buttonPanel.add(backButton);
            container.add(buttonPanel, "South");

            newAButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (admin.newAccount(usernameTextField.getText(), String.valueOf(passwordField.getPassword()), Integer.parseInt(idTextField.getText()))) {
                            TipWindow tipWindow = new TipWindow("新建成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("用户名已存在");
                            tipWindow.setVisible(true);
                        }
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
        } else {
            JPanel midPanel = new JPanel();
            midPanel.setLayout(null);
            JLabel usernameLabel = new JLabel("用 户 名");
            usernameLabel.setBounds(50, 20, 50, 20);
            midPanel.add(usernameLabel);
            JTextField usernameTextField = new JTextField();
            usernameTextField.setBounds(110, 20, 120, 20);
            midPanel.add(usernameTextField);
            JLabel newUsernameLabel = new JLabel("新用户名");
            newUsernameLabel.setBounds(50, 60, 50, 20);
            midPanel.add(newUsernameLabel);
            JTextField newUsernameTextField = new JTextField();
            newUsernameTextField.setBounds(110, 60, 120, 20);
            midPanel.add(newUsernameTextField);
            JLabel passwordLabel = new JLabel("密    码");
            passwordLabel.setBounds(50, 100, 50, 20);
            midPanel.add(passwordLabel);
            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(110, 100, 120, 20);
            midPanel.add(passwordField);
            container.add(midPanel, "Center");

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            JButton saveButton = new JButton("更改");
            buttonPanel.add(saveButton);
            JButton backButton = new JButton("返回");
            buttonPanel.add(backButton);
            container.add(buttonPanel, "South");

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(admin.changeAccount(usernameTextField.getText(), newUsernameTextField.getText(), String.valueOf(passwordField.getPassword()))) {
                            TipWindow tipWindow = new TipWindow("更改成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("用户名已存在");
                            tipWindow.setVisible(true);
                        }
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
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

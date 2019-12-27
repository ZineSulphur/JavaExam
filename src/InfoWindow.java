import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InfoWindow extends JFrame {
    public InfoWindow(StudentMenu studentMenu, Student student){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 220);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("学生信息");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("学号");
        numLabel.setBounds(30,10,30,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField(String.valueOf(student.getId()));
        numTextField.setEnabled(false);
        numTextField.setBounds(60,10,140,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名字");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField(student.getName());
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel sexLabel = new JLabel("性别");
        sexLabel.setBounds(30,40,30,20);
        midPanel.add(sexLabel);
        JComboBox<String> sexComboBox = new JComboBox<>();
        sexComboBox.addItem("男");
        sexComboBox.addItem("女");
        sexComboBox.setSelectedItem(student.getSex());
        sexComboBox.setBounds(60,40,50,20);
        midPanel.add(sexComboBox);
        JLabel bornLabel = new JLabel("出生年月");
        bornLabel.setBounds(130,40,110,20);
        midPanel.add(bornLabel);
        JTextField bornTextField = new JTextField(student.getBirthdayY() + "." + student.getBirthdayM());
        bornTextField.setBounds(180,40,70,20);
        midPanel.add(bornTextField);
        JLabel schoolLabel = new JLabel("学院");
        schoolLabel.setBounds(30,70,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField(student.getFaulty());
        schoolTextField.setBounds(60,70,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("专业");
        majorLabel.setBounds(190,70,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField(student.getMajor());
        majorTextField.setBounds(220,70,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("保存");
        JButton backButton = new JButton("返回");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM");
                try {
                    date = dateFormat.parse(bornTextField.getText());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    try {
                        student.setName(nameTextField.getText());
                        student.setSex(String.valueOf(sexComboBox.getSelectedItem()));
                        student.setBirthday(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
                        student.setFaulty(schoolTextField.getText());
                        student.setMajor(majorTextField.getText());
                        TipWindow tipWindow = new TipWindow("保存成功");
                        tipWindow.setVisible(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        TipWindow tipWindow = new TipWindow("系统错误");
                        tipWindow.setVisible(true);
                    }
                } catch (ParseException e1) {
                    e1.printStackTrace();
                    TipWindow tipWindow = new TipWindow("出生年月格式不对");
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

    public InfoWindow(TeacherMenu teacherMenu, Teacher teacher){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("教师信息");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("职工编号");
        numLabel.setBounds(30,10,60,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField(String.valueOf(teacher.getId()));
        numTextField.setEnabled(false);
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名字");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField(teacher.getName());
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学院");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField(teacher.getFaulty());
        schoolTextField.setBounds(60,40,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("系");
        majorLabel.setBounds(190,40,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField(teacher.getDepartment());
        majorTextField.setBounds(220,40,140,20);
        midPanel.add(majorTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("保存");
        JButton backButton = new JButton("返回");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    teacher.setName(nameTextField.getText());
                    teacher.setFaulty(schoolTextField.getText());
                    teacher.setDepartment(majorTextField.getText());
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

    public InfoWindow(DeanMenu deanMenu, Officer officer){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 200);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("教务员信息");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("职工编号");
        numLabel.setBounds(30,10,50,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField(String.valueOf(officer.getId()));
        numTextField.setEnabled(false);
        numTextField.setBounds(80,10,120,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名字");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField(officer.getName());
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel schoolLabel = new JLabel("学院");
        schoolLabel.setBounds(30,40,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField(officer.getFaulty());
        schoolTextField.setBounds(60,40,300,20);
        midPanel.add(schoolTextField);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton saveButton = new JButton("保存");
        JButton backButton = new JButton("返回");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    officer.setName(nameTextField.getText());
                    officer.setFaulty(schoolTextField.getText());
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

    public InfoWindow(ManagerMenu managerMenu, Admin admin, int select) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 220);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label;
        JPanel panel;

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel;
        JTextField numTextField;
        JLabel nameLabel;
        JTextField nameTextField;
        JLabel schoolLabel;
        JTextField schoolTextField;
        JLabel majorLabel;
        JTextField majorTextField;
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton newButton = new JButton("新建");
        JButton searchButton = new JButton("查询");
        JButton saveButton = new JButton("保存");
        JButton backButton = new JButton("返回");
        buttonPanel.add(newButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        switch (select) {
        case 1:
            label = new JLabel("学生信息");
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(label);
            container.add(panel, "North");

            numLabel = new JLabel("学号");
            numLabel.setBounds(30, 10, 30, 20);
            midPanel.add(numLabel);
            numTextField = new JTextField();
            numTextField.setBounds(60, 10, 140, 20);
            midPanel.add(numTextField);
            nameLabel = new JLabel("名字");
            nameLabel.setBounds(210, 10, 30, 20);
            midPanel.add(nameLabel);
            nameTextField = new JTextField();
            nameTextField.setBounds(240, 10, 120, 20);
            midPanel.add(nameTextField);
            JLabel sexLabel = new JLabel("性别");
            sexLabel.setBounds(30, 40, 30, 20);
            midPanel.add(sexLabel);
            JComboBox<String> sexComboBox = new JComboBox<>();
            sexComboBox.addItem("男");
            sexComboBox.addItem("女");
            sexComboBox.setBounds(60, 40, 50, 20);
            midPanel.add(sexComboBox);
            JLabel bornLabel = new JLabel("出生年月");
            bornLabel.setBounds(130, 40, 110, 20);
            midPanel.add(bornLabel);
            JTextField bornTextField = new JTextField();
            bornTextField.setBounds(180, 40, 70, 20);
            midPanel.add(bornTextField);
            schoolLabel = new JLabel("学院");
            schoolLabel.setBounds(30, 70, 30, 20);
            midPanel.add(schoolLabel);
            schoolTextField = new JTextField();
            schoolTextField.setBounds(60, 70, 120, 20);
            midPanel.add(schoolTextField);
            majorLabel = new JLabel("专业");
            majorLabel.setBounds(190, 70, 30, 20);
            midPanel.add(majorLabel);
            majorTextField = new JTextField();
            majorTextField.setBounds(220, 70, 140, 20);
            midPanel.add(majorTextField);
            container.add(midPanel, "Center");

            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date date;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM");
                    try {
                        date = dateFormat.parse(bornTextField.getText());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        try {
                            Student student = admin.newStudent(Integer.parseInt(numTextField.getText()));
                            if(student != null) {
                                student.setName(nameTextField.getText());
                                student.setSex(String.valueOf(sexComboBox.getSelectedItem()));
                                student.setBirthday(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
                                student.setFaulty(schoolTextField.getText());
                                student.setMajor(majorTextField.getText());
                                TipWindow tipWindow = new TipWindow("新建成功");
                                tipWindow.setVisible(true);
                            } else {
                                TipWindow tipWindow = new TipWindow("学号已存在");
                                tipWindow.setVisible(true);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            TipWindow tipWindow = new TipWindow("系统错误");
                            tipWindow.setVisible(true);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        TipWindow tipWindow = new TipWindow("出生年月格式不对");
                        tipWindow.setVisible(true);
                    }
                }
            });

            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Student student = admin.changeStudent(Integer.parseInt(numTextField.getText()));
                        nameTextField.setText(student.getName());
                        sexComboBox.setSelectedItem(student.getSex());
                        bornTextField.setText(student.getBirthdayY() + "." + student.getBirthdayM());
                        schoolTextField.setText(student.getFaulty());
                        majorTextField.setText(student.getMajor());
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
                    Date date;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM");
                    try {
                        date = dateFormat.parse(bornTextField.getText());
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        try {
                            Student student = admin.changeStudent(Integer.parseInt(numTextField.getText()));
                            student.setName(nameTextField.getText());
                            student.setSex(String.valueOf(sexComboBox.getSelectedItem()));
                            student.setBirthday(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
                            student.setFaulty(schoolTextField.getText());
                            student.setMajor(majorTextField.getText());
                            TipWindow tipWindow = new TipWindow("保存成功");
                            tipWindow.setVisible(true);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            TipWindow tipWindow = new TipWindow("系统错误");
                            tipWindow.setVisible(true);
                        }
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                        TipWindow tipWindow = new TipWindow("出生年月格式不对");
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
            break;
        case 2:
            label = new JLabel("教师信息");
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(label);
            container.add(panel,"North");

            numLabel = new JLabel("职工编号");
            numLabel.setBounds(30,10,60,20);
            midPanel.add(numLabel);
            numTextField = new JTextField();
            numTextField.setBounds(80,10,120,20);
            midPanel.add(numTextField);
            nameLabel = new JLabel("名字");
            nameLabel.setBounds(210,10,30,20);
            midPanel.add(nameLabel);
            nameTextField = new JTextField();
            nameTextField.setBounds(240,10,120,20);
            midPanel.add(nameTextField);
            schoolLabel = new JLabel("学院");
            schoolLabel.setBounds(30,40,30,20);
            midPanel.add(schoolLabel);
            schoolTextField = new JTextField();
            schoolTextField.setBounds(60,40,120,20);
            midPanel.add(schoolTextField);
            majorLabel = new JLabel("系");
            majorLabel.setBounds(190,40,30,20);
            midPanel.add(majorLabel);
            majorTextField = new JTextField();
            majorTextField.setBounds(220,40,140,20);
            midPanel.add(majorTextField);
            container.add(midPanel,"Center");

            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Teacher teacher = admin.newTeacher(Integer.parseInt(numTextField.getText()));
                        if(teacher != null) {
                            teacher.setName(nameTextField.getText());
                            teacher.setFaulty(schoolTextField.getText());
                            teacher.setDepartment(majorTextField.getText());
                            TipWindow tipWindow = new TipWindow("新建成功");
                            tipWindow.setVisible(true);
                        } else {
                            TipWindow tipWindow = new TipWindow("职工编号已存在");
                            tipWindow.setVisible(true);
                        }
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
                        Teacher teacher = admin.changeTeacher(Integer.parseInt(numTextField.getText()));
                        nameTextField.setText(teacher.getName());
                        schoolTextField.setText(teacher.getFaulty());
                        majorTextField.setText(teacher.getDepartment());
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
                    try {
                        Teacher teacher = admin.changeTeacher(Integer.parseInt(numTextField.getText()));
                        teacher.setName(nameTextField.getText());
                        teacher.setFaulty(schoolTextField.getText());
                        teacher.setDepartment(majorTextField.getText());
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
            break;
        case 3:
            label = new JLabel("教务员信息");
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.add(label);
            container.add(panel,"North");

            numLabel = new JLabel("职工编号");
            numLabel.setBounds(30,10,50,20);
            midPanel.add(numLabel);
            numTextField = new JTextField();
            numTextField.setBounds(80,10,120,20);
            midPanel.add(numTextField);
            nameLabel = new JLabel("名字");
            nameLabel.setBounds(210,10,30,20);
            midPanel.add(nameLabel);
            nameTextField = new JTextField();
            nameTextField.setBounds(240,10,120,20);
            midPanel.add(nameTextField);
            schoolLabel = new JLabel("学院");
            schoolLabel.setBounds(30,40,30,20);
            midPanel.add(schoolLabel);
            schoolTextField = new JTextField();
            schoolTextField.setBounds(60,40,300,20);
            midPanel.add(schoolTextField);
            container.add(midPanel,"Center");

            newButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Officer officer = admin.newOfficer(Integer.parseInt(numTextField.getText()));
                        if(officer != null) {
                            officer.setName(nameTextField.getText());
                            officer.setFaulty(schoolTextField.getText());
                        } else {
                            TipWindow tipWindow = new TipWindow("职工编号已存在");
                            tipWindow.setVisible(true);
                        }
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
                        Officer officer = admin.changeOfficer(Integer.parseInt(numTextField.getText()));
                        nameTextField.setText(officer.getName());
                        schoolTextField.setText(officer.getFaulty());
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
                    try {
                        Officer officer = admin.changeOfficer(Integer.parseInt(numTextField.getText()));
                        officer.setName(nameTextField.getText());
                        officer.setFaulty(schoolTextField.getText());
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
            break;
        }
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

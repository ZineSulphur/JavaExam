import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoWindow extends JFrame {
    public StudentInfoWindow(StudentMenu studentMenu){
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 400, 220);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("欢迎使用学生成绩管理系统！");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel numLabel = new JLabel("学号");
        numLabel.setBounds(30,10,30,20);
        midPanel.add(numLabel);
        JTextField numTextField = new JTextField();
        numTextField.setBounds(60,10,140,20);
        midPanel.add(numTextField);
        JLabel nameLabel = new JLabel("名字");
        nameLabel.setBounds(210,10,30,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(240,10,120,20);
        midPanel.add(nameTextField);
        JLabel sexLabel = new JLabel("性别");
        sexLabel.setBounds(30,40,30,20);
        midPanel.add(sexLabel);
        JComboBox sexComboBox = new JComboBox();
        sexComboBox.addItem("男");
        sexComboBox.addItem("女");
        sexComboBox.setBounds(60,40,50,20);
        midPanel.add(sexComboBox);
        JLabel bornLabel = new JLabel("出生年月");
        bornLabel.setBounds(130,40,110,20);
        midPanel.add(bornLabel);
        JTextField bornTextField = new JTextField();
        bornTextField.setBounds(180,40,70,20);
        midPanel.add(bornTextField);
        JLabel schoolLabel = new JLabel("学院");
        schoolLabel.setBounds(30,70,30,20);
        midPanel.add(schoolLabel);
        JTextField schoolTextField = new JTextField();
        schoolTextField.setBounds(60,70,120,20);
        midPanel.add(schoolTextField);
        JLabel majorLabel = new JLabel("专业");
        majorLabel.setBounds(190,70,30,20);
        midPanel.add(majorLabel);
        JTextField majorTextField = new JTextField();
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
                TipWindow tipWindow = new TipWindow("保存成功");
                tipWindow.setVisible(true);
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

    public void closeThisWindow() {
        this.dispose();
    }
}

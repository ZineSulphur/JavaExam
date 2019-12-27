import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

public class RankWindow extends JFrame {
    public RankWindow(DeanMenu deanMenu, Officer officer) {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 400);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel label = new JLabel("输入课程名称排名");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        container.add(panel,"North");

        JPanel midPanel = new JPanel();
        midPanel.setLayout(null);
        JLabel nameLabel = new JLabel("课程名称");
        nameLabel.setBounds(30,10,50,20);
        midPanel.add(nameLabel);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(80,10,120,20);
        midPanel.add(nameTextField);
        JLabel numLabel = new JLabel("排名");
        numLabel.setBounds(30,30,50,20);
        midPanel.add(numLabel);
        String[] name = {"学生姓名", "成绩"};
        DefaultTableModel model = new DefaultTableModel(null, name) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80, 30, 200, 200);
        midPanel.add(scrollPane);
        container.add(midPanel,"Center");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton searchButton = new JButton("排名");
        buttonPanel.add(searchButton);
        JButton backButton = new JButton("返回");
        buttonPanel.add(backButton);
        container.add(buttonPanel,"South");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Grade[] grades = officer.ranking(nameTextField.getText());
                    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                    for (Grade grade : grades) {
                        tableModel.addRow(new Object[] {grade.getStudent(), grade.getGrade()});
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    TipWindow tipWindow = new TipWindow("系统错误");
                    tipWindow.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deanMenu.setVisible(true);
                closeThisWindow();
            }
        });
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

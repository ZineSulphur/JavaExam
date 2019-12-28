import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipWindow extends JFrame {
    public TipWindow(String tip){
        setTitle("提示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 250, 100);

        Container container = getContentPane();
        container.setLayout(new GridLayout(2,1));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel(tip);
        panel1.add(label);
        container.add(panel1);

        JPanel panel2 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton backButton = new JButton("确定");
        panel2.add(backButton);
        container.add(panel2);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeThisWindow();
            }
        });
    }

    public void closeThisWindow() {
        this.dispose();
    }
}

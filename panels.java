import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// import javax.swing.plaf.PanelUI;

public class panels {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("Hello, This is my first panel work in java!");
        label.setFont(new Font("Times new Roman",Font.ITALIC,14));
        label.setBounds(250, 125, 0, 0);
        label.setForeground(Color.white);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.yellow);
        panel1.setBounds(0, 0, 250,250);
        panel1.setOpaque(true);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        panel2.setBounds(250, 0, 250,250);
        panel2.setOpaque(true);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setBounds(0,250,250,250);
        panel3.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setSize(750,750);
        frame.setTitle("Panels");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        panel2.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class flowlayout {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.black);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        
        JPanel p = new JPanel();
        p.setPreferredSize(new DimensionUIResource(250, 200));
        p.setBackground(Color.gray);
        p.setLayout(new FlowLayout());
        
        JButton b1= new JButton();
        JButton b2= new JButton();
        JButton b3= new JButton();
        JButton b4= new JButton();
        JButton b5= new JButton();
        JButton b6= new JButton();
        JButton b7= new JButton();
        JButton b8= new JButton();
        JButton b9= new JButton();
        
        b1.setText("1");
        b2.setText("2");
        b3.setText("3");
        b4.setText("4");
        b5.setText("5");
        b6.setText("6");
        b7.setText("7");
        b8.setText("8");
        b9.setText("9");
        
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b6.setFocusable(false);
        b7.setFocusable(false);
        b8.setFocusable(false);
        b9.setFocusable(false);
        
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        frame.add(p);
        frame.setVisible(true);



    }
}

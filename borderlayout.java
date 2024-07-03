import java.awt.Color;

// import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class borderlayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();


        p1.setBackground(Color.red);
        p2.setBackground(Color.blue);
        p3.setBackground(Color.green);
        p4.setBackground(Color.cyan);
        p5.setBackground(Color.pink);

        p1.setPreferredSize(new DimensionUIResource(100, 100));
        p2.setPreferredSize(new DimensionUIResource(100, 100));
        p3.setPreferredSize(new DimensionUIResource(100, 100));
        p4.setPreferredSize(new DimensionUIResource(100, 100));
        p5.setPreferredSize(new DimensionUIResource(100, 100));

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.WEST);
        frame.add(p3,BorderLayout.EAST);
        frame.add(p4,BorderLayout.SOUTH);
        frame.add(p5,BorderLayout.CENTER);

    }
}

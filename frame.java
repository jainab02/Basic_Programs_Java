import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class frame {
    public static void main(String[] args) {

        JLabel label = new JLabel();  //create label
        ImageIcon image = new ImageIcon("images.png");  
        Border border = BorderFactory.createLineBorder(Color.black,10);

        label.setText("What are you doing?"); //set text to the label
        label.setIcon(image); //inserting image to the frame
        label.setHorizontalTextPosition(SwingConstants.CENTER); //set text left center right imageicon
        label.setVerticalTextPosition(SwingConstants.TOP); //set text to top,center and bottom of imageicon
        label.setForeground(Color.RED); //set font color
        label.setFont(new Font("MV Boli",Font.BOLD,20)); //set font of text
        label.setIconTextGap(12);  //gap between text and image
        label.setBackground(Color.blue);   //bg 
        label.setOpaque(true);  //enabling the bg
        label.setBorder(border);  //adding border created above
        label.setVerticalAlignment(JLabel.CENTER);   // moving it in centre
        label.setHorizontalAlignment(JLabel.CENTER);
        // label. setBounds(10, 20, 500, 500);

        JFrame frame =new JFrame();
        frame.setTitle("First frame");
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.gray);
    }
}

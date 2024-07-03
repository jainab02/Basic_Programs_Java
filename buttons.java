import java.awt.Color;
import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

// public class buttons extends JFrame implements ActionListener{

public class buttons extends JFrame {

    JButton btn;

    buttons(){
        ImageIcon image = new ImageIcon("images.png");
        Border border = BorderFactory.createLineBorder(Color.BLACK,5);
        btn = new JButton();
        btn.setBounds(200, 150, 350, 250);
        btn.setForeground(Color.blue);
        btn.setFocusable(false);
        btn.setText("Name?");
        btn.setIcon(image);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setFont(new Font("times new roman",Font.BOLD,15));
        btn.setBorder(border);

        btn.addActionListener(e -> System.out.println("Hey"));
        this.setTitle("This is button!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);   
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.add(btn);
    
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource()==btn){
    //         System.out.println("Hie");
            
    //     }
    // }

}

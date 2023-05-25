import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private  JFrame frame;
    MyFrame(JPanel inputSection,JPanel logoSection){
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,2));
        frame.setSize(1200,800);
        frame.setTitle("Student Management");
        frame.setVisible(true);
//        frame.setResizable(false);

        Rectangle size = frame.getBounds();
        int w1 = size.width/2;
        int w2 = size.width/2;
        inputSection.setPreferredSize(new Dimension(w1,size.height));
        logoSection.setPreferredSize(new Dimension(w2,size.height));
        frame.add(inputSection,BorderLayout.WEST);
        frame.add(logoSection,BorderLayout.EAST);

        frame.pack();
    }

    public JFrame getFrame(){
        return this.frame;
    }


}

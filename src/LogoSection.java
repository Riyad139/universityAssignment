import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LogoSection extends JFrame {
    JPanel logoSection ;
    LogoSection(){
        ImageIcon logo = new ImageIcon("src/Logo/diu2.png");

      ImageIcon newImg = new ImageIcon(getScaledImage(logo.getImage(),350,300));

        logoSection = new JPanel();
        logoSection.setLayout(new GridLayout(1,1));
        JLabel label = new JLabel();
        label.setBackground(new Color(0xF1F6F9));
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(newImg);
        logoSection.add(label,BorderLayout.CENTER);
    }

    public JPanel getLogoSection(){
        return logoSection;
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}

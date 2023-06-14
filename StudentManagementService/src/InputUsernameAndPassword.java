import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class InputUsernameAndPassword extends JFrame {
    LoginForm loginForm;
    InputUsernameAndPassword(){
     loginForm = new LoginForm();
//     loginForm.LogInForm.setBackground(new Color(0x76b8f7));
//     loginForm.loginButton.setFocusable(false);
//     loginForm.loginButton.setBackground(new Color(0x0060af));
//     loginForm.loginButton.setFont(new Font("roboto",Font.PLAIN,20));
//     loginForm.loginButton.setForeground(new Color(0xffffff));
//     loginForm.usrname.setFont(new Font("roboto",Font.PLAIN,20));
//     loginForm.usrname.setFont(new Font("roboto",Font.PLAIN,20));
//     loginForm.welcome.setFont(new Font("roboto",Font.BOLD,70));
    }

  public  JPanel getPanel(){
        return loginForm.LogInForm;
  }
  public LoginForm getLoginForm(){
        return this.loginForm;
  }

}

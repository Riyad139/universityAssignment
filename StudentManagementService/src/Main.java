import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        InputUsernameAndPassword inputUsernameAndPassword = new InputUsernameAndPassword();
        JPanel inputArea =  inputUsernameAndPassword.getPanel();
        JPanel logoSection = new LogoSection().getLogoSection();
        LoginForm loginForm = inputUsernameAndPassword.getLoginForm();

       JFrame frame =  new MyFrame(inputArea,logoSection).getFrame();

       JFrame dashBoard = new StudentDashBoard().getFrame();

       loginForm.loginButton.addActionListener(e->{
            if(loginForm.username.getText().toLowerCase().compareTo("admin") == 0 &&
                    loginForm.password.getText().toLowerCase().compareTo("admin") == 0
            ) {
                frame.setVisible(false);
                dashBoard.setVisible(true);
            }

        });
    }
}
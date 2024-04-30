import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfEmail;
    JPasswordField pfPassword;

    public void initialize(){
        //panel
        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        //BUTTONS
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                User user = getAuthenticatedUser(email, password);

                if(user !=null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(LoginForm.this,
                    "Email or Password Invalid",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });

        //New Panel
        add(formPanel, BorderLayout.NORTH);







        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

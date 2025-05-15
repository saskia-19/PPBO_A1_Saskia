import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    //bikin login dulu, baru nyambut doang sama masukin nama doang sih
    public LoginPage(){
        setTitle("Login Page");
        setSize(300,200);
        setLocationRelativeTo(null); //Pertama muncul di tengah layar = null, kalo di kiri kanan apa tadi? = pake koordinat tentuin x berapa y berapa
        setLayout(new BorderLayout()); //ada west, east, center, north, dan south

        //ini kasih text gitu, bisa ganti font dan ukuran juga, posisi juga bisa diatur pake BorderLayout
        JLabel titleLabel = new JLabel("Selamat Datang!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        //ini kita kasih button
        JButton loginButton = new JButton("Login");
        add(loginButton, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel(new GridLayout(3,2));//auto ke center layout kah?
        add(inputPanel);

        JLabel labelUsername = new JLabel("Username : ");
        inputPanel.add(labelUsername);
        JTextField usernameField = new JTextField();
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Password : "));
        JPasswordField passwordField = new JPasswordField();
        inputPanel.add(passwordField);

        loginButton.addActionListener(e->{
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if(username.equals("Admin") && password.equals("12345")){
                JOptionPane.showMessageDialog(this, "Login Success");
                dispose();
                new Dashboard().setVisible(true);
            }
            else JOptionPane.showMessageDialog(this, "Username atau password salah");
        });
    }
}

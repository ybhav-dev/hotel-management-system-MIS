package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

  JTextField username;
  JPasswordField password;
  JButton login, cancel;

  Login() {
    getContentPane().setBackground(Color.white);
    setLayout(null);
    setResizable(false);
    setTitle("Login");
    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 600, 300);
    add(image);

    JLabel text = new JLabel("User Login");
    text.setBounds(200, 10, 800, 50);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif", Font.PLAIN, 40));
    image.add(text);

    JLabel user = new JLabel("Username");
    user.setForeground(Color.white);
    user.setBounds(150, 80, 100, 30);
    image.add(user);
    username = new JTextField();
    username.setBounds(260, 80, 150, 30);
    image.add(username);

    JLabel pass = new JLabel("Password");
    pass.setForeground(Color.white);
    pass.setBounds(150, 130, 100, 30);
    image.add(pass);
    password = new JPasswordField();
    password.setBounds(260, 130, 150, 30);
    image.add(password);

    login = new JButton("Login");
    login.setBounds(160, 180, 120, 30);
    login.setBackground(Color.white);
    login.setForeground(Color.black);
    login.addActionListener(this);
    image.add(login);

    cancel = new JButton("Cancel");
    cancel.setBounds(290, 180, 120, 30);
    cancel.setBackground(Color.white);
    cancel.setForeground(Color.black);
    cancel.addActionListener(this);
    image.add(cancel);

    // ImageIcon i1 = new
    // ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
    // Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    // JLabel lockImage = new JLabel(new ImageIcon(i2));
    // lockImage.setBounds(350, 10, 200, 200);
    // image.add(lockImage);

    setBounds(480, 250, 600, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Login();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == login) {
      String user = username.getText();
      String pass = password.getText();

      try {
        Conn c = new Conn();
        String query = "select * from login where username = '" + user + "' and password ='" + pass + "'";

        ResultSet rs = c.s.executeQuery(query);
        if (rs.next()) {
          setVisible(false);
          new Dashboard();
        } else {
          JOptionPane.showMessageDialog(null, "Invalid username or password");
          setVisible(false);
        }
      } catch (Exception ex) {
      }
    } else if (e.getSource() == cancel) {
      setVisible(false);
    }
  }
}
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutApp extends JFrame implements ActionListener {

  JLabel aboutApp;
  JButton back;

  AboutApp() {

    setLayout(null);
    setTitle("About App");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    aboutApp = new JLabel(
        "<html>The code represents a Hotel Management System's dashboard using Java Swing. The visually appealing dashboard features key functionalities like adding employees, rooms, and drivers, accessible through an intuitive menu structure. The application's aesthetic is enhanced by a dynamic background and engaging font styles. Employing event handling, it enables seamless navigation and functionality. The dashboard is a user-friendly interface for managing various aspects of a hotel business, offering a solid foundation for further expansion and refinement.</html>");

    aboutApp.setHorizontalAlignment(JLabel.CENTER);
    aboutApp.setVerticalAlignment(JLabel.CENTER);
    aboutApp.setFont(new Font("Arial", Font.PLAIN, 25));
    aboutApp.setForeground(Color.WHITE);
    aboutApp.setBounds(35, 45, 780, 350);
    image.add(aboutApp);

    back = new JButton("Back");
    back.setForeground(Color.black);
    back.setBackground(Color.white);
    back.addActionListener(this);
    back.setBounds(350, 400, 150, 30);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new AboutApp();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      setVisible(false);
    }
  }
}

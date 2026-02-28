package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setTitle("Sapphire Skies");

        // Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        // setIconImage(icon);

        ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 800);
        add(image);

        JLabel welcomeText = new JLabel("Welcome To Hotel");
        welcomeText.setBounds(500, 120, 400, 90);
        welcomeText.setForeground(Color.WHITE);
        welcomeText.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(welcomeText);

        JLabel text = new JLabel("Sapphire Skies");
        text.setBounds(400, 180, 800, 140);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 100));
        image.add(text);

        JLabel mis = new JLabel("Hotel Management System");
        mis.setBounds(10, 690, 400, 90);
        mis.setForeground(Color.WHITE);
        mis.setFont(new Font("serif", Font.PLAIN, 30));
        image.add(mis);

        JButton next = new JButton("Next");
        next.setBounds(1250, 700, 120, 40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.BOLD, 18));
        image.add(next);

        setBounds(75, 10, 1400, 800);
        setVisible(true);

        while (true) {
            mis.setVisible(false);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mis.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}

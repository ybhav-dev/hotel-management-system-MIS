package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem addemp, aboutUs, aboutApp, addrooms, reception;

    Dashboard() {

        setLayout(null);
        setResizable(false);
        setTitle("Dashboard");

        ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 800);
        add(image);

        JLabel text = new JLabel("SAPPHIRE SKIES WELCOMES YOU");
        text.setBounds(245, 30, 1200, 90);
        text.setFont(new Font("Arial", Font.PLAIN, 50));
        text.setForeground(Color.WHITE);
        image.add(text);

        JLabel mis = new JLabel("Hotel Management System");
        mis.setBounds(10, 690, 400, 90);
        mis.setForeground(Color.WHITE);
        mis.setFont(new Font("serif", Font.PLAIN, 30));
        image.add(mis);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);

        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);

        addemp = new JMenuItem("ADD EMPLOYEE");
        admin.add(addemp);
        addemp.addActionListener(this);

        addrooms = new JMenuItem("ADD ROOMS");
        admin.add(addrooms);
        addrooms.addActionListener(this);

        JMenu info = new JMenu("HELP");
        info.setForeground(Color.BLACK);
        mb.add(info);

        aboutApp = new JMenuItem("ABOUT APP");
        info.add(aboutApp);
        aboutApp.addActionListener(this);

        aboutUs = new JMenuItem("ABOUT US");
        info.add(aboutUs);
        aboutUs.addActionListener(this);

        setBounds(75, 10, 1400, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addemp) {
            new AddEmployee();
        } else if (e.getSource() == aboutApp) {
            new AboutApp();
        } else if (e.getSource() == addrooms) {
            new AddRooms();
        } else if (e.getSource() == reception) {
            new Reception();
        }
    }
}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class RoomInfo extends JFrame implements ActionListener {
  JTable table;
  JButton back;

  RoomInfo() {
    setLayout(null);
    setTitle("Room Information");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel("Room Information");
    head.setBounds(260, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(185, 100, 100, 20);
    image.add(l1);

    JLabel l2 = new JLabel("Availability");
    l2.setBounds(285, 100, 100, 20);
    image.add(l2);

    JLabel l3 = new JLabel("Status");
    l3.setBounds(385, 100, 100, 20);
    image.add(l3);

    JLabel l4 = new JLabel("Price");
    l4.setBounds(485, 100, 100, 20);
    image.add(l4);

    JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(585, 100, 100, 20);
    image.add(l5);

    table = new JTable();
    table.setBounds(175, 120, 500, 300);
    image.add(table);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from room");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(365, 440, 120, 30);
    back.addActionListener(this);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);

  }

  public static void main(String[] args) {
    new RoomInfo();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }

}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
  JTable table;
  JButton back;

  CustomerInfo() {
    setLayout(null);
    setTitle("Employee Information");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel("Customer Information");
    head.setBounds(240, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel l1 = new JLabel("Document Type");
    l1.setBounds(10, 100, 100, 20);
    image.add(l1);

    JLabel l2 = new JLabel("Number");
    l2.setBounds(130, 100, 100, 20);
    image.add(l2);

    JLabel l3 = new JLabel("Name");
    l3.setBounds(250, 100, 100, 20);
    image.add(l3);

    JLabel l4 = new JLabel("Gender");
    l4.setBounds(350, 100, 100, 20);
    image.add(l4);

    JLabel l5 = new JLabel("Country");
    l5.setBounds(450, 100, 100, 20);
    image.add(l5);

    JLabel l6 = new JLabel("Room Number");
    l6.setBounds(530, 100, 100, 20);
    image.add(l6);

    JLabel l7 = new JLabel("Checkin Time");
    l7.setBounds(640, 100, 100, 20);
    image.add(l7);

    JLabel l8 = new JLabel("Deposit");
    l8.setBounds(760, 100, 100, 20);
    image.add(l8);

    table = new JTable();
    table.setBounds(0, 120, 837, 300);
    image.add(table);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from customer");
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
    new CustomerInfo();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }

}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
  JTable table;
  JButton back;

  ManagerInfo() {
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

    JLabel head = new JLabel("Manager Information");
    head.setBounds(240, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel l1 = new JLabel("Name");
    l1.setBounds(45, 100, 100, 20);
    image.add(l1);

    JLabel l2 = new JLabel("Age");
    l2.setBounds(160, 100, 100, 20);
    image.add(l2);

    JLabel l3 = new JLabel("Gender");
    l3.setBounds(260, 100, 100, 20);
    image.add(l3);

    JLabel l4 = new JLabel("Job");
    l4.setBounds(410, 100, 100, 20);
    image.add(l4);

    JLabel l5 = new JLabel("Salary");
    l5.setBounds(520, 100, 100, 20);
    image.add(l5);

    JLabel l6 = new JLabel("Phone");
    l6.setBounds(630, 100, 100, 20);
    image.add(l6);

    JLabel l7 = new JLabel("Email");
    l7.setBounds(760, 100, 100, 20);
    image.add(l7);

    table = new JTable();
    table.setBounds(0, 120, 837, 300);
    image.add(table);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from employee where job='Manager'");
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
    new ManagerInfo();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }

}

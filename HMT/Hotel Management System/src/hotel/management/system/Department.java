package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
  JTable table;
  JButton back;

  Department() {
    setLayout(null);
    setTitle("Departments");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel("Department Information");
    head.setBounds(210, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel l1 = new JLabel("Department");
    l1.setBounds(240, 100, 100, 20);
    image.add(l1);

    JLabel l2 = new JLabel("Budgets");
    l2.setBounds(506, 100, 100, 20);
    image.add(l2);

    table = new JTable();
    table.setBounds(175, 120, 500, 200);
    image.add(table);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from department");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(365, 370, 120, 30);
    back.addActionListener(this);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);

  }

  public static void main(String[] args) {
    new Department();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }

}

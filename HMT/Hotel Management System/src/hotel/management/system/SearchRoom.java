package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
  JTable table;
  JButton back, submit;
  JComboBox bedType;
  JCheckBox available;

  SearchRoom() {
    setLayout(null);
    setTitle("Search Rooms");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel(" Search for Room");
    head.setBounds(240, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel lbbed = new JLabel("Bed Type");
    lbbed.setBounds(100, 100, 100, 20);
    image.add(lbbed);

    bedType = new JComboBox<>(new String[] { "Single Bed", "Double Bed" });
    bedType.setBounds(165, 100, 100, 20);
    bedType.setBackground(Color.WHITE);
    image.add(bedType);

    available = new JCheckBox("Available Rooms");
    available.setBounds(620, 100, 145, 20);
    available.setBackground(Color.WHITE);
    image.add(available);

    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(30, 155, 100, 20);
    image.add(l1);

    JLabel l2 = new JLabel("Availability");
    l2.setBounds(200, 155, 100, 20);
    image.add(l2);

    JLabel l3 = new JLabel("Status");
    l3.setBounds(385, 155, 100, 20);
    image.add(l3);

    JLabel l4 = new JLabel("Price");
    l4.setBounds(555, 155, 100, 20);
    image.add(l4);

    JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(725, 155, 100, 20);
    image.add(l5);

    table = new JTable();
    table.setBounds(0, 175, 850, 129);
    image.add(table);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from room");
      table.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
      e.printStackTrace();
    }

    submit = new JButton("Submit");
    submit.setBackground(Color.white);
    submit.setForeground(Color.black);
    submit.setBounds(265, 360, 120, 30);
    submit.addActionListener(this);
    image.add(submit);

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(465, 360, 120, 30);
    back.addActionListener(this);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);

  }

  public static void main(String[] args) {
    new SearchRoom();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      try {
        String str = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
        String str1 = "select * from room where availability = 'Available' AND bed_type = '"
            + bedType.getSelectedItem() + "'";

        Conn c = new Conn();
        ResultSet rs;
        if (available.isSelected()) {
          rs = c.s.executeQuery(str1);
        } else {
          rs = c.s.executeQuery(str);
        }
        table.setModel(DbUtils.resultSetToTableModel(rs));

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (e.getSource() == back) {
      setVisible(false);
      new Reception();
    }
  }

}

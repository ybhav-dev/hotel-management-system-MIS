package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {

  Choice cCustomer;
  JTextField tfRoom, tfAvailability, tfStatus;
  JButton check, back, update;

  UpdateRoom() {
    setLayout(null);
    setTitle("Update Room");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel(" Update Room");
    head.setBounds(240, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel lblId = new JLabel("Custome Id");
    lblId.setBounds(90, 150, 100, 20);
    lblId.setForeground(Color.white);
    image.add(lblId);

    cCustomer = new Choice();
    cCustomer.setBounds(200, 150, 100, 20);
    image.add(cCustomer);
    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from customer");
      while (rs.next()) {
        cCustomer.add(rs.getString("number"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    JLabel lblRoom = new JLabel("Room Number");
    lblRoom.setBounds(90, 180, 100, 20);
    lblRoom.setForeground(Color.white);
    image.add(lblRoom);

    tfRoom = new JTextField();
    tfRoom.setBounds(200, 180, 100, 20);
    image.add(tfRoom);

    JLabel lblAvailability = new JLabel("Availability");
    lblAvailability.setBounds(90, 210, 100, 20);
    lblAvailability.setForeground(Color.white);
    image.add(lblAvailability);

    tfAvailability = new JTextField();
    tfAvailability.setBounds(200, 210, 100, 20);
    image.add(tfAvailability);

    JLabel lblStatus = new JLabel("Cleaning Status");
    lblStatus.setBounds(90, 240, 100, 20);
    lblStatus.setForeground(Color.white);
    image.add(lblStatus);

    tfStatus = new JTextField();
    tfStatus.setBounds(200, 240, 100, 20);
    image.add(tfStatus);

    check = new JButton("Check");
    check.setBackground(Color.white);
    check.setForeground(Color.black);
    check.setBounds(90, 340, 100, 30);
    check.addActionListener(this);
    image.add(check);

    update = new JButton("Update");
    update.setBackground(Color.white);
    update.setForeground(Color.black);
    update.setBounds(200, 340, 100, 30);
    update.addActionListener(this);
    image.add(update);

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(310, 340, 100, 30);
    back.addActionListener(this);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new UpdateRoom();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == check) {
      String id = cCustomer.getSelectedItem();
      String query = "select * from customer where number = '" + id + "'";
      try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        while (rs.next()) {
          tfRoom.setText(rs.getString("room"));
        }
        ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber ='" + tfRoom.getText() + "'");
        while (rs2.next()) {
          tfAvailability.setText(rs2.getString("availability"));
          tfStatus.setText(rs2.getString("cleaning_status"));
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (e.getSource() == update) {
      String number = cCustomer.getSelectedItem();
      String room = tfRoom.getText();
      String name = tfAvailability.getText();
      String checkin = tfStatus.getText();

      try {
        Conn c = new Conn();
        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
        setVisible(false);
        new Reception();

      } catch (Exception a) {
        a.printStackTrace();
      }

    } else {
      setVisible(false);
      new Reception();
    }

  }
}
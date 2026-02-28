package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
  Choice cCustomer;
  JLabel roomNumber, checkinTime, checkOutTime;
  JButton checkout, back;

  Checkout() {
    setLayout(null);
    setTitle("Checkout");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel("Checkout");
    head.setBounds(330, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel lblid = new JLabel("Customer Id");
    lblid.setBounds(30, 100, 150, 30);
    lblid.setForeground(Color.white);
    lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
    image.add(lblid);

    cCustomer = new Choice();
    cCustomer.setBounds(190, 100, 150, 30);
    image.add(cCustomer);

    JLabel lblRoom = new JLabel("Room Number");
    lblRoom.setBounds(30, 140, 150, 30);
    lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblRoom.setForeground(Color.white);
    image.add(lblRoom);

    roomNumber = new JLabel();
    roomNumber.setBounds(190, 140, 100, 30);
    roomNumber.setForeground(Color.white);
    image.add(roomNumber);

    JLabel lblCheckin = new JLabel("Checkin Time");
    lblCheckin.setBounds(30, 180, 150, 30);
    lblCheckin.setForeground(Color.white);
    lblCheckin.setFont(new Font("Tahoma", Font.PLAIN, 20));
    image.add(lblCheckin);

    checkinTime = new JLabel();
    checkinTime.setBounds(190, 180, 150, 30);
    checkinTime.setForeground(Color.white);
    image.add(checkinTime);

    JLabel lblCheckout = new JLabel("Checkout Time");
    lblCheckout.setBounds(30, 220, 150, 30);
    lblCheckout.setForeground(Color.white);
    lblCheckout.setFont(new Font("Tahoma", Font.PLAIN, 20));
    image.add(lblCheckout);

    Date date = new Date();
    checkOutTime = new JLabel("" + date);
    checkOutTime.setBounds(190, 220, 150, 30);
    checkOutTime.setForeground(Color.white);
    image.add(checkOutTime);

    checkout = new JButton("Checkout");
    checkout.setBackground(Color.white);
    checkout.setForeground(Color.black);
    checkout.setBounds(270, 340, 120, 30);
    checkout.addActionListener(this);
    image.add(checkout);

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(410, 340, 120, 30);
    back.addActionListener(this);
    image.add(back);

    try {
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from customer");
      while (rs.next()) {
        cCustomer.add(rs.getString("number"));
        roomNumber.setText(rs.getString("room"));
        checkinTime.setText(rs.getString("checkintime"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    setBounds(350, 160, 850, 540);
    setVisible(true);

  }

  public static void main(String[] args) {
    new Checkout();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == checkout) {
      String query = "delete from customer where number = '" + cCustomer.getSelectedItem() + "'";
      String query2 = "update room set availability = 'Available' where roomnumber = '" + roomNumber.getText() + "'";

      try {
        Conn c = new Conn();
        c.s.executeUpdate(query);
        c.s.executeUpdate(query2);

        JOptionPane.showMessageDialog(null, "Checkout Done");
        setVisible(false);
        new Reception();

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else {
      setVisible(false);
      new Reception();
    }

  }
}

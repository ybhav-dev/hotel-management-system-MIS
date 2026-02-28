package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

  JComboBox comboId;
  JTextField tfNumber, tfName, tfCountry, tfDeposit;
  JRadioButton rMale, rFemale;
  Choice cRoom;
  JLabel checkingTime;
  JButton add, back;

  AddCustomer() {
    setLayout(null);
    setTitle("Add Customer");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel head = new JLabel("New Customer Form");
    head.setBounds(240, 25, 600, 45);
    head.setFont(new Font("Tahoma", Font.PLAIN, 40));
    head.setForeground(Color.white);
    image.add(head);

    JLabel lblId = new JLabel("ID");
    lblId.setBounds(35, 80, 100, 20);
    lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblId.setForeground(Color.white);
    image.add(lblId);

    String options[] = { "Aadhar", "Passport", "License" };
    comboId = new JComboBox(options);
    comboId.setBounds(200, 80, 150, 25);
    comboId.setBackground(Color.white);
    image.add(comboId);

    JLabel lblNum = new JLabel("Number");
    lblNum.setBounds(35, 120, 100, 20);
    lblNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblNum.setForeground(Color.white);
    image.add(lblNum);

    tfNumber = new JTextField();
    tfNumber.setBounds(200, 120, 150, 20);
    image.add(tfNumber);

    JLabel lblName = new JLabel("Name");
    lblName.setBounds(35, 160, 100, 20);
    lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblName.setForeground(Color.white);
    image.add(lblName);

    tfName = new JTextField();
    tfName.setBounds(200, 160, 150, 20);
    image.add(tfName);

    JLabel lblGender = new JLabel("Gender");
    lblGender.setBounds(35, 200, 100, 20);
    lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblGender.setForeground(Color.white);
    image.add(lblGender);

    rMale = new JRadioButton("Male");
    rMale.setBackground(Color.white);
    rMale.setBounds(200, 200, 60, 25);
    image.add(rMale);

    rFemale = new JRadioButton("Female");
    rFemale.setBackground(Color.white);
    rFemale.setBounds(270, 200, 80, 25);
    image.add(rFemale);

    JLabel lblCountry = new JLabel("Country");
    lblCountry.setBounds(35, 240, 100, 20);
    lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblCountry.setForeground(Color.white);
    image.add(lblCountry);

    tfCountry = new JTextField();
    tfCountry.setBounds(200, 240, 150, 20);
    image.add(tfCountry);

    JLabel lblRoom = new JLabel("Room Number");
    lblRoom.setBounds(35, 280, 150, 20);
    lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblRoom.setForeground(Color.white);
    image.add(lblRoom);

    cRoom = new Choice();
    try {
      Conn conn = new Conn();
      String query = "select * from room where availability ='Available'";
      ResultSet rs = conn.s.executeQuery(query);
      while (rs.next()) {
        cRoom.add(rs.getString("roomnumber"));
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
    cRoom.setBounds(200, 280, 150, 25);
    image.add(cRoom);

    JLabel checking = new JLabel("Checking Time");
    checking.setBounds(35, 320, 150, 20);
    checking.setFont(new Font("Tahoma", Font.PLAIN, 20));
    checking.setForeground(Color.white);
    image.add(checking);

    Date date = new Date();
    checkingTime = new JLabel("" + date);
    checkingTime.setBounds(200, 320, 150, 25);
    checkingTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
    checkingTime.setForeground(Color.white);
    image.add(checkingTime);

    JLabel lblDeposit = new JLabel("Deposit");
    lblDeposit.setBounds(35, 360, 100, 20);
    lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblDeposit.setForeground(Color.white);
    image.add(lblDeposit);

    tfDeposit = new JTextField();
    tfDeposit.setBounds(200, 360, 150, 20);
    image.add(tfDeposit);

    add = new JButton("Add");
    add.setBackground(Color.white);
    add.setForeground(Color.black);
    add.setBounds(50, 410, 120, 30);
    add.addActionListener(this);
    image.add(add);

    back = new JButton("Back");
    back.setBackground(Color.white);
    back.setForeground(Color.black);
    back.setBounds(200, 410, 120, 30);
    back.addActionListener(this);
    image.add(back);

    setBounds(350, 160, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new AddCustomer();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == add) {
      String id = (String) comboId.getSelectedItem();
      String num = tfNumber.getText();
      String name = tfName.getText();
      String gender = null;
      if (rMale.isSelected()) {
        gender = "Male";
      } else {
        gender = "Female";
      }
      String country = tfCountry.getText();
      String room = cRoom.getSelectedItem();
      String time = checkingTime.getText();
      String deposit = tfDeposit.getText();

      try {
        String query = "INSERT INTO customer (document, number, name, gender, country, room, checkintime, deposit) VALUES ('"
            + id + "','" + num + "','" + name + "','" + gender + "','"
            + country + "','" + room + "','" + time + "','" + deposit + "')";

        String query2 = "update room set availability = 'Occupied' where roomnumber ='" + room + "'";

        Conn conn = new Conn();
        conn.s.executeUpdate(query);
        conn.s.executeUpdate(query2);

        JOptionPane.showMessageDialog(null, "New Customer Added");
        setVisible(false);
        new Reception();

      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (e.getSource() == back) {
      setVisible(false);
      new Reception();

    }

  }

}

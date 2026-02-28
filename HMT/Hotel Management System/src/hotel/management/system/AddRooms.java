package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class AddRooms extends JFrame implements ActionListener {
  JButton cancel, add;
  JTextField tfroom, tfprice;
  JComboBox typeCombo, availCombo, cleanCombo;

  AddRooms() {
    setLayout(null);
    setTitle("Add Rooms");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel heading = new JLabel("Add Rooms");
    heading.setFont(new Font("serif", Font.PLAIN, 40));
    heading.setBounds(330, 60, 600, 45);
    heading.setForeground(Color.WHITE);
    image.add(heading);

    JLabel lblRoom = new JLabel("Room Number");
    lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblRoom.setBounds(100, 140, 120, 30);
    lblRoom.setForeground(Color.WHITE);
    image.add(lblRoom);

    tfroom = new JTextField();
    tfroom.setBounds(240, 140, 150, 30);
    image.add(tfroom);

    JLabel lblAvail = new JLabel("Available");
    lblAvail.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblAvail.setBounds(410, 140, 120, 30);
    lblAvail.setForeground(Color.WHITE);
    image.add(lblAvail);

    String availOption[] = { "Available", "Occupied" };
    availCombo = new JComboBox(availOption);
    availCombo.setBounds(550, 140, 150, 30);
    availCombo.setBackground(Color.white);
    image.add(availCombo);

    JLabel lblClean = new JLabel("Cleaning Status");
    lblClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblClean.setBounds(100, 190, 120, 30);
    lblClean.setForeground(Color.WHITE);
    image.add(lblClean);

    String cleanOption[] = { "Cleaned", "Dirty" };
    cleanCombo = new JComboBox(cleanOption);
    cleanCombo.setBounds(240, 190, 150, 30);
    cleanCombo.setBackground(Color.white);
    image.add(cleanCombo);

    JLabel lblprice = new JLabel("Price");
    lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblprice.setBounds(410, 190, 120, 30);
    lblprice.setForeground(Color.WHITE);
    image.add(lblprice);

    tfprice = new JTextField();
    tfprice.setBounds(550, 190, 150, 30);
    image.add(tfprice);

    JLabel lbltype = new JLabel("Bed Type");
    lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lbltype.setBounds(100, 240, 120, 30);
    lbltype.setForeground(Color.WHITE);
    image.add(lbltype);

    String typeOption[] = { "Single Bed", "Double Bed" };
    typeCombo = new JComboBox(typeOption);
    typeCombo.setBounds(240, 240, 150, 30);
    typeCombo.setBackground(Color.white);
    image.add(typeCombo);

    add = new JButton("Add Room");
    add.setForeground(Color.black);
    add.setBackground(Color.white);
    add.setBounds(280, 300, 130, 30);
    add.addActionListener(this);
    image.add(add);

    cancel = new JButton("Cancel Room");
    cancel.setForeground(Color.black);
    cancel.setBackground(Color.white);
    cancel.setBounds(440, 300, 130, 30);
    cancel.addActionListener(this);
    image.add(cancel);

    setBounds(350, 160, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new AddRooms();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == add) {
      String roomNumber = tfroom.getText();
      String availability = (String) availCombo.getSelectedItem();
      String status = (String) cleanCombo.getSelectedItem();
      String price = tfprice.getText();
      String type = (String) typeCombo.getSelectedItem();

      try {
        Conn conn = new Conn();
        String str = "insert into room values('" + roomNumber + "','" + availability + "','" + status + "','" + price
            + "','" + type + "')";
        conn.s.executeUpdate(str);
        JOptionPane.showMessageDialog(null, "New Room Added");
        setVisible(false);

      } catch (Exception ex) {
        ex.printStackTrace();

      }

    } else if (e.getSource() == cancel) {
      setVisible(false);

    }

  }
}

package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener {
  JButton newCustomer, room, department, employees, customer, manager, checkout, update, roomStatus, pickup, search,
      logout;

  Reception() {
    setLayout(null);
    setTitle("Reception");
    setResizable(false);

    ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
    setIconImage(icon.getImage());

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 0, 1400, 800);
    add(image);

    JLabel recep = new JLabel("Reception");
    recep.setFont(new Font("serif", Font.PLAIN, 40));
    recep.setBounds(330, 60, 600, 45);
    recep.setForeground(Color.white);
    image.add(recep);

    newCustomer = new JButton("New Customer Form");
    newCustomer.setBounds(100, 150, 200, 40);
    newCustomer.setForeground(Color.black);
    newCustomer.setBackground(Color.white);
    newCustomer.addActionListener(this);
    image.add(newCustomer);

    room = new JButton("Rooms");
    room.setBounds(310, 150, 200, 40);
    room.setForeground(Color.black);
    room.setBackground(Color.white);
    room.addActionListener(this);
    image.add(room);

    department = new JButton("Department");
    department.setBounds(520, 150, 200, 40);
    department.setForeground(Color.black);
    department.setBackground(Color.white);
    department.addActionListener(this);
    image.add(department);

    employees = new JButton("All Employees");
    employees.setBounds(100, 200, 200, 40);
    employees.setForeground(Color.black);
    employees.setBackground(Color.white);
    employees.addActionListener(this);
    image.add(employees);

    customer = new JButton("Customer");
    customer.setBounds(310, 200, 200, 40);
    customer.setForeground(Color.black);
    customer.setBackground(Color.white);
    customer.addActionListener(this);
    image.add(customer);

    manager = new JButton("Manager Info");
    manager.setBounds(520, 200, 200, 40);
    manager.setForeground(Color.black);
    manager.setBackground(Color.white);
    manager.addActionListener(this);
    image.add(manager);

    checkout = new JButton("Checkout");
    checkout.setBounds(100, 250, 200, 40);
    checkout.setForeground(Color.black);
    checkout.setBackground(Color.white);
    checkout.addActionListener(this);
    image.add(checkout);

    update = new JButton("Update Status");
    update.setBounds(310, 250, 200, 40);
    update.setForeground(Color.black);
    update.setBackground(Color.white);
    update.addActionListener(this);
    image.add(update);

    roomStatus = new JButton("Update Room Status");
    roomStatus.setBounds(520, 250, 200, 40);
    roomStatus.setForeground(Color.black);
    roomStatus.setBackground(Color.white);
    roomStatus.addActionListener(this);
    image.add(roomStatus);

    // pickup = new JButton("Pickup Service");
    // pickup.setBounds(100, 300, 200, 40);
    // pickup.setForeground(Color.black);
    // pickup.setBackground(Color.white);
    // image.add(pickup);

    search = new JButton("Search Room");
    search.setBounds(310, 300, 200, 40);
    search.setForeground(Color.black);
    search.setBackground(Color.white);
    search.addActionListener(this);
    image.add(search);

    logout = new JButton("Logout");
    logout.setBounds(600, 440, 200, 40);
    logout.setForeground(Color.white);
    logout.setBackground(Color.red);
    logout.addActionListener(this);
    image.add(logout);

    setBounds(350, 160, 850, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Reception();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == logout) {
      JOptionPane.showMessageDialog(null, "Succesfully Logged Out");
      setVisible(false);
    } else if (e.getSource() == newCustomer) {
      new AddCustomer();
      setVisible(false);
    } else if (e.getSource() == room) {
      new RoomInfo();
      setVisible(false);
    } else if (e.getSource() == department) {
      new Department();
      setVisible(false);
    } else if (e.getSource() == employees) {
      new EmployeeInfo();
      setVisible(false);
    } else if (e.getSource() == manager) {
      new ManagerInfo();
      setVisible(false);
    } else if (e.getSource() == customer) {
      new CustomerInfo();
      setVisible(false);
    } else if (e.getSource() == search) {
      new SearchRoom();
      setVisible(false);
    } else if (e.getSource() == update) {
      new UpdateCheck();
      setVisible(false);
    } else if (e.getSource() == roomStatus) {
      new UpdateRoom();
      setVisible(false);
    } else if (e.getSource() == checkout) {
      new Checkout();
      setVisible(false);
    }
  }
}

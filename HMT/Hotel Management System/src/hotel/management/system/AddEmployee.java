package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfemail, tfphone, tfage, tfsalary;
    JRadioButton male, female;
    JButton submit;
    JComboBox cbjob;

    AddEmployee() {
        setLayout(null);
        setTitle("Add Employees");
        setResizable(false);

        ImageIcon icon = new ImageIcon("src\\Icon\\Icon3.jpeg");
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/lb.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1400, 800);
        add(image);

        JLabel head = new JLabel("EMPLOYEE REGISTERATION");
        head.setBounds(160, 80, 600, 45);
        head.setFont(new Font("Tahoma", Font.PLAIN, 40));
        head.setForeground(Color.white);
        image.add(head);

        JLabel name = new JLabel("NAME");
        name.setBounds(80, 150, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name.setForeground(Color.white);
        image.add(name);

        tfname = new JTextField();
        tfname.setBounds(220, 150, 150, 30);
        image.add(tfname);

        JLabel age = new JLabel("AGE");
        age.setBounds(395, 150, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age.setForeground(Color.white);
        image.add(age);

        tfage = new JTextField();
        tfage.setBounds(530, 150, 150, 30);
        image.add(tfage);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(80, 200, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender.setForeground(Color.white);
        image.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(220, 200, 70, 30);
        male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        image.add(male);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        female = new JRadioButton("Female");
        female.setBounds(300, 200, 70, 30);
        female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        image.add(female);

        JLabel job = new JLabel("JOB");
        job.setBounds(395, 200, 120, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job.setForeground(Color.white);
        image.add(job);

        String str[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs",
                "Manager", "Accountant", "Receptionist" };
        cbjob = new JComboBox(str);
        cbjob.setBounds(530, 200, 150, 30);
        cbjob.setBackground(Color.WHITE);
        image.add(cbjob);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(80, 250, 120, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary.setForeground(Color.white);
        image.add(salary);

        tfsalary = new JTextField();
        tfsalary.setBounds(220, 250, 150, 30);
        image.add(tfsalary);

        JLabel phone = new JLabel("PHONE");
        phone.setBounds(395, 250, 120, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone.setForeground(Color.white);
        image.add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(530, 250, 150, 30);
        image.add(tfphone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(80, 300, 120, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setForeground(Color.white);
        image.add(email);

        tfemail = new JTextField();
        tfemail.setBounds(220, 300, 460, 30);
        image.add(tfemail);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.setBounds(350, 370, 150, 30);
        submit.addActionListener(this);
        image.add(submit);

        /*
         * ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
         * Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
         * ImageIcon i3 = new ImageIcon(i2);
         * Jlabel image = new JLabel(i3);
         * image.setBounds(380, 60, 450, 370);
         * add(image);
         */

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 160, 850, 540);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "MALE";
        } else if (female.isSelected()) {
            gender = "FEMALE";
        }

        String job = (String) cbjob.getSelectedItem();

        try {
            Conn conn = new Conn();
            String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','"
                    + salary + "','" + phone + "','" + email + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, " Employee Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

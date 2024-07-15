package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

class new_user
{
    public void Create()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes_db";
            String user = "root";
            String pswd = "P02122003K";
            Connection con = DriverManager.getConnection(url, user, pswd);

            String q = "insert into users(Username,Password) values(?,?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, Creating_Account.name.getText());
            ps.setString(2, Creating_Account.pswd.getText());

            System.out.println("Data Inserted Successfully..!!");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class Creating_Account extends JPanel implements ActionListener, MouseListener
{
    static JFrame f;
    JLabel head, username, password;
    static JTextField name;
    static JPasswordField pswd;
    JCheckBox show;
    JButton submit, cancel;
    Font label_font;
    static char temp;
    private int count = 1;

    Creating_Account()
    {
        f = new JFrame("Create Account");
        GroupLayout.Alignment center_pos = GroupLayout.Alignment.CENTER;
        f.setBounds(center_pos.ordinal(), center_pos.ordinal(), 500, 300);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(new Color(230,230,250));
        setLayout(null);
        label_font = new Font("Arial", Font.BOLD, 20);

        head = new JLabel("Sign up");
        head.setBounds(195, 20, 200,35);
        head.setFont(new Font("Arial", Font.BOLD, 30));
        add(head);

        username = new JLabel("Username");
        username.setBounds(60, 80, 150,25);
        username.setFont(label_font);
        add(username);

        password = new JLabel("Password");
        password.setBounds(60,125,150,25);
        password.setFont(label_font);
        add(password);

        name = new JTextField();
        name.setBounds(210,80,200,25);
        name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        add(name);

        pswd = new JPasswordField();
        pswd.setBounds(210,125,200,25);
        pswd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        temp = pswd.getEchoChar();
        add(pswd);

        show = new JCheckBox("Show Password");
        show.setBounds(210,160,200,25);
        show.addActionListener(this);
        add(show);

        submit = new JButton("Submit");
        submit.setBounds(210,200,90,25);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addMouseListener(this);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(320,200,90,25);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancel.addMouseListener(this);
        add(cancel);

        f.add(this);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == show)
        {
            if (show.isSelected())
                pswd.setEchoChar((char)0);
            else
                pswd.setEchoChar(temp);
        }

        if (e.getSource() == submit)
        {
            boolean check_name = Pattern.matches("[a-z A-Z 0-9 _]*", name.getText());
            if (!check_name)
                JOptionPane.showMessageDialog(f,"Username cannot have any special character..!!", "Warning", JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(f, "Access Denied", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == submit) {
            if (name.getText().equals("") || pswd.getText().equals("")) {
                switch (count) {
                    case 1 -> {
                        submit.setLocation(100, 200);
                        count++;
                    }
                    case 2 -> {
                        submit.setLocation(210, 200);
                        count = 1;
                    }
                }
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
//        if (e.getSource() == submit && e.getButton() == MouseEvent.BUTTON1)
//        {
//            JOptionPane.showMessageDialog(f, "Access Denied", "Error", JOptionPane.ERROR_MESSAGE);
//        }
        if (e.getSource() == cancel && e.getButton() == MouseEvent.BUTTON1)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Creating_Account();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
}
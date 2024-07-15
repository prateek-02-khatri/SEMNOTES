package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Log_in extends JPanel implements MouseListener, ActionListener
{
    static JFrame f;
    JPanel p;
    JLabel log_in, id, pswd, new_user, sign_up;
    JCheckBox show;
    static JTextField user_id;
    static JPasswordField password;
    Font label_font, msg_font, text_font;
    JButton Log_in_button;
    private int count = 1;
    static char temp;
    Log_in()
    {
        f = new JFrame("SEMNOTES");
        GroupLayout.Alignment center_pos = GroupLayout.Alignment.CENTER;
        f.setBounds(center_pos.ordinal(), center_pos.ordinal(), 750, 675);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        p = new JPanel();
        p.setBounds(125,175,500,300);
        p.setOpaque(false);
        p.setLayout(null);
//        p.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        f.add(p);

        log_in = new JLabel("Log in");
        log_in.setBounds(200, 5, 100,35);
        log_in.setFont(new Font("Arial", Font.BOLD, 30));
        p.add(log_in);

        label_font = new Font("Arial", Font.BOLD, 24);

        id = new JLabel("Student ID");
        id.setBounds(75, 85, 200,25);
        id.setFont(label_font);
        p.add(id);

        pswd = new JLabel("Password");
        pswd.setBounds(75, 130, 200, 25);
        pswd.setFont(label_font);
        p.add(pswd);

        text_font = new Font("Times New Roman", Font.PLAIN, 17);

        user_id = new JTextField("21BTE3CSE10057");
        user_id.setBounds(225,85,200,25);
        user_id.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        user_id.setFont(text_font);
        p.add(user_id);

        password = new JPasswordField("Prateek");
        password.setBounds(225,130,200,25);
        password.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        password.setFont(text_font);
        temp = password.getEchoChar();
        p.add(password);

        show = new JCheckBox("Show Password");
        show.setBounds(225,165,200,25);
        show.setForeground(Color.WHITE);
        show.setOpaque(false);
        show.addActionListener(this);
        p.add(show);

        Log_in_button = new JButton("Log in");
        Log_in_button.setBounds(225,200,100,30);
        Log_in_button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Log_in_button.setBackground(Color.WHITE);
        Log_in_button.setBorderPainted(false);
        Log_in_button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        Log_in_button.addMouseListener(this);
        Log_in_button.addActionListener(this);
        p.add(Log_in_button);

        msg_font = new Font("Dialog", Font.BOLD, 12);

//        new_user = new JLabel("Don't have an account?");
//        new_user.setBounds(150,225,135,30);
//        new_user.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
//        p.add(new_user);

        sign_up = new JLabel("Sign up");
        sign_up.setBounds(290, 225, 50, 30);
        sign_up.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sign_up.setForeground(Color.BLUE);
        sign_up.addMouseListener(this);
        sign_up.setBorder(BorderFactory.createStrokeBorder(new BasicStroke()));
        p.add(sign_up);

        f.add(this);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        String path = "src/Images/Welcome Page.jpg";
        Image image = new ImageIcon(path).getImage();
        g.drawImage(image, 0, 0, 750, 675,null);

//        String logo_path = "src/Images/Logo.png";
//        Image logo = new ImageIcon(logo_path).getImage();
//        g.drawImage(logo, 300, 45,150, 135, null);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (e.getSource() == Log_in_button)
        {
            if (user_id.getText().equals("") || password.getText().equals("")) {
                switch (count) {
                    case 1 -> {
                        Log_in_button.setLocation(100, 200);
                        count++;
                    }
                    case 2 -> {
                        Log_in_button.setLocation(350, 200);
                        count++;
                    }
                    case 3 -> {
                        Log_in_button.setLocation(225, 200);
                        count = 1;
                    }
                }
            }
        }
        else if (e.getSource() == sign_up)
        {
            sign_up.setFont(new Font("Dialog", Font.BOLD, 12));
            sign_up.setCursor((new Cursor(Cursor.HAND_CURSOR)));
            Font font1 = sign_up.getFont();
            Map attrib = font1.getAttributes();
            attrib.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            sign_up.setFont(font1.deriveFont(attrib));
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (e.getSource() == sign_up)
            sign_up.setFont(msg_font);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getSource() == sign_up && e.getButton() == MouseEvent.BUTTON1)
        {
            JOptionPane.showMessageDialog(f, "Access Denied..!!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Log_in_button)
        {
            Verification.Connection();
            Verification.checking();
            Verification.verify();
        }
        else if (e.getSource() == show)
        {
            if (show.isSelected())
                password.setEchoChar((char)0);
            else
                password.setEchoChar(temp);
        }
    }

    public static void main(String[] args)
    {
        new Log_in();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}
}
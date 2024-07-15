package Project_Semnotes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface colors
{
    Color light = new Color(255,235,220);
    Color dark = new Color(255, 220,200);
    Border border = null;
//    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
}
class basicDimensions
{
    int initialWidth = 135;
    int initialHeight = 105;
    int hoverWidth = 145;
    int hoverHeight = 115;
    int w = 183;
    int h = 180;
    int posX, posY;
    int posX2, posY2;
    int label_X, label_Y;
    Color light = new Color(255,235,220);
    Color dark = new Color(255, 220,200);
    Font font = new Font("Times New Roman", Font.PLAIN, 12);
    Rectangle panel_bounds = new Rectangle(200,125,735,545);
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
}
class Head extends JPanel implements colors
{
    JLabel user, id;
    Head()
    {
        setBounds(0,0,935,90);
        setLayout(null);
        setBackground(light);

        user = new JLabel();
        user.setBounds(785,20,140,25);
        user.setBorder(border);
        add(user);

        id = new JLabel();
        id.setBounds(785,45,140,25);
        id.setBorder(border);
        add(id);

        String username = Verification.student_name;
        String user_id = Verification.student_id;
        if (!username.equals("") && !user_id.equals(""))
        {
            user.setText(username);
            id.setText(user_id);
        }
        else
        {
            user.setText("Unknown User");
            id.setText("N/A");
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        String Logo_path = "src/Images/Logo.png";
        ImageIcon logo = new ImageIcon(Logo_path);
        g.drawImage(logo.getImage(), 20,5,75,75,null);

        String name_path = "src/Images/Name.png";
        ImageIcon name = new ImageIcon(name_path);
        g.drawImage(name.getImage(), 120, 3, 450, 80,null);

        String profile_path = "src/Images/Profile.png";
        ImageIcon profile = new ImageIcon(profile_path);
        g.drawImage(profile.getImage(), 725, 20, 50, 50,null);
    }
}
class Bar extends JPanel implements colors
{
    static JButton back, home, log_out;
    static JLabel select;
    Bar()
    {
        setBounds(200,90,735,35);
        setBackground(dark);
        setLayout(null);

        Menu menu = new Menu();
        Main_Frame.f.add(menu);

        select = new JLabel();
        select.setBounds(290,6,200,23);
        select.setFont(new Font("Rockwell", Font.BOLD, 20));
        select.setText("Select School");

        back = new JButton();
        back.setBounds(600,7,20,20);
        back.setIcon(new ImageIcon("src/Images/Back.png"));
        back.setBackground(null);
        back.setBorder(null);
        back.setBorderPainted(false);

        home = new JButton();
        home.setBounds(650,7,20,20);
        home.setIcon(new ImageIcon("src/Images/Home.png"));
        home.setBackground(null);
        home.setBorder(null);
        home.setBorderPainted(false);

        log_out = new JButton();
        log_out.setBounds(700,7,20,20);
        log_out.setIcon(new ImageIcon("src/Images/Logout.png"));
        log_out.setBackground(null);
        log_out.setBorder(null);
        log_out.setBorderPainted(false);

        if (Main_Frame.frame_number == 1)
            back.setEnabled(false);

        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Main_Frame.tab.equals("Home"))
                {
                    if (Main_Frame.frame_number == 2)
                    {
                        Selecting_School.p.setVisible(true);
                        Selecting_Branch.p.setVisible(false);
                        select.setText("Select School");
                        back.setEnabled(false);
                        Main_Frame.frame_number = 1;
                    }
                    else if (Main_Frame.frame_number == 3)
                    {
                        Selecting_Branch.p.setVisible(true);
                        Selecting_Semester.p.setVisible(false);
                        select.setText("Select Branch");
                        Main_Frame.frame_number = 2;
                    }
                    else if (Main_Frame.frame_number == 4)
                    {
                        Selecting_Semester.p.setVisible(true);
                        Semester_1_Subjects.p.setVisible(false);
                        Semester_2_Subjects.p.setVisible(false);
                        Semester_3_Subjects.p.setVisible(false);
                        Semester_4_Subjects.p.setVisible(false);
                        select.setText("Select Semester");
                        Main_Frame.frame_number = 3;
                    }
                    else if (Main_Frame.frame_number == 5)
                    {
                        Semester_4_Subjects.p.setVisible(true);
                        Selecting_Unit_DBMS.p.setVisible(false);
                        select.setText("Select Subject");
                        Main_Frame.frame_number = 4;
                    }
                }
            }
        });

        home.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Main_Frame.frame_number != 1)
                {
                    switch (Main_Frame.frame_number)
                    {
                        case 2 -> Selecting_Branch.p.setVisible(false);
                        case 3 -> Selecting_Semester.p.setVisible(false);
                        case 4 ->
                        {
                            Semester_1_Subjects.p.setVisible(false);
                            Semester_2_Subjects.p.setVisible(false);
                            Semester_3_Subjects.p.setVisible(false);
                            Semester_4_Subjects.p.setVisible(false);
                        }
                        case 5 -> Selecting_Unit_DBMS.p.setVisible(false);
                    }
                    Selecting_School.p.setVisible(true);
                    select.setText("Select School");
                    back.setEnabled(false);
                    Main_Frame.frame_number = 1;
                }
            }
        });

        log_out.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int option = JOptionPane.showConfirmDialog(Main_Frame.f, "Are you sure to Log out..!!", "Log out", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    Main_Frame.frame_number = 1;
                    Selecting_Branch.p.setVisible(false);
                    Selecting_Semester.p.setVisible(false);
                    Semester_1_Subjects.p.setVisible(false);
                    Semester_2_Subjects.p.setVisible(false);
                    Semester_3_Subjects.p.setVisible(false);
                    Semester_4_Subjects.p.setVisible(false);
                    Selecting_Unit_DBMS.p.setVisible(false);
                    Main_Frame.f.dispose();
                    new Log_in();
                }
            }
        });

        add(back);
        add(home);
        add(log_out);
        add(select);
    }
}
class Menu extends JPanel implements colors, ActionListener
{
    JButton home, library, about, feedback;
    Font menu_font;
    Menu()
    {
        setBounds(0,90,200,570);
        setBackground(dark);
        setBorder(BorderFactory.createLineBorder(dark, 1));
        setLayout(null);
        setVisible(true);

        menu_font = new Font("Times New Roman", Font.BOLD, 21);

        home = new JButton("     Home");
        home.setBounds(0,35,200,40);
        home.setFont(menu_font);
        home.setBackground(light);
        home.setBorderPainted(false);
        home.setBorder(null);
        home.setFocusPainted(false);
        home.setHorizontalAlignment(SwingConstants.LEFT);
        home.addActionListener(this);
        add(home);

        library = new JButton("     Notes Library");
        library.setBounds(0,85,200,40);
        library.setFont(menu_font);
        library.setBackground(dark);
        library.setBorderPainted(false);
        library.setBorder(null);
        library.setFocusPainted(false);
        library.setHorizontalAlignment(SwingConstants.LEFT);
        library.addActionListener(this);
        add(library);

//        feedback = new JButton("     Feedback");
//        feedback.setBounds(0,135,200,40);
//        feedback.setFont(menu_font);
//        feedback.setBackground(dark);
//        feedback.setBorderPainted(false);
//        feedback.setBorder(null);
//        feedback.setFocusPainted(false);
//        feedback.setHorizontalAlignment(SwingConstants.LEFT);
//        feedback.addActionListener(this);
//        add(feedback);

        about = new JButton("     About Us");
        about.setBounds(0,135,200,40);
//        0,185,200,40
        about.setFont(menu_font);
        about.setBackground(dark);
        about.setBorderPainted(false);
        about.setBorder(null);
        about.setFocusPainted(false);
        about.setHorizontalAlignment(SwingConstants.LEFT);
        about.addActionListener(this);
        add(about);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == home)
        {
            Main_Frame.setHomeTab();
            home.setBackground(light);
            library.setBackground(dark);
//            feedback.setBackground(dark);
            about.setBackground(dark);
        }

        else if (e.getSource() == library)
        {
            Main_Frame.setLibraryTab();
            home.setBackground(dark);
            library.setBackground(light);
//            feedback.setBackground(dark);
            about.setBackground(dark);
        }

//        else if (e.getSource() == feedback)
//        {
//            Main_Frame.tab = "Feedback";
//            home.setBackground(dark);
//            library.setBackground(dark);
//            feedback.setBackground(light);
//            about.setBackground(dark);
//        }

        else if (e.getSource() == about)
        {
            Main_Frame.setAboutTab();
            home.setBackground(dark);
            library.setBackground(dark);
//            feedback.setBackground(dark);
            about.setBackground(light);
        }
    }
}

public class Main_Frame
{
    public static int frame_number = 1;
    public static String tab = "Home";
    static JFrame f;
    Main_Frame()
    {
        f = new JFrame("SEMNOTES");
        f.setSize(950, 700);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Head head = new Head();
        Bar bar = new Bar();

        new Selecting_School();
        new Selecting_Branch();
        new Selecting_Semester();
        new Semester_1_Subjects();
        new Semester_2_Subjects();
        new Semester_3_Subjects();
        new Semester_4_Subjects();
//        new Selecting_Unit();
        new Selecting_Unit_DBMS();

        f.add(head);
        f.add(bar);
        f.add(Selecting_School.p);
        f.add(Selecting_Branch.p);
        f.add(Selecting_Semester.p);
        f.add(Semester_1_Subjects.p);
        f.add(Semester_2_Subjects.p);
        f.add(Semester_3_Subjects.p);
        f.add(Semester_4_Subjects.p);
//        f.add(Selecting_Unit.p);
        f.add(Selecting_Unit_DBMS.p);

        new Notes_Library();
        new About_Us();

        f.add(Notes_Library.p);
        f.add(About_Us.p);

        f.setVisible(true);
    }

    public static void setHomeTab()
    {
        Main_Frame.tab = "Home";
        Notes_Library.p.setVisible(false);
        About_Us.p.setVisible(false);
        Selecting_School.p.setVisible(true);
        Selecting_Branch.p.setVisible(false);
        Selecting_Semester.p.setVisible(false);
        Semester_1_Subjects.p.setVisible(false);
        Semester_2_Subjects.p.setVisible(false);
        Semester_3_Subjects.p.setVisible(false);
        Semester_4_Subjects.p.setVisible(false);
        Selecting_Unit_DBMS.p.setVisible(false);
        Bar.back.setEnabled(false);
        Bar.home.setEnabled(true);
        Bar.select.setText("Select School");
        Main_Frame.frame_number = 1;
    }
    public static void setLibraryTab()
    {
        Main_Frame.tab = "Library";
        Notes_Library.p.setVisible(true);
        About_Us.p.setVisible(false);
        Selecting_School.p.setVisible(false);
        Selecting_Branch.p.setVisible(false);
        Selecting_Semester.p.setVisible(false);
        Semester_1_Subjects.p.setVisible(false);
        Semester_2_Subjects.p.setVisible(false);
        Semester_3_Subjects.p.setVisible(false);
        Semester_4_Subjects.p.setVisible(false);
        Selecting_Unit_DBMS.p.setVisible(false);
        Bar.back.setEnabled(false);
        Bar.home.setEnabled(false);
        Bar.select.setText("Downloaded Notes");
        Main_Frame.frame_number = 0;
    }
    public static void setAboutTab()
    {
        Main_Frame.tab = "About";
        About_Us.p.setVisible(true);
        Notes_Library.p.setVisible(false);
        Selecting_School.p.setVisible(false);
        Selecting_Branch.p.setVisible(false);
        Selecting_Semester.p.setVisible(false);
        Semester_1_Subjects.p.setVisible(false);
        Semester_2_Subjects.p.setVisible(false);
        Semester_3_Subjects.p.setVisible(false);
        Semester_4_Subjects.p.setVisible(false);
        Selecting_Unit_DBMS.p.setVisible(false);
        Bar.back.setEnabled(false);
        Bar.home.setEnabled(false);
        Bar.select.setText("Our Team");
        Main_Frame.frame_number = 0;
    }

    public static void main(String[] args)
    {
//        new Main_Frame();
        new Log_in();
    }
}

package Project_Semnotes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

interface content
{

    // Prateek Khatri
    String p_name = "Prateek Khatri";
    String p_edu = "B.Tech (CSE) - 2nd Year";
    String p_des = "Frontend & Backend Developer";
    String p_mobile = "9755021051";
    String p_mail = "khatriprateek02@gmail.com";


    // Chirayu Singh
    String c_name = "Chirayu Singh";
    String c_edu = "B.Tech (CSE) - 2nd Year";
    String c_des = "UI Designer & Content Writer";
    String c_mobile = "8349234610";
    String c_mail = "artist.chirayu@gmail.com";


    // Rishikesh Moon
    String r_name = " Rishikesh Moon";
    String r_edu = "B.Tech (CSE) - 2nd Year";
    String r_des = "UI Designer & Frontend Developer";
    String r_mobile = "9131267153";
    String r_mail = "rishikeshmoon19@gmail.com";


    // About Semnotes
    String aboutSemnotes1 = "     The SEMNOTES App is an initiative aimed at creating a comprehensive and organized collection of notes for various subjects and courses in a college or educational institution. The project aims to provide students with valuable resources that can assist them in their studies, enhance their understanding of subjects, and facilitate effective learning.";
    String aboutSemnotes2 = "     Through the SEMNOTES App, students can benefit from a collective pool of knowledge and expertise, fostering a community of learners who can support each other in their academic pursuits. By harnessing the power of technology and collaborative efforts, the project aims to revolutionize the way students approach their studies, making learning more efficient, engaging, and accessible.";
}
public class About_Us extends basicDimensions implements content
{
    static JPanel p;
    JLabel prateek, chirayu, rishikesh;
    About_Us()
    {
        int image_x = 42;
        int image_y = 20;
        int image_width = 160;
        int image_height = 175;

        int total_width = 245;

        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setBackground(light);
        p.setVisible(false);

//        w = 735;
//        h = 545;

        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        Font nameFont = new Font(Font.DIALOG,Font.BOLD, 14);
        Font font = new Font(Font.DIALOG,Font.PLAIN, 14);

        // Prateek Khatri //
        ImageIcon prateek_image = new ImageIcon("src/Team/Prateek.jpg");
        prateek = new JLabel();
        prateek.setBounds(image_x,image_y,image_width,image_height);
        prateek.setIcon(prateek_image);
        prateek.setBorder(border);
        p.add(prateek);

        JLabel prateek_name = new JLabel(p_name);
        prateek_name.setBounds(0,200,total_width,30);
        prateek_name.setFont(nameFont);
        prateek_name.setHorizontalAlignment(0);
        p.add(prateek_name);

        JLabel prateek_edu = new JLabel(p_edu);
        prateek_edu.setBounds(0,200+30,total_width,30);
        prateek_edu.setFont(font);
        prateek_edu.setFont(font);
        prateek_edu.setHorizontalAlignment(0);
        p.add(prateek_edu);

        JLabel prateek_designation = new JLabel(p_des);
        prateek_designation.setBounds(0,200+30+30,total_width,30);
        prateek_designation.setFont(font);
        prateek_designation.setHorizontalAlignment(0);
        p.add(prateek_designation);

        p.add(whatsappIcon(15));

        JLabel prateek_mobile = new JLabel(p_mobile);
        prateek_mobile.setBounds(50,200+30+30+30,total_width-50,30);
        prateek_mobile.setFont(font);
        p.add(prateek_mobile);

        p.add(mailIcon(15));

        JLabel prateek_mail = new JLabel(p_mail);
        prateek_mail.setBounds(50,200+30+30+30+30,total_width-50,30);
        prateek_mail.setFont(font);
        p.add(prateek_mail);


        // Chirayu Singh //
        ImageIcon chirayu_image = new ImageIcon("src/Team/Chirayu.jpg");
        chirayu = new JLabel();
        chirayu.setBounds(total_width+image_x,image_y,image_width,image_height);
        chirayu.setIcon(chirayu_image);
        chirayu.setBorder(border);
        p.add(chirayu);

        JLabel chirayu_name = new JLabel(c_name);
        chirayu_name.setBounds(total_width,200,total_width,30);
        chirayu_name.setFont(nameFont);
        chirayu_name.setHorizontalAlignment(0);
        p.add(chirayu_name);

        JLabel chirayu_edu = new JLabel(c_edu);
        chirayu_edu.setBounds(total_width,200+30,total_width,30);
        chirayu_edu.setFont(font);
        chirayu_edu.setFont(font);
        chirayu_edu.setHorizontalAlignment(0);
        p.add(chirayu_edu);

        JLabel chirayu_designation = new JLabel(c_des);
        chirayu_designation.setBounds(total_width,200+30+30,total_width,30);
        chirayu_designation.setFont(font);
        chirayu_designation.setHorizontalAlignment(0);
        p.add(chirayu_designation);

        p.add(whatsappIcon(total_width+15));

        JLabel chirayu_mobile = new JLabel(c_mobile);
        chirayu_mobile.setBounds(total_width+50,200+30+30+30,total_width-50,30);
        chirayu_mobile.setFont(font);
        p.add(chirayu_mobile);

        p.add(mailIcon(total_width+15));

        JLabel chirayu_mail = new JLabel(c_mail);
        chirayu_mail.setBounds(total_width+50,200+30+30+30+30,total_width-50,30);
        chirayu_mail.setFont(font);
        p.add(chirayu_mail);


        // Rishikesh Moon //
        ImageIcon rishikesh_image = new ImageIcon("src/Team/Rishikesh original.jpg");
        rishikesh = new JLabel();
        rishikesh.setBounds(total_width+total_width+image_x,image_y,image_width,image_height);
        rishikesh.setIcon(rishikesh_image);
        rishikesh.setBorder(border);
        p.add(rishikesh);

        JLabel rishikesh_name = new JLabel(r_name);
        rishikesh_name.setBounds(2*total_width,200,total_width,30);
        rishikesh_name.setFont(nameFont);
        rishikesh_name.setHorizontalAlignment(0);
        p.add(rishikesh_name);

        JLabel rishikesh_edu = new JLabel(r_edu);
        rishikesh_edu.setBounds(2*total_width,200+30,total_width,30);
        rishikesh_edu.setFont(font);
        rishikesh_edu.setFont(font);
        rishikesh_edu.setHorizontalAlignment(0);
        p.add(rishikesh_edu);

        JLabel rishikesh_designation = new JLabel(r_des);
        rishikesh_designation.setBounds(2*total_width,200+30+30,total_width,30);
        rishikesh_designation.setFont(font);
        rishikesh_designation.setHorizontalAlignment(0);
        p.add(rishikesh_designation);

        p.add(whatsappIcon(2*total_width+15));

        JLabel rishikesh_mobile = new JLabel(r_mobile);
        rishikesh_mobile.setBounds(2*total_width+50,200+30+30+30,total_width-50,30);
        rishikesh_mobile.setFont(font);
        p.add(rishikesh_mobile);

        p.add(mailIcon(2*total_width+15));

        JLabel rishikesh_mail = new JLabel(r_mail);
        rishikesh_mail.setBounds(2*total_width+49,200+30+30+30+30,total_width-49,30);
        rishikesh_mail.setFont(font);
        p.add(rishikesh_mail);


        // About Semnotes
        ImageIcon about = new ImageIcon("src/Team/About App copy.png");
        JLabel aboutApp = new JLabel(about);
        aboutApp.setBounds(10,360,710,178);
//        aboutApp.setBorder(border);
        aboutApp.setBackground(null);
        aboutApp.setOpaque(false);
        p.add(aboutApp);
    }

    JLabel whatsappIcon(int x)
    {
        ImageIcon whatsapp = new ImageIcon("src/Team/Whatsapp.png");
        JLabel whatsAppIcon = new JLabel(whatsapp);
        whatsAppIcon.setBounds(x, 200+30+30+30,30,30);
        return whatsAppIcon;
    }
    JLabel mailIcon(int x)
    {
        ImageIcon gmail = new ImageIcon("src/Team/Mail Icon.jpg");
        JLabel mail = new JLabel(gmail);
        mail.setBounds(x,200+30+30+30+35,30,22);
        return mail;
    }

    public static void main(String[] args)
    {
        new Log_in();
    }
}

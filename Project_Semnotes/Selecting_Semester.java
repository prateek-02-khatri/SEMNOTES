package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Selecting_Semester extends basicDimensions implements MouseListener
{
    static JPanel p;
    static JLabel [][] sem_info;
    JButton [][] semester;
    int initialWidth = 125;
    int initialHeight = 75;
    int w = 200;
    int h = 125;
    static JLabel semester_number;
    Selecting_Semester()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setVisible(false);
        p.setBackground(light);

        int sem_num = 1;

        semester_number = new JLabel();
        semester_number.setBounds(285,18,190,30);
        semester_number.setFont(new Font("Times New Roman", Font.BOLD, 20));
        semester_number.setHorizontalAlignment(0);
//        semester_number.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));

        semester = new JButton[4][2];
        sem_info = new JLabel[4][2];

        for (int i=0; i<4; i++)
        {
            for (int j=0; j<2; j++)
            {
                posX = (j*w)+40;
                posY = (i*h)+40;

                semester[i][j] = new JButton();
                semester[i][j].setBounds(posX,posY,initialWidth,initialHeight);
//                semester[i][j].setBackground(dark);
//                semester[i][j].setForeground(new Color(230,230,240));
                semester[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
//                semester[i][j].setIcon(new ImageIcon(path[i][j]));
                semester[i][j].addMouseListener(this);
                semester[i][j].setFont(new Font("Times New Roman", Font.BOLD, 16));
                semester[i][j].setText("Semester "+sem_num);
                sem_num++;
                p.add(semester[i][j]);

                sem_info[i][j] = new JLabel();
//                sem_info[i][j].setBorder(border);
                sem_info[i][j].setBounds(400,15,325,500);
                sem_info[i][j].setVisible(false);
                p.add(sem_info[i][j]);
            }
        }

        semester[0][0].addActionListener(e ->
        {
            if (Main_Frame.frame_number == 3)
            {
                Selecting_Semester.p.setVisible(false);
                Semester_1_Subjects.p.setVisible(true);
                Bar.select.setText("Select Subject");
                semester_number.setText("Semester 1");
                Main_Frame.frame_number = 4;
            }
        });

        semester[0][1].addActionListener(e ->
        {
            if (Main_Frame.frame_number == 3)
            {
                Selecting_Semester.p.setVisible(false);
                Semester_2_Subjects.p.setVisible(true);
                Bar.select.setText("Select Subject");
                Main_Frame.frame_number = 4;
            }
        });

        semester[1][0].addActionListener(e ->
        {
            if (Main_Frame.frame_number == 3)
            {
                Selecting_Semester.p.setVisible(false);
                Semester_3_Subjects.p.setVisible(true);
                Bar.select.setText("Select Subject");
                Main_Frame.frame_number = 4;
            }
        });

        semester[1][1].addActionListener(e ->
        {
            if (Main_Frame.frame_number == 3)
            {
                Selecting_Semester.p.setVisible(false);
                Semester_4_Subjects.p.setVisible(true);
                Bar.select.setText("Select Subject");
                Main_Frame.frame_number = 4;
            }
        });
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        String [][] sem_info_path = new String[4][2];
        sem_info_path[0][0] = "src/Semester_Info/Semester_1.png";
        sem_info_path[0][1] = "src/Semester_Info/Semester_2.png";
        sem_info_path[1][0]= "src/Semester_Info/Semester_3.png";
        sem_info_path[1][1]= "src/Semester_Info/Semester_4.png";

        hoverWidth = 135;
        hoverHeight = 85;
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<2; j++)
            {
                if (e.getSource() == semester[i][j])
                {
                    posX2 = (j*w)+35;
                    posY2 = (i*h)+35;
                    semester[i][j].setBounds(posX2,posY2,hoverWidth,hoverHeight);
                    semester[i][j].setFont(new Font("Times New Roman", Font.BOLD, 18));
//                    semester[i][j].setIcon(new ImageIcon(hover_path[i][j]));

                    sem_info[i][j].setVisible(true);
                    sem_info[i][j].setIcon(new ImageIcon(sem_info_path[i][j]));
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<2; j++)
            {
                if (e.getSource() == semester[i][j])
                {
                    posX = (j*w)+40;
                    posY = (i*h)+40;
                    semester[i][j].setBounds(posX,posY,initialWidth,initialHeight);
                    semester[i][j].setFont(new Font("Times New Roman", Font.BOLD, 16));
//                    semester[i][j].setIcon(new ImageIcon(path[i][j]));

                    sem_info[i][j].setVisible(false);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Main_Frame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Selecting_School extends basicDimensions implements MouseListener
{
    static JPanel p;
    JButton [][] schools;
    String [][] path, hover_path;
    JLabel [][] labels;
    Selecting_School()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setBackground(light);

        schools = new JButton[3][4];
        labels = new JLabel[3][4];

        path = new String[3][4];
        hover_path = new String[3][4];

        path[0][0] = "src/Schools/Icons/1_Advanced Computing.jpg";
        path[0][1] = "src/Schools/Icons/2_Agriculture.jpg";
        path[0][2] = "src/Schools/Icons/3_Arts.jpg";
        path[0][3] = "src/Schools/Icons/4_Commerce.jpg";
        path[1][0] = "src/Schools/Icons/5_Computer Application.jpg";
        path[1][1] = "src/Schools/Icons/6_Design.jpg";
        path[1][2] = "src/Schools/Icons/7_E&T.jpg";
        path[1][3] = "src/Schools/Icons/8_Journalism.jpg";
        path[2][0] = "src/Schools/Icons/9_Management.jpg";
        path[2][1] = "src/Schools/Icons/10_Performing Arts.jpg";
        path[2][2] = "src/Schools/Icons/11_Science.jpg";
        path[2][3] = "src/Schools/Icons/12_Law & Legal Studies.jpg";

        hover_path[0][0] = "src/Schools/Hover/1_Advanced Computing hover.jpg";
        hover_path[0][1] = "src/Schools/Hover/2_Agriculture hover.jpg";
        hover_path[0][2] = "src/Schools/Hover/3_Arts hover.jpg";
        hover_path[0][3] = "src/Schools/Hover/4_Commerce hover.jpg";
        hover_path[1][0] = "src/Schools/Hover/5_Computer Application hover.jpg";
        hover_path[1][1] = "src/Schools/Hover/6_Design hover.jpg";
        hover_path[1][2] = "src/Schools/Hover/7_E&T hover.jpg";
        hover_path[1][3] = "src/Schools/Hover/8_Journalism hover.jpg";
        hover_path[2][0] = "src/Schools/Hover/9_Management hover.jpg";
        hover_path[2][1] = "src/Schools/Hover/10_Performing Arts hover.jpg";
        hover_path[2][2] = "src/Schools/Hover/11_Science hover.jpg";
        hover_path[2][3] = "src/Schools/Hover/12_Law & Legal Studies hover.jpg";

        for (int i=0; i<3;i++)
        {
            for(int j=0; j<4; j++)
            {
                posX = (j*w)+24;
                posY = (i*h)+20;

                schools[i][j] = new JButton();
                schools[i][j].setBounds(posX,posY,initialWidth,initialHeight);
                schools[i][j].setIcon(new ImageIcon(path[i][j]));
                schools[i][j].setFont(font);
                schools[i][j].setBorder(null);
                schools[i][j].setBorderPainted(false);
                schools[i][j].setOpaque(false);
                schools[i][j].setBackground(null);
                schools[i][j].addMouseListener(this);

                label_X = (j*w)+5;
                label_Y = (i*h)+30+hoverHeight;

                labels[i][j] = new JLabel();
                labels[i][j].setBounds(label_X,label_Y,175,30);
                labels[i][j].setFont(font);
                labels[i][j].setHorizontalAlignment(0);
//                labels[i][j].setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
                labels[i][j].setForeground(Color.BLACK);

                p.add(schools[i][j]);
                p.add(labels[i][j]);
            }
        }

        labels[0][0].setText("Advanced Computing");
        labels[0][1].setText("Agriculture");
        labels[0][2].setText("Arts, Humanities & Social Science");
        labels[0][3].setText("Commerce");
        labels[1][0].setText("Computer Application");
        labels[1][1].setText("Design");
        labels[1][2].setText("Engineering & Technology");
        labels[1][3].setText("Journalism & Mass Communication");
        labels[2][0].setText("Management");
        labels[2][1].setText("Performing Arts");
        labels[2][2].setText("Science");
        labels[2][3].setText("Law & Legal Studies");

        schools[1][2].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Main_Frame.frame_number == 1)
                {
                    Selecting_School.p.setVisible(false);
                    Selecting_Branch.p.setVisible(true);
                    Bar.select.setText("Select Branch");
                    Main_Frame.frame_number = 2;
                    Bar.back.setEnabled(true);
                }
            }
        });
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<4; j++)
            {
                if (e.getSource() == schools[i][j])
                {
                    posX2 = (j*w)+19;
                    posY2 = (i*h)+15;
                    schools[i][j].setBounds(posX2,posY2,hoverWidth,hoverHeight);
                    schools[i][j].setIcon(new ImageIcon(hover_path[i][j]));
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<4; j++)
            {
                if (e.getSource() == schools[i][j])
                {
                    posX = (j*w)+24;
                    posY = (i*h)+20;
                    schools[i][j].setBounds(posX,posY,initialWidth,initialHeight);
                    schools[i][j].setIcon(new ImageIcon(path[i][j]));
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    public static void main(String[] args)
    {
        new Main_Frame();
    }
}
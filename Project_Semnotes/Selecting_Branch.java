package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Selecting_Branch extends basicDimensions implements MouseListener
{
    static JPanel p;
    JButton [][] branches;
    String [][] path, hover_path;
    JLabel [][] labels;
    Selecting_Branch()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setVisible(false);
        p.setBackground(light);

        branches = new JButton[3][4];
        labels = new JLabel[3][4];

        path = new String[3][4];
        hover_path = new String[3][4];

        path[0][0] = "src/Branches/Icons/1_CSE.jpg";
        path[0][1] = "src/Branches/Icons/2_Civil.jpg";
        path[0][2] = "src/Branches/Icons/3_Mechanical.jpg";
        path[0][3] = "src/Branches/Icons/4_EC.jpg";
        path[1][0] = "src/Branches/Icons/5_IT.jpg";
        path[1][1] = "src/Branches/Icons/6_AI.jpg";
        path[1][2] = "src/Branches/Icons/7_DS.jpg";
        path[1][3] = "src/Branches/Icons/8_IoT.jpg";
        path[2][0] = "src/Branches/Icons/9_ML.jpg";
        path[2][1] = "src/Branches/Icons/10_Robotics.jpg";
        path[2][2] = "src/Branches/Icons/11_Mechatronics.jpg";

        hover_path[0][0] = "src/Branches/Hover/1_CSE hover.jpg";
        hover_path[0][1] = "src/Branches/Hover/2_Civil hover.jpg";
        hover_path[0][2] = "src/Branches/Hover/3_Mechanical hover.jpg";
        hover_path[0][3] = "src/Branches/Hover/4_EC hover.jpg";
        hover_path[1][0] = "src/Branches/Hover/5_IT hover.jpg";
        hover_path[1][1] = "src/Branches/Hover/6_AI hover.jpg";
        hover_path[1][2] = "src/Branches/Hover/7_DS hover.jpg";
        hover_path[1][3] = "src/Branches/Hover/8_IoT hover.jpg";
        hover_path[2][0] = "src/Branches/Hover/9_ML hover.jpg";
        hover_path[2][1] = "src/Branches/Hover/10_Robotics hover.jpg";
        hover_path[2][2] = "src/Branches/Hover/11_Mechatronics hover.jpg";


        for (int i=0; i<3;i++)
        {
            for(int j=0; j<4; j++)
            {
                posX = (j*w)+24;
                posY = (i*h)+20;

                branches[i][j] = new JButton();
                branches[i][j].setBounds(posX,posY,initialWidth,initialHeight);
                branches[i][j].setIcon(new ImageIcon(path[i][j]));
                branches[i][j].setFont(font);
                branches[i][j].setBorder(null);
                branches[i][j].setBorderPainted(false);
                branches[i][j].setOpaque(false);
                branches[i][j].setBackground(null);
                branches[i][j].addMouseListener(this);

                label_X = (j*w)+5;
                label_Y = (i*h)+30+hoverHeight;

                labels[i][j] = new JLabel();
                labels[i][j].setBounds(label_X,label_Y,175,30);
                labels[i][j].setFont(font);
                labels[i][j].setHorizontalAlignment(0);
//                labels[i][j].setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
                labels[i][j].setForeground(Color.BLACK);

                p.add(branches[i][j]);
                p.add(labels[i][j]);
            }
        }

        labels[0][0].setText("Computer Science & Engineering");
        labels[0][1].setText("Civil Engineering");
        labels[0][2].setText("Mechanical Engineering");
        labels[0][3].setText("Electronics & Communication Engineering");
        labels[1][0].setText("Information Technology");
        labels[1][1].setText("Artificial Intelligence");
        labels[1][2].setText("Data Science");
        labels[1][3].setText("Internet of Things");
        labels[2][0].setText("Machine Learning");
        labels[2][1].setText("Automation & Robotics");
        labels[2][2].setText("Mechatronics Engineering");
        
        branches[2][3].setVisible(false);
        labels[2][3].setVisible(false);

        branches[0][0].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Main_Frame.frame_number == 2)
                {
                    Selecting_Branch.p.setVisible(false);
                    Selecting_Semester.p.setVisible(true);
                    Bar.select.setText("Select Semester");
                    Main_Frame.frame_number = 3;
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
                if (e.getSource() == branches[i][j])
                {
                    posX2 = (j*w)+19;
                    posY2 = (i*h)+15;
                    branches[i][j].setBounds(posX2,posY2,hoverWidth,hoverHeight);
                    branches[i][j].setIcon(new ImageIcon(hover_path[i][j]));
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
                if (e.getSource() == branches[i][j])
                {
                    posX = (j*w)+24;
                    posY = (i*h)+20;
                    branches[i][j].setBounds(posX,posY,initialWidth,initialHeight);
                    branches[i][j].setIcon(new ImageIcon(path[i][j]));
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

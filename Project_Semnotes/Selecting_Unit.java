package Project_Semnotes;

import Database.Downloading_Files;
import Database.Viewing_Files;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selecting_Unit extends basicDimensions
{
    static JPanel p;
    JButton [] units;
    JButton syllabus;

    Selecting_Unit()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setBackground(light);
        p.setVisible(false);

        units = new JButton[5];

        initialWidth = 125;
        initialHeight = 50;

        for (int i=0; i<5; i++)
        {
            posX = 50;
            posY = i*90+65;

            units[i] = new JButton();
            units[i].setBounds(posX,posY,initialWidth,initialHeight);
            units[i].setFont(font);
            units[i].setText("Unit "+(i+1));

            p.add(units[i]);
        }

        syllabus = new JButton("Syllabus");
        syllabus.setBounds(250,65,initialWidth, initialHeight);
        syllabus.setFont(font);
        p.add(syllabus);

        syllabus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    int opt = JOptionPane.showConfirmDialog(Main_Frame.f,"Are you sure to download this file ?", "Download", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (opt == JOptionPane.YES_OPTION)
                    {
//                        new Downloading_Files();
                        Viewing_Files viewFiles = new Viewing_Files();
                        viewFiles.viewFile();
                        JOptionPane.showMessageDialog(Main_Frame.f,Downloading_Files.fileName+" downloaded successfully :)", "Downloaded", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                catch (Exception ex) {
                    System.out.println("Failed to Download File..!!");
                    System.out.println(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Log_in();
    }
}

package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selecting_Unit_DBMS extends basicDimensions implements ActionListener
{
    static JPanel p;
    static int unitNumber;
    JLabel [] units;
    JButton [] downloadButton, viewButton;
    Font unitFont;
    Subject_DBMS_Notes dbmsNotes;
    Selecting_Unit_DBMS()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setBackground(light);
        p.setVisible(false);

        dbmsNotes = new Subject_DBMS_Notes();

        units = new JLabel[5];
        downloadButton = new JButton[5];
        viewButton = new JButton[5];

        initialWidth = 125;
        initialHeight = 50;

        unitFont = new Font("Times new Roman", Font.BOLD, 20);

        for (int i=0; i<5; i++)
        {
            posX = 50;
            posY = i*90+65;

            units[i] = new JLabel();
            units[i].setBounds(posX+10,posY,initialWidth,initialHeight);
            String unitName = "Unit "+(i+1)+"      :";
            units[i].setText(unitName);
            units[i].setFont(unitFont);
            units[i].setHorizontalAlignment(0);
            p.add(units[i]);

            downloadButton[i] = new JButton("Download");
            downloadButton[i].setBounds(posX+initialWidth+25,posY,initialWidth,initialHeight);
            downloadButton[i].setFont(new Font("Times new Roman", Font.PLAIN, 18));
            downloadButton[i].setBackground(Color.WHITE);
            downloadButton[i].setBorder(border);
            downloadButton[i].addActionListener(this);
            p.add(downloadButton[i]);

            viewButton[i] = new JButton("View");
            viewButton[i].setBounds(posX+initialWidth+initialWidth+50,posY,initialWidth,initialHeight);
            viewButton[i].setFont(new Font("Times new Roman", Font.PLAIN, 18));
            viewButton[i].setBackground(Color.WHITE);
            viewButton[i].setBorder(border);
            viewButton[i].addActionListener(this);
            p.add(viewButton[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i<5; i++)
        {
            if (e.getSource() == downloadButton[i])
            {
                unitNumber = i+1;
                String msg = "Do you want to Download Unit "+unitNumber+" Notes";
                int option = JOptionPane.showConfirmDialog(Main_Frame.f,msg,"Download Notes",JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                {
                    dbmsNotes.downloadNotesDBMS();
                    String downloaded = Subject_DBMS_Notes.fileName+" downloaded successfully..!";
                    JOptionPane.showMessageDialog(Main_Frame.f,downloaded,"Downloaded",JOptionPane.INFORMATION_MESSAGE);
                }
            }

            else if (e.getSource() == viewButton[i])
            {
                unitNumber = i+1;
                String msg = "Do you want to View Unit "+unitNumber+" Notes";
                int option = JOptionPane.showConfirmDialog(Main_Frame.f,msg,"Download Notes",JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION)
                    dbmsNotes.viewNotesDBMS();
            }
        }
    }

    public static void main(String[] args)
    {
        new Log_in();
    }
}

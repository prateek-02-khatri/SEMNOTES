package Project_Semnotes;

import javax.swing.*;
import java.awt.*;

public class Welcome_Screen extends JPanel
{
    JWindow w;
    JProgressBar pb;
    Timer t;
    Welcome_Screen()
    {
        w = new JWindow();
        GroupLayout.Alignment center_pos = GroupLayout.Alignment.CENTER;
        w.setBounds(center_pos.ordinal(), center_pos.ordinal(), 450,200);
        w.setLocationRelativeTo(null);
        w.add(this);

        pb = new JProgressBar(0, 100);
        pb.setStringPainted(true);
        w.add(pb, BorderLayout.PAGE_END);

        t = new Timer(100, e ->
        {
            int load = pb.getValue();
            if (load == 100)
            {
                w.dispose();
                t.stop();
                new Log_in();
            }
            else
                pb.setValue(load+4);
        });
        t.start();

        w.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        String path = "src/Images/App Front.jpg";
        Image image = new ImageIcon(path).getImage();
        g.drawImage(image, 0,0, w.getWidth(), w.getHeight(), null);
    }

    public static void main(String[] args)
    {
        new Welcome_Screen();
    }
}

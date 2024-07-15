package Project_Semnotes;
import javax.swing.*;

public class Notes_Library extends basicDimensions
{
    static JPanel p;
    Notes_Library()
    {
        p = new JPanel();
        p.setBounds(panel_bounds);
        p.setLayout(null);
        p.setBackground(light);
        p.setVisible(false);
    }
    public static void main(String[] args)
    {
        new Log_in();
    }
}
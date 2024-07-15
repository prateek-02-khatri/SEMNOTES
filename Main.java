import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    JFrame f;
    JButton b;
    Main()
    {
        f = new JFrame();
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        b = new JButton("Get Size");
        b.setBounds(150,200,150,30);
        b.addActionListener( e ->
        {
            Rectangle rect = f.getBounds();
            System.out.println("x : "+rect.getX());
            System.out.println("y : "+rect.getY());
            System.out.println("w : "+rect.getWidth());
            System.out.println("h : "+rect.getHeight());
            System.out.println();
        });
        f.add(b);
        f.setVisible(true);
    }

    void createFolderIfDoesNotExist()
    {
        if (Files.exists(Path.of("C:/Users/dell/Desktop/My Download")))
            System.out.println("Yes");
        else
        {
            System.out.println("No");
            File file = new File("C:/Users/dell/Desktop/My_Folder");
            boolean flag = file.mkdir();
            System.out.println(flag);
        }
    }
    public static void main(String[] args)
    {
        new Main();
    }
}
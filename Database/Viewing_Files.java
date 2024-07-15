package Database;

import java.awt.*;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Viewing_Files
{
    public static String fileName;
    public void viewFile()
    {
        String download_query = "select * from notes where file_id=8";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/semnotes_db";
            String user = "root";
            String pswd = "P02122003K";

            Connection connection = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = connection.prepareStatement(download_query);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                fileName = rs.getString("file_name");
                Blob blob = rs.getBlob("file_content");
                InputStream inputStream = blob.getBinaryStream();
                Files.copy(inputStream, Paths.get("C:\\Users\\dell\\Desktop\\My Downloads\\"+fileName));

                File file = new File("C:\\Users\\dell\\Desktop\\My Downloads\\"+fileName);

                if(!Desktop.isDesktopSupported())
                {
                    System.out.println("Not Supported");
                }
                else
                {
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists())
                    {
                        System.out.println("Opening File...");
                        desktop.open(file);
                        file.deleteOnExit();
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void deleteFile()
    {
        try
        {
            File f = new File("C:\\Users\\dell\\Desktop\\My File.txt");
            if (f.delete())
                System.out.println(f.getName() + " deleted.");
            else
                System.out.println("Error..!!");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Viewing_Files obj = new Viewing_Files();
        obj.viewFile();
    }
}

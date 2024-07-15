package Database;

import java.io.InputStream;
import java.sql.*;

public class Downloading_Files
{
    public static String fileName;
    public Downloading_Files()
    {
        String download_query = "select * from notes where file_id=8";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/semnotes_db";
            String user = "root";
            String pswd = "P02122003K";

            Connection connection = DriverManager.getConnection(url,user,pswd);
            PreparedStatement ps = connection.prepareStatement(download_query);
            ResultSet rs = ps.executeQuery();

//            System.out.println("Following flies are downloaded from database..");

            while (rs.next())
            {
                int fileId = rs.getInt("file_id");
                fileName = rs.getString("file_name");
                long fileSize = rs.getLong("file_size");
                String fileExtension = rs.getString("file_extension");
                System.out.println("Downloaded Successfully :)");

                Blob blob = rs.getBlob("file_content");
                InputStream inputStream = blob.getBinaryStream();
//                Files.copy(inputStream, Paths.get("C:/Users/dell/Desktop/My Downloads/"+fileName));

            }
        }
        catch (Exception e)
        {
            System.out.println("Error : "+e);
        }
//        catch (IOException | ClassNotFoundException | SQLException e)
//        {
//            System.out.println(e);;
//        }
    }

    public static void main(String[] args)
    {
        new Downloading_Files();
    }
}

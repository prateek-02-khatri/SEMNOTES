package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Uploading_Files
{
    public static void main(String[] args)
    {
        String upload_query = "insert into notes(file_name,file_size,file_extension,file_content) values(?,?,?,?)";
        Path dir = Paths.get("src/temp_downloads");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/semnotes_db";
            String user = "root";
            String pswd = "P02122003K";

            Connection connection = DriverManager.getConnection(url,user,pswd);

            PreparedStatement ps = connection.prepareStatement(upload_query);
            Stream<Path> list = Files.list(dir);

            List<Path> pathList = list.collect(Collectors.toList());

            System.out.println("Following files are saved in database..");
            for (Path path : pathList)
            {
                System.out.println(path.getFileName());
                File file = path.toFile();
                String fileName = file.getName();
                long fileLength = file.length();
                long fileLengthInKb = fileLength/1024;

                ps.setString(1, fileName);

                ps.setLong(2, fileLengthInKb);
                ps.setString(3, fileName.substring(fileName.lastIndexOf(".")+1));
                FileInputStream fis = new FileInputStream(file);
                ps.setBinaryStream(4, fis, fileLength);

                ps.addBatch();
            }
            System.out.println("----------------------------------------");
            int [] executeBatch = ps.executeBatch();
            for (int i : executeBatch)
            {
                System.out.println(i);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
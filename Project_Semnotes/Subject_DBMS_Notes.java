package Project_Semnotes;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Subject_DBMS_Notes {
    public static String fileName;

    public static void main(String[] args) {
        Subject_DBMS_Notes notes = new Subject_DBMS_Notes();
        notes.uploadNotesDBMS();
    }

    public static void uploadNotesDBMS() {
        String upload_query = "INSERT INTO notes(file_id, file_name, file_extension, file_content) VALUES(?,?,?,?)";
        Path dir = Paths.get("src/temp_downloads");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes";
            String user = "root";
            String pswd = "Prateek#02";

            Connection connection = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = connection.prepareStatement(upload_query);

            Stream<Path> list = Files.list(dir);
            List<Path> pathList = list.collect(Collectors.toList());

            System.out.println("Following files are saved in the database..");
            int id = 1;
            for (Path path : pathList) {
                System.out.println(path.getFileName());
                File file = path.toFile();
                String fileName = file.getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                long fileLength = attr.size();

                ps.setInt(1, id);
                id++;
                ps.setString(2, fileName);
                ps.setString(3, fileExtension);

                FileInputStream fis = new FileInputStream(file);
                ps.setBinaryStream(4, fis, fileLength);

                ps.addBatch();
            }
            System.out.println("----------------------------------------");
            int[] executeBatch = ps.executeBatch();
            for (int i : executeBatch) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("Upload Error: " + e);
        }
    }


    public void downloadNotesDBMS() {
        String downloadPath = "src/downloads";
        String unitNumber = String.valueOf(Selecting_Unit_DBMS.unitNumber);
        String download_query = "select * from notes where file_id = " + unitNumber;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes";
            String user = "root";
            String pswd = "Prateek#02";

            Connection connection = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = connection.prepareStatement(download_query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fileName = rs.getString("file_name");
                Blob blob = rs.getBlob("file_content");
                InputStream inputStream = blob.getBinaryStream();
                File folderPath = new File(downloadPath);
                if (folderPath.exists()) {
                    File notesFile = new File(downloadPath + "/" + fileName);
                    if (!notesFile.exists()) {
                        Files.copy(inputStream, Paths.get(downloadPath + "/" + fileName));
                    } else {
                        JOptionPane.showMessageDialog(null, "File Already Exist..!!", "Existing File", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    folderPath.mkdir();
                    Files.copy(inputStream, Paths.get(downloadPath + "/" + fileName));
                }
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void viewNotesDBMS() {
        String downloadPath = "src/downloads";
        String unitNumber = String.valueOf(Selecting_Unit_DBMS.unitNumber);
        String download_query = "select * from notes where file_id = " + unitNumber;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes";
            String user = "root";
            String pswd = "Prateek#02";

            Connection connection = DriverManager.getConnection(url, user, pswd);
            PreparedStatement ps = connection.prepareStatement(download_query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fileName = rs.getString("file_name");
                Blob blob = rs.getBlob("file_content");
                InputStream inputStream = blob.getBinaryStream();

                File folder = new File(downloadPath);

                if (folder.exists()) {
                    File notesFile = new File(downloadPath + "/" + fileName);
                    if (!notesFile.exists()) {
                        Files.copy(inputStream, Paths.get(downloadPath + "/" + fileName));
                        if (Desktop.isDesktopSupported() && notesFile.exists()) {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.open(notesFile);
                            notesFile.deleteOnExit();
                        }
                    } else {
                        if (Desktop.isDesktopSupported() && notesFile.exists()) {
                            Desktop desktop = Desktop.getDesktop();
                            desktop.open(notesFile);
                            notesFile.deleteOnExit();
                        }
                    }
                } else {
                    folder.mkdir();
                    Files.copy(inputStream, Paths.get(downloadPath + "/" + fileName));
                    File notesFile = new File(downloadPath + "/" + fileName);
                    if (Desktop.isDesktopSupported() && notesFile.exists()) {
                        Desktop desktop = Desktop.getDesktop();
                        desktop.open(notesFile);
                        notesFile.deleteOnExit();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Creating_Table
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes_db";
            String user = "root";
            String pswd = "P02122003K";
            Connection con = DriverManager.getConnection(url, user, pswd);
            System.out.println("Connected Successfully..!!");

//            String users_query = "create table users(Username varchar(200), Password varchar(200))";
//            Statement s = con.createStatement();
//            s.executeUpdate(users_query);

            String notes_upload_query = "CREATE TABLE Notes(file_id varchar(20) NOT NULL PRIMARY KEY, file_name varchar(50) NOT NULL, file_size bigint(20) NOT NULL, file_extension char(30) NOT NULL, file_content longblob  NOT NULL)";

            Statement s = con.createStatement();
            s.executeUpdate(notes_upload_query);
            System.out.println("Table created..!!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
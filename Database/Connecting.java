package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecting
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes_db";
            String user = "root";
            String pswd = "P02122003K";
            Connection con = DriverManager.getConnection(url, user, pswd);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

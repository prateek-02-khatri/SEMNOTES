package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Inserting
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes_db";
            String user = "root";
            String pswd = "P02122003K";
            Connection con = DriverManager.getConnection(url, user, pswd);

            String q = "insert into users(Username,Password) values(?,?)";
            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, "Prateek Khatri");
            ps.setString(2, "Prateek#02");
            ps.executeUpdate();

            System.out.println("Data Inserted Succesfully..!!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

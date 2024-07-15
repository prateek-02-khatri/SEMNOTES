package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Searching
{
    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes_db";
            String user = "root";
            String pswd = "P02122003K";
            Connection con = DriverManager.getConnection(url, user, pswd);

            String query_name = "select Username from users where Username=?";
            String query_pswd = "select Password from users where Password=?";

            PreparedStatement ps1 = con.prepareStatement(query_name);
            PreparedStatement ps2 = con.prepareStatement(query_pswd);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Username : ");
            String temp_name = sc.nextLine();

            System.out.print("Enter Password : ");
            String temp_pswd = sc.nextLine();

            ps1.setString(1, temp_name);
            ps2.setString(1, temp_pswd);

            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();

            if (!rs1.next())
            {
                System.out.println("No Record Found..!!");
                JOptionPane.showMessageDialog(null, "Sorry Record not found..!!");
            }

            else
            {
                if (!rs2.next())
                    System.out.println("Invalid Password..!!");
                else
                    System.out.println("\n\tWelcome");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
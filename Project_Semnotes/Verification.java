package Project_Semnotes;

import javax.swing.*;
import java.sql.*;

public class Verification {
    static String student_name, student_id, student_password;
    static Connection con;
    static PreparedStatement ps;
    static ResultSet rs;

    public static void Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Semnotes";
            String user = "root";
            String pswd = "Prateek#02";
            con = DriverManager.getConnection(url, user, pswd);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void checking() {
        try {
            String query = "select * from users where s_id = ?";
            ps = con.prepareStatement(query);
            String input_id = Log_in.user_id.getText();
            ps.setString(1, input_id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void verify() {
        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(Log_in.f, "Record not found..!!", "Unknown User", JOptionPane.ERROR_MESSAGE);
            } else {
                student_id = rs.getString("s_id").toUpperCase();
                student_name = rs.getString("Username");
                student_password = rs.getString("Password");

                String input_id = Log_in.user_id.getText();
                String input_password = Log_in.password.getText();

                if (!input_id.equals(student_id)) {
                    JOptionPane.showMessageDialog(Log_in.f, "Record not found..!!", "Unknown User", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!input_password.equals(student_password)) {
                        JOptionPane.showMessageDialog(Log_in.f, "Invalid Password..!!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Log_in.f, "Welcome " + student_name, "SEMNOTES", JOptionPane.PLAIN_MESSAGE);
                        Log_in.f.dispose();
                        new Main_Frame();
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Log_in();
    }
}
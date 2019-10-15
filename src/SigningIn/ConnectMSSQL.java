package SigningIn;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Security.*;
import Admin.*;

public class ConnectMSSQL {
    public static Connection connected;
    public void connectDB(String s1, String s2, String s3) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Apartment Security Management System;selectMethod=cursor", "sa", "123456");
            System.out.println("DATABASE NAME IS:" + connection.getMetaData().getDatabaseProductName());
            connected=connection;
            PreparedStatement statement = connection.prepareStatement("SELECT * from "+ s3);
            boolean f = false;
            if (s3.equals("Admin")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    if ((s2.equals(resultSet.getString("Password")) && s1.equals(resultSet.getString("Username")))) {
                        f = true;
                        break;
                    }
                }
                if(f){
                    AdminInfo.main(null);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Information");
                    Login.main(null);
                }
            } else if (s3.equals("Security")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    if ((s2.equals(resultSet.getString("Password")) && s1.equals(resultSet.getString("Username")))) {
                        f = true;
                        break;
                    }
                }
                if (f) {
                    SecurityInfo.main(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Information");
                    Login.main(null);
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error found at ConnectMSSQL class, ConnectDB()");
            System.out.println("Error: " + e);
        }
    }
}

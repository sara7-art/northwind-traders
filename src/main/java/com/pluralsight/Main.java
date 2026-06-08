package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws IOException {

        Properties props = new Properties();
        props.load(new FileInputStream("database.properties"));

        String url = "JDBC:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "yearup2026";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            String query = "SELECT ProductName FROM Products";

            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                System.out.println(results.getString("ProductName"));
            }

            results.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

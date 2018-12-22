/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1;
import java.sql.*;
/**
 *
 * @author kimsal
 */
public class Lesson1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123";

        System.out.println("Connecting database...");
           
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Class.forName("com.mysql.jdbc.Driver"); 
            System.out.println("Database connected!");
            
            Statement stmt=connection.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from person");

            while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}

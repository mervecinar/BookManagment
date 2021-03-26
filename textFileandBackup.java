/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanagment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class textFileandBackup {
//BOOKTABLE 
    public static void  exporttotxtfileBook() throws ClassNotFoundException, SQLException, IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException e) {
            System.out.println(" class bulunamadııgg");

            e.printStackTrace();
        }

        try {

            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = c.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM BOOK");
            System.out.println(" go to the file and check the informations");
            System.out.println(result);
            FileWriter k = new FileWriter("C:\\Users\\PC\\OneDrive\\Masaüstü\\java2proje\\book.txt");
            BufferedWriter h = new BufferedWriter(k);
            while (result.next()) {
                try {
                    h.write(result.getString("BOOKID"));
                    h.write(result.getString("BOOKNAME"));
                    h.write(result.getString("BOOKAUTHOR"));
                    h.write(result.getString("BOOKGENRE"));
                    h.newLine();

                } catch (Exception e) {

                    System.out.println(e);

                }
            }
            h.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //USERSTABLE
     public static void  exporttotxtfileUser() throws ClassNotFoundException, SQLException, IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException e) {
            System.out.println(" class bulunamadııgg");

            e.printStackTrace();
        }

        try {

            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = c.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM USERS");
            System.out.println(" go to the file and check the informations");
            System.out.println(result);
            FileWriter k = new FileWriter("C:\\Users\\PC\\OneDrive\\Masaüstü\\java2proje\\users.txt");
            BufferedWriter h = new BufferedWriter(k);
            while (result.next()) {
                try {
                    h.write(result.getString("UID"));
                    h.write(result.getString("UNAME"));
                    h.write(result.getString("UPASS"));
                    h.write(result.getString("UGENDER"));
                    h.newLine();

                } catch (Exception e) {

                    System.out.println(e);

                }
            }
            h.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     //ADMİNTABLE
      public static void  exporttotxtfileAdmin() throws ClassNotFoundException, SQLException, IOException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");

        } catch (ClassNotFoundException e) {
            System.out.println(" class bulunamadııgg");

            e.printStackTrace();
        }

        try {

            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = c.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM ADMİN");
            System.out.println(" go to the file and check the informations");
            System.out.println(result);
            FileWriter k = new FileWriter("C:\\Users\\PC\\OneDrive\\Masaüstü\\java2proje\\admin.txt");
            BufferedWriter h = new BufferedWriter(k);
            while (result.next()) {
                try {
                    h.write(result.getString("AID"));
                    h.write(result.getString("ANAME"));
                    h.write(result.getString("APASS"));
                    h.write(result.getString("AGENDER"));
                    h.newLine();

                } catch (Exception e) {

                    System.out.println(e);

                }
            }
            h.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
      
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        textFileandBackup a= new textFileandBackup();
        a.exporttotxtfileBook();
        a.exporttotxtfileUser();
      a.exporttotxtfileAdmin();
       //My BackUp
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("cmd.exe /c start C:\\Users\\PC\\AppData\\Roaming\\NetBeans\\8.2\\config\\Preferences\\org\\netbeans\\modules\\derby\\databases");
            System.exit(0);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
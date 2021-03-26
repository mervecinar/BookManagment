/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookmanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class user extends BookandUser{
    int n;
    String a;
    String b;
    @Override
    public void isExist(String a) {
    

 userView u= new userView();

        String sql="select* from USERS where UNAME like '"+a+"%'";
      
                try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE" ,"123");
        java.sql.Statement stmt=c.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
              
       
          while(rs.next()){
              int UID=rs.getInt("UID");
              String UNAME=rs.getString("UNAME");
                int  UPASS=rs.getInt("UPASS");

                String UGENDER = (String) rs.getString("UGENDER");
              
              System.out.println(UID+" "+UNAME +" "+UPASS+" "+UGENDER);
              userView.k.addRow(new Object []{UID,UNAME,UPASS,UGENDER}); 
          
            u.setVisible(true);
       }
        }catch(SQLException e){
                System.out.println(e);
                }
    }
    @Override
    public String printt(String a, String s, int numara) {
        return a +" "+b +" "+" "+n;
        
    }


        public static void main(String[] args) {
             user h= new user();
            h.isExist("merve");
            h.printt("merve", "çınar", 2000);
        }

    

}


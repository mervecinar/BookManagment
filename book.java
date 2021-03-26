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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */

    public class book extends BookandUser{
        
    int n;
    String a;
    String s;
    int b;
  



    @Override
    public void isExist(String a) {
    

   bookView b= new bookView();

        String sql="select* from BOOK where BOOKNAME like '"+a+"%'";
      
                try{
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE" ,"123");
        java.sql.Statement stmt=c.createStatement();
        ResultSet rs= stmt.executeQuery(sql);
              
       
          while(rs.next()){
              int BOOKID=rs.getInt("BOOKID");
              String BOOKNAME=rs.getString("BOOKNAME");
                int  BOOKPAGE=rs.getInt("BOOKPAGE");
              String BOOKAUTHOR =rs.getString("BOOKAUTHOR");
                String BOOKGENRE = (String) rs.getString("BOOKGENRE");
              
              System.out.println(BOOKID+" "+BOOKNAME +" "+BOOKPAGE+" "+BOOKAUTHOR +" "+BOOKGENRE);
            bookView.c.addRow(new Object []{BOOKID,BOOKNAME,BOOKPAGE,BOOKAUTHOR,BOOKGENRE}); 
              
            
          
            b.setVisible(true);
       }
        }catch(SQLException e){
                System.out.println(e);
                }
    
 
    } 
    @Override
    public String printt(String a, String s, int numara) {
       return a+ " "+ s+ " "+ n;
    }
    //overloading
    public String Bookİnfo(String a,String s){
        this.a=a;
        this.s=s;
        return "author name=" + a +" author surname =" +s;
        
    }
    //overloading
       public String Bookİnfo(String a,String s,int c,int d){
        this.a=a;
        this.s=s;
        this.n=c;
        this.b=d;
        return "author name=" + a +" author surname =" +s+"yearofbook= "+c + "pageofbook = " +d;
        
    }

        public static void main(String[] args) {
             book b= new book();
            b.isExist("c");
            b.printt("jurnes", "verne", 1969);
        }

   
  
}

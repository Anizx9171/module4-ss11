package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
   private static final String URL = "jdbc:mysql://localhost:3306/ss10";
   private static final String UNAME = "root";
   private static final String UPASS = "Anizx9171?!";

   public static Connection opDB(){
       Connection c = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           c = DriverManager.getConnection(URL,UNAME,UPASS);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return c;
   }
   public static void clDB(Connection c) {
       if (c != null){
           try {
               c.close();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
   }
}

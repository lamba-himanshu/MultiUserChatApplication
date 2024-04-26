package com.himanshu.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.himanshu.chatapp.utils.ConfigReader.getValue;


// Implementing the CommonDAO interface
public interface CommonDAO {
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        // Step 1 - Load driver
        Class.forName(getValue("Driver"));
        
        // Step 2 - Making connection
        final String connection_String = getValue( "Connection_url");
        String userID = getValue("userID");
        String password = getValue("password");
        Connection con = DriverManager.getConnection(connection_String, userID, password);
        
        if (con != null) {    // Check connection
            System.out.println("Connection Created...");
            //con.close();
        }
        return con;
    }

    
}

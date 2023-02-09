package com.example.appstage.services;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class SignletonConnexionDB {
    public  static final String URL="src/main/resources/database/stageDB";

    private static Connection connection ;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection= DriverManager.getConnection("jdbc:sqlite:"+URL);

          //  connection= DriverManager.getConnection(" jdbc:sqlite:src/main/resources/database/stageDB");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}

package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstarctDAO {
    public  Connection connect() throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "Mizan_12";

        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

}

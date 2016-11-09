package com.gqxie.study;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstProject {

    public static void main(String[] args) throws SQLException {
        java.sql.Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/study";
        String user = "root";
        String password = "password";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("Succeeded connetcing to the Database!");
            }
            java.sql.Statement statement = con.createStatement();
            String sql = "select * from student";
            ResultSet rs = statement.executeQuery(sql);
            String name = null;
            String id = null;
            while (rs.next()) {
                name = rs.getString("name");
                id = rs.getString("id");
                System.out.println(id + "\t" + name);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！");
        }
    }
}

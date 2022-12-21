package com.ky.database.tables;

import com.ky.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersTable {
    public static void create(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="CREATE TABLE users (id int primary key auto_increment,username varchar(256) not null,email varchar(256) not null, password varchar(256) not null,photo varchar(256), created_at timestamp default current_timestamp, unique(username),unique(email))";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("users table created.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void destroy(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="DROP TABLE users";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("users table deleted.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

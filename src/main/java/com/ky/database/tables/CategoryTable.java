package com.ky.database.tables;

import com.ky.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryTable {
    public static void create(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="CREATE TABLE category (id int primary key auto_increment,name varchar(256) not null,description varchar(256), created_at timestamp default current_timestamp,updated_at timestamp default current_timestamp, unique(name))";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("category table created.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void destroy(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="DROP TABLE category";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("category table deleted.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

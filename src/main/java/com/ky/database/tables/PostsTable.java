package com.ky.database.tables;

import com.ky.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostsTable {
    public static void create(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="CREATE TABLE posts (id int primary key auto_increment,title varchar(256) not null,content text,image varchar(256),category_id int, user_id int, created_at timestamp default current_timestamp,updated_at timestamp default current_timestamp, unique(title))";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("posts table created.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void destroy(){
        try {
            Connection cn= ConnectDB.connect();
            String sql="DROP TABLE posts";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("posts table deleted.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

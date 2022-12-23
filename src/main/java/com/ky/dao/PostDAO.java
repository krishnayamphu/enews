package com.ky.dao;

import com.ky.database.ConnectDB;
import com.ky.models.Category;
import com.ky.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
    public static ArrayList<Post> allPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM posts";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static Post getPost(int id) {
        Post post = null;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM posts WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }

    public static boolean create(Post post) {
        boolean status = false;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "INSERT INTO posts (title,content,image,category_id,user_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setInt(4, post.getCategoryId());
            ps.setInt(5, post.getUserId());
            if (ps.executeUpdate() == 0) {
                status = true;
            }
            System.out.println("data inserted");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean update(Post post) {
        boolean status = false;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "UPDATE posts SET title=?, content=?,image=?,category_id=?,user_id=? WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setInt(4, post.getCategoryId());
            ps.setInt(5, post.getUserId());
            ps.setInt(6, post.getId());
            if (ps.executeUpdate() == 0) {
                status = true;
            }
            System.out.println("data updated");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean remove(int id) {
        boolean status = false;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DELETE FROM posts WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 0) {
                status = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}

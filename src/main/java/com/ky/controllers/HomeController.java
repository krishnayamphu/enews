package com.ky.controllers;

import com.ky.dao.PostDAO;
import com.ky.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Post> posts= PostDAO.allPosts();
        ArrayList<Post> latestPosts= PostDAO.latestPosts();
        request.setAttribute("posts",posts);
        request.setAttribute("latestPosts",latestPosts);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}

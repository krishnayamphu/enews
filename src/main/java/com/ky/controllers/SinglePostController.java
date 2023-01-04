package com.ky.controllers;

import com.ky.dao.PostDAO;
import com.ky.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinglePostController", value = "/single")
public class SinglePostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ArrayList<Post> latestPosts= PostDAO.latestPosts();
        Post post= PostDAO.getPost(id);
        request.setAttribute("post",post);
        request.setAttribute("latestPosts",latestPosts);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
}

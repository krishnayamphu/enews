package com.ky.controllers.admin.posts;

import com.ky.dao.PostDAO;
import com.ky.listeners.ContextPostListener;
import com.ky.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostsController", value = "/posts")
public class PostsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new ContextPostListener(getServletContext()).updateValue(null);
        request.getRequestDispatcher("admin/posts/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PostDAO.remove(id);
        new ContextPostListener(getServletContext()).updateValue(null);
        response.sendRedirect(request.getHeader("referer"));
    }
}

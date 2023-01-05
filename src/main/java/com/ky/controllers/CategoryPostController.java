package com.ky.controllers;

import com.ky.dao.CategoryDAO;
import com.ky.dao.PostDAO;
import com.ky.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoryPostController", value = "/cat")
public class CategoryPostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catItem=request.getParameter("name");
        int id = CategoryDAO.getCategoryByName(catItem).getId();
        ArrayList<Post> categoryPosts = PostDAO.getPostsByCategory(id);
        request.setAttribute("categoryPosts", categoryPosts);
        request.getRequestDispatcher("category.jsp").forward(request, response);

    }
}

package com.ky.controllers.admin.category;

import com.ky.dao.CategoryDAO;
import com.ky.models.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories= CategoryDAO.allCategories();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("admin/category/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryDAO.remove(id);
        response.sendRedirect(request.getHeader("referer"));
    }
}

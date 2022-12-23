package com.ky.controllers.admin.category;

import com.ky.dao.CategoryDAO;
import com.ky.models.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryEditController", value = "/category-edit")
public class CategoryEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryDAO.getCategory(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("admin/category/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String description=request.getParameter("description");
        Category category=new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        CategoryDAO.update(category);
        response.sendRedirect(request.getHeader("referer"));
    }
}

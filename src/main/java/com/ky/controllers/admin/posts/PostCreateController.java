package com.ky.controllers.admin.posts;

import com.ky.dao.CategoryDAO;
import com.ky.dao.PostDAO;
import com.ky.listeners.ContextPostListener;
import com.ky.models.Category;
import com.ky.models.Post;
import com.ky.models.User;
import com.ky.utils.MediaFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostCreateController", value = "/post-create")
public class PostCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories= CategoryDAO.allCategories();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("admin/posts/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String image=request.getParameter("image");
        int categoryId=Integer.parseInt(request.getParameter("category"));
        User currentUser= (User) getServletContext().getAttribute("currentUser");
        int userId=currentUser.getId();
        Post post=new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImage(image);
        post.setCategoryId(categoryId);
        post.setUserId(userId);
        PostDAO.create(post);

        new ContextPostListener(getServletContext()).updateValue(null);
        response.sendRedirect("posts");
    }
}

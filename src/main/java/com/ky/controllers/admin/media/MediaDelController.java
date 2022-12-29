package com.ky.controllers.admin.media;

import com.ky.utils.MediaFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MediaDelController", value = "/media-del")
public class MediaDelController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item=request.getParameter("media");
        String root = getServletContext().getRealPath("/uploads");
        MediaFile.delete(root,item);
        response.sendRedirect(request.getHeader("referer"));
    }
}

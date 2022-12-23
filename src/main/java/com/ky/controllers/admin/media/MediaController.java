package com.ky.controllers.admin.media;

import com.ky.utils.MediaFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MediaController", value = "/media")
public class MediaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String root = getServletContext().getRealPath("/uploads");
        ArrayList<String> files = MediaFile.getFiles(root);
        request.setAttribute("files", files);
        request.getRequestDispatcher("media/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            try {
                List<FileItem> items = upload.parseRequest(request);
                // Process the uploaded items
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        //processFormField(item);
                    } else {
                        String contextPath = getServletContext().getRealPath("/");
                        processUploadedFile(item, contextPath);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        } else {
            pw.print("reqest is regular");
        }
        response.sendRedirect("media");
    }

    private void processUploadedFile(FileItem item, String contextPath) {
        String fileName = item.getName();
        File path = new File(contextPath + "/uploads");
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadedFile = new File(path + "/" + fileName);
        try {
            item.write(uploadedFile);
            System.out.println("File Uploaded to :" + uploadedFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

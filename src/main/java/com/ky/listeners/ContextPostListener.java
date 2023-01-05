package com.ky.listeners;

import com.ky.dao.PostDAO;
import com.ky.listeners.job.JobListener;
import com.ky.models.Post;

import javax.servlet.ServletContext;
import java.util.ArrayList;

public class ContextPostListener implements JobListener {
    private ServletContext context;

    public ContextPostListener(ServletContext context) {
        this.context = context;
    }

    @Override
    public void updateValue(Object newValue) {
        ArrayList<Post> posts= PostDAO.allPosts();
        ArrayList<Post> latestPosts= PostDAO.latestPosts();
        context.setAttribute("posts",posts);
        context.setAttribute("latestPosts",latestPosts);
    }
}

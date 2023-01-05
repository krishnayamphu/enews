package com.ky.listeners;

import com.ky.dao.PostDAO;
import com.ky.dao.UserDAO;
import com.ky.listeners.job.JobListener;
import com.ky.models.Post;
import com.ky.models.User;

import javax.servlet.ServletContext;
import java.util.ArrayList;

public class ContextUserListener implements JobListener {
    private ServletContext context;

    public ContextUserListener(ServletContext context) {
        this.context = context;
    }

    @Override
    public void updateValue(Object newValue) {
        User currentUser= UserDAO.getUser((String) newValue);
        context.setAttribute("currentUser",currentUser);
    }
}

package com.ky.listeners;

import com.ky.listeners.job.JobListener;
import com.ky.utils.MediaFile;

import javax.servlet.ServletContext;
import java.util.ArrayList;

public class ContextMediaListener implements JobListener {
    private ServletContext context;

    public ContextMediaListener(ServletContext context) {
        this.context = context;
    }

    @Override
    public void updateValue(Object newValue) {
        String root = context.getRealPath("/uploads");
        ArrayList<String> files = MediaFile.getFiles(root);
        context.setAttribute("files", files);
    }
}

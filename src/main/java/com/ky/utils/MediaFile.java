package com.ky.utils;

import java.io.File;
import java.util.ArrayList;

public class MediaFile {
    public static ArrayList<String> getFiles(String rootPath){
        ArrayList<String> files=new ArrayList<>();
        File file=new File(rootPath);
        if(!file.exists()){
            file.mkdirs();
        }
        File[] allFiles =file.listFiles();
        for(File f: allFiles){
            files.add(f.getName());
        }
        return files;
    }

    public static boolean delete(String path,String filename){
        File file=new File(path+"/"+filename);
        if(file.delete()){
            return true;
        }
        return false;
    }
}

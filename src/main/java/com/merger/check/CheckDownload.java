package com.merger.check;

import java.io.File;

public class CheckDownload {
    public boolean checkIfDownloaded(Boolean debug) {
        String[] pathnames;
        boolean nothingfound = false;
        File f = new File(System.getProperty("user.dir") + "/LIBS");
        if(debug) {
            System.out.println("Call path: " + System.getProperty("user.dir") + "/LIBS");
            System.out.println("Folder LIBS Exists: " + f.exists());
            System.out.println("Is LIBS a Folder: " + f.isDirectory());
            System.out.println("Folder Path: " + f.getPath());
        }
        pathnames = f.list();
        for (String pathname : pathnames) {
            if(pathname.contains("")) {
                nothingfound = true;
            }else{
            }
        }
        if(nothingfound) {
            return false;
        }else{
            return true;
        }
    }
}

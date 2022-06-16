package com.merger.internet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HandleUnpacked {
    private static String searchFor() {
        List<String> results = new ArrayList<String>();
        File[] files = new File(System.getProperty("user.dir") + "/LIBS/").listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
                if(file.getName().contains("win64")) {
                    return "win64";
                }
                if(file.getName().contains("win32")) {
                    return "win32";
                }
                if(file.getName().contains("ffmpeg")) {
                    return "winxpx86";
                }
            }
        }
        return null;
    }
    public static String getFFMPEGExecPath() {
        if(searchFor().contains("win64")) {
            return "/LIBS/ffmpeg-master-latest-win64-lgpl/bin/ffmpeg.exe";
        }
        if(searchFor().contains("win32")) {
            return "/LIBS/ffmpeg-20200831-4a11a6f-win32-static/bin/ffmpeg.exe";
        }
        if(searchFor().contains("winxpx86")) {
            return "/LIBS/ffmpeg/ffmpeg.exe";
        }
        return null;
    }
}

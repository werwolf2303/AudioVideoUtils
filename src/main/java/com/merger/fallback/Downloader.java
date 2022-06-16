package com.merger.fallback;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Downloader {
    public void downloadXP(String url, String path) {
        try {
            String[] worker = url.split("\\.");
            String worker2 = worker[worker.length-1];
            InputStream in = new URL(url).openStream();
            Files.copy(in, Paths.get(path + "/ffmpeg." + worker2), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
    }
}

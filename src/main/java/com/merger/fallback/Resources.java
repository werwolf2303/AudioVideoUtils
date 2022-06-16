package com.merger.fallback;

import java.io.*;

public class Resources {
    public void unpackWGET() {
        try {
            Runtime.getRuntime().exec("jar xf AudVidMerger.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

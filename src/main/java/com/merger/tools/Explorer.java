package com.merger.tools;

import java.io.IOException;

public class Explorer {
    public void openOutputFolder() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c explorer \"" + System.getProperty("user.dir") + "\\OUT\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Deprecated
    public void openPath(String path) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c explorer \"" + path + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

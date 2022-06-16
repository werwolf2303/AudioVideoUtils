package com.merger.tools;

public class DetectArchitecture {
    public boolean is32() {
        if(System.getProperty("os.arch").contains("amd64")) {
            return false;
        }else{
            return true;
        }
    }
    public boolean is64() {
        if(System.getProperty("os.arch").contains("x86")) {
            return false;
        }else{
            return true;
        }
    }
}

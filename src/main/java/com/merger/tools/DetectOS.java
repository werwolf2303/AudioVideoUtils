package com.merger.tools;

public class DetectOS {
    private final String os = System.getProperty("os.name").toLowerCase();
    public boolean isWindows() {
        if (os.contains("win")){
            return true;
        }else{
            return false;
        }
    }
    public boolean isXP() {
        if(System.getProperty("os.name").equals("Windows XP")) {
            return true;
        }else{
            return false;
        }
    }
    public boolean isLinux() {
        if (os.contains("nix") || os.contains("aix") || os.contains("nux")){
            return true;
        }else{
            return false;
        }
    }
}

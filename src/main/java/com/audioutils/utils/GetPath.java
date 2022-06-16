package com.audioutils.utils;

import com.audioutils.check.IntelliJ;

public class GetPath {
    public String get() {
        if(new IntelliJ().check()) {
            return System.getProperty("user.dir");
        }else{
            return "C:\\AudioVideoUtils";
        }
    }
}

package com.audioutils.first;

import com.audioutils.check.IntelliJ;
import com.audioutils.utils.Unpack;

import java.io.File;

public class FirstStep {
    String from = System.getProperty("user.dir") + "\\AudioVideoUtils.jar";
    public String to = "C:\\AudioVideoUtils";
    public void exec() {
        if(!new IntelliJ().check()) {
            new File("C:\\AudioVideoUtils").mkdir();
            new Unpack().unpack(from, to);
        }
    }
}

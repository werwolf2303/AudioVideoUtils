package com.audioutils.check;

import com.audioutils.first.FirstStep;

import java.io.File;

public class Check {
    public Check() {
        if(!new IntelliJ().check()) {
            if (!new File(new FirstStep().to).exists()) {
                System.err.println("Failure extraction failed");
                System.exit(1);
            }
        }
    }
}

package com.merger.tests;

import com.merger.fallback.Resources;
import com.merger.tools.DetectArchitecture;
import com.merger.tools.DetectOS;

public class Test {
    public static void main(String[] args) {
        try {
            if(args[0].contains("-test-resources")) {
                new Resources().unpackWGET();
                System.exit(0);
            }
        }catch (ArrayIndexOutOfBoundsException aioobe) {
            if (new DetectOS().isWindows()) {
                System.out.println("Operating System is Windows");
            } else {
                System.out.println("Operating System is not Windows");
            }
            if (new DetectArchitecture().is64()) {
                System.out.println("System is x64");
            }
            if (new DetectArchitecture().is32()) {
                System.out.println("System is x86");
            }
        }
    }
}

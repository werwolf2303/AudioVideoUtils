package com.audioutils.check;

import java.io.File;

public class IntelliJ {
    public boolean check() {
        return new File("pom.xml").exists();
    }
}

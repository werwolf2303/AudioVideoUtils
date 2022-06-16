package com.audioutils.utils;

import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.IOException;

public class Unpack {
    public boolean unpack(String from, String to) {
        try {
            new ZipFile(from).extractAll(to);
            return new File(to).exists();
        } catch (IOException e) {
            return false;
        }
    }
}

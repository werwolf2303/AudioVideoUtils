package com.merger.fallback;

import java.io.IOException;

public class Unpack {
    public void unpack() {
        try {
            Runtime.getRuntime().exec("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

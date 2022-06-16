package com.audioutils;

import com.audioutils.check.Check;
import com.audioutils.first.FirstStep;
import com.audioutils.frames.MainFrame;

public class Init {
    public static void main(String[] args) {
        //Unpack jar file
        new FirstStep();
        //Check files
        new Check();
        //Execute mainframe
        new MainFrame(false).showFrame();
    }
}

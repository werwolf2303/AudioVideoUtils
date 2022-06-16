package com.audioutils.frames;

import javax.swing.*;
import java.io.File;

public class OpenFile {
    public String openFile(String location, JFrame f) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File(location));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(f) == JFileChooser.OPEN_DIALOG) {
            return chooser.getSelectedFile().getPath();
        } else {
            return "";
        }
    }
    public String openFile(JFrame f) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showOpenDialog(f) == JFileChooser.OPEN_DIALOG) {
            return chooser.getSelectedFile().getPath();
        } else {
            return "";
        }
    }
}

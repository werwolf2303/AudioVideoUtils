package com.merger.tools;

import javax.swing.*;
import java.io.File;

public class Files {
    public String fileChooser(String title, JFrame frame, String startpath) {
        JFileChooser chooser = new JFileChooser(startpath);
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = chooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            return file.getPath();
        }else{
            return "";
        }
    }
    public String folderChooser(String title, JFrame frame, String startpath) {
        JFileChooser chooser = new JFileChooser(startpath);
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(frame);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            return file.getPath();
        }else{
            return "";
        }
    }
}

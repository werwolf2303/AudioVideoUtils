package com.merger.setup;

import com.merger.windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setup {
    int indexing = 0;
    public void showSetup() {
        final JFrame main = new JFrame("AudVidMerger Setup");
        final JTextArea info = new JTextArea("AudVidMerger Setup\n\nClick Next");
        final JTextArea info2 = new JTextArea("This setup will download ffmpeg and create some directories.\n\nThis things will be created in the current directory\n\nAfter clicking Next the Setup will start do its thing");
        final JTextArea info3 = new JTextArea("\n\n\n After clicking Done the program will start itself\n\n\nDone!");
        JPanel control = new JPanel();
        JPanel infos = new JPanel();
        final JButton next = new JButton("Next");
        final JButton previous = new JButton("Previous");
        final JButton done = new JButton("Done");
        control.add(previous);
        control.add(done);
        control.add(next);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(indexing==0) {
                    info.setVisible(false);
                    info2.setVisible(true);
                    previous.setVisible(true);
                    indexing = indexing + 1;
                }else {
                    if (indexing == 1) {
                        info2.setVisible(false);
                        info3.setVisible(true);
                        next.setVisible(false);
                        previous.setVisible(false);
                        done.setVisible(true);
                        new runthis().runthat();
                    }
                }
            }
        });
        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(indexing==1) {
                    indexing = indexing -1;
                    info2.setVisible(false);
                    info.setVisible(true);
                    previous.setVisible(false);
                }
            }
        });
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainWindow().open();
                main.setVisible(false);
                main.dispose();
            }
        });
        info3.setEditable(false);
        info2.setEditable(false);
        info.setEditable(false);
        info2.setVisible(false);
        previous.setVisible(false);
        infos.add(info2, BorderLayout.CENTER);
        done.setVisible(false);
        info3.setVisible(false);
        main.add(control, BorderLayout.SOUTH);
        infos.add(info3, BorderLayout.CENTER);
        infos.add(info, BorderLayout.CENTER);
        main.add(infos, BorderLayout.CENTER);
        main.setMinimumSize(new Dimension(618,396));
        main.setVisible(true);
        main.pack();
        main.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Setup().showSetup();
    }
}
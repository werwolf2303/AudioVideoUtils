package com.merger.error;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XPErrorDialog {
    public void failedDownload() {
        final JDialog dialog = new JDialog();
        JTextArea area = new JTextArea();
        JButton b = new JButton("Ok");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        Runnable sound2 = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.exclamation");
        if(sound2 != null) sound2.run();
        area.setEditable(false);
        area.setText("Failed to download ffmpeg");
        dialog.add(b, BorderLayout.SOUTH);
        dialog.setAlwaysOnTop(true);
        dialog.setTitle("Download Failed");
        dialog.add(area);
        dialog.setVisible(true);
        dialog.pack();
    }
}

package com.merger.error;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog {
    public void open(String title, String message, JFrame frame) {
        final JDialog dialog = new JDialog();
        JTextArea area = new JTextArea();
        JButton b = new JButton("Ok");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        area.setEditable(false);
        area.setText(message);
        dialog.add(b, BorderLayout.SOUTH);
        dialog.setAlwaysOnTop(true);
        dialog.setTitle(title);
        dialog.add(area);
        dialog.setVisible(true);
        dialog.pack();
    }
}

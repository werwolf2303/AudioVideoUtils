package com.audioutils.frames;
import com.audioutils.utils.FFMPEG;
import com.audioutils.utils.GetPath;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.print.attribute.standard.JobKOctets;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame extends JPanel {
    private JMenuBar jcomp1;
    private JComboBox jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField jcomp5;
    private JButton jcomp6;
    private JLabel jcomp7;
    private JTextField jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JTextField jcomp11;
    private JLabel jcomp12;
    private JButton jcomp13;
    private JLabel jcomp14;
    private JButton jcomp15;
    private JButton jcomp16;
    private JFrame frame;
    private String opened = "";
    private String nameopened = "";
    private Integer rand = new Random().nextInt(9999);
    public MainFrame(boolean init) {
        if (init) {
            //construct preComponents
            JMenu fileMenu = new JMenu("File");
            JMenuItem openItem = new JMenuItem("Open");
            fileMenu.add(openItem);
            JMenuItem exitItem = new JMenuItem("Exit");
            fileMenu.add(exitItem);
            JMenu helpMenu = new JMenu("Help");
            JMenuItem aboutItem = new JMenuItem("About");
            helpMenu.add(aboutItem);
            JLabel open = new JLabel("Click 'File>Open' to start");
            String[] jcomp2Items = {"32 kbits", "96 kbits", "128 kbits", "256 kbits", "320 kbits"};
            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String file = new OpenFile().openFile(frame).replace("\\", "/");
                    String name = file.split("/")[file.split("/").length-1];
                    if(!file.equals("")) {
                        if (file.endsWith(".mp4")) {
                            //MP4
                            nameopened = name;
                            jcomp5.setText(name);
                            jcomp14.setVisible(true);
                            jcomp15.setVisible(true);
                            jcomp7.setVisible(true);
                            jcomp8.setVisible(true);
                            jcomp9.setVisible(true);
                            jcomp10.setVisible(true);
                            jcomp11.setVisible(true);
                            jcomp12.setVisible(true);
                            jcomp13.setVisible(true);
                            jcomp16.setVisible(true);
                            jcomp5.setVisible(true);
                            opened = file;
                            jcomp2.setVisible(false);
                            jcomp4.setVisible(false);
                            jcomp6.setVisible(false);
                            open.setVisible(false);
                        } else {
                            if (file.endsWith(".mp3")) {
                                //MP3
                                nameopened = name;
                                opened = file;
                                jcomp5.setText(name);
                                jcomp14.setVisible(true);
                                jcomp15.setVisible(true);
                                jcomp2.setVisible(true);
                                jcomp3.setVisible(true);
                                jcomp4.setVisible(true);
                                jcomp5.setVisible(true);
                                jcomp6.setVisible(true);

                                open.setVisible(false);
                                jcomp7.setVisible(false);
                                jcomp8.setVisible(false);
                                jcomp9.setVisible(false);
                                jcomp10.setVisible(false);
                                jcomp11.setVisible(false);
                                jcomp12.setVisible(false);
                                jcomp13.setVisible(false);
                                jcomp16.setVisible(false);
                            } else {
                                System.err.println("Unsupported file");
                            }
                        }
                    }
                }
            });
            //construct components
            jcomp1 = new JMenuBar();
            jcomp1.add(fileMenu);
            jcomp1.add(helpMenu);
            jcomp2 = new JComboBox(jcomp2Items);
            jcomp3 = new JLabel("File options");
            jcomp4 = new JLabel("Change bitrate");
            jcomp5 = new JTextField(6);
            jcomp6 = new JButton("Apply changes");
            jcomp7 = new JLabel("Save audio from video");
            jcomp8 = new JTextField(5);
            jcomp9 = new JLabel("Enter name");
            jcomp10 = new JLabel("Merge video and audio");
            jcomp11 = new JTextField(5);
            jcomp12 = new JLabel("Audio path");
            jcomp13 = new JButton("Apply");
            jcomp14 = new JLabel("Change name");
            jcomp15 = new JButton("Change");
            jcomp16 = new JButton("Apply");

            //set components properties
            jcomp2.setToolTipText("Click to change");
            jcomp5.setToolTipText("Click to enter different name");
            jcomp11.setToolTipText("Click to enter path");
            jcomp2.getModel().setSelectedItem(jcomp2Items[jcomp2Items.length-1]);
            //adjust size and set layout
            setPreferredSize(new Dimension(944, 601));
            setLayout(null);
            jcomp6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selected = jcomp2Items[jcomp2.getSelectedIndex()].replace(" kbits", "") + "k";
                    if(!new File(new GetPath().get() + "/OUT").exists()) {
                        new File(new GetPath().get() + "/OUT").mkdir();
                    }
                    System.out.println("Bitrate play");
                    new FFMPEG().changeBitrate(opened, new GetPath().get() + "/OUT/" + nameopened.replace(".mp3", "") + selected + ".mp3",selected);
                }
            });
            jcomp13.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!new File(new GetPath().get() + "/OUT").exists()) {
                        new File(new GetPath().get() + "/OUT").mkdir();
                    }
                    new FFMPEG().merge(opened,jcomp11.getText(),new GetPath().get()+"/OUT/"+"Merged" + rand + ".mp4");
                    System.out.println("Merged under name " + "Merged" + rand + ".mp4 in C:\\AudioVideoUtils\\OUT");
                }
            });
            jcomp15.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!new File(new GetPath().get() + "/OUT").exists()) {
                        new File(new GetPath().get() + "/OUT").mkdir();
                    }
                    System.out.println("Not supported yet");
                }
            });
            jcomp11.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String path = new OpenFile().openFile(frame);
                    if(!path.equals("")) {
                        if(path.contains(".mp3")) {
                            jcomp11.setText(path);
                        }else{
                            System.err.println("You have to select an supported audio file");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            jcomp16.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!new File(new GetPath().get() + "/OUT").exists()) {
                        new File(new GetPath().get() + "/OUT").mkdir();
                    }
                    new FFMPEG().saveAudio(opened,new GetPath().get()+"/OUT/"+jcomp8.getText()+".mp3");
                }
            });
            //add components
            add(jcomp1);
            add(open);
            //Audio
            add(jcomp2);
            add(jcomp3);
            add(jcomp4);
            add(jcomp5);
            add(jcomp6);
            //--
            //Video
            add(jcomp7);
            add(jcomp8);
            add(jcomp9);
            add(jcomp10);
            add(jcomp11);
            add(jcomp12);
            add(jcomp13);
            add(jcomp14);
            add(jcomp15);
            add(jcomp16);
            //--

            //set component bounds (only needed by Absolute Positioning
            open.setBounds(50,50,950,25);
            jcomp1.setBounds(0, 0, 950, 25);
            jcomp2.setBounds(145, 165, 100, 25);
            jcomp3.setBounds(5, 25, 100, 25);
            jcomp4.setBounds(15, 165, 100, 25);
            jcomp5.setBounds(140, 75, 335, 30);
            jcomp6.setBounds(315, 165, 130, 25);
            jcomp7.setBounds(15, 245, 140, 30);
            jcomp8.setBounds(120, 295, 245, 30);
            jcomp9.setBounds(15, 295, 100, 25);
            jcomp10.setBounds(15, 430, 135, 25);
            jcomp11.setBounds(135, 480, 140, 25);
            jcomp12.setBounds(15, 480, 100, 25);
            jcomp13.setBounds(330, 480, 100, 25);
            jcomp14.setBounds(15, 75, 100, 25);
            jcomp15.setBounds(565, 75, 100, 30);
            jcomp16.setBounds(450, 295, 105, 30);

            jcomp11.setEditable(false);
            jcomp2.setVisible(false);
            jcomp3.setVisible(false);
            jcomp4.setVisible(false);
            jcomp5.setVisible(false);
            jcomp6.setVisible(false);
            jcomp7.setVisible(false);
            jcomp8.setVisible(false);
            jcomp9.setVisible(false);
            jcomp10.setVisible(false);
            jcomp11.setVisible(false);
            jcomp12.setVisible(false);
            jcomp13.setVisible(false);
            jcomp14.setVisible(false);
            jcomp15.setVisible(false);
            jcomp16.setVisible(false);
        }
    }


        public void showFrame() {
            frame = new JFrame ("AudioVideoUtils v1.0 Alpha");
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new MainFrame(true));
            frame.pack();
            frame.setVisible (true);
        }
}

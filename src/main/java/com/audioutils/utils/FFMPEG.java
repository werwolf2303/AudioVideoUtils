package com.audioutils.utils;

import com.audioutils.check.IntelliJ;

import java.io.IOException;

public class FFMPEG {
    String location = "";
    public FFMPEG() {
        if(new IntelliJ().check()) {
            location = System.getProperty("user.dir") + "/src/main/resources/ffmpeg/bin";
        }else{
            location = "C:/AudioVideoUtils/ffmpeg";
        }
    }
    public void changeBitrate(String input, String output, String bitrate) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + location + "/ffmpeg.exe -i \"" + input + "\" -b:a " + bitrate + " \"" + output + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveAudio(String input, String output) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + location + "/ffmpeg.exe -i \"" + input + "\" -q:a 0 -map a \"" + output + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveVideo(String input, String output) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + location + "/ffmpeg.exe -i \"" + input + "\" -vcodec copy -an \"" + output + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void merge(String video, String audio, String output) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + location + "/ffmpeg.exe -i \"" + video + "\" -i \"" + audio + "\" -c:v copy -c:a aac \"" + output + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

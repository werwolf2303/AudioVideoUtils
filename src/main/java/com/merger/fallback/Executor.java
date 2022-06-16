package com.merger.fallback;

import com.merger.config.Config;

import java.io.IOException;

public class Executor {
    public void cutAudio(String videopath,String outputpath) {
        try{
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c start " + System.getProperty("user.dir").replace("/", "\\").replace("Documents and Settings", "\"Documents and Settings\"") + new Config().readConfig("ffmpeg").replace("/", "\\") + " -i \"" + videopath + "\" -q:a 0 -map a \"" + outputpath + "cutaudio.mp3\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cutAudioSaveOnlyVideo(String videopath,String outputpath) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c start " + new Config().readConfig("ffmpeg") + " -i \"" + videopath + "\" -c:v copy -an \"" + outputpath + "noAudio.mp4\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mergeAudioAndVideo(String videopath,String audiopath, String outputpath) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c start " + new Config().readConfig("ffmpeg") + " -i \"" + videopath + "\" -i \"" + audiopath + "\" \"" + outputpath + "merged.mp4\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

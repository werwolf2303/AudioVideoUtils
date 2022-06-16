package com.merger.tools;

import com.merger.config.Config;

import java.io.IOException;

public class ffmpeg {
    public void cutAudio(String videopath,String outputpath) {
        try{
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + System.getProperty("user.dir") + new Config().readConfig("ffmpeg") + " -i \"" + videopath + "\" -q:a 0 -map a \"" + outputpath + "cutaudio.mp3\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cutAudioSaveOnlyVideo(String videopath,String outputpath) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + System.getProperty("user.dir") + new Config().readConfig("ffmpeg") + " -i \"" + videopath + "\" -c:v copy -an \"" + outputpath + "noAudio.mp4\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void mergeAudioAndVideo(String videopath,String audiopath, String outputpath) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c " + System.getProperty("user.dir") + new Config().readConfig("ffmpeg") + " -i \"" + videopath + "\" -i \"" + audiopath + "\" \"" + outputpath + "merged.mp4\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.merger.setup;

import com.merger.check.CheckDownload;
import com.merger.config.Config;
import com.merger.fallback.Downloader;
import com.merger.internet.Download;
import com.merger.internet.HandleUnpacked;
import com.merger.tools.DetectArchitecture;
import com.merger.tools.DetectOS;
import com.merger.windows.MainWindow;

import java.io.File;

public class runthis {
    public void runthat() {
        File file = new File(System.getProperty("user.dir") + "/OUT");
        File file2 = new File(System.getProperty("user.dir") + "/LIBS");
        if(!file2.exists()) {
            file2.mkdir();
        }
        if(!file.exists()) {
            file.mkdir();
        }
        File f = new File(System.getProperty("user.dir") + "/config.conf");
        if(!f.exists()) {
            new Config().createConfig(false);
            DetectOS os = new DetectOS();
            DetectArchitecture arch = new DetectArchitecture();
            if (os.isXP()) {
                try {
                    Download.downloadZIP(new Download.downloadFFMPEG().WinXPx86(), System.getProperty("user.dir") + "/LIBS");
                }catch (NullPointerException nullPointerException) {

                }
                if(new CheckDownload().checkIfDownloaded(false)) {
                    Download.extractZIP(System.getProperty("user.dir") + "/LIBS/ffmpeg.zip", System.getProperty("user.dir") + "/LIBS/");
                }else{
                    new Downloader().downloadXP(new Download.downloadFFMPEG().WinXPx86(), System.getProperty("user.dir") + "/LIBS");
                    if(new CheckDownload().checkIfDownloaded(false)) {
                    }else{
                        Download.extractZIP(System.getProperty("user.dir") + "/LIBS/ffmpeg.zip", System.getProperty("user.dir") + "/LIBS/");
                    }
                }
                try {
                    new Config().writeKey("ffmpeg", HandleUnpacked.getFFMPEGExecPath());
                }catch (NullPointerException nullPointerException) {
                    new Config().writeKey("ffmpeg", "/LIBS/ffmpeg/ffmpeg.exe");
                }
            } else {
                if (os.isWindows()) {
                    if (arch.is32()) {
                        Download.downloadZIP(new Download.downloadFFMPEG().WinX86(), System.getProperty("user.dir") + "/LIBS");
                        Download.extractZIP(System.getProperty("user.dir") + "/LIBS/ffmpeg.zip", System.getProperty("user.dir") + "/LIBS/");
                        new Config().writeKey("ffmpeg", HandleUnpacked.getFFMPEGExecPath());
                    } else {
                        if (arch.is64()) {
                            Download.downloadZIP(new Download.downloadFFMPEG().WinX64(), System.getProperty("user.dir") + "/LIBS");
                            Download.extractZIP(System.getProperty("user.dir") + "/LIBS/ffmpeg.zip", System.getProperty("user.dir") + "/LIBS/");
                            new Config().writeKey("ffmpeg", HandleUnpacked.getFFMPEGExecPath());
                        } else {
                            System.out.println("Your architecture is not supported; You must find the binaries for ffmpeg yourself");
                            while (true) {

                            }
                        }
                    }
                } else {
                    System.out.println();
                    while (true) {

                    }
                }
            }
        }else{
            new MainWindow().open();
        }
    }
}

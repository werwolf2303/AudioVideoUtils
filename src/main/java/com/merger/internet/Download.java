package com.merger.internet;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Download {
    public static class downloadFFMPEG {
        public String WinX64() {
            return "https://github.com/BtbN/FFmpeg-Builds/releases/download/latest/ffmpeg-master-latest-win64-lgpl.zip";
        }
        public String WinX86() {
            return "https://github.com/werwolf2303/SomeStuff/releases/download/v1.2/ffmpeg-20200831-4a11a6f-win32-static.zip";
        }
        public String WinXPx86() {
            return "https://github.com/werwolf2303/SomeStuff/releases/download/v1%2C3/ffmpeg.zip";
        }
    }
    public static void downloadZIP(String url, String path) {
        String[] worker = url.split("\\.");
        String worker2 = worker[worker.length-1];
        Wget.wGet(path + "/ffmpeg." + worker2, url);
    }
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
    public static void extractZIP(String in, String out) {
        try {
            String fileZip = in;
            File destDir = new File(out);
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        }catch (IOException ioexc) {

        }
    }
}

package com.kangyh.easyenv.mod;

import Utils.FileDownloadUtils;
import com.kangyh.easyenv.BaseEnv;
import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.IOException;

import com.jianggujin.registry.JRegistry;


public class JavaEnv implements BaseEnv {
    public void download(String url, String downloadDest) {
        try {
            FileDownloadUtils.download(url, downloadDest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void decompress(File file, String dest) {
        try (ZipFile zipFile = new ZipFile(file)) {
            String path = dest + "\\java";
            zipFile.extractAll(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean renameFolder(File src, String destName) {
        return src.renameTo(new File(destName));
    }

    public void  setEnv() {
    }

}

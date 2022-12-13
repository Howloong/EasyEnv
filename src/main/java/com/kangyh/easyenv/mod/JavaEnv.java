package com.kangyh.easyenv.mod;

import Utils.FileDownloadUtils;
import Utils.RegistryUtils;
import com.kangyh.easyenv.BaseEnv;
import com.kangyh.easyenv.constants.Constants;
import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.IOException;


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

    public void setEnv() {
        System.out.println(Constants.CACHE_FILEPATH);
        RegistryUtils.writeToRegistry(Constants.CACHE_FILEPATH + "\\src\\main\\java\\script\\setJavaEnv.bat",
                "HKEY_LOCAL_MACHINE\\System\\CurrentControlSet\\Control\\Session Manager\\Environment",
                "Test",
                "31");
    }

}

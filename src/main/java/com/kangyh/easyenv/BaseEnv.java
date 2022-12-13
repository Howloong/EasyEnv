package com.kangyh.easyenv;

import java.io.File;

public interface BaseEnv {
    void download(String url, String downloadDest);

    void decompress(File file, String dest);

    boolean renameFolder(File src, String destName);
}

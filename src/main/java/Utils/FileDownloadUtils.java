package Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloadUtils {
    /**
     * 下载文件时，针对不同浏览器，进行附件名的编码
     *
     * @param filename 载文件名
     * @param request  请求request
     * @return 编码后的下载附件名
     * @throws IOException
     */

    public static File download(String url, String path)
            throws IOException {
        System.out.println("下载中...");
        InputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10 * 1000);
            String[] filenames = url.split("/");
            File file = new File(path + "\\" + filenames[filenames.length - 1]);
            //文件夹是否存在
            if (!file.getParentFile().exists())
                file.getParentFile().mkdir();
            if (file.exists())
                file.delete();
            file.createNewFile();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                inputStream = urlConnection.getInputStream();
                int len = 0;
                byte[] data = new byte[4096];
                //用于保存当前进度（具体进度）
                int progress = 0;
                //获取文件长度
                int maxProgress = urlConnection.getContentLength();
                randomAccessFile = new RandomAccessFile(file, "rwd");
                //设置文件大小
                randomAccessFile.setLength(maxProgress);
                //将文件大小分成100分，每一分的大小为unit
                int unit = maxProgress / 100;
                //用于保存当前进度(1~100%)
                int unitProgress = 0;
                while (-1 != (len = inputStream.read(data))) {
                    randomAccessFile.write(data, 0, len);
                    progress += len;//保存当前具体进度
                    System.out.println(progress + "/" + maxProgress);
                }
                inputStream.close();
                System.out.println("下载完成...");
                return file;
            } else {
                System.out.println("服务器异常...");
            }
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }
            if (null != randomAccessFile) {
                randomAccessFile.close();
            }
        }
        return null;
    }

    public static String getFileName(String url) {
        String[] filenames = url.split("/");
        return filenames[filenames.length - 1];
    }

    public static String getPath(String filename) {
        int index = filename.lastIndexOf(".");
        return filename.substring(0, index);
    }
}

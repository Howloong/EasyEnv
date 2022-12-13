package test.com.kangyh.easyenv.mod;

import Utils.FileDownloadUtils;
import com.kangyh.easyenv.constants.Constants;
import com.kangyh.easyenv.mod.JavaEnv;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;

/**
 * JavaEnv Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12�� 12, 2022</pre>
 */
public class JavaEnvTest {

    private JavaEnv javaEnv;
    private String fileName;
    private String filePath;
    private File file;
    private String version;


    @Before
    public void before() throws Exception {
        javaEnv = new JavaEnv();
        fileName = FileDownloadUtils.getFileName(Constants.java_Download_URL);
        filePath = FileDownloadUtils.getPath(fileName);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: download(String url, String downloadPath)
     */
    @Test
    public void testDownload() throws Exception {
        javaEnv.download(Constants.java_Download_URL, Constants.CACHE_FILEPATH);
    }

    /**
     * Method: decompress(File file, String dest)
     */
    @Test
    public void testDecompress() throws Exception {
        file = new File(Constants.CACHE_FILEPATH + "\\" + fileName);
        javaEnv.decompress(file, Constants.INSTALL_LOCATION);
    }

    @Test
    public void testRename() throws Exception {
        javaEnv.renameFolder(new File(Constants.INSTALL_LOCATION + "\\java\\" + filePath), Constants.INSTALL_LOCATION + "\\" + "java\\1");
    }

    @Test
    public void testSetEnv() {
        javaEnv.setEnv();
    }
}

package Utils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Oleg Ryaboy, based on work by Miguel Enriquez
 */
public class RegistryUtils {
    public static void writeToRegistry(String batLocation, String key, String value1, String value2) {
        String s;
        Process process;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cmd /c ")
                .append(batLocation).append(' ')
                .append("\"").append(key).append("\"").append(' ')
                .append("\"").append(value1).append("\"").append(' ')
                .append("\"").append(value2).append("\"");
        try {
            process = Runtime.getRuntime().exec(stringBuilder.toString());
            InputStream in = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, Charset.forName("GBK")));
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
            in.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeToRegistry("E:\\Code\\Java\\EasyEnv\\src\\main\\java\\script\\setJavaEnv.bat",
                "HKEY_LOCAL_MACHINE\\System\\CurrentControlSet\\Control\\Session Manager\\Environment",
                "Test",
                "31");
    }
}
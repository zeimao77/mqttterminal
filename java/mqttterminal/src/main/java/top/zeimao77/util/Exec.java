package top.zeimao77.util;

import java.io.*;

public class Exec {

    private Exec() {}


    public static void main(String[] args) throws IOException {
        String str = Base.compressionBase("C:\\Users\\zeimao77\\Pictures\\Saved Pictures\\20181118014315338.jpg");
        System.out.println(str);
    }

    public static String execCmd(String cmd) {
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
            InputStream os = process.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int temp = -1;
            while((temp = os.read()) != -1) {
                baos.write(temp);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\a"));
            baos.writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cmd;
    }

}

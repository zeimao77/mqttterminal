package top.zeimao77.util;

import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class Base {

    private Base(){}

    public static String compressionBase(String imgFile) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Thumbnails.of(new File(imgFile)).scale(0.8).toOutputStream(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File file = new File(imgFile);
//        System.out.println(file.exists());
//        FileInputStream fileOutputStream = new FileInputStream(file);
//        int temp = -1;
//        while((temp = fileOutputStream.read()) != -1) {
//            baos.write(temp);
//        }
//        fileOutputStream.close();
        byte[] data = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String resultStr = encoder.encode(data);
        //System.out.println(resultStr);
        return resultStr;
    }

}

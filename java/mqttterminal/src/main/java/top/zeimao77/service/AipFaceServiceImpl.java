package top.zeimao77.service;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import top.zeimao77.util.Base;

import java.io.IOException;
import java.util.HashMap;

public class AipFaceServiceImpl {


    AipFace aipFace = null;


    private static String PATH= "xxxxx";


    public static void main(String[] args) {
        AipFace aipFace = new AipFace("xxxxxxxx","xxxxxxxxxxxxxxxxxxxx","xxxxxxxxxxxxxxxxxxxx");
        new AipFaceServiceImpl().caceDetection(aipFace);
    }

    public void caceDetection(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field","age,beauty,faceshape,gender,facetype,glasses,emotion");

        String image = null;
        try {
            image = Base.compressionBase(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageType = "BASE64";

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        System.out.println(res.toString(2));
    }


}

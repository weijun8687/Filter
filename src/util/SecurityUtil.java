package util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    // 将字符串进行 md5加密
    public static String md5(String message){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte b[] = md.digest(message.getBytes());
            BASE64Encoder base64 = new BASE64Encoder();
            return base64.encode(b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 使用 base64 加密
    public static String base64encode(String message){
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(message.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 使用base64 解密
    public static String base64decode(String message){
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            return new String(decoder.decodeBuffer(message));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

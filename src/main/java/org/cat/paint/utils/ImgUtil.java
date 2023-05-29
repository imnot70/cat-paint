package org.cat.paint.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ImgUtil {



    public static void text2Jpg(String filePath,String source){
        try(OutputStream out = Files.newOutputStream(Paths.get(filePath))) {
            String base64 = source.substring(source.indexOf(",", 1) + 1);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] imgBytes = decoder.decode(base64);
            for (int i = 0; i < imgBytes.length; ++i) {
                if (imgBytes[i] < 0) {
                    imgBytes[i] += 256;
                }
            }

            out.write(imgBytes);
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

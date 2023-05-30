package org.cat.paint.utils;

import org.cat.paint.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;


@Component
public class ImgUtil {

    public static final String STR_COMMA = ",";
    public static final String IMG_EXT_NAME = ".png";
    public static final String IMG_NAME_PATTERN = "yyyyMMddHHmmss";

    private static Config config;
    @Autowired
    public void setConfig(Config conf){
        config = conf;
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(IMG_NAME_PATTERN);

    public static String taskId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 根据用户id生成文件夹路径
     * @param userId 用户id
     * @return 文件夹路径
     */
    public static String getDirPath(long userId){
        String dirPath = config.getOutPutFilePath() + File.pathSeparator + userId + File.pathSeparator;
        File file = new File(dirPath);
        if(!file.exists()){
            try {
                boolean createResult = file.createNewFile();
                if(!createResult){
                    throw new RuntimeException("create directory ["+file.getPath()+"] error");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return dirPath;
    }

    /**
     * 根据用户id生成文件路径
     * @param userId 用户id
     * @return 文件路径
     */
    public static String getFilePath(long userId){
        String dirPath = getDirPath(userId);
        String timeStr = FORMATTER.format(LocalDateTime.now());
        return dirPath + timeStr;
    }

    /**
     * 字符串转图片
     * @param filePath  文件路径
     * @param source    字符串
     */
    public static void text2Jpg(String filePath,String source){
        try(OutputStream out = Files.newOutputStream(Paths.get(filePath))) {
            String base64 = source.substring(source.indexOf(STR_COMMA, 1) + 1);
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

    /**
     * 图片转换为base64字符串
     * @param img 图片文件
     * @return base64字符串
     */
    public static String resolveImgToStr(File img){
        String name = img.getName();
        if(!name.endsWith(IMG_EXT_NAME)){
            throw new RuntimeException("img format error");
        }
        return null;
    }

}

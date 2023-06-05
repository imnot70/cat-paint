package org.cat.paint.utils;

import lombok.extern.slf4j.Slf4j;
import org.cat.paint.config.Config;
import org.cat.paint.constant.ResConst;
import org.cat.paint.constant.StrConst;
import org.cat.paint.enums.AspectRatioEnum;
import org.cat.paint.enums.RespCode;
import org.cat.paint.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class ImgUtil {


    private static Config config;

    @Autowired
    public void setConfig(Config conf) {
        config = conf;
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(StrConst.IMG_NAME_PATTERN);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(StrConst.TIME_PATTERN_DATE);

    public static String taskId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 根据用户id生成文件夹路径
     *
     * @param userId 用户id
     * @return 文件夹路径
     */
    public static String getDirPath(long userId) {
        String dirPath = config.getOutPutFilePath() + File.separator
                + userId + File.separator
                + DATE_FORMATTER.format(LocalDateTime.now()) + File.separator;
        File dir = new File(dirPath);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new BusinessException(RespCode.FAILED.getCode(), "create dir failed,dir:" + dirPath);
            }
        }
        return dirPath;
    }

    /**
     * 根据用户id生成文件路径
     *
     * @param userId 用户id
     * @return 文件路径
     */
    public static String getFilePath(long userId) {
        String dirPath = getDirPath(userId);
        String timeStr = FORMATTER.format(LocalDateTime.now());
        return dirPath + timeStr + StrConst.IMG_EXT_NAME;
    }

    /**
     * 字符串转图片
     *
     * @param filePath 文件路径
     * @param source   字符串
     */
    public static void convertTxtToImg(String filePath, String source) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new BusinessException(RespCode.FAILED.getCode(), "create image failed,file:" + filePath);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        try (OutputStream out = Files.newOutputStream(Paths.get(filePath))) {
            String base64 = source.substring(source.indexOf(StrConst.STR_COMMA, 1) + 1);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] imgBytes = decoder.decode(base64);
            for (int i = 0; i < imgBytes.length; ++i) {
                if (imgBytes[i] < 0) {
                    imgBytes[i] += 256;
                }
            }
            out.write(imgBytes);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片转换为base64字符串
     *
     * @param img 图片文件
     * @return base64字符串
     */
    public static String resolveImgToStr(File img) {
        String name = img.getName();
        if (!name.endsWith(StrConst.IMG_EXT_NAME)) {
            throw new RuntimeException("img format error");
        }
        // TODO
        return null;
    }

    public static void main(String[] args) {
        List<Integer> r = calculateRes(2);
        System.out.println(r);
    }

    /**
     * 返回一个Integer列表，只有两个元素，第一个为横向分辨率，第二个为纵高分辨率
     *
     * @param type 图片比例类型
     * @return 图片分辨率
     */
    public static List<Integer> calculateRes(int type) {
        Double aspectRatio = AspectRatioEnum.widthHeightRatio(type);
        if (aspectRatio == null) {
            throw new RuntimeException("calculateRes,type is wrong,type:[" + type + "]");
        }
        List<Integer> result = new ArrayList<>(2);
        if (aspectRatio > 1.0) {
            // 宽高比大于1，用横向作为基准
            result.add((int) ResConst.BASIC_RES);
            result.add((int) (ResConst.BASIC_RES * (1.0 / aspectRatio)));
        } else {
            // 宽高比小于等于1
            result.add((int) (ResConst.BASIC_RES * aspectRatio));
            result.add((int) ResConst.BASIC_RES);
        }
        return result;
    }

}

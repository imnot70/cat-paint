package org.cat.paint.enums;

import java.util.HashMap;
import java.util.Map;

public enum AspectRatioEnum {

    RATIO_1_1(1, 1.0, 1.0),
    RATIO_1_2(2, 1.0, 2.0),
    RATIO_3_4(3, 3.0, 4.0),
    RATIO_4_3(4, 4.0, 3.0),
    RATIO_9_16(5, 9.0, 16.0),
    RATIO_16_9(6, 16.0, 9.0);

    private final int type;
    private final double with;
    private final double height;

    private static final Map<Integer, AspectRatioEnum> ENUMS;

    static {
        ENUMS = new HashMap<>(8);
        ENUMS.put(1, RATIO_1_1);
        ENUMS.put(2, RATIO_1_2);
        ENUMS.put(3, RATIO_3_4);
        ENUMS.put(4, RATIO_4_3);
        ENUMS.put(5, RATIO_9_16);
        ENUMS.put(6, RATIO_16_9);
    }

    public static Double widthHeightRatio(int type){
        AspectRatioEnum ratioEnum = ENUMS.get(type);
        return ratioEnum == null
                ? null
                : (ratioEnum.getWith() / ratioEnum.getHeight());
    }

    public static AspectRatioEnum getByType(int type){
        return ENUMS.get(type);
    }

    AspectRatioEnum(int type, double with, double height) {
        this.type = type;
        this.with = with;
        this.height = height;
    }

    public int getType() {
        return type;
    }

    public double getWith() {
        return with;
    }

    public double getHeight() {
        return height;
    }
}

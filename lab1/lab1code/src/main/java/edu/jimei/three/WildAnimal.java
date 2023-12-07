package edu.jimei.three;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class WildAnimal{
    // 实例变量
    private String size;

    // 类方法
    // 类变量

    // 重载的方法，允许设置并返回活动区域
    @Getter
    private static String activityArea;

    // 构造方法
    public WildAnimal() {
    }

    public WildAnimal(String size) {
        this.size = size;
    }

    // 实例方法
    public String getActivityStyle() {
        return "Walking"; // 默认的活动方式
    }

    public String getActivityStyle(String style) {
        return style; // 重载的方法，允许指定活动方式
    }

    public static String getActivityArea(String area) {
        activityArea = area;
        return activityArea; // 重载的方法，允许设置并返回活动区域
    }
}

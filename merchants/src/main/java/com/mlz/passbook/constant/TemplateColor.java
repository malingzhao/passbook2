package com.mlz.passbook.constant;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：<h1>优惠券的背景色</h1>
 */
public enum TemplateColor {
    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色");

    /*颜色代码*/
    private Integer code;

    /*颜色的描述*/
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getColor() {
        return this.color;
    }
}

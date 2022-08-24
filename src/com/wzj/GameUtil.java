package com.wzj;

import sun.awt.image.ToolkitImage;

import java.awt.*;

/**
 * 工具类
 * 存放静态参数
 * 工具方法
 */
public class GameUtil {
    //地雷的个数
    static int RAY_MAX = 12;
    //地图的宽
    static int MAP_W = 11;
    //地图的高
    static int MAP_H = 11;
    //雷区偏移量
    static int OFFSET = 45;
    //格子的边长
    static int SQUARE_LENGTH = 50;

    //鼠标相关参数
    //恒坐标
    static int MOUSE_X;
    //纵坐标
    static int MOUSE_Y;
    //状态
    static boolean LEFT = false;
    static boolean RIGHT = false;

    //底层元素 -1代表雷 0代表空 1-8表示对应的数组
    static int[][] DATA_BOTTOM =new int[MAP_W+2][MAP_H+2];
    //顶层元素元素 -1代无覆盖 0代表覆盖 1表示插旗2表示插错旗
    static int[][] DATA_TOP =new int[MAP_W+2][MAP_H+2];
    //载入图片
    static Image lei = Toolkit.getDefaultToolkit().getImage("imgs/lei.png");
    static Image top = Toolkit.getDefaultToolkit().getImage("imgs/top.gif");
    static Image flag = Toolkit.getDefaultToolkit().getImage("imgs/flag.gif");
    static Image noflag = Toolkit.getDefaultToolkit().getImage("imgs/noflag.png");


    //数字图片
    static Image[] images=new Image[9];
    static{
        for (int i = 1; i <=8; i++) {
            images[i]= Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }
}

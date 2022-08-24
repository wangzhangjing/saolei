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
    static int RAY_MAX = 5;
    //地图的宽
    static int MAP_W = 11;
    //地图的高
    static int MAP_H = 11;
    //雷区偏移量
    static int OFFSET = 45;
    //格子的边长
    static int SQUARE_LENGTH = 50;
    //插旗数量
    static int FLAG_NUM = 0;


    //鼠标相关参数
    //恒坐标
    static int MOUSE_X;
    //纵坐标
    static int MOUSE_Y;
    //状态
    static boolean LEFT = false;
    static boolean RIGHT = false;
    //0代表游戏中1代表胜利2代表失败
    static int state =0;

    static long START_TIME;
    static long END_TIME;

    //底层元素 -1代表雷 0代表空 1-8表示对应的数组
    static int[][] DATA_BOTTOM =new int[MAP_W+2][MAP_H+2];
    //顶层元素元素 -1代无覆盖 0代表覆盖 1表示插旗2表示插错旗
    static int[][] DATA_TOP =new int[MAP_W+2][MAP_H+2];
    //载入图片
    static Image lei = Toolkit.getDefaultToolkit().getImage("imgs/lei.png");
    static Image top = Toolkit.getDefaultToolkit().getImage("imgs/top.gif");
    static Image flag = Toolkit.getDefaultToolkit().getImage("imgs/flag.gif");
    static Image noflag = Toolkit.getDefaultToolkit().getImage("imgs/noflag.png");

    static Image face = Toolkit.getDefaultToolkit().getImage("imgs/face.png");
    static Image over = Toolkit.getDefaultToolkit().getImage("imgs/over.png");
    static Image win = Toolkit.getDefaultToolkit().getImage("imgs/win.png");

    //数字图片
    static Image[] images=new Image[9];
    static{
        for (int i = 1; i <=8; i++) {
            images[i]= Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }

    static void drawWord(Graphics g,String str,int x,int y,int size,Color color){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}

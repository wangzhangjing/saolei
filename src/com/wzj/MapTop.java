package com.wzj;

import java.awt.*;

/**
 * 顶层地图类
 * 绘制顶层组件
 * 判断逻辑
 */
public class MapTop {

    //格子位置
    int temp_x;
    int temp_y;

    //判断逻辑
    void logic(){
        //写入坐标
        //添加判断以避免没点击其他格子也翻开
        temp_x=0;
        temp_y=0;
        if (GameUtil.MOUSE_X>GameUtil.OFFSET && GameUtil.MOUSE_Y>3*GameUtil.OFFSET){
            temp_x =(GameUtil.MOUSE_X-GameUtil.OFFSET)/GameUtil.SQUARE_LENGTH+1;
            temp_y =(GameUtil.MOUSE_Y-GameUtil.OFFSET*3)/GameUtil.SQUARE_LENGTH+1;
        }
        //判断是否点击窗口中网格位置
        if (temp_x>=1&&temp_x<=GameUtil.MAP_W
        &&temp_y>=1&&temp_y<=GameUtil.MAP_H){
            //如果左键被点击
            if (GameUtil.LEFT){
                if (GameUtil.LEFT){
                    //如果是0（初始被覆盖）取消覆盖
                    if (GameUtil.DATA_TOP[temp_x][temp_y]==0){
                        GameUtil.DATA_TOP[temp_x][temp_y]=-1;
                    }
                    spaceOpen(temp_x,temp_y);
                    GameUtil.LEFT=false;
                }
//                System.out.println(GameUtil.MOUSE_X);
//                System.out.println(GameUtil.MOUSE_Y);
//                GameUtil.LEFT=false;

            }
            //如果右键被点击
            if (GameUtil.RIGHT){
//                System.out.println(GameUtil.MOUSE_X);
//                System.out.println(GameUtil.MOUSE_Y);
                //覆盖则插旗
                if (GameUtil.DATA_TOP[temp_x][temp_y]==0){
                    GameUtil.DATA_TOP[temp_x][temp_y]=1;
                }
                //插旗则取消
                else if (GameUtil.DATA_TOP[temp_x][temp_y]==1){
                    GameUtil.DATA_TOP[temp_x][temp_y]=0;
                }else  if (GameUtil.DATA_TOP[temp_x][temp_y]==-1){
                    numOpen(temp_x,temp_y);
                }

                GameUtil.RIGHT=false;
            }
        }
      boom();
      victory();
    }
    //失败后显示雷区所有雷
    void seeBoom(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                //低层是雷顶层不是旗，显示
                if (GameUtil.DATA_BOTTOM[i][j]==-1&&GameUtil.DATA_TOP[i][j]!=1){
                    GameUtil.DATA_TOP[i][j]=-1;
                }
                //低层是雷 顶层是旗，显示插错旗
                if (GameUtil.DATA_BOTTOM[i][j]!=-1&&GameUtil.DATA_TOP[i][j]==1){
                    GameUtil.DATA_TOP[i][j]=2;
                }
            }

        }
    }

    //数字翻开
    void numOpen(int x,int y){
        //记录旗数
        int count=0;
        if (GameUtil.DATA_BOTTOM[x][y]>0){
            for (int i = x-1; i <=x+1 ; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (GameUtil.DATA_TOP[i][j]==1){
                        count++;
                    }
                }
            }
            if (count == GameUtil.DATA_BOTTOM[x][y]) {
                for (int i = x-1; i <=x+1 ; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                       if (GameUtil.DATA_TOP[i][j]!=1){
                           GameUtil.DATA_TOP[i][j]=-1;
                       }
                        //必须在雷区中
                        if (i>=1&&j>=1&&i<=GameUtil.MAP_W&&j<=GameUtil.MAP_H){
                            spaceOpen(i,j);
                        }
                    }
                }
            }
        }
    }
    //胜利判定t表示胜利f表示为胜利
    boolean victory(){
        //统计被打开格子数
        int count=0;
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
               if (GameUtil.DATA_TOP[i][j]!=-1){
                   count++;
               }
            }
        }
        if (count==GameUtil.RAY_MAX){
            GameUtil.state=1;
            for (int i = 1; i <=GameUtil.MAP_W ; i++) {
                for (int j = 1; j <= GameUtil.MAP_H; j++) {
                  if (GameUtil.DATA_TOP[i][j]==0){
                      GameUtil.DATA_TOP[i][j]=1;
                  }
                }
            }
            return true;
        }
        return false;
    }

    //失败判定t表示失败f表示没有失败
    boolean boom(){
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
               if (GameUtil.DATA_BOTTOM[i][j]==-1&&GameUtil.DATA_TOP[i][j]==-1){
                   GameUtil.state=2;
                   seeBoom();
                   return true;
               }
            }

        }
        return false;
    }

    //利用递归打开周围没有雷的格子
    void spaceOpen(int x,int y){
        if (GameUtil.DATA_BOTTOM[x][y]==0){
            for (int i = x-1; i <=x+1 ; i++) {
                for (int j = y-1; j <=y+1 ; j++) {
                    //覆盖，才递归
                    if (GameUtil.DATA_TOP[i][j]!=-1){
                        GameUtil.DATA_TOP[i][j]=-1;
                        //必须在雷区中
                        if (i>=1&&j>=1&&i<=GameUtil.MAP_W&&j<=GameUtil.MAP_H){
                            spaceOpen(i,j);
                        }
                    }
                }
            }
        }
    }

    void paintSelf(Graphics g){
        //调用逻辑
        logic();
        //填充图片
        for (int i = 1; i <= GameUtil.MAP_W; i++) {
            //二维数组需要循环遍历
            for (int j = 1; j <= GameUtil.MAP_H ; j++) {
                //覆盖
                if (GameUtil.DATA_TOP[i][j] == 0) {
                    g.drawImage(GameUtil.top,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                //插旗
                if (GameUtil.DATA_TOP[i][j] == 1) {
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                //插错旗
                if (GameUtil.DATA_TOP[i][j] == 2) {
                    g.drawImage(GameUtil.noflag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
            }
        }
    }
}

package com.wzj;

/**
 *初始化地雷
 *
 */
public class BottomRay {
    //存放坐标
    //该数组中相连两个数代表地雷的坐标
    int [] rays =new int[GameUtil.RAY_MAX*2];
    //地雷坐标
    int x,y;
    //是否放置T表示可以放置F表示不可放置
    boolean isPlace = true;



    void newRay(){
        //地雷每次生成一个坐标，需要循环从0到结束
        for (int i = 0; i < GameUtil.RAY_MAX*2; i=i+2) {
            //每次生成随机坐标
            x= (int) (Math.random()*GameUtil.MAP_W+1);//+1是因为让数字从0-11变成1-12
            y= (int) (Math.random()*GameUtil.MAP_H+1);
            //循环判断
            for (int j = 0; j < i; j=j+2) {
                //判断是否重复
              if (x==rays[j]&& y==rays[j+1]){
                  //如果已经存在回退
                  i=i-2;
                  //不可放置
                  isPlace=false;
                  break;
              }
            }
            //将坐标放入数组
            if (isPlace){
                //将坐标赋值到数组中
                rays[i]=x;
                rays[i+1]=y;
            }
            //释放状态
            isPlace=true;
        }
        for (int i = 0; i < GameUtil.RAY_MAX*2; i=i+2) {
            GameUtil.DATA_BOTTOM[rays[i]][rays[i+1]]=-1;
        }
    }
}

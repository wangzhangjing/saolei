package com.wzj;

/**
 * 底层数字类
 */
public class BottomNum {
    {   //从宽遍历
        for (int i = 1; i <=GameUtil.MAP_W ; i++) {
            //从高遍历
            for (int j = 1; j <=GameUtil.MAP_H ; j++) {
                //判断这个位置是否有雷
                if (GameUtil.DATA_BOTTOM[i][j]==-1){
                    //如果有雷遍历雷区3*3区域
                    for (int k = i-1; k <= i+1; k++) {
                        for (int l = j-1; l <= j+1; l++) {
                            //判断区域是否为数字如果不是-1那么全部+1
                            if (GameUtil.DATA_BOTTOM[k][l]>=0){
                                GameUtil.DATA_BOTTOM[k][l]++;
                            }
                        }
                    }
                }
            }

        }
    }
}

package com.wzj;

import java.awt.*;

/**
 * 顶层地图类
 * 绘制顶层组件
 * 判断逻辑
 */
public class MapTop {
    void paintSelf(Graphics g){
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

package com.wzj;

import javax.swing.*;
import java.awt.*;

//继承JFrame拥有窗口监听功能
public class GameWin extends JFrame {
    //90+11*50
    int wigth =2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    //90+11*50
    int height =4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;
    MapBottom mapBottom=new MapBottom();

    void launch(){
        //查看窗口是否可见
        this.setVisible(true);
        //窗口大小
//        this.setSize(500,500);
        this.setSize(wigth,height);
        //窗口位置null为居中显示
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("扫雷游戏");
        //添加关闭窗口的方法
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        while (true){
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //创建一个方法其中g.drawLine画像方法
    public void paint(Graphics g) {
//        //设置颜色
//        g.setColor(Color.red);
//        //传入起点坐标和终点坐标
//        g.drawLine(100,100,100,400);
//        g.drawLine(100,100,400,100);
        mapBottom.paintSelf(g);
    }

    //添加入口函数
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

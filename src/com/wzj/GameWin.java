package com.wzj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//继承JFrame拥有窗口监听功能
public class GameWin extends JFrame {
    //90+11*50
    int wigth =2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    //90+11*50
    int height =4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;
    //添加最底层画布
    Image offScreenImage = null;

    MapBottom mapBottom=new MapBottom();
    MapTop mapTop=new MapTop();

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
        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //1鼠标左键被点击
                if (e.getButton()==1){
//                    System.out.println(1);
                    //提交坐标
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    //相关鼠标左键状态
                    GameUtil.LEFT=true;
                }
                //2是滚轮被点击
                //3鼠标右键被点击
                if (e.getButton()==3){
//                    System.out.println(3);
                    //提交坐标
                    GameUtil.MOUSE_X=e.getX();
                    GameUtil.MOUSE_Y=e.getY();
                    //相关鼠标左键状态
                    GameUtil.RIGHT=true;
                }
            }
        });
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
        //设置画布的高宽
        offScreenImage=this.createImage(wigth,height);
        Graphics gImage = offScreenImage.getGraphics();
        //设置颜色
        gImage.setColor(Color.magenta);
        //填充全部画布
        gImage.fillRect(0,0,wigth,height);
        //把mapBottom和maptop存入该最低层画布中
        mapBottom.paintSelf(gImage);
        mapTop.paintSelf(gImage);
        g.drawImage(offScreenImage,0,0,null);
    }

    //添加入口函数
    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

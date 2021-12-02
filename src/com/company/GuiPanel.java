package com.company;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
public class GuiPanel extends JPanel implements ActionListener {
    static int SCREEN_WIDTH;
    static int SCREEN_HIGHT;
    static int UNIT_SIZE =29;
    boolean runing = false;
    List<edge> edge;
    int X;
    int Y;
    GuiPanel(int Col, int Lines, List<edge> edge)
    {
        this.X =Col;
        this.Y =Lines;
        this.SCREEN_HIGHT = (Lines)*UNIT_SIZE;
        this.SCREEN_WIDTH = (Col)*UNIT_SIZE;
        this.edge = edge;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH+10,SCREEN_HIGHT+10));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        //this.addKeyListener(new MyKeyAdapter);
        startMaze();
    }
public void startMaze()
{
    this.runing =true;
}
public void findBlock(Graphics g) {
    Iterator<edge> it = edge.iterator();
    while (it.hasNext()) {
        edge temp = it.next();
        if(temp.src.getIndex()+1 ==temp.dst.getIndex())
        {
            int y = (temp.src.getIndex()%X);
            int x = (temp.src.getIndex()-y)/X;
            System.out.println("src: " + temp.src.getIndex() + " Dst: " + temp.dst.getIndex());
            System.out.println("the paramters are: " + x +" " +y);
            drawRight(y,x,g);
        }
        if(temp.src.getIndex()+X ==temp.dst.getIndex())
        {
            int y = (temp.src.getIndex()%X);
            int x = (temp.src.getIndex()-y)/X;
            System.out.println("src: " + temp.src.getIndex() + " Dst: " + temp.dst.getIndex());
            System.out.println("the paramters are: " + x +" " +y);
            drawUp(y,x,g);
        }
    }
}
    public void drawUp(int x, int y, Graphics g)
    {
        g.setColor(Color.RED);
        g.drawLine((x)*UNIT_SIZE,(y)*UNIT_SIZE,(x+1)*UNIT_SIZE,(y)*UNIT_SIZE);
    }
    public void drawRight(int x,int y, Graphics g)
    {
        g.setColor(Color.RED);
        g.drawLine((x+1)*UNIT_SIZE,(y)*UNIT_SIZE,(x+1)*UNIT_SIZE,(y+1)*UNIT_SIZE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        drawRight(3,1,g);
        //drawUp(29,6,g);
        findBlock(g);
    }
    public void draw(Graphics g) {
        if (runing) {
            g.setColor(new Color(2,240,120));
            g.drawLine(2,2,SCREEN_WIDTH,2);
            g.drawLine(2,2,2,SCREEN_HIGHT);
            g.drawLine(SCREEN_WIDTH,2,SCREEN_WIDTH,SCREEN_HIGHT);
            g.drawLine(2,SCREEN_HIGHT-2,SCREEN_WIDTH,SCREEN_HIGHT-2);
            for (int i=0; i<SCREEN_WIDTH/UNIT_SIZE;i++)
            {
                g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HIGHT);
            }
           for (int i=0; i<SCREEN_HIGHT/UNIT_SIZE;i++)
            {
                g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
           }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

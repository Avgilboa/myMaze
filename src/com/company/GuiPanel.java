package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiPanel extends JPanel {
    static int SCREEN_WIDTH;
    static int SCREEN_HIGHT;
    static int UNIT_SIZE =15;
    boolean running = false;
    List<edge> cell1;
    int X; //=Col
    int Y; //=Lines

    GuiPanel(int Col, int Lines, List<edge> edge) {
        this.X =Col;
        this.Y =Lines;
        this.SCREEN_HIGHT = (Lines)*UNIT_SIZE;
        this.SCREEN_WIDTH = (Col)*UNIT_SIZE;
        this.cell1 = edge;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH+10,SCREEN_HIGHT+10));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        startMaze();
    }

    public void startMaze() {
        this.running =true;
    }

    //draw a line between node to the node in its right: __node1__|__node2__
    public void drawUp(int x, int y, Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((x)*UNIT_SIZE,(y)*UNIT_SIZE,(x+1)*UNIT_SIZE,(y)*UNIT_SIZE);
    }

    //draw a line between node to the node below it:
    // __node1__
    // ---------
    // __node2__
    public void drawRight(int x,int y, Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine((x+1)*UNIT_SIZE,(y)*UNIT_SIZE,(x+1)*UNIT_SIZE,(y+1)*UNIT_SIZE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        findBlock(g);
    }

    //for each edge in cell find the square which the edge begins and decide if it is
    //drawRight or drawUp
    public void findBlock(Graphics g) {
        for (int i=0;i<cell1.size();i++) {
            if(cell1.get(i).src.getIndex()+1==cell1.get(i).dst.getIndex()) {
            int x =cell1.get(i).src.getIndex()%X; //x=col
            int y = (cell1.get(i).src.getIndex()-x)/X; //y=line
            drawRight(x,y,g);
        }
            if(cell1.get(i).src.getIndex()+X==cell1.get(i).dst.getIndex()) {
                int x =cell1.get(i).dst.getIndex()%X;
                int y = (cell1.get(i).dst.getIndex()-x)/X;
                drawUp(x,y,g);
            }
        }
    }

    public void draw(Graphics g) {
        if (running) {
            g.setColor(Color.BLACK);
            g.drawLine(2,2,SCREEN_WIDTH,2);
            g.drawLine(2,UNIT_SIZE,2,SCREEN_HIGHT);
            g.drawLine(SCREEN_WIDTH,2,SCREEN_WIDTH,SCREEN_HIGHT-UNIT_SIZE);
            g.drawLine(2,SCREEN_HIGHT-2,SCREEN_WIDTH,SCREEN_HIGHT-2);
            g.setColor(Color.RED);
            g.drawLine(2,UNIT_SIZE,2,0);
            g.drawLine(SCREEN_WIDTH,SCREEN_HIGHT,SCREEN_WIDTH,SCREEN_HIGHT-UNIT_SIZE);
        }
    }
}
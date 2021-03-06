package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiFrame extends JFrame {
    GuiFrame(int lines, int row, List<edge> edge){
        this.add(new GuiPanel(lines, row, edge));
        this.setTitle("Union-Maze");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

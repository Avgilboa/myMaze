package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class edge {
    Node src;
    Node dst;

    public edge(Node node1, Node node2) {
        this.src = node1;
        this.dst = node2;
    }

    //    public String tstring() {
    //        return " " + this.src.getIndex() + " " + this.dst.getIndex();
    //    }
}

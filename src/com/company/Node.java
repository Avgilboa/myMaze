package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * this class represents a node.
 * every node has an index (from 0 to m*n-1) referring to its square in the m*n matrix:
 * n0 | n1|....| n(m-1) and so on for the next rows...
 * and its root represent the key of the set that this node is belonged
 */

public class Node {
    private int index;
    private int root;

    public Node(int index) {
        this.index = index;
        this.root = index;
    }

    public int getIndex() {
        return index;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getRoot() {
        return root;
    }
}

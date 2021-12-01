package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
    private int index;
    private int root;

    public Node(int index) {
        this.index = index;
        this.root = index;
    }

    public void union(int id) {
        this.root =id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getRoot() {
        return root;
    }
}

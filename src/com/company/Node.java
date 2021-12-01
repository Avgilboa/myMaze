package com.company;

import java.util.HashMap;

public class Node {
    private int index;
    private int root;
    static HashMap<Integer,Node> nodes = new HashMap<>();

    public Node(int index) {
        this.index = index;
        this.root = index;
    }

    static public void makeNodes(int m, int n) {
        for(int i=0; i<m*n;i++) {
            nodes.put(i,new Node(i));
        }
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

package com.company;

import java.util.*;

public class edge {
    Node src;  //columns + lines*columns
    Node dst;

    public edge(Node node1, Node node2) {
        this.src = node1;
        this.dst = node2;
    }
    public String tstring() {
        return " " + this.src.getIndex() + " " + this.dst.getIndex();
    }


}

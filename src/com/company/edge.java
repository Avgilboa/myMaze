package com.company;

import java.util.*;

public class edge {
    Node src;  //columns + lines*columns
    Node dst;
    static int countEdge = 0;

    public edge(Node node1, Node node2) {
        this.src = node1;
        this.dst = node2;
    }

    public String tstring() {
        return " " + this.src.getIndex() + " " + this.dst.getIndex();
    }

    public static List<edge> getEdges(int m, int n) {
        //make HashMap of nodes
        //HashMap <Integer,Node> nodes = new HashMap<>();
        //for (int i=0; i<m*n;i++) {
        //    nodes.put(i,new Node(i));
        //}
        Node.makeNodes(n,m);
        //make HashMap of all the possibly edges
        List<edge> myEdge = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n is lines
            for (int j = 0; j < m; j++) { // m columns
                if (i == n - 1) {
                    if (j != m - 1) {
                        edge temp = new edge(Node.nodes.get(i * m + j),Node.nodes.get(i * m + j + 1));
                        myEdge.add(countEdge,temp);
                        countEdge++;
                    }
                } else if (j == m - 1) {
                    if (i != n - 1) {
                        edge temp = new edge(Node.nodes.get(i * m + j),Node.nodes.get((i + 1) * m + j));
                        myEdge.add(countEdge,temp);
                        countEdge++;
                    }
                } else {
                    edge temp1 = new edge(Node.nodes.get(i * m + j),Node.nodes.get((i + 1) * m + j));
                    myEdge.add(countEdge,temp1);
                    countEdge++;
                    edge temp2 = new edge(Node.nodes.get(i * m + j),Node.nodes.get((i * m) + j + 1));
                    myEdge.add(countEdge, temp2);
                    countEdge++;
                }
            }
        }
        for (int i = 0; i < myEdge.size(); i++) {
            System.out.printf(myEdge.get(i).tstring() + " ");
        }
        System.out.println();
        Collections.shuffle(myEdge, new Random());
        for (int i = 0; i < myEdge.size(); i++) {
            System.out.printf(myEdge.get(i).tstring() + " ");
        }
        return myEdge;
    }

    public static void main(String[] args) {
        List<edge> t = getEdges(4,4);
    }
}

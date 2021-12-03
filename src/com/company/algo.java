package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * this class represents the Maze Generator
 * the algorithm:
 * for an m*n matrix, each square represents a node
 * - initialize m*n sets of each node
 * - make all the possible edges in m*m matrix and shuffle them
 * - for each edge, if its nodes are not in the same set, make union-find on this nodes,
 *   else: add these nodes to cell
 * - draw this m*n matrix when the edges in cell are the blocks in our maze
 */

public class algo {
    HashMap<Integer, List<Node>> nodes = new HashMap<>(); //disjoint-set data structure of the nodes
    List<edge> Edge; // a list of all the possible edges
    List<edge> cell; //This list represent the blocks (walls) in the maze
    int i=0;

    public algo(int m, int n) {
        makeNodes(m,n);
        Edge = getEdges(m,n);
        cell = new ArrayList<>();
        cell = checkBlock();
        new GuiFrame(m,n, cell);
    }

    //sets Initialization: each node is root to itself. we need to use this nodes all the algo from now
    public  void makeNodes(int m, int n) {
        for(int i=0; i<m*n;i++) {
            this.nodes.put(i,new ArrayList<>());
            this.nodes.get(i).add(new Node(i));
        }
    }

    //make HashMap of all the possibly edges.
    public List<edge> getEdges(int m, int n) {
        List<edge> myEdge = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n is lines
            for (int j = 0; j < m; j++) { // m is columns
                //make edge of two nodes in the last line. Each node has an edge with a node in his right,
                //except the node in the last column
                if (i == n - 1) {
                    if (j != m - 1) {
                        edge temp = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get(i * m + j + 1).get(0));
                        myEdge.add(temp);
                    }
                //the same for the last column
                } else if (j == m - 1) {
                    if (i != n - 1) {
                        edge temp = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i + 1) * m + j).get(0));
                        myEdge.add(temp);
                    }
                //for the rest nodes, do en edge between a node to the node in his right and below it.
                } else {
                    edge temp1 = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i + 1) * m + j).get(0));
                    myEdge.add(temp1);
                    edge temp2 = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i * m) + j + 1).get(0));
                    myEdge.add(temp2);
                }
            }
        }
        Collections.shuffle(myEdge, new Random());
        return myEdge;
    }

    public void changeRoot(int move, int stay) {
        while(!nodes.get(move).isEmpty())
        {
            Node v = nodes.get(move).get(0);
            v.setRoot(stay);
            nodes.get(move).remove(0);
            nodes.get(stay).add(v);
        }
        nodes.remove(move);
    }

    //for two nodes of an edge. check if they are not in the same set. else, add them to cell
    public List<edge> checkBlock() {
        Iterator<edge> it = Edge.iterator();
        while(it.hasNext()) {
            edge temp = it.next();
            //the nodes are in the same set
            if(temp.src.getRoot()==temp.dst.getRoot()) {
                cell.add(temp);
                continue;
            } else { //change all node's root in the smaller set to be the key of the bigger set
                if(nodes.get(temp.src.getRoot()).size() > nodes.get(temp.dst.getRoot()).size()) {
                    changeRoot(temp.dst.getRoot(),temp.src.getRoot());
                    continue;
                }
                else {
                    changeRoot(temp.src.getRoot(),temp.dst.getRoot());
                    continue;
                }
            }
        }
        return this.cell;
    }

    public static void main(String[] args) {
        algo t = new algo(30,40);
    }
}
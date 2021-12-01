package com.company;

import java.util.*;

public class algo {
    HashMap<Integer, List<Node>> nodes = new HashMap<>();
    List<edge> Edge;
    List<edge> cell;
    int i=0;

    public algo(int m, int n) {
        makeNodes(m,n);
        Edge = getEdges(m,n);
        cell = new ArrayList<>();
        cell = checkBlock();
        new GuiFrame(m,n, cell);
    }
    public  void makeNodes(int m, int n) {

        /// Make HashMap when every Node is root to itself. we need to use this nodes all the algo from now
        for(int i=0; i<m*n;i++) {
            this.nodes.put(i,new ArrayList<>());
            this.nodes.get(i).add(new Node(i));
        }
    }

    public List<edge> getEdges(int m, int n) {
        //make HashMap of nodes
        //HashMap <Integer,Node> nodes = new HashMap<>();
        //for (int i=0; i<m*n;i++) {
        //    nodes.put(i,new Node(i));
        //}
        //make HashMap of all the possibly edges
        List<edge> myEdge = new ArrayList<>();
        for (int i = 0; i < n; i++) { // n is lines
            for (int j = 0; j < m; j++) { // m columns
                if (i == n - 1) {
                    if (j != m - 1) {
                        edge temp = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get(i * m + j + 1).get(0));
                        myEdge.add(temp);
                    }
                } else if (j == m - 1) {
                    if (i != n - 1) {
                        edge temp = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i + 1) * m + j).get(0));
                        myEdge.add(temp);
                    }
                } else {
                    edge temp1 = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i + 1) * m + j).get(0));
                    myEdge.add(temp1);
                    edge temp2 = new edge(this.nodes.get(i * m + j).get(0),this.nodes.get((i * m) + j + 1).get(0));
                    myEdge.add(temp2);
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

    public void changeRoot(int move, int stay)
    {
        while(!nodes.get(move).isEmpty())
        {
            Node v = nodes.get(move).get(0);
            v.setRoot(stay);
            nodes.get(move).remove(0);
            nodes.get(stay).add(v);
        }
        nodes.remove(move);
    }

    public List<edge> checkBlock() {
        Iterator<edge> it = Edge.iterator();
        while(it.hasNext()) {
            i++;
            edge temp = it.next();
            //System.out.println(nodes.get(temp.src.getIndex()).size() + " " +(++i));
            if(temp.src.getRoot()==temp.dst.getRoot()) {
                cell.add(temp);
                System.out.println(cell.size() + " Root of "+temp.dst.getIndex()+" is " + temp.dst.getRoot()
                        + " Root of "+temp.src.getIndex()+ " is " + temp.src.getRoot());
                continue;
            } else  {
               if(nodes.get(temp.src.getRoot()).size() > nodes.get(temp.dst.getRoot()).size())
               {
                   changeRoot(temp.dst.getRoot(),temp.src.getRoot());
                   continue;
               }
               else {
                   changeRoot(temp.src.getRoot(),temp.dst.getRoot());
                   continue;
               }

            }
        }
        System.out.println(this.i);
        return this.cell;
    }
    public static void main(String[] args) {
        algo t = new algo(17,14);
    }
}
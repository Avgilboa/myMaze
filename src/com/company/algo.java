package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class algo {
    List<edge> Edge;
    List<edge> cell;

    public algo(int m, int n) {
        Edge = edge.getEdges(m,n);
        cell = new ArrayList<>();
        checkBlock();
    }

    public List<edge> checkBlock() {
        Iterator<edge> it = Edge.iterator();
        while(it.hasNext()) {
            edge temp = it.next();
            if(temp.src.getRoot()==temp.dst.getRoot()) {
                cell.add(temp);
                continue;
            } else  {
               // Node.nodes.get(temp.src.getIndex()).;

            }
        }
        return this.cell;
    }
}
package problems.searchengines.modifiable.graph;

import problems.searchengines.Node;
import problems.searchengines.SearchEngine;

import java.util.LinkedList;

abstract public class GraphSearch extends SearchEngine {

    protected LinkedList<Node> closed = new LinkedList<>();

    protected LinkedList<Node> open = new LinkedList<>();

    public void printDataBase(){
        System.out.println("Closed nodes: ");
        for (Node item:closed){
            System.out.println(item);
        }
        System.out.println("Open nodes: ");
        for (Node item:open){
            System.out.println(item);
        }
    }

    abstract protected void expands(Node node);

}

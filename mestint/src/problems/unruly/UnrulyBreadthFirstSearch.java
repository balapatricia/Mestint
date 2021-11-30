package problems.unruly;

import problems.searchengines.Node;
import problems.searchengines.modifiable.graph.breadthfirstsearch.BreadthFirstSearch;

public class UnrulyBreadthFirstSearch {

    public static void main(String[] args) {

        UnrulyState us = new UnrulyState();
        System.out.println(us.toString());
        BreadthFirstSearch bfs = new BreadthFirstSearch(us);
        bfs.search();
        if (bfs.getTerminalNodes().isEmpty()){
            System.out.println(":(");
        }
        else {
            System.out.println(":)");
            for (Node node : bfs.getTerminalNodes()) {
                System.out.println("Egy megoldás:");
                bfs.printSolution(node);
            }
        }
    }
}

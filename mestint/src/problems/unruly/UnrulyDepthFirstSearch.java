package problems.unruly;

import problems.searchengines.Node;
import problems.searchengines.modifiable.graph.depthfirstsearch.DepthFirstSearch;

public class UnrulyDepthFirstSearch {

    public static void main(String[] args) {

        UnrulyState st = new UnrulyState();
        System.out.println("Searching was started...");
        DepthFirstSearch dfs = new DepthFirstSearch(st);
        dfs.search();
        if (dfs.getTerminalNodes().isEmpty()){
            System.out.println(":(");
        }
        else {
            System.out.println(":)");
            for (Node node : dfs.getTerminalNodes()) {
                System.out.println("Egy megoldás:");
                dfs.printSolution(node);
            }
        }
    }
}

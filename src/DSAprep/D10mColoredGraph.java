package DSAprep;

import java.util.ArrayList;
import java.util.List;

/*
*       m colored graph:
*           recursive solution:
*               base case: if node passed == the length of the graph, return true
*
*               for a given no. of colors m, try to color the node with a color in the range 1 to m
*               i.e loop from 1 to m and try to color the node
*                   if the adjacent colors are different, color the node
*                   mark color[node] == i where i is the color from the loop
*                   call the recur function for the next node, i.e node + 1
*                   if the function returns true, we have found a solution, so return true
*                   make sure to remove the color from the node,
*                   i.e color[node] = 0 to facilitate for the next color in the loop
*
*               isValid method to check if the adjacent nodes have the same color or not:
*                   take the list<int> adjacent nodes from the graph for the node passed and iterate over it
*                       if the color[adj node] == color specified, then the adj node has the same
*                       color as the color we are trying to color the node, so return false
*                   return true
**/

public class D10mColoredGraph {

//    method to check if the adjacent nodes have the same color or not
    private static boolean isValid(int node, List<Integer>[] g, int[] color, int col) {
//        we are getting the adjacent nodes of the node and checking if they have the same color as the one we are
//        trying to color the current node
        for (int it: g[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }

    private static boolean recur(int node, List<Integer>[] g, int[] color, int m) {
//        base case
        if (node == g.length) return true;

//        try to color the node from colors 1 to m
        for (int i = 1; i <=m; i++) {
            if (isValid(node, g, color, i)) {
//                color the node with the current color
                color[node] = i;
//                call the recur function and if it returns true, we can color all the nodes successfully
//                so return true
                if(recur(node + 1, g, color, m)) return true;
//                make sure to mark the color as 0 [not colored] to facilitate for the next color
                color[node] = 0;
            }
        }

//        if we reach this far without coloring any node, then we can say that we can't color the graph with
//        m colors successfully, so return false
        return false;
    }

    public static boolean solve(List<Integer>[] g, int m) {
        int n = g.length;

//        array to keep track of colors
        int[] color = new int[n];

//        call the recursive function for node 0 at the start
        return recur(0, g, color, m);
    }

    public static void main(String[] args) {
        List<Integer>[] g = new List[4];

        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

//        nodes adjacent to a node are stored as list<int> for every node
//        adjacent nodes for node 0
        g[0].add(1);
        g[0].add(3);

//        adjacent nodes for node 1
        g[1].add(0);
        g[1].add(2);
        g[1].add(3);

//        adjacent nodes for node 2
        g[2].add(1);
        g[2].add(3);

//        adjacent nodes for node 3
        g[3].add(0);
        g[3].add(1);
        g[3].add(2);

        System.out.println(solve(g, 3));
    }
}

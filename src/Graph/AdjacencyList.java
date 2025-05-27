package Graph;

import java.util.ArrayList;

/*
Time Complexity-O(V+E)
Space Complexity-O(V+E)
Explanation:

Each vertex stores a list of its neighbors.

There are V lists (one for each vertex).

The total number of items across all lists is E (or 2𝐸)
2E for undirected graphs, since each edge appears twice).
 */

public class AdjacencyList {

    public static ArrayList<ArrayList<Integer>> adjacencyList(int n,int e,int[][] input){

        //declare an array of arrayList
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<e;i++){
            int u=input[i][0];
            int v=input[i][1];


            //if bidirectional
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;

    }

    // Method to display the adjacency list
    public static void displayAdjList(ArrayList<ArrayList<Integer>> adjacencyList) {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adjacencyList.get(i)) {
                System.out.print(j + " "); // Print its adjacent
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n=3,e=3;
        int[][] input=new int[e][2];
       /*
       1-2
       2-3
       1-3
        */

        input[0][0]=1;
        input[0][1]=2;
        input[1][0]=2;
        input[1][1]=3;
        input[2][0]=1;
        input[2][1]=3;

        ArrayList<ArrayList<Integer>> adj=adjacencyList(n,e,input);


       displayAdjList(adj);
    }
}

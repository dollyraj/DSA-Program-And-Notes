package Graph;

import java.util.ArrayList;

public class AdjacencyList {

    public static ArrayList<Integer>[] adjacencyList(int n,int e,int[][] input){

        //declare an array of arrayList
        ArrayList[] graph=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<e;i++){
            int u=input[i][0];
            int v=input[i][1];


            //if bidirectional
            graph[u].add(v);
            graph[v].add(u);
        }

        return graph;

    }

    // Method to display the adjacency list
    public static void displayAdjList(ArrayList<Integer>[] adjacencyList) {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adjacencyList[i]) {
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

        ArrayList<Integer>[] adj=adjacencyList(n,e,input);


       displayAdjList(adj);
    }
}

package Graph;

import java.util.ArrayList;

public class AdjacencyMatrix {
    public static int[][] adjacencyList(int n, int e, int[][] input){

        //declare an array of arrayList
        int[][] graph=new int[n+1][n+1];

        for(int i=0;i< input.length;i++){
            graph[input[i][0]][input[i][1]]=1;
            graph[input[i][1]][input[i][0]]=1;
        }

        return graph;

    }

    // Method to display the adjacency list
    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
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

        int[][] adj=adjacencyList(n,e,input);


        displayMatrix(adj);
    }
}

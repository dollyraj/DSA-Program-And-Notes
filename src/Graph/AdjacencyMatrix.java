package Graph;
/*
Time Complexity-O(V*V)
Space Complexity-O(V*V)
 */

public class AdjacencyMatrix {
    public static int[][] adjacencyMatrix(int v, int e, int[][] input){


        int[][] graph=new int[v+1][v+1];

        for (int[] ints : input) {
            graph[ints[0]][ints[1]] = 1;
            graph[ints[1]][ints[0]] = 1;
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

        int[][] adj=adjacencyMatrix(n,e,input);


        displayMatrix(adj);
    }
}

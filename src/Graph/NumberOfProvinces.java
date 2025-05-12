package Graph;

import java.util.ArrayList;

public class NumberOfProvinces {
  /*
  There are n cities. Some of them are connected, while some are not.
  If city a is connected directly with city b, and city b is connected directly with city c,
  then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities
 and no other cities outside of the group.

You are given an n x n matrix isConnected where
isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


Idea-> We can traverse using DFS/BFS, No of connected components
 if we calculate how many times we have called DFS/BFS
using different starting node, it will give no of islands

-->Below code is implemented using DFS
   */

    public static int noOfProvinces(int[][] isConnected){
        int n= isConnected.length;

        //convert adjacency matrix to adjacency list
     /*   ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                  if(isConnected[i][j]==1 && i!=j){
                      //undirected graph
                      adjList.get(i).add(j);
                      adjList.get(j).add(i);
                  }
            }
        }*/

        int[] visited=new int[n];

        int noOfProvince=0;

        for(int i=0;i<n;i++){
           if(visited[i]==0){
               noOfProvince++;
               dfs(i,isConnected,visited);
           }
        }
        return noOfProvince;
    }

    public static void dfs(int src,int[][] isConnected,int[] visited){
        //mark the cell visited
        visited[src]=1;

        //using adjacency matrix
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0 && isConnected[src][i]==1){
                dfs(i,isConnected,visited);
            }
        }


        //using adjacency list
//        for(int nbr:adjList.get(src)) {
//            if (visited[nbr] == 0) {
//                //call dfs for unvisited neighbour
//                dfs(nbr, adjList, visited);
//            }
//        }

    }

    public static void main(String[] args) {
        int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(noOfProvinces(isConnected));
    }
}

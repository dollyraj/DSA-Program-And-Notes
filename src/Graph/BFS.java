package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    /*
    Queue data structure: follows FIFO, and will always contain the starting.
--->Visited array: an array initialized to 0
--->In BFS, we start with a “starting” node, mark it as visited,
and push it into the queue data structure.
--->In every iteration, we pop out the node ‘v’ and put it in the solution vector,
as we are traversing this node.
--->All the unvisited adjacent nodes from ‘v’ are visited next
and are pushed into the queue. The list of adjacent neighbors of the node
can be accessed from the adjacency list.
--->Repeat steps 2 and 3 until the queue becomes empty,
and this way you can easily traverse all the nodes in the graph.
--->In this way, all the nodes are traversed in a breadth wise manner.

TC=O(N+E)
SC=O(N+E)
     */

    public static void bfs(int[] visited,ArrayList<ArrayList<Integer>> adjList){

        Queue<Integer> queue=new LinkedList<>();

        queue.add(0);
        //mark node as visited
        visited[0]=1;

        while(!queue.isEmpty()){
           int curr= queue.poll();//retrieves and removes the head node
            System.out.print(curr+" ");
            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it
            // visited and enqueue it
          for(int nbr: adjList.get(curr)){
              if(visited[nbr]==0) {
                  visited[nbr] = 1;
                  queue.add(nbr);
              }
          }

        }
    }

    public static void main(String[] args) {
        int[][] graph={{0,1},{0,2},{1,2},{2,3}};
        //from vertex u to v (u,v)

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        //V=4 no of vertices
        for(int i=0;i<4;i++){
            adjList.add(new ArrayList<>());
        }

        //no of edges=graph.length
        //no of nodes=4
       /* for(int i=0;i<4;i++){
            for(int j=0;j< graph.length;j++){
                int u=graph[j][0];
                int v=graph[j][1];
                adjList.get(u).add(v);

            }
        }*/
        for(int[] edge:graph){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] visited=new int[adjList.size()];
        bfs(visited,adjList);
    }
}

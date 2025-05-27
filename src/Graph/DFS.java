package Graph;

import java.util.ArrayList;

public class DFS {
/*
Time complexity-O(V+E)
-->Each vertex is visited once:O(V)
-->Each edge is explored once (in directed graphs) or twice (in undirected graphs):O(E)
-->All the nodes and edges will be visited in DFS
-->So total time = O(V+E)
SC--> O(V)--> Maximum size of recursive stack

"""
    - Depth First Search starts at a vertex.
    - Select the adjacent vertex from the start vertex.
    - Visit the adjacent vertex , mark as visited.
    - Continue the above procedure until there are no more unexplored edges.
    - then terminate.
    """


 */
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] visited){
        //Mark visited
        visited[src]=true;
        System.out.println(src);

        //explore its all neighbour

        for(int nbr:graph.get(src)){
            if(!visited[nbr]){
                dfs(graph,nbr,visited);
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
        boolean[] visited=new boolean[adjList.size()];
        dfs(adjList,0,visited);
    }
}

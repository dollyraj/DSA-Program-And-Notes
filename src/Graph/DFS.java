package Graph;

import java.util.ArrayList;

public class DFS {
/*
Time complexity-O(N+E)
-->All the nodes and edges will be visited in DFS
SC--> O(n)--> Maximum size of recursive stack

"""
    - Depth First Search starts at a vertex.
    - Select the adjacent vertex from the start vertex.
    - Visit the adjacent vertex , mark as visited.
    - Continue the above procedure until there are no more unexplored edges.
    - then terminate.
    """
 */
    public void DFS(ArrayList<Integer>[] graph,int src,boolean[] visited){
        //Mark visited
        visited[src]=true;
        System.out.println(src);

        //explore its all neighbour

        for(int nbr:graph[src]){
            if(visited[nbr]==false){
                DFS(graph,nbr,visited);
            }
        }
    }

    public static void main(String[] args) {

    }
}

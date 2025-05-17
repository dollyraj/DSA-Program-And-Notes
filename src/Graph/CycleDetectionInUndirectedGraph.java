package Graph;

import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph {

    /*/
    Idea--> Apply DFS, if a node in current path is encountered again
    means cycle detected
    In case of undirected graph we can pass parent node in DFS call.
     */

    public static boolean cycleDetectInUnDirectedGraph(ArrayList<ArrayList<Integer>> adjList){
        int n=adjList.size();
        int[] visited=new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(dfs(i, -1, adjList, visited))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(int src,int parent,ArrayList<ArrayList<Integer>> adjList,int[] visited){
        //mark the node visited
        visited[src]=1;

        for(int nbr: adjList.get(src)){

            //if node is already visited and not equal to parent node
            if(visited[nbr]==1 && nbr!=parent)
                return true;

            //if that node is not visited
            if(visited[nbr]==0){
                if((dfs(nbr,src, adjList, visited))){
                    return true;
                }
            }


        }

        return false;

    }

    public static void main(String[] args) {
        //int[][] graph={{0,1},{0,2},{1,2},{2,3}};
        int[][] graph={{0,1},{1,2},{2,3}};
        //from vertex u to v (u,v)
        //from vertex v to u

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
                //adjList.get(v).add(u);
            }
        }*/
        for(int[] edge:graph){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println(cycleDetectInUnDirectedGraph(adjList));
    }
}

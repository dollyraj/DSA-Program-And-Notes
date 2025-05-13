package Graph;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {

    /*/
    Idea--> Apply DFS, if a node in current path is encountered again
    means cycle detected
     */

    public static boolean cycleDetectInDirectedGraph(ArrayList<ArrayList<Integer>> adjList){
             int n=adjList.size();
            int[] visited=new int[n];
            int[] path=new int[n];

            for(int i=0;i<n;i++){
                if(visited[i]==0){
                    return dfs(i,adjList,visited,path);
                }
            }

            return false;
    }

    public static boolean dfs(int src,ArrayList<ArrayList<Integer>> adjList,int[] visited,int[] path){
        //mark the node visited
        visited[src]=1;
        //include node in current path
        path[src]=1;

        for(int nbr: adjList.get(src)){

            //if that node is already visited and present in current path
            if(path[nbr]==1)
                return true;

            //if that node is not visited
            if(visited[nbr]==0){
                if((dfs(nbr, adjList, visited, path))){
                    return true;
                }
            }


        }

        path[src]=0;

        return false;

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
        for(int i=0;i<4;i++){
            for(int j=0;j< graph.length;j++){
                int u=graph[i][0];
                int v=graph[i][1];
                adjList.get(u).add(v);
            }
        }

        System.out.println(cycleDetectInDirectedGraph(adjList));
    }
}

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Topological sorting only exists in Directed Acyclic Graph (DAG).
If the nodes of a graph are connected through directed edges and the graph does not contain a cycle,
 it is called a directed acyclic graph(DAG).

The topological sorting of a directed acyclic graph is nothing
but the linear ordering of vertices such that if there is an edge between node u and v(u -> v),
node u appears before v in that ordering.

Approach---> We will do the traversal of graph,
but before returning from a node after exploring all of its
 neighbours add this node to stack(LIFO).
--->If there is a cycle present, topological sort order is not possible.
--->Kahn's Algorithm=Topological sorting using BFS
 */

public class TopologicalSort {

    public static void dfs(int src,ArrayList<ArrayList<Integer>> graph,int[] visited,Stack<Integer> st){

        //mark the current node as visited
        visited[src]=1;

        //we will traverse it's all neighbours
        for(Integer nbr:graph.get(src)){
            if(visited[nbr]==0){
                dfs(nbr,graph,visited,st);
            }
        }
        //we will add node to stack when all of its neighbours are explored and ,we return back to this node

        st.add(src);
    }

    public static ArrayList<Integer> topologicalSortDFS(ArrayList<ArrayList<Integer>> adj){

        int n= adj.size();
        int[] visited=new int[n];

        Stack<Integer> st=new Stack<>();

        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(visited[i]==0){
                dfs(i,adj,visited,st);
            }
        }

        while(!st.isEmpty()){
            ans.add(st.peek());
            st.pop();
        }


        return ans;

    }

    public static ArrayList<Integer> topologicalSortBFS(ArrayList<ArrayList<Integer>> adj){

        int n= adj.size();
        int[] inDegree=new int[n];

        Queue<Integer> q=new LinkedList<>();
        //we will take Min Heap in case if we need lexographically smallest order

        ArrayList<Integer> ans=new ArrayList<>();

        //Calculate inDegree of nodes
        for(int i=0;i<n;i++){
            for(int nbr:adj.get(i)){
                inDegree[nbr]+=1;
            }
        }

        //Store nodes in queue having inDegree=0

        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            //store node in ans
            ans.add(curr);

            //traverse neighbours of the node
            for(int nbr:adj.get(curr)){

                //decrement inDegree of neighbour node of current node as it is removed
                inDegree[nbr]-=1;

                //check if inDegree of any neighbour became 0. add that neighbour in queue
                if(inDegree[nbr]==0){
                    q.add(nbr);
                }
            }
        }


        return ans;

    }


    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);


        System.out.println(topologicalSortBFS(adj));

    }
}

package Graph;

import java.util.ArrayList;
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

 ----Kahn's Algorithm=Topological sorting using BFS
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

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj){

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


        System.out.println(topologicalSort(adj));

    }
}

package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    //Minimum cost to connect cities
    //Minimum Spanning Tree

    /*
    Given number of centers and possible connections that can be made with their cost.
    Find minimum cost of constructing roads between centers such that it is possible to travel
    from one center to any other via roads

    First argument is an integer A.
    -->A==no of nodes
Second argument is a 2-D integer array B of size C×3 denoting edges. B[i][0]and B[i][1]are
 the distribution centers connected by the ith edge with construction cost B[i][2].

 --->Approach:
      *Possible to travel from one center to any other via roads => connected graph
      *For n cities, minimum number of roads to connect=n-1 =>Tree
      *Sum of all edge weights should be minimum
      =>Minimum spanning tree
      => Prim's Algorithm
    Consider any node as root node, and keep on adding minimum edge weights to get final answer


 //Time complexity=
     */

    class Pair{
        Integer node;
        Integer weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }


    public int minimumConnectingCost(int A, int[][] B) {

        //Let's first create adjacency list
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();

        for(int i=0;i<=A;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge:B){
            int u=edge[0];
            int v=edge[1];
            int weight=edge[2];
            adjList.get(u).add(new Pair(v,weight));
            adjList.get(v).add(new Pair(u,weight));
        }

        int[] visited=new int[A+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>()
        {
            public int compare(Pair p1, Pair p2) {
                return p1.weight - p2.weight;
            }
        });

        //PriorityQueue<Pair> pq = new PriorityQueue<Pair>();//Min Heap

        visited[1]=1;

        int mod = 1000000007;
        int ans=0;

        //consider all neighbours of 0
        for(Pair np:adjList.get(0)){
            pq.add(np);
        }

        //while heap is not empty
        while(!pq.isEmpty()){
            Pair rp=pq.remove();//remove on the basis of weight

            if(visited[rp.node]==1)
                continue;

            visited[rp.node]=1;
            ans+= rp.weight;
            ans=ans%mod;

            for(Pair np:adjList.get(rp.node)){
                if(visited[np.node]==0){
                    pq.add(np);
                }
            }
        }

        //confirm if all nodes are visited or not, if graph is connected we can not form MST
//        for(int i=0;i<A;i++){
//            if(visited[i]==0)
//                return -1;
//        }

        return ans;
    }
}

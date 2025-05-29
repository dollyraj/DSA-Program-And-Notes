package Graph;

import java.util.ArrayList;
import java.util.HashSet;

/*
Given a boolean 2D matrix grid of size N x M.
You have to find the number of distinct islands where a group of connected 1s
(horizontally or vertically) forms an island. Two islands are considered to be distinct
if and only if one island is equal to another (not rotated or reflected).

--->How to store identical islands
--->This problem is extension of number of Islands Problem
--->We will use DFS for traversal but we can use BFS as well
--->We will use set data structure to store islands
--->we will store islands as list of (r,c)of cells in that island

 */
class Pair {
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
public class NoOfDistinctIslands {


    private static void dfs(int sr, int sc,int r0,int c0, int[][] grid, int[][] visited, ArrayList<String> temp){

        visited[sr][sc]=1;
        // coordinates - base coordinates
        //why ArrayList of String??
        //ArrayList of Pair did not work
        temp.add(toString(sr-r0,sc-c0));
        int n= grid.length;
        int m=grid[0].length;

        // delta row and delta column
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, -1, 0, +1};

        //traverse the neighbours
        for(int i=0;i<4;i++){

            int nrow=sr+delrow[i];
            int ncol=sc+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,r0,c0,grid,visited,temp);
            }
        }

    }
    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }



    static int countDistinctIslands(int[][] grid){
        int n= grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];

        HashSet< ArrayList < String >> st = new HashSet < > ();

        //traverse the grid
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> temp=new ArrayList<>();
                    dfs(i,j,i,j,grid,visited,temp);

                    //store in hashset
                    st.add(temp);
                }
            }
        }

        for(ArrayList<String>pairs:st){
            System.out.println(pairs);
        }
        return st.size();
    }

    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        int ans = countDistinctIslands(grid);
        System.out.println(ans);
    }
}



package Graph;

public class NumberOfIslands {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands
 horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.

 Idea-> Calculate no of connected component using DFS/BFS
 How many times DFS/BFS called using different starting node?

It is similar to number of provinces but here matrix is not an adjacency matrix.
Here each cell having 1 we can consider as node, so here traversing is abit different not straightforward
adjacency matrix/adjacency list

--> Below implementation using DFS
     */

    public static int numIslands(int[][] grid) {

        int n= grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];
        int[] r={0,-1,0,1,-1,-1,1,1};
        int[] c={-1,0,1,0,-1,1,-1,1};

        int noOfIslands=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    noOfIslands++;
                    dfs(i,j,grid,visited,r,c);
                }
            }
        }

        return noOfIslands;
    }

    public static void dfs(int row,int col,int[][] mat,int[][] visited,int[] r,int[] c){
        int n= mat.length;
        int m=mat[0].length;
        //mark visited the curr node
        visited[row][col]=1;

        //traverse neighbours and call dfs for unvisited nodes
        for(int i=0;i<8;i++){
            //accessing the neighbours
            int newRow=row+r[i];
            int newCol=col+c[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && mat[newRow][newCol]==1){
                dfs(newRow,newCol,mat,visited,r,c);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(numIslands(grid));
    }
}

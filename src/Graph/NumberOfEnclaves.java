package Graph;

public class NumberOfEnclaves {
    /*
    You are given an m x n binary matrix grid, where 0 represents a sea cell and
    1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or
walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off
the boundary of the grid in any number of moves.

Approach---> check for boundary 1 and traverse neibours of this one which are connected , from boundary
1 we can get off the grid

call for dfs for each boundary 1

below implementation is using dfs

TODO--> Implement using BFS
     */

    public void dfs(int sr,int sc,int[][] grid,int[][] visited,int[] dr,int[] dc){
        int n= grid.length;
        int m=grid[0].length;
        visited[sr][sc]=1;
        for(int i=0;i<4;i++){
            int nr=sr+dr[i];
            int nc=sc+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0 && grid[nr][nc]==1){
                dfs(nr,nc,grid,visited,dr,dc);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];

        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};

        //first row having 'O'-->boundary element

        for(int i=0;i<m;i++){
            if(grid[0][i]==1){
                dfs(0,i,grid,visited,dr,dc);
            }
        }

        //first column having 'O' -->boundary element
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(i,0,grid,visited,dr,dc);
            }
        }

        //last row having 'O' ---> boundary element
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1){
                dfs(n-1,i,grid,visited,dr,dc);
            }
        }

        //last col having 'O' ---> boundary element
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1){
                dfs(i,m-1,grid,visited,dr,dc);
            }
        }


        //traverse visited matrix to find which 'O' not visited
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    cnt++;
                }
            }
        }

        return cnt;

    }

}

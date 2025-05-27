package Graph;
/*

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
Approach---> check for boundary 'O' and traverse neibours of this one which are connected

call for dfs for each boundary 'O'

below implementation is using dfs

TODO--> Implement using BFS
 */
public class SurroundedRegions {

    public void dfs(int sr,int sc,char[][] board,int[][] visited,int[] dr,int[] dc){
        int n= board.length;
        int m=board[0].length;
        visited[sr][sc]=1;
        for(int i=0;i<4;i++){
            int nr=sr+dr[i];
            int nc=sc+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(nr,nc,board,visited,dr,dc);
            }
        }

    }
    public void solve(char[][] board) {
        int n= board.length;
        int m=board[0].length;

        int[][] visited=new int[n][m];

        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};

        //first row having 'O'-->boundary element

        for(int i=0;i<m;i++){
          if(board[0][i]=='O'){
              dfs(0,i,board,visited,dr,dc);
          }
        }

        //first column having 'O' -->boundary element
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board,visited,dr,dc);
            }
        }

        //last row having 'O' ---> boundary element
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O'){
                dfs(n-1,i,board,visited,dr,dc);
            }
        }

        //last col having 'O' ---> boundary element
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O'){
                dfs(i,m-1,board,visited,dr,dc);
            }
        }


        //traverse visited matrix to find which 'O' not visited
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }


    }
}


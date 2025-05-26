package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    class Pair {
        int row;
        int col;
        int dist;
        Pair(int r,int c,int d){
            this.row=r;
            this.col=c;
            this.dist=d;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;

        int[][] visited=new int[n][m];
        int[][] ans=new int[n][m];

        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};

        Queue<Pair> queue=new LinkedList<>();

        //We will apply multi-source BFS considering all cells having 1 as source,
        //in leetcode question e have to consider cells having 0 as source because question is bit different

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    visited[i][j]=1;
                    queue.add(new Pair(i,j,0));

                }
            }
        }


        while(!queue.isEmpty()){
            Pair rp=queue.poll();
            int r=rp.row;
            int c=rp.col;
            int d=rp.dist;
            ans[r][c]=d;

            //we will traverse all unvisited neighbours of curr node
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==0){
                    visited[nr][nc]=1;
                    queue.add(new Pair(nr,nc,d));
                }
            }
        }

        return ans;

    }
}


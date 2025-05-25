package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /*
    You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.


// Approach---> Multi source BFS
//TC-O(5*m*n),SC-O(m*n)
     */

    public class Pair{
        int r;
        int c;

        Pair(int row,int col){
            this.r=row;
            this.c=col;
        }
    }


    public int orangesRotting(int[][] grid){

        Queue<Pair> pairQueue=new LinkedList<>();

        int m= grid.length;
        int n=grid[0].length;


        int[] dx={0,-1,0,1};
        int[] dy={-1,0,1,0};

        int fOrange=0;
        //Check if grid contains fresh orange or not if not we will return 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fOrange=1;
                }
            }
        }

        if(fOrange==0)
            return 0;


        //We have multiple source, we will add all rotten orange in queue initially
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    pairQueue.add(new Pair(i,j));
                }
            }
        }

        int t=0;
        while(!pairQueue.isEmpty()){
            //size of queue
            int sz= pairQueue.size();

            //do below removals
            for(int k=0;k<sz;k++){
                Pair rp=pairQueue.poll();
                //consider all the neighbour nodes
                for(int l=0;l<4;l++){
                    int ni=rp.r+dx[l];
                    int nj=rp.c+dy[l];

                    //if node is valid and contains fresh orange in neighbour, mark it as rotten and add in queue
                    if(ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1){
                        grid[ni][nj]=2;
                        pairQueue.add(new Pair(ni,nj));
                    }
                }
            }

            t++;
        }

        //We will check if there is still fresh orange present in grid or not

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }


        return t-1;
    }
}


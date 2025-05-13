package Graph;

public class FloodFillAlgorithm {
    /*
    You are given an image represented by an m x n grid of integers image,
    where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color.
    Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent
(pixels that share a side with the original pixel, either horizontally or vertically)
and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels
and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color
to update.
Return the modified image after performing the flood fill.

Idea->Start traversing the matrix from (sr,sc) using DFS/BFS and keep marking
the cell with given color if it satisfies the flood fill conditions.

To perform a "flood fill", consider the starting pixel,
plus any pixels connected 4-directionally to the
starting pixel of the same colour as the starting pixel,
plus any pixels connected 4-directionally to those pixels
(also with the same colour as the starting pixel), and so on.

here we will call dfs only once using (sr,sc) as starting point
     */

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
           int[] row={0,-1,0,+1};
           int[] col={-1,0,+1,0};

           dfs(image,sr,sc,image[sr][sc],color,row,col);

           return  image;
    }

    public static void dfs(int[][] image,int sr,int sc,int originalColor,int newColor,int[] row,int[] col){
        image[sr][sc]=newColor;
        int n= image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int newRow=sr+row[i];
            int newCol=sc+col[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && image[newRow][newCol]==originalColor){
                dfs(image,newRow,newCol,originalColor,newColor,row,col);
            }
        }

    }

    public static void main(String[] args) {
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        image=floodFill(image,1,1,2);
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++)
                System.out.print(image[i][j] + " ");
            System.out.println();
        }
    }
}

class Solution {
     boolean [][] visited;

     int [][] dir = {
        {-1, 0}, {1, 0}, {0,-1}, {0, 1}
     };
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] ==1){
                    return dfs(grid , i, j);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid, int r, int c){
        if(r <0 | c < 0 || r >= grid.length || c >= grid[0].length){
            return 1;
        } 
        if(grid[r][c] ==0){
            return 1;

        }
        if(visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        int perimeter = 0;

        for(int [] d : dir){
            perimeter += dfs(
                grid, 
                r + d[0], 
                c + d[1]
            );
        }
        return perimeter;
    }

}
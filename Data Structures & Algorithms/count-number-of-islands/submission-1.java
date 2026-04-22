class Solution {
    public int numIslands(char[][] grid) {
        int result=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result+=1;
                    coverAllLand(grid, i, j);
                }
            }
        }
        return result;
    }

    private void coverAllLand(char[][] grid, int i, int j){

        grid[i][j] = '0';
        // go down
        if(i+1 < grid.length && grid[i+1][j] == '1'){
            coverAllLand(grid, i+1, j);
        }

        // go up
        if(i-1 >= 0 && grid[i-1][j] == '1'){
            coverAllLand(grid, i-1, j);
        }

        // go left
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            coverAllLand(grid, i, j-1);
        }

        // go right
        if(j+1 < grid[i].length && grid[i][j+1] == '1'){
            coverAllLand(grid, i, j+1);
        }
    }
}

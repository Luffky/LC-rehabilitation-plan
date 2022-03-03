class Solution {
    int count = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        } else {
            return;
        }
        if (x > 0 && grid[x - 1][y] == '1') {
            helper(grid, x - 1, y);
        }
        if (x < grid.length - 1 && grid[x + 1][y] == '1') {
            helper(grid, x + 1, y);
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            helper(grid, x, y - 1);
        }
        if (y < grid[0].length - 1 && grid[x][y + 1] == '1') { 
            helper(grid, x, y + 1);
        }
    }
}

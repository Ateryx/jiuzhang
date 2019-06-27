public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    class Coordinate {
        int x;
        int y;
        
        Coordinate (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] directionX = {0, 1, -1, 0};
    int[] directionY = {1, 0, 0, -1};
    
    public int numIslands(boolean[][] grid) {
        // write your code here
        int numIslands = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == true) {
                    grid[i][j] = false;
                    numIslands++;
                    Coordinate point = new Coordinate(i, j);
                    bfs(point, row, col, grid);
                }
            }
        }
        return numIslands;
    }
    
    public void bfs(Coordinate point, int row, int col, boolean[][] grid) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(point);
        grid[point.x][point.y] = false;
        
        while (!queue.isEmpty()) {
            Coordinate curPoint = queue.poll();
            for (int i = 0; i < directionX.length; i++) {
                int x = point.x + directionX[i];
                int y = point.y + directionY[i];
                Coordinate newPoint = new Coordinate(x, y);
                if (!inBoundary(newPoint,row, col)) {
                    continue;
                }                
                if (inBoundary(newPoint, row, col) && grid[newPoint.x][newPoint.y] == true) {
                    queue.offer(newPoint);
                    grid[newPoint.x][newPoint.y] = false;
                }

            }
        }
    }
    
    public boolean inBoundary(Coordinate point, int row, int col) {
        return (point.x >=0 && point.x < row && point.y >= 0 && point.y < col);
    }
}

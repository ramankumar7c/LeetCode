class Solution {
    private static int[] DIRECTIONS = {-1, 0, 1};
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        Queue<int[]>queue = new LinkedList<>();
        int[][] moves = new int[m][n];

        for(int i = 0; i < m; i++)
            queue.offer(new int[] {i, 0});
        
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];

            for(int dir : DIRECTIONS){
                int ni = i + dir;
                int nj = j + 1;

                if(ni >= 0 && ni < m && nj < n && grid[ni][nj] > grid[i][j])
                    if(moves[ni][nj] < moves[i][j] + 1) {
                        moves[ni][nj] = moves[i][j] + 1;
                        queue.offer(new int[] {ni, nj});
                        ans = Math.max(ans, moves[ni][nj]);
                    }                
            }
        }
        return ans;
    }
}
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Long> obsSet = new HashSet<>();
        
        for (int[] obs : obstacles) {
            long ox = obs[0] + 30000;
            long oy = obs[1] + 30000;
            obsSet.add((ox << 16) | oy);
        }
        
        int x = 0, y = 0, dir = 0, maxDist = 0;
        
        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    long hash = ((long) nx + 30000) << 16 | (ny + 30000);
                    
                    if (obsSet.contains(hash)) {
                        break;
                    }
                    
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }
        
        return maxDist;
    }
}
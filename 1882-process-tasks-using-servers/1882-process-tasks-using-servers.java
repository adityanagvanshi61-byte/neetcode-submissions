import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];

        // Min-heap for free servers: ordered by weight, then index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Min-heap for unavailable servers: ordered by free_time, then weight, then index
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        // Initialize free servers: [weight, index]
        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] { servers[i], i });
        }

        long currentTime = 0;
        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);

            // If no servers are free, advance time to when the next server becomes free
            if (freeServers.isEmpty() && !busyServers.isEmpty()) {
                currentTime = Math.max(currentTime, busyServers.peek()[0]);
            }

            // Free up servers whose tasks are completed by currentTime
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] busy = busyServers.poll();
                // busy: [free_time, weight, index]
                freeServers.offer(new int[] { busy[1], busy[2] });
            }

            // Assign the current task to the best available free server
            int[] server = freeServers.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;
            int freeTime = (int) currentTime + tasks[j];
            busyServers.offer(new int[] { freeTime, weight, index });
        }

        return ans;
    }
}
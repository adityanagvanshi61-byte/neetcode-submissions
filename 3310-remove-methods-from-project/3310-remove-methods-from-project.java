import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }
        
        Set<Integer> suspicious = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(k);
        suspicious.add(k);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbor : adj.get(curr)) {
                if (!suspicious.contains(neighbor)) {
                    suspicious.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        
        boolean canRemove = true;
        for (int[] inv : invocations) {
            if (!suspicious.contains(inv[0]) && suspicious.contains(inv[1])) {
                canRemove = false;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (!canRemove) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
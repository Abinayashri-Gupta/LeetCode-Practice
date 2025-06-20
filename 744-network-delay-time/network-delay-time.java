class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], node = curr[1];

            if (dist.containsKey(node)) continue;

            dist.put(node, time);

            if (!graph.containsKey(node)) continue;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (!dist.containsKey(next)) {
                    pq.offer(new int[]{time + weight, next});
                }
            }
        }

        if (dist.size() != n) return -1;

        int maxTime = 0;
        for (int time : dist.values()) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
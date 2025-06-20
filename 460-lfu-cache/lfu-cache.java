class LFUCache {
class Node {
        int key, value, freq;
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }
    int capacity, minFreq;
    Map<Integer, Node> keyNodeMap;
    Map<Integer, LinkedHashSet<Integer>> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) return -1;
        Node node = keyNodeMap.get(key);
        int oldFreq = node.freq;
        node.freq++;
        freqMap.get(oldFreq).remove(key);
        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;
        }
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(key);
        return node.value;
    }
    public void put(int key, int value) {
         if (capacity == 0) return;
        if (keyNodeMap.containsKey(key)) {
            keyNodeMap.get(key).value = value;
            get(key); 
            return;
        }
        if (keyNodeMap.size() == capacity) {
            LinkedHashSet<Integer> minFreqKeys = freqMap.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            if (minFreqKeys.isEmpty()) freqMap.remove(minFreq);
            keyNodeMap.remove(evictKey);
        }
        Node node = new Node(key, value);
        keyNodeMap.put(key, node);
        freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
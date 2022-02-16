class LRUCache {
    class CacheNode {
        int val;
        int key;
        CacheNode prev;
        CacheNode next;
        public CacheNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    CacheNode head;
    CacheNode tail;
    int capacity;
    Map<Integer, CacheNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;            
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;            
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            node.val = value;
        } else {
            CacheNode node = new CacheNode(key, value);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            map.put(key, node);
            if (map.size() > capacity) {
                CacheNode deleteNode = head.next;
                head.next = head.next.next;
                head.next.prev = head;
                map.remove(deleteNode.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

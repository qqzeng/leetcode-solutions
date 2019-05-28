class DLinkNode {
    DLinkNode prev;
    DLinkNode next;
    int key;
    int value;
}

class LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkNode head;
    private DLinkNode tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        
        this.head = new DLinkNode();
        this.head.prev = null;
        this.tail = new DLinkNode();
        this.tail.next = null;
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            DLinkNode res = cache.get(key);
            moveToHead(res);
            return res.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkNode node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            moveToHead(node);            
        } else {
            DLinkNode node = new DLinkNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            count++;
            addNode(node);
            if (count > capacity) {
                DLinkNode lastNode = popTail();
                count--;
                cache.remove(lastNode.key);
            }
        }
    }
    
    private void removeNode(DLinkNode node) {
        DLinkNode nextNode = node.next;
        DLinkNode prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    private DLinkNode popTail() {
        DLinkNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    
    private void addNode(DLinkNode node) {
        DLinkNode firstNode = head.next;
        firstNode.prev = node;
        node.next = firstNode;
        head.next = node;
        node.prev = head;
    }
    
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {

    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    int capacity;

     public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Add node just before tail
    void addNode(Node node) {

        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    // Remove node
    void removeNode(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    // public LRUCache(int capacity) {
        
    // }
    
    public int get(int key) {
         // Key doesn't exist
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Remove from current position
        removeNode(node);

        // Put at MRU position
        addNode(node);

        return node.value;
    }
    
    public void put(int key, int value) {
         // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            removeNode(node);
            addNode(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        map.put(key, node);

        addNode(node);

        // Capacity exceeded
        if (map.size() > capacity) {

            Node lru = head.next;

            removeNode(lru);

            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
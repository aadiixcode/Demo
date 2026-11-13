class LRUCache {
    static class Node {
        int value, key;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    int maxSize;
    Map<Integer, Node> mp;
    Node start, end;

    public LRUCache(int capacity) {
        maxSize = capacity;
        start = new Node(-1, -1);
        end = new Node(-1, -1);
        start.next = end;
        end.prev = start;
        mp = new HashMap<>();
    }

    void delete(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void insertAtStart(Node temp) {
        temp.next = start.next;
        start.next.prev = temp;
        start.next = temp;
        temp.prev = start;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        Node temp = mp.get(key);
        delete(temp);
        insertAtStart(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node temp = mp.get(key);
            delete(temp);
            temp.value = value;
            insertAtStart(temp);
        } else {
            Node temp = new Node(key, value);
            if (mp.size() == maxSize) {
                mp.remove(end.prev.key);
                delete(end.prev);
            }
            mp.put(key, temp);
            insertAtStart(temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
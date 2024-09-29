class Node {
    public int count;
    public Set<String> keys;
    public Node prev;
    public Node next;

    public Node(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }

    public Node(int count, String key) {
        this(count);
        this.keys.add(key);
    }
}

class AllOne {
    private Node head;
    private Node tail;
    private Map<String, Node> keyToNode;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        keyToNode = new HashMap<>();
    }

    public void inc(String key) {
        if (keyToNode.containsKey(key))
            updateCount(key, 1);
        else
            addNewKey(key);
    }

    public void dec(String key) {
        updateCount(key, -1);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void addNewKey(String key) {
        if (head.next.count != 1)
            insertNodeAfter(head, new Node(1, key));
        else
            head.next.keys.add(key);
        keyToNode.put(key, head.next);
    }

    private void updateCount(String key, int delta) {
        Node node = keyToNode.get(key);
        node.keys.remove(key);
        int newCount = node.count + delta;

        if (newCount == 0)
            keyToNode.remove(key);
        else {
            Node targetNode = delta > 0 ? node.next : node.prev;

            if (targetNode.count != newCount) {
                targetNode = new Node(newCount);
                if (delta > 0)
                    insertNodeAfter(node, targetNode);
                else
                    insertNodeAfter(node.prev, targetNode);
            }
            targetNode.keys.add(key);
            keyToNode.put(key, targetNode);
        }
        if (node.keys.isEmpty())
            removeNode(node);
    }

    private void insertNodeAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
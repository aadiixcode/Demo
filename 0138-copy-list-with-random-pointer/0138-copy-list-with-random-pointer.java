/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> mp = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            mp.put(temp, copy);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copy = mp.get(temp);
            Node next = temp.next;
            Node random = temp.random;
            if (next != null) {
                copy.next = mp.get(next);
            }
            if (random != null) {
                copy.random = mp.get(random);
            }
            temp = temp.next;
        }
        return mp.get(head);
    }
}
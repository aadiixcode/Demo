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
        Node temp = head, nextNode = null;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            temp = nextNode;
        }
        temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            Node originalRandom = temp.random;
            if (originalRandom != null) {
                copyNode.random = originalRandom.next;
            }
            temp = copyNode.next;
        }

        Node dummy = new Node(-1);
        Node ans = dummy;
        temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            nextNode = copyNode.next;

            temp.next = nextNode;
            copyNode.next = null;

            ans.next = copyNode;
            ans = ans.next;
            temp = nextNode;
        }
        return dummy.next;
    }
}
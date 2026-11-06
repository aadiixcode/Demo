/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);

        ListNode oddNode = dummyOdd;
        ListNode evenNode = dummyEven;
        ListNode temp = head;
        int pos = 1;
        while (temp != null) {
            if (pos % 2 == 1) {
                oddNode.next = temp;
                oddNode = oddNode.next;
            } else {
                evenNode.next = temp;
                evenNode = evenNode.next;
            }
            temp = temp.next;
            pos += 1;
        }
        evenNode.next = null;
        oddNode.next = dummyEven.next;
        return dummyOdd.next;
    }
}
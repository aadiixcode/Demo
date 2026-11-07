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
    ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode merged = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merged.next = l1;
                l1 = l1.next;
            } else {
                merged.next = l2;
                l2 = l2.next;
            }
            merged = merged.next;
        }
        if (l1 == null) {
            merged.next = l2;
        }
        if (l2 == null) {
            merged.next = l1;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head==null || head.next == null) {
            return head;
        }

        ListNode middleNode = findMiddle(head);
        ListNode l2 = middleNode.next;
        middleNode.next = null;

        ListNode leftPart = sortList(head);
        ListNode rightPart = sortList(l2);

        return merge(leftPart, rightPart);
    }
}
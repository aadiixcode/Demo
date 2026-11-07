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
    // ListNode merge(ListNode l1, ListNode l2) {
    //     ListNode ans = new ListNode(-1);
    //     ListNode dummy = ans;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val < l2.val) {
    //             dummy.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             dummy.next = l2;
    //             l2 = l2.next;
    //         }
    //         dummy = dummy.next;
    //     }
    //     if (l1 == null) {
    //         dummy.next = l2;
    //     }
    //     if (l2 == null) {
    //         dummy.next = l1;
    //     }
    //     return ans.next;
    // }

    // ListNode helper(ListNode[] lists, int low, int high) {
    //     if (low == high) {
    //         return lists[low];
    //     }
    //     int mid = low + (high - low) / 2;
    //     ListNode left = helper(lists, low, mid);
    //     ListNode right = helper(lists, mid + 1, high);
    //     return merge(left, right);
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            if (current.next != null) {
                pq.add(current.next);
            }
            dummy.next = current;
            dummy = dummy.next;
        }
        return ans.next;
    }
}
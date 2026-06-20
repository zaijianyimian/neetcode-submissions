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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        while(p != null){
            ListNode nxt = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = nxt;
        }
        return dummy.next;
    }
}

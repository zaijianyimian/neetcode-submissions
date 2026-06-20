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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode p = head,q = dummy;
        Deque<ListNode> deque = new ArrayDeque<>();
        while(p != null){
            deque.addLast(p);
            p = p.next;
            if(deque.size() == k){
                while(deque.size() > 0){
                    ListNode node = deque.pollLast();
                    q.next = node;
                    q = q.next;
                }
            }
        }
        while(deque.size() > 0){
            ListNode node = deque.pollFirst();
            q.next = node;
            q = q.next;
        }
        q.next = null;
        return dummy.next;
    }
}

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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        Deque<ListNode> queue = new ArrayDeque();
        while(p != null){
            queue.addLast(p);
            p = p.next;
        }
        boolean flag = true;
        p = dummy;
        while(queue.size() != 0){
            ListNode node;
            if(flag){
                node = queue.pollFirst();
            }else{
                node = queue.pollLast();
            }
            p.next = node;
            flag = !flag;
            p = p.next;
        }
        p.next = null;
    }
}

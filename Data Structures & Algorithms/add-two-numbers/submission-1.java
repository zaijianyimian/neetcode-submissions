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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        ListNode p = l1,q = l2;
        int carry = 0;
        while(p != null || q != null || carry != 0){
            int sum = 0;
            if(p != null){
                sum += p.val;
                p = p.next;
            }
            if(q != null){
                sum += q.val;
                q = q.next;
            }
            sum += carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            head.next = node;
            head = head.next;
        }
        return dummy.next;
    }
}

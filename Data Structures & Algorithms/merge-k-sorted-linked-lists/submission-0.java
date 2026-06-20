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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> arr = new ArrayList<>();
        for(ListNode list : lists){
            ListNode p = list;
            while(p != null){
                arr.add(p);
                p = p.next;
            }
        }
        arr.sort((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for(ListNode l : arr){
            p.next = l;
            p = p.next;
        }
        p.next = null;
        return dummy.next;
    }
}

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
        Node p = head;
        Map<Node,Node> map = new HashMap<>();
        while(p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        p = head;
        while(p != null){
            Node copy = map.getOrDefault(p, null);
            copy.next = map.getOrDefault(p.next, null);
            copy.random = map.getOrDefault(p.random, null);
            p = p.next ;
        }
        return map.getOrDefault(head, null);
    }
}

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        stack = []
        p = head
        dummy = ListNode()
        q = dummy
        while p:
            stack.append(p)
            nxt = p.next
            if(len(stack) == k):
                while stack:
                    node = stack.pop()
                    q.next = node
                    q = q.next
            p = nxt
        for node in stack:
            q.next = node
            q = q.next
        q.next = None
        return dummy.next
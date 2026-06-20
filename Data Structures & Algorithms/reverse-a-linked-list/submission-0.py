# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0,None)
        p = head
        while p:
            nxt = p.next
            p.next = dummy.next
            dummy.next = p
            p = nxt
        return dummy.next
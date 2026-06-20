# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        queue = deque()
        dummy = ListNode()
        p = head
        while p:
            queue.append(p)
            p = p.next
        flag = True
        p = dummy
        while queue:
            node = None
            if flag:
                node = queue.popleft()
            else:
                node = queue.pop()
            flag = not flag
            p.next = node
            p = p.next
        p.next = None  

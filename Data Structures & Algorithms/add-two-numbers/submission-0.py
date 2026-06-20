# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# 已经倒序存储了
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        head = dummy
        p,q = l1,l2
        carry = 0
        while p or q or carry != 0:
            sum = 0 
            sum += p.val if p != None else 0
            sum += q.val if q != None else 0
            sum += carry
            carry = sum // 10
            sum %= 10
            node = ListNode(sum)
            head.next = node
            head = head.next
            p = p.next if p else None
            q = q.next if q else None   
        return dummy.next
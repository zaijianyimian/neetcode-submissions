# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Codec:

    def serialize(self, root):
        """将二叉树编码为字符串"""
        if root is None:
            return "N"

        res = []
        queue = deque([root])

        while queue:
            node = queue.popleft()

            if node is None:
                res.append("N")
                continue

            res.append(str(node.val))
            queue.append(node.left)
            queue.append(node.right)

        return ",".join(res)

    def deserialize(self, data):
        """将字符串解码为二叉树"""
        if not data or data == "N":
            return None

        values = data.split(",")

        root = TreeNode(int(values[0]))
        queue = deque([root])

        index = 1

        while queue and index < len(values):
            parent = queue.popleft()

            # 左孩子
            if values[index] != "N":
                left = TreeNode(int(values[index]))
                parent.left = left
                queue.append(left)
            index += 1

            # 右孩子
            if index < len(values) and values[index] != "N":
                right = TreeNode(int(values[index]))
                parent.right = right
                queue.append(right)
            index += 1

        return root
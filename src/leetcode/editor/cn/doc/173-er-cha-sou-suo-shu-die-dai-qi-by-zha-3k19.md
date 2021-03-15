### 解题思路1
利用中序遍历来查找下一个最小值，核心是利用中序遍历的迭代操作（左链入表的操作），维护空间复杂度是 O(h)

### 代码

```python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.root = root
        self.stack = []
        
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        cur = self.stack.pop()
        
        root = cur.right
        while root:
            self.stack.append(root)
            root = root.left
        
        return cur.val

    def hasNext(self) -> bool:
        return len(self.stack) != 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
```

### 解题思路
土方法，预先中序遍历，空间复杂度O(n). 会把所有的值存储到一个数组中。

### 代码
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: TreeNode):
        self.root = root
        self.res = []
        
        self.__dfs__(self.res, root)
        self.curIdx = 0
    
    def __dfs__(self, res, root):
        if not root:
            return
        
        self.__dfs__(res, root.left)
        res.append(root.val)
        self.__dfs__(res, root.right)

    def next(self) -> int:
        val = self.res[self.curIdx]
        self.curIdx += 1
        return val

    def hasNext(self) -> bool:
        return self.curIdx < len(self.res)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
```
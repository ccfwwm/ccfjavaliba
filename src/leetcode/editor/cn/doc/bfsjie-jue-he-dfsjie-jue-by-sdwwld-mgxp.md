
### 1，BFS解决


这题上面说了一大堆，其实就是**把二叉树转化为一个字符串，并且还能把这个字符串还原成原来的二叉树**就可以了。

<br>

把二叉树转化为字符串可以有很多种方式，比如前序遍历，中序遍历，后续遍历，BFS，DFS都是可以的，对于树的各种遍历具体可以看下[373，数据结构-6,树](https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247487028&idx=1&sn=e06a0cd5760e62890e60e43a279a472b&chksm=fb419d14cc36140257eb220aaeac182287b10c3cab5c803ebd54013ee3fc120d693067c2e960&scene=21#wechat_redirect)。但这题还要求把字符串再还原成原来的二叉树。最容易想到的就是BFS，就是一层一层从往下遍历
![image.png](https://pic.leetcode-cn.com/1612095292-BWJODI-image.png)


<br>

来看下代码

```java
public class Codec {

    //把树转化为字符串（使用BFS遍历）
    public String serialize(TreeNode root) {
        //边界判断，如果为空就返回一个字符串"#"
        if (root == null)
            return "#";
        //创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        //把根节点加入到队列中
        queue.add(root);
        while (!queue.isEmpty()) {
            //节点出队
            TreeNode node = queue.poll();
            //如果节点为空，添加一个字符"#"作为空的节点
            if (node == null) {
                res.append("#,");
                continue;
            }
            //如果节点不为空，把当前节点的值加入到字符串中，
            //注意节点之间都是以逗号","分隔的，在下面把字符
            //串还原二叉树的时候也是以逗号","把字符串进行拆分
            res.append(node.val + ",");
            //左子节点加入到队列中（左子节点有可能为空）
            queue.add(node.left);
            //右子节点加入到队列中（右子节点有可能为空）
            queue.add(node.right);
        }
        return res.toString();
    }

    //把字符串还原为二叉树
    public TreeNode deserialize(String data) {
        //如果是"#"，就表示一个空的节点
        if (data == "#")
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        //因为上面每个节点之间是以逗号","分隔的，所以这里
        //也要以逗号","来进行拆分
        String[] values = data.split(",");
        //上面使用的是BFS，所以第一个值就是根节点的值，这里创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            //队列中节点出栈
            TreeNode parent = queue.poll();
            //因为在BFS中左右子节点是成对出现的，所以这里挨着的两个值一个是
            //左子节点的值一个是右子节点的值，当前值如果是"#"就表示这个子节点
            //是空的，如果不是"#"就表示不是空的
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            //上面如果不为空就是左子节点的值，这里是右子节点的值，注意这里有个i++，
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
```

<br>

### 2，DFS解决

DFS遍历是从根节点开始，一直往左子节点走，当到达叶子节点的时候会返回到父节点，然后从从父节点的右子节点继续遍历……

![image.png](https://pic.leetcode-cn.com/1612095390-IWqXKd-image.png)

```
class Codec {

    //把树转化为字符串（使用DFS遍历，也是前序遍历，顺序是：根节点→左子树→右子树）
    public String serialize(TreeNode root) {
        //边界判断，如果为空就返回一个字符串"#"
        if (root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    //把字符串还原为二叉树
    public TreeNode deserialize(String data) {
        //把字符串data以逗号","拆分，拆分之后存储到队列中
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        //出队
        String sVal = queue.poll();
        //如果是"#"表示空节点
        if ("#".equals(sVal))
            return null;
        //否则创建当前节点
        TreeNode root = new TreeNode(Integer.valueOf(sVal));
        //分别创建左子树和右子树
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
```



<br>


**公众号**：[数据结构和算法](https://img-blog.csdnimg.cn/20201229141648443.png#pic_center)

#### 如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解

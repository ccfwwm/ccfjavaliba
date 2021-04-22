package com.company;

/**
 * The type Rb tree.
 *
 * @param <T> the type parameter
 */
public class RBTree<T extends Comparable<T>> {
    private RBTNode<T> mRoot;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;  //颜色 T key;
        T key; //关键字（键值）
        RBTNode<T> left; //左孩子
        RBTNode<T> right;//右孩子
        RBTNode<T> parent;//父亲

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return this.key;
        }

        public String toString() {
            return "" + this.key + (this.color == RED ? "R" : "B");
        }
    }

    //初始化红黑树
    public RBTree() {
        this.mRoot = null;
    }

    //一系列简单获取和设置属性的方法
    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node == null ? null : node.parent;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node == null ? BLACK : node.color;
    }

    private boolean isRed(RBTNode<T> node) {
        return ((node != null) && (node.color == RED)) ? true : false;
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void setRed(RBTNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    //前序遍历红黑树
    private void preOrder(RBTNode<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    //中序遍历红黑树
    private void inOrder(RBTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    //后序遍历红黑树
    private void postOrder(RBTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    //递归查找红黑树node中，键值为key的节点
    public RBTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private RBTNode<T> search(RBTNode<T> node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    //迭代查找红黑树node中，键值为key的节点

    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }


    private RBTNode<T> iterativeSearch(RBTNode<T> node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }

    //查找最小节点：返回node为根的红黑树的最小节点的键值
    public T minimum() {
        RBTNode<T> node = minimum(mRoot);
        return node == null ? null : node.key;
    }

    private RBTNode<T> minimum(RBTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //查找最大节点：返回node为根的红黑树的最大节点的键值
    public T maximum() {
        RBTNode<T> node = maximum(mRoot);
        return node == null ? null : node.key;
    }

    private RBTNode<T> maximum(RBTNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    //寻找节点node的后继节点，查找红黑树中数据值大于该节点的最小节点
    public RBTNode<T> successor(RBTNode<T> node) {
        if (node.right != null) {
            return minimum(node.right);
        }
        RBTNode<T> res = node.parent;
        while (res != null && node == res.right) {
            node = res;
            res = res.parent;
        }
        return res;
    }

    //寻找节点node的前驱节点，查找红黑树中数据值小于该节点的最大节点
    public RBTNode<T> predecessor(RBTNode<T> node) {
        if (node.left != null) {
            return maximum(node.left);
        }
        RBTNode<T> res = node.parent;
        while (res != null && node == res.left) {
            node = res;
            res = res.parent;
        }
        return res;
    }

    /***
     * 对红黑树的节点x进行左旋转
     *
     *       px                   px
     *      |                     |
     *     x                     y
     *    /  \       左旋x      /  \
     *  lx    y                x    ry
     *      /  \             /  \
     *     ly  ry         lx   ly
     *
     * 三个关系的处理，x.right 和y.left  x.parent和y.parent, x和y,依次处理
     */
    private void leftRotate(RBTNode<T> x) {

        //设置x的右孩子为y
        RBTNode<T> y = x.right;

        //将 y的左孩子 设为 x的右孩子
        //如果y的左孩子非空，将x 设为 y的左孩子的父亲
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //将 x的父亲，设为y的父亲
        y.parent = x.parent;
        if (x.parent == null) {
            this.mRoot = y;  //如果x.parent为空，则y设为根节点。
        } else {
            if (x.parent.left == x) {
                x.parent.left = y; //如果x为左孩子，则y为parent.left
            } else {
                x.parent.right = y;//否则为右孩子
            }
        }

        y.left = x;  //x设为y的左孩子
        x.parent = y;//x的父亲设为y

    }

    /***
     *          py                        py
     *         /                         /
     *        y                         x
     *       / \         右旋y         /  \
     *      x   ry                   lx   y
     *     / \                           / \
     *    lx  rx                        rx  ry
     *
     *
     */
    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;

        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    /***
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后，失去平衡，再调用该函数
     * 目的是将它重新塑造成一颗红黑树
     * arg node 插入的节点
     *
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        //若父节点存在，并且父节点的颜色是红色
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若父节点是祖父节点的左孩子
            if (parent == gparent.left) {
                RBTNode<T> uncle = gparent.right;

                //case 1条件：叔叔节点是红色
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case 2条件：叔叔是黑色，且当前节点是右孩子（null为黑色),目的还是化为case 3,转换后在一条线上
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case 3条件：叔叔是黑色，且当前节点是右孩子
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);

            } else {//若z的父节点是z的祖父节点的右孩子
                //case 1条件：叔叔节点是红色
                RBTNode<T> uncle = gparent.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case 2:条件：叔叔是黑色，且当前节点是左孩子，旋转后到达case 3
                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                //case 3条件：叔叔是黑色，且当前节点是右孩子
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);

            }
        }
        //将根节点设为黑色，这一步总是正确的
        setBlack(this.mRoot);

    }

    /***
     * 将节点插入到红黑树中,插入的节点一定是不存在树中的
     * arg node 插入的节点
     */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;
        //1.将红黑树当做一颗二叉查找树，将节点添加到二叉查找树中
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            //根节点为空，直接node为根节点，同时返回
            this.mRoot = node;
            return;
        }
        //2 设置节点为红色
        node.color = RED;
        //3 将它修正为一颗红黑树
        insertFixUp(node);
    }

    public void insert(T key) {
        RBTNode<T> node = new RBTNode<>(key, BLACK, null, null, null);
        //如果新建节点失败，则返回
        if (node != null) {
            insert(node);
        }
    }

    /***
     * 红黑树删除修正函数
     * 在从红黑树中删除插入节点之后，红黑树失去平衡，再调用该函数
     * 目的：重新塑造为红黑树
     * arg node 待修正的节点
     */
    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;

        while ((node == null || isBlack(node) && (node != this.mRoot))) {
            if (parent.left == node) {
                //node为左节点
                other = parent.right;
                if (isRed(other)) {
                    //case 1:x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }
                if ((other.left == null || isBlack(other.left)) && (other.right == null || isBlack(other.right))) {
                    //case 2:x的兄弟w是黑色的，且w的两个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.right == null || isBlack(other.right)) {
                        //case 3:x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    //case 4:x的的兄弟w是黑色的，并且w的右孩子是红色的，左孩子任意颜色
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {
                //node为右节点
                other = parent.left;
                if (isRed(other)) {
                    //case 1:x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    //case 2:x的兄弟w是黑色的，且w的两个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);

                } else {
                    if (other.left == null || isBlack(other.left)) {
                        //case 3:x的兄弟w是黑色的，并且w的左孩子是黑色，右孩子为红色
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }
                    //case 4:x的的兄弟w是黑色的，并且w的左孩子是红色的，右孩子任意颜色
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }

            }
        }
        if (node != null) {
            setBlack(node);
        }
    }

    /***
     * 删除节点node
     */
    public void remove(T key) {
        RBTNode<T> node;
        if ((node = search(this.mRoot, key)) != null) {
            remove(node);
        }
    }

    /***
     * 删除节点node
     * arg node 删除的节点
     */
    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;
        //被删除节点的左右孩子都不为空的情况
        if (node.left != null && node.right != null) {
            //被删除的节点的后继节点，为replace
            //用它来取代 被删除节点的位置，然后再将被删除节点去掉
            //获取后继节点
            RBTNode<T> replace = successor(node);
            node.key = replace.key;
            node = replace;
        }
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        parent = node.parent;
        //保存取代节点的颜色
        color = node.color;
        if (child != null) {
            child.parent = parent;
        }
        //node不是根节点
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            this.mRoot = child;
        }
        if (color = BLACK) {
            removeFixUp(child, parent);
        }
        node = null;
    }

    /***
     * 销毁红黑树
     */
    public void clear() {
        destroy(this.mRoot);
        mRoot = null;
    }

    private void destroy(RBTNode<T> tree) {
        if (tree == null) {
            if (tree.left != null) {
                destroy(tree.left);
            }
            if (tree.right != null) {
                destroy(tree.right);
            }
            tree = null;
        }
    }

    /***
     * 打印"红黑树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(RBTNode<T> tree, T key, int direction) {

        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2d(B) is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree) ? "R" : "B", key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
}





















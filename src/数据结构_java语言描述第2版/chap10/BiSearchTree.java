package 数据结构_java语言描述第2版.chap10;

import 数据结构_java语言描述第2版.Visit;

/**
 * 二叉排序树类
 * @author VincentJ
 * @date 2019-06-30
 */
public class BiSearchTree {
    /**根指针*/
    private BiTreeNode root;

    public BiSearchTree() {
        root = null;
    }

    public BiSearchTree(BiTreeNode t) {
        root = t;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void inOrder(Visit vs) {
        inOrder(root, vs);
    }

    public void preOrder(Visit vs) {
        preOrder(root, vs);
    }

    public BiTreeNode getLeft(BiTreeNode current) {
        return current != null ? current.getLeftChild() : null;
    }

    public BiTreeNode getRight(BiTreeNode current) {
        return current != null ? current.getRightChild() : null;
    }

    /**
     * 中序遍历
     */
    private void inOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            inOrder(t.getLeftChild(), vs);
            vs.print(t.getData());
            inOrder(t.getRightChild(), vs);
        }
    }

    /**
     * 前序遍历
     */
    private void preOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            vs.print(t.getData());
            preOrder(t.getLeftChild(), vs);
            preOrder(t.getRightChild(), vs);
        }
    }

    /**
     * 查找
     */
    public BiTreeNode find(int item) {
        if (root != null) {
            BiTreeNode temp = root;
            while (temp != null) {
                if (temp.getData() == item) {
                    return temp;
                }
                if (temp.getData() < item) {
                    // 右子树查找
                    temp = temp.getRightChild();
                } else {
                    // 左子树查找
                    temp = temp.getLeftChild();
                }
            }
        }
        // 查找失败
        return null;
    }

    /**
     * 插入
     * <p>
     *     如果存在则结束；反之，执行插入逻辑
     */
    public void insert(BiTreeNode ptr, int item) {
        if (item < ptr.getData()) {
            if (ptr.getLeftChild() == null) {
                BiTreeNode temp = new BiTreeNode(item);
                temp.setParent(ptr);
                ptr.setLeftChild(temp);
            } else {
                // 在左子树递归
                insert(ptr.getLeftChild(), item);
            }
        } else if (item > ptr.getData()) {
            if (ptr.getRightChild() == null) {
                BiTreeNode temp = new BiTreeNode(item);
                temp.setParent(ptr);
                ptr.setRightChild(temp);
            } else {
                // 在右子树递归
                insert(ptr.getRightChild(), item);
            }
        }
    }

    /**
     * 删除<br>
     *     数据元素不存在则结束；反之，执行删除逻辑
     */
    public void delete(BiTreeNode ptr, int item) {
        if (ptr != null) {
            if (item < ptr.getData()) {
                // 在左子树递归
                delete(ptr.getLeftChild(), item);
            } else if (item > ptr.getData()) {
                // 在右子树递归
                delete(ptr.getRightChild(), item);
            } else if (ptr.getLeftChild() != null && ptr.getRightChild() != null) {
                // 情况1：删除有左右孩子结点的结点
                BiTreeNode min = ptr.getRightChild();
                while (min.getLeftChild() != null) {
                    min = min.getLeftChild();
                }
                // 把右子树的最左结点复制到该位置，然后在右子树中递归删除它
                ptr.setData(min.getData());
                delete(ptr.getRightChild(), min.getData());
            } else {
                if (ptr.getLeftChild() == null && ptr.getRightChild() != null) {
                    // 情况2：删除只有右孩子结点的结点
                    ptr.getParent().setRightChild(ptr.getRightChild());
                    ptr.getRightChild().setParent(ptr.getParent());
                } else if (ptr.getRightChild() == null && ptr.getLeftChild() != null) {
                    // 情况3：删除只有左孩子结点的结点
                    ptr.getParent().setLeftChild(ptr.getLeftChild());
                    ptr.getLeftChild().setParent(ptr.getParent());
                } else {
                    // 情况4：删除结点为叶子结点(即无孩子结点)
                    BiTreeNode p = ptr.getParent();
                    if (p.getLeftChild() == ptr) {
                        // 要删除的结点在左结点上
                        p.setLeftChild(null);
                    } else {
                        // 要删除的结点在右结点上
                        p.setRightChild(null);
                    }
                }
            }
        }
    }
}

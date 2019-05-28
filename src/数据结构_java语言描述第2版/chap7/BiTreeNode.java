package 数据结构_java语言描述第2版.chap7;

/**
 * 二叉树结点类的设计
 * @author VincentJ
 * @date 2019-05-28
 */
public class BiTreeNode {
    /**左孩子结点对象引用*/
    private BiTreeNode leftChild;
    /**右孩子结点对象引用*/
    private BiTreeNode rightChild;
    /**数据元素*/
    private Object data;

    /**
     * 可用于带头结点结构中头对象的创建
     */
    public BiTreeNode() {
        leftChild = null;
        rightChild = null;
    }

    /**
     * 用于常规结点对象的创建
     */
    public BiTreeNode(Object item, BiTreeNode left, BiTreeNode right) {
        leftChild = left;
        rightChild = right;
        data = item;
    }

    public BiTreeNode getLeft() {
        return leftChild;
    }

    public BiTreeNode getRight() {
        return rightChild;
    }

    public Object getData() {
        return data;
    }
}

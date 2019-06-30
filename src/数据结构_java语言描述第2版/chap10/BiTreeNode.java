package 数据结构_java语言描述第2版.chap10;

/**
 * 三叉链结点类的设计
 * @author VincentJ
 * @date 2019-06-30
 */
public class BiTreeNode {
    /**左孩子结点对象引用*/
    private BiTreeNode leftChild;
    /**右孩子结点对象引用*/
    private BiTreeNode rightChild;
    /**双亲结点对象引用*/
    private BiTreeNode parent;
    /**数据元素*/
    private int data;

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
    public BiTreeNode(int item) {
        leftChild = null;
        rightChild = null;
        data = item;
    }

    public BiTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BiTreeNode pLeftChild) {
        leftChild = pLeftChild;
    }

    public BiTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BiTreeNode pRightChild) {
        rightChild = pRightChild;
    }

    public BiTreeNode getParent() {
        return parent;
    }

    public void setParent(BiTreeNode pParent) {
        parent = pParent;
    }

    public int getData() {
        return data;
    }

    public void setData(int pData) {
        data = pData;
    }
}

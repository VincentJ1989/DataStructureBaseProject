package 数据结构_java语言描述第2版;

/**
 * 结点类
 *
 * @author VincentJ
 * @date 2019-05-14
 */
public class Node {
    /**
     * 数据元素
     */
    public Object data;
    /**
     * 下一个结点的对象引用
     */
    public Node next;

    public Node(Object pData) {
        data = pData;
    }

    public Node(Object pData, Node pNext) {
        data = pData;
        next = pNext;
    }

    public Object getElement() {
        return data;
    }

    public void setElement(Object pData) {
        data = pData;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node pNext) {
        next = pNext;
    }
}

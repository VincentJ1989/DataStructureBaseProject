package 数据结构_java语言描述第2版.chap2;

/**
 * 单链表类<p>
 * 这里是带头结点的单链表的实现（所以内部有个-1相关的临界值）。
 *
 * @author VincentJ
 * @date 2019-05-14
 */
public class LinList implements List {
    /**
     * 头指针
     */
    private Node head;
    /**
     * 当前结点元素
     */
    private Node current;
    /**
     * 数据元素的大小
     */
    private int size;

    public LinList() {
        head = new Node(null);
        size = 0;
    }

    /**
     * 定位：让当前结点位置成员变量current表示该节点
     */
    private void index(int i) throws Exception {
        if (i < -1 || i > size - 1) {
            throw new Exception("参数错误!");
        }

        if (i == -1) {
            return;
        }

        current = head.next;
        int j = 0;
        while (current != null && j < i) {
            current = current.next;
            j++;
        }

    }


    @Override
    public void insert(int i, Object obj) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("参数错误!");
        }
        index(i - 1);
        current.setNext(new Node(obj, current.next));
        size++;
    }

    @Override
    public Object delete(int i) throws Exception {
        if (i == 0) {
            throw new Exception("链表已空无元素可删!");
        }
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误!");
        }

        index(i - 1);
        Node obj = current.next;
        current.setNext(current.next.next);
        size--;
        return obj;
    }

    @Override
    public Object getData(int i) throws Exception {
        if (i < -1 || i > size - 1) {
            throw new Exception("参数错误!");
        }
        index(i);

        return current.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

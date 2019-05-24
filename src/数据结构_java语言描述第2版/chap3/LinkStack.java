package 数据结构_java语言描述第2版.chap3;

import 数据结构_java语言描述第2版.Node;

/**
 * 链式堆栈类的设计
 * @author VincentJ
 * @date 2019-05-24
 */
public class LinkStack implements Stack {
    /**堆栈头*/
    Node head;
    /**结点个数*/
    int size;

    public LinkStack() {
        head = null;
        size = 0;
    }

    @Override
    public void push(Object obj) throws Exception {
        head = new Node(obj, head);
        size++;
    }

    @Override
    public Object pop() throws Exception {
        if (size == 0) {
            throw new Exception("堆栈已空！");
        }
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    @Override
    public Object getTop() throws Exception {
        if (size == 0) {
            throw new Exception("堆栈已空!");
        }

        return head.data;
    }

    @Override
    public boolean isEmpty() throws Exception {
        return head != null;
    }
}

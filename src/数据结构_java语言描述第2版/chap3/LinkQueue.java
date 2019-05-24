package 数据结构_java语言描述第2版.chap3;

import 数据结构_java语言描述第2版.Node;

/**
 * 链式队列类的设计<p>
 *     使用计数器处理队空、队满的判断问题
 * @author VincentJ
 * @date 2019-05-24
 */
public class LinkQueue implements Queue {
    /**队头*/
    Node front;
    /**队尾*/
    Node rear;
    /**计数器*/
    int count;

    public LinkQueue() {
        front = null;
        rear = null;
        count = 0;
    }

    @Override
    public void append(Object obj) throws Exception {
        Node newNode = new Node(obj, front);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;

        if (front == null) {
            front = newNode;
        }
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空!");
        }

        Node temp = front;
        front = front.next;
        count--;
        return temp.getElement();
    }

    @Override
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空!");
        }
        return front.getElement();
    }

    @Override
    public boolean notEmpty() {
        return count != 0;
    }
}

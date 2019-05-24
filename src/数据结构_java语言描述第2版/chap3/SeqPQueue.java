package 数据结构_java语言描述第2版.chap3;

/**
 * 顺序优先级队列<p>
 *     出队列：出队列后，后面的元素会前移，不会出现假溢出，所以无需设计成循环队列。
 * @author VincentJ
 * @date 2019-05-24
 */
public class SeqPQueue {
    private static final int DEFAULT_SIZE = 10;
    /**队头*/
    int front;
    /**队尾*/
    int rear;
    /**计数器*/
    int count;
    int maxSize;
    Element[] data;

    public SeqPQueue() {
        initiate(DEFAULT_SIZE);
    }

    public SeqPQueue(int sz) {
        initiate(sz);
    }

    private void initiate(int sz) {
        front = 0;
        rear = 0;
        count = 0;
        maxSize = sz;
        data = new Element[sz];
    }

    public void append(Element elem) throws Exception {
        if (count == maxSize) {
            throw new Exception("队列已满!");
        }
        data[rear] = elem;
        rear++;
        count++;
    }

    public Element delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空!");
        }
        // 寻找优先级最高的数据元素并记录下来
        Element min = data[0];
        int minIndex = 0;
        for (int i = 1; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }
        // 后面数据元素的前移
        for (int i = minIndex + 1; i < count; i++) {
            data[i - 1] = data[i];
        }

        rear--;
        count--;

        return min;
    }

    public Element getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空!");
        }

        // 寻找优先级最高的数据元素并记录下来
        Element min = data[0];
        for (int i = 1; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
            }
        }
        return min;
    }

    public boolean notEmpty() {
        return count != 0;
    }
}

package 数据结构_java语言描述第2版.chap3;

/**
 * 顺序循环队列类的设计<p>
 *     采用计数器的方式来处理队空、队满的判断问题。
 * @author VincentJ
 * @date 2019-05-24
 */
public class SeqQueue implements Queue{
    private static final int DEFAULT_SIZE = 10;
    /**队头*/
    int front;
    /**队尾*/
    int rear;
    /**计数器*/
    int count;
    int maxSize;
    Object[]data;


    public SeqQueue() throws Exception {
        initiate(DEFAULT_SIZE);
    }

    public SeqQueue(int sz) throws Exception {
        initiate(sz);
    }

    private void initiate(int sz) throws Exception {
        if(sz <= 0){
            throw new Exception("队列大小不能小于0!");
        }
        maxSize = sz;
        front = 0;
        rear = 0;
        count = 0;
        data = new Object[sz];
    }
    @Override
    public void append(Object obj) throws Exception {
        if(count==maxSize){
            throw new Exception("队列已满!");
        }
        // 加的是队尾
        data[rear] = obj;
        // 这个其实就是rear = (rear+1)%maxSize
        rear = (rear+1)&(maxSize-1);
        count++;
    }

    @Override
    public Object delete() throws Exception {
        if(count == 0){
            throw new Exception("队列已空!");
        }
        // 删的是队头
        Object temp = data[front];
        front = (front+1)&(maxSize-1);
        count--;
        return temp;
    }

    @Override
    public Object getFront() throws Exception {
        if(count == 0){
            throw new Exception("队列已空!");
        }
        return data[front];
    }

    @Override
    public boolean notEmpty() {
        return count != 0;
    }
}

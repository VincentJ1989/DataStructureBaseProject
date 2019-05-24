package 数据结构_java语言描述第2版.chap3;

/**
 * 队列抽象数据类型
 * @author VincentJ
 * @date 2019-05-24
 */
public interface Queue {
    /**
     * 在队尾插入元素
     */
    void append(Object obj) throws Exception;

    /**
     * 删除队头元素并返回
     */
    Object delete() throws Exception;

    /**
     * 取出队头的元素
     */
    Object getFront() throws Exception;

    /**
     * 非空否
     */
    boolean notEmpty();
}

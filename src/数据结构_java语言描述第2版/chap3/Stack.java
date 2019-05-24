package 数据结构_java语言描述第2版.chap3;

/**
 * 堆栈抽象数据类型
 * @author VincentJ
 * @date 2019-05-24
 */
public interface Stack {
    void push(Object obj) throws Exception;

    Object pop() throws Exception;

    Object getTop() throws Exception;

    boolean isEmpty() throws Exception;
}

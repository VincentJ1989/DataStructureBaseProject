package 数据结构_java语言描述第2版.chap2;

/**
 * 线性表抽象数据结构的接口
 *
 * @author VincentJ
 * @date 2019-05-14
 */
public interface List {
    /**
     * 插入
     */
    public void insert(int i, Object obj) throws Exception;

    /**
     * 删除
     */
    public Object delete(int i) throws Exception;

    /**
     * 取数据元素
     */
    public Object getData(int i) throws Exception;

    /**
     * 求元素个数
     */
    public int size();

    /**
     * 是否空
     */
    public boolean isEmpty();
}

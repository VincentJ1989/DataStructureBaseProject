package 数据结构_java语言描述第2版.chap7;

/**
 * 二叉树游标类的设计
 * @author VincentJ
 * @date 2019-05-29
 */
public class BiTreeInterator {
    /**根指针*/
    BiTreeNode root;
    /**当前结点*/
    BiTreeNode current;
    /**到达尾部标记*/
    int iteComplete;

    public BiTreeInterator() {
    }

    public BiTreeInterator(BiTreeNode tree) {
        root = tree;
        current = tree;
        iteComplete = 1;
    }

    /**
     * 重置
     */
    public void reset() {

    }

    /**
     * 下一个结点
     */
    public void next()
        throws Exception {

    }

    /**
     * 结束否
     */
    public boolean endOfBiTree() {
        return iteComplete == 1;
    }

    /**
     * 取数据元素
     */
    public Object getData() {
        if (current == null) {
            return null;
        } else {
            return current.getData();
        }
    }
}

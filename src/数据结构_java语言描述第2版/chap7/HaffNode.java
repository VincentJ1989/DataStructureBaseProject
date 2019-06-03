package 数据结构_java语言描述第2版.chap7;

/**
 * 基于双亲孩子仿真指针存储结构的哈夫曼树结点
 * @author VincentJ
 * @date 2019-06-03
 */
public class HaffNode {
    /**权值*/
    int weight;
    /**标记，代表是否加入哈夫曼树*/
    int flag;
    /**双亲结点下标*/
    int parent;
    /**左孩子下标*/
    int leftChild;
    /**右孩子下标*/
    int rightChild;

    public HaffNode() {
    }
}

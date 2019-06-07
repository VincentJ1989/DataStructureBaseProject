package 数据结构_java语言描述第2版.chap8;

/**
 * @author VincentJ
 * @date 2019-06-07
 */
public class MinSpanTree {
    /**边的弧头结点数据*/
    Object vertex;
    /**权值*/
    int weight;

    public MinSpanTree() {
    }

    public MinSpanTree(Object pVertex, int pWeight) {
        vertex = pVertex;
        weight = pWeight;
    }
}

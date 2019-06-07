package 数据结构_java语言描述第2版.chap8;

/**
 * Prim算法
 * @author VincentJ
 * @date 2019-06-07
 */
public class Prim {
    /**最大权值*/
    static final int maxWeight = 9999;

    public static void prim(AdjMWGraph g, MinSpanTree[] closeVertex)
        throws Exception {

        int n = g.getNumOfVertices();
        int[] lowCost = new int[n];

        // 初始化lowCost的值
        for (int i = 0; i < n; i++) {
            lowCost[i] = g.getWeight(0, i);
        }

        MinSpanTree temp = new MinSpanTree();

        // 从结点0出发构造最小生成树
        temp.vertex = g.getValue(0);
        closeVertex[0] = temp;// 保存结点0
        lowCost[0] = -1;// 标记结点0

        // 寻找当前最小权值的边所对应的弧头结点k的权值minCost和结点索引k
        int minCost;
        int k = 0;
        for (int i = 0; i < n; i++) {

            // 寻找当前最小权值的边所对应的弧头结点k的权值minCost和结点索引k
            // 不需要从0开始，因为一开始初始化就是用结点0和其他结点的权值初始化的，比较没意义
            minCost = maxWeight;
            for (int j = 1; j < n; j++) {
                if (lowCost[j] > 0 && lowCost[j] < minCost) {
                    minCost = lowCost[j];
                    k = j;
                }
            }

            // 保存找到的最小权值的点
            MinSpanTree curr = new MinSpanTree();
            curr.vertex = g.getValue(k);
            curr.weight = minCost;
            closeVertex[i] = curr;
            lowCost[k] = -1;

            // 根据加入集合U的结点k修改lowCost中的数值--就是要重新刷新最小权值，因为现在有新的结点
            // 不需要从0开始，因为一开始初始化就是用结点0和其他结点的权值初始化的
            for (int j = 1; j < n; j++) {
                if (g.getWeight(k, j) < lowCost[j]) {
                    lowCost[j] = g.getWeight(k, j);
                }
            }
        }

    }
}

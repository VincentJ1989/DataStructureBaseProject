package 数据结构_java语言描述第2版.chap8;

/**
 * 最短路径之Dijkstra算法
 * @author VincentJ
 * @date 2019-06-07
 */
public class Dijkstra {
    /**最大权值*/
    static final int maxWeight = 9999;

    public static void dijkstra(AdjMWGraph g, int v0, int[] distance, int[] path)
        throws Exception {
        // 带权图g从下表v0结点到其他结点的最短距离distance和相应的目标结点的前一结点下标结点path

        int n = g.getNumOfVertices();
        int[] s = new int[n];// 用来存放n个结点的标记--是否从T加入到S

        // 初始化
        for (int i = 0; i < n; i++) {
            distance[i] = g.getWeight(0, i);
            s[i] = 0;// 初始都标记为0
            if (i != v0 && distance[i] < maxWeight) {
                path[i] = v0;// 初始的目标结点的前一结点均为v0
            } else {
                path[i] = -1;
            }
        }

        s[v0] = 1;// 标记结点v0已从集合T加入到结合S中

        // 当前还未找到最短路径的结点集中选取具有最短距离的结点u
        int minDis, u = 0;
        for (int i = 1; i < n; i++) {
            minDis = maxWeight;

            for (int j = i; j < n; j++) {
                if (s[j] == 0 && distance[j] < minDis) {
                    minDis = distance[j];
                    u = j;
                }
            }

            // 当已不存在路径时算法结束；此语句对非连通图是必需的
            if (minDis == maxWeight) {
                return;
            }

            s[u] = 1;// 标记结点u已从集合T加入到集合S中

            // 修改从v0到其他的最短距离和最短路径
            for (int j = 1; j < n; j++) {
                // s[j]还在集合T中+uj是可连通的+经过u到j的距离比从v0到j的距离更短--->更新距离+记录下标
                if (s[j] == 0 && g.getWeight(u, j) < maxWeight && distance[u] + g.getWeight(u, j) < distance[j]) {
                    // 结点v0经结点u到其他结点的最短距离和最短路径
                    distance[j] = distance[u] + g.getWeight(u, j);
                    path[j] = u;

                }
            }
        }
    }
}

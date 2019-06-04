package 数据结构_java语言描述第2版.chap8;

import 数据结构_java语言描述第2版.chap2.SeqList;

/**
 * 邻接矩阵图类的设计<p>
 *     结点信息采用顺序表存储；边信息使用二维数组存储。
 * @author VincentJ
 * @date 2019-06-04
 */
public class AdjMWGraph {
    static final int maxWeight = 10000;

    /**存储结点的顺序表*/
    private SeqList vertices;
    /**存储边的二维数组*/
    private int[][] edge;
    /**边的个数*/
    private int numOfEdges;

    /**
     * 构造函数<p>
     *     主要是初始化一折变量。
     * @param maxV 最大结点个数
     */
    public AdjMWGraph(int maxV) {
        vertices = new SeqList(maxV);
        edge = new int[maxV][maxV];
        for (int i = 0; i < maxV; i++) {
            for (int j = 0; j < maxV; j++) {
                if (i == j) {
                    edge[i][j] = 0;
                } else {
                    edge[i][j] = maxWeight;
                }
            }
        }
        numOfEdges = 0;
    }

    /**
     * 返回结点个数
     */
    public int getNumOfVertices() {
        return vertices.size();
    }

    /**
     * 返回边的个数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回结点v的数据元素
     */
    public Object getValue(int v)
        throws Exception {
        return vertices.getData(v);
    }

    /**
     * 返回边<v1,v2>的权值
     */
    public int getWeight(int v1, int v2)
        throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new ArrayIndexOutOfBoundsException("参数v1或者v2越界");
        }
        return edge[v1][v2];
    }

    /**
     * 插入结点
     */
    public void insertVertex(Object vertex)
        throws Exception {
        vertices.insert(vertices.size(), vertex);
    }

    /**
     * 插入边
     */
    public void insertEdge(int v1, int v2, int weight)
        throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new ArrayIndexOutOfBoundsException("参数v1或者v2越界");
        }
        edge[v1][v2] = weight;
        // 记得维护边数
        numOfEdges++;
    }

    /**
     * 删除某一条边
     */
    public void deleteEdge(int v1, int v2)
        throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new ArrayIndexOutOfBoundsException("参数v1或者v2越界");
        }
        if (edge[v1][v2] == maxWeight || v1 == v2) {
            throw new Exception("该边不存在!");
        }
        edge[v1][v2] = maxWeight;
        numOfEdges--;
    }

    /**
     * 取结点v的第一个邻接点。<p>
     *     存在则返回该结点的下标序号；反之，返回-1。
     */
    public int getFirstNeighbor(int v)
        throws Exception {
        if (v < 0 || v >= vertices.size()) {
            throw new ArrayIndexOutOfBoundsException("参数v越界出错!");
        }
        for (int col = 0; col < vertices.size(); col++) {
            if (edge[v][col] > 0 && edge[v][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }

    /**
     * 取结点v1的邻接点v2后的邻接点<p>
     *     存在则返回该结点的下标序号；反之，返回-1。
     */
    public int getNextNeighbor(int v1, int v2)
        throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new ArrayIndexOutOfBoundsException("参数v1或者v2越界");
        }

        for (int col = v2 + 1; col < vertices.size(); col++) {
            if (edge[v1][col] > 0 && edge[v1][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }
}

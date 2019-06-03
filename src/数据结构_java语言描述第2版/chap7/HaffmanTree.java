package 数据结构_java语言描述第2版.chap7;

/**
 * 哈夫曼树的设计
 * @author VincentJ
 * @date 2019-06-03
 */
public class HaffmanTree {
    /**最大权值*/
    private static final int MAX_VALUE = 10000;
    /**叶节点个数*/
    private int nodeNum;

    public HaffmanTree(int n) {
        nodeNum = n;
    }

    public void haffman(int[] weight, HaffNode[] node) {
        // 构造权值为weight的哈夫曼树
        int m1, m2, x1, x2;
        int n = nodeNum;

        // 哈夫曼树初始化。n个结点的哈夫曼树共有2n-1个结点
        for (int i = 0; i < 2 * n - 1; i++) {
            HaffNode temp = new HaffNode();
            if (i < n) {
                temp.weight = weight[i];
            } else {
                temp.weight = 0;
            }

            temp.parent = 0;
            temp.flag = 0;
            temp.leftChild = -1;
            temp.rightChild = -1;
            node[i] = temp;
        }

        // 构造哈夫曼树的n-1个非叶节点
        for (int i = 0; i < n - 1; i++) {
            m1 = m2 = MAX_VALUE;
            x1 = x2 = 0;
            for (int j = 0; j < n + 1; j++) {
                if (node[j].weight < m1 && node[j].flag == 0) {
                    m2 = m1;
                    x2 = x1;
                    m1 = node[j].weight;
                    x1 = j;
                } else if (node[j].weight < m2 && node[j].flag == 0) {
                    m2 = node[j].weight;
                    x2 = j;
                }
            }

            // 将找出的两棵权值最小的子树合并为一棵子树
            node[x1].parent = n + i;
            node[x2].parent = n + i;
            node[x1].flag = 1;
            node[x2].flag = 1;

            node[n + i].weight = node[x1].weight + node[x2].weight;
            node[n + i].leftChild = x1;
            node[n + 1].rightChild = x2;
        }
    }

    public void halfmanCode(HaffNode[] node, Code[] haffCode) {
        // 由哈夫曼树构造哈夫曼编码
        int n = nodeNum;
        Code cd = new Code(n);
        int child, parent;

        // 求n个叶结点的哈夫曼编码
        for (int i = 0; i < n; i++) {
            // 不等长编码的最后一位为n-1
            cd.start = n - 1;
            // 取得编码对应的权值
            cd.weight = node[i].weight;
            child = i;
            parent = node[i].parent;

            while (parent != 0) {
                // 由叶节点向上知道跟结点循环
                if (node[parent].leftChild == child) {
                    // 左孩子结点编码0
                    cd.bit[cd.start] = 0;
                } else {
                    // 右孩子结点编码1
                    cd.bit[cd.start] = 1;
                }
                cd.start--;
                child = parent;
                parent = node[child].parent;
            }

            Code temp = new Code(n);

            // 保存叶节点的编码和不等长编码的起始位
            for (int j = cd.start + 1; j < n; j++) {
                temp.bit[j] = cd.bit[j];
                temp.start = cd.start;
                temp.weight = cd.weight;
                haffCode[i] = temp;
            }

        }
    }
}

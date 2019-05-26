package 数据结构_java语言描述第2版.chap5;

/**
 * n阶对称矩阵类的设计
 * @author VincentJ
 * @date 2019-05-26
 */
public class SynmeMatrix {
    /**矩阵元素*/
    double[] a;
    /**阶数*/
    int n;
    /**一维数组个数*/
    int m;

    public SynmeMatrix(int n) {
        // 计算一维数组个数
        m = n * (n + 1) / 2;
        this.n = n;
        a = new double[m];
    }

    /**
     * 矩阵赋值
     * @param b
     */
    public void evaluateMatrix(double[][] b) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 只保留下三角元素
                if (i >= j) {
                    a[k++] = b[i][j];
                }
            }
        }
    }

    /**
     * 矩阵赋值
     * @param b
     */
    public void evaluteMatrix(double[] b) {
        for (int i = 0; i < m; i++) {
            a[i] = b[i];
        }
    }

    /**
     * 矩阵加
     * @param myB
     * @return
     */
    public SynmeMatrix add(SynmeMatrix myB) {
        SynmeMatrix t = new SynmeMatrix(n);
        int k = 0;
        // 注意这里从1开始
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i >= j) {
                    k = i * (i - 1) / 2 + j - 1;
                } else {
                    k = j * (j - 1) / 2 + i - 1;
                }
                t.a[k] = a[k] + myB.a[k];
            }
        }
        return t;
    }
}

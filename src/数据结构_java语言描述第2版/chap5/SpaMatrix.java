package 数据结构_java语言描述第2版.chap5;

/**
 * 数组结构的稀疏矩阵类的设计
 * @author VincentJ
 * @date 2019-05-26
 */
public class SpaMatrix {
    /**行数*/
    int rows;
    /**列数*/
    int cols;
    /**非零元素个数*/
    int dNum;
    /**数组*/
    MyVector v;

    /**
     * 构造函数
     * @param max
     */
    SpaMatrix(int max) {
        rows = 0;
        cols = 0;
        dNum = 0;
        v = new MyVector(max);
    }

    /**
     * 给矩阵赋值
     * @param r
     * @param c
     * @param d
     * @param item
     * @throws Exception
     */
    public void evaluate(int r, int c, int d, Three[] item)
        throws Exception {
        rows = r;
        cols = c;
        dNum = d;
        for (int i = 0; i < d; i++) {
            v.add(i, item[i]);
        }
    }

    /**
     * 矩阵的转置
     * @return
     */
    public SpaMatrix transpose() {
        SpaMatrix a = new SpaMatrix(v.size());
        a.cols = rows;
        a.rows = cols;
        a.dNum = dNum;

        for (int i = 0; i < dNum; i++) {
            Three t = (Three) v.get(i);
            a.v.set(i, new Three(t.col, t.row, t.value));

        }
        return a;
    }
}

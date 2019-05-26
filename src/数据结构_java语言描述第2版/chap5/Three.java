package 数据结构_java语言描述第2版.chap5;

/**
 * 数组结构的稀疏矩阵三元组类的设计
 * @author VincentJ
 * @date 2019-05-26
 */
public class Three {
    public int row;
    public int col;
    public double value;

    public Three(int r, int c, double v) {
        row = r;
        col = c;
        value = v;
    }

    public Three() {
        this(0, 0, 0.0);
    }
}

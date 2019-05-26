package 数据结构_java语言描述第2版.chap5;

/**
 * 矩阵类的设计<p>
 *     操作值设计了矩阵加，其余的未处理。
 * @author VincentJ
 * @date 2019-05-26
 */
public class Matrix {
    private MyVector values;
    private int h;
    private int w;

    public Matrix(int h, int w) {
        if (!(h > 0 && w > 0)) {
            throw new ArrayIndexOutOfBoundsException("h or w <" + 1);
        }
        // 创建h行的对象
        values = new MyVector(h);
        // 初始化内部每一行
        for (int i = 0; i < h; i++) {
            MyVector row = new MyVector(w);
            values.add(row);
            for (int j = 0; i < w; j++) {
                row.add(null);
            }
        }

        this.h = h;
        this.w = w;
    }

    /**
     * 设置元素
     * @param row 行
     * @param col 列
     * @param obj 元素
     */
    public void set(int row, int col, Object obj) {
        if (!(row >= 0 && col >= 0 && row < h && col < w)) {
            throw new ArrayIndexOutOfBoundsException("输入的row、col有误:" + row + "," + col);
        }
        MyVector selRow = (MyVector) values.get(row);
        selRow.set(col, obj);
    }

    /**
     * 获取元素
     * @param row
     * @param col
     * @return
     */
    public Object get(int row, int col) {
        if (!(row >= 0 && col >= 0 && row < h && col < w)) {
            throw new ArrayIndexOutOfBoundsException("输入的row、col有误:" + row + "," + col);
        }
        MyVector selRow = (MyVector) values.get(row);
        return selRow.get(col);
    }

    /**
     * 矩阵加
     * @param b
     * @return
     */
    public Matrix add(Matrix b) {
        if (b != null && (height() != b.height() || width() != b.width())) {
            throw new ArrayIndexOutOfBoundsException("Matrix error");
        }

        Matrix result = new Matrix(height(), width());

        // 其实底下的操作也不是很完美，一个是空指针，另一个是i1+i2可能溢出。
        for (int i = 0; i < height(); i++) {
            for (int j = 0; i < width(); j++) {
                Integer i1 = (Integer) get(i, j);
                Integer i2 = (Integer) b.get(i, j);
                result.set(i, j, i1 + i2);
            }
        }

        return result;
    }

    public int width() {
        return w;
    }

    public int height() {
        return h;
    }

}

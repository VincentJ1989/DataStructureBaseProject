package 数据结构_java语言描述第2版.chap6;

/**
 * 一些递归的case
 * @author VincentJ
 * @date 2019-05-27
 */
public class RecursiveMain {
    public static void main(String[] args) {
        // 演示阶乘
        System.out.println("--------演示阶乘--------");
        int n = 5;
        try {
            System.out.println(factorialFunc(n));
        } catch (Exception pE) {
            pE.printStackTrace();
        }

        // 演示二分查找
        System.out.println("--------演示二分查找--------");
        int[] a = {1, 3, 4, 5, 17, 19, 31, 33};

        System.out.println(bSearch(a, 17, 0, 7));
        System.out.println(bSearch(a, 18, 0, 7));

        // 演示打印
        System.out.println("--------演示打印--------");
        printCase(5);
    }

    /**
     * 阶乘case
     * @param n
     * @return
     * @throws Exception
     */
    private static long factorialFunc(int n)
        throws Exception {
        if (n < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        // 第一步先写结束的情况
        if (n == 0) {
            return 1;
        }
        // 第二步，正常情况下，简化计算

        return n * factorialFunc(n - 1);
    }

    /**
     * 模拟二分查找
     * @param a 数组
     * @param x 等待被查找的数字
     * @param start 起始位置
     * @param end 终止的位置
     * @return 如果存在怎返回下标；反之，返回-1
     */
    private static long bSearch(int[] a, int x, int start, int end) {
        // 先处理最后的不存在
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        // 最后存在
        if (x == a[mid]) {
            return mid;
        }

        // 正常情况下中间的迭代过程
        if (x < a[mid]) {
            // 搜左边
            return bSearch(a, x, start, mid - 1);
        } else {
            return bSearch(a, x, mid + 1, end);
        }

    }

    private static void printCase(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("参数错误");
        }

        if (n == 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(" " + n);
        }
        System.out.println();

        // 先打印在迭代，如果反了，效果也就反过来了。这个和红黑树中的3种顺序打印类似。
        printCase(n - 1);
    }

}

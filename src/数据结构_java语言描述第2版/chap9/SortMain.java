package 数据结构_java语言描述第2版.chap9;

/**
 * 排序
 * @author VincentJ
 * @date 2019-06-07
 */
public class SortMain {
    public static void main(String[] args) {
        int[] test = {5, 1, 3, 6, 2, 4};

        insertSort(test);
        shellSort(test, new int[] {3, 2, 1});
        selectSort(test);
        selectSort2(test);
        heapSort(test);
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] a) {
        int n = a.length;

        // 初始化创建最大堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            createHeap(a, n, i);
        }

        // 当前最大堆个数依次递减1
        int temp;
        for (int i = n - 1; i > 0; i--) {
            // 把堆顶a[0]元素和最大堆的最后一个元素交换
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // 调整根结点满足最大堆定义
            // 传i是因为后面的肯定比前面的大
            createHeap(a, i, 0);
        }

        System.out.println("堆排序");
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    /**
     * 创建堆<p>
     *     从下而上循环调用该函数调整完全二叉树满足堆定义
     *
     */
    private static void createHeap(int[] a, int n, int h) {
        int i, j, flag;
        int temp;

        i = h;// i为要创建堆的二叉树根结点下标
        j = 2 * i + 1;// j为结点的左孩子结点的下标
        temp = a[i];
        flag = 0;

        // 沿左右孩子中值最大值者重复向下筛选
        while (j < n && flag != 1) {
            // 寻找左右孩子节点中的较大者，j为其下标
            if (j < n - 1 && a[j] < a[j + 1]) {
                j++;
            }

            if (temp > a[j]) {// a[i]>a[j]
                flag = 1;// 标记结束筛选条件
            } else {// 否则把a[j]上移
                a[i] = a[j];
                i = j;
                j = i * 2 + 1;
            }
        }

        a[i] = temp;// 把最初的a[i]赋值给最后的a[j]
    }

    /**
     * 直接选择排序(稳定版)
     */
    public static void selectSort2(int[] a) {
        int i, j, small;
        int temp;
        int n = a.length;

        for (i = 0; i < n - 1; i++) {
            small = i;// 一开始设当前的为最小值的索引
            // 寻找更小的(从后面的数据元素)
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[small]) {
                    small = j;
                }
            }

            // 进行交换
            if (small != i) {
                temp = a[small];
                // 把该区段尚未排序元素一次后移
                for (j = small; j > i; j--) {
                    a[j] = a[j - 1];
                }
                a[i] = temp;
            }
        }

        System.out.println("直接选择排序(稳定版)");
        for (int b : a) {
            System.out.println(b);
        }
    }

    /**
     * 直接选择排序(不稳定版)
     */
    public static void selectSort(int[] a) {
        int i, j, small;
        int temp;
        int n = a.length;

        for (i = 0; i < n - 1; i++) {
            small = i;// 一开始设当前的为最小值的索引
            // 寻找更小的(从后面的数据元素)
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[small]) {
                    small = j;
                }
            }

            // 进行交换
            if (small != i) {
                temp = a[i];
                a[i] = a[small];
                a[small] = temp;
            }
        }

        System.out.println("直接选择排序(不稳定版)");
        for (int b : a) {
            System.out.println(b);
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] a, int[] d) {
        int i, j, k, m, span;
        int temp;
        int n = a.length;

        for (m = 0; m < d.length; m++) {// 共numOfD次循环
            span = d[m];// 去本次的增量值
            for (k = 0; k < span; k++) {// 共span个小组
                // 直接插入排序
                for (i = k; i < n - span; i = i + span) {
                    temp = a[i + span];
                    j = i;
                    while (j > -1 && temp <= a[j]) {
                        a[j + span] = a[j];
                        j = j - span;
                    }
                    a[j + span] = temp;
                }
            }
        }

        System.out.println("希尔排序");
        for (int b : a) {
            System.out.println(b);
        }
    }

    /**
     * 直接插入排序
     */
    private static void insertSort(int[] a) {
        int i, j, temp;
        int n = a.length;

        for (i = 0; i < n - 1; i++) {
            temp = a[i + 1];
            j = i;
            while (j > -1 && temp <= a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }

        System.out.println("直接插入排序");
        for (int b : a) {
            System.out.println(b);
        }
    }

}

package 数据结构_java语言描述第2版.chap9;

import 数据结构_java语言描述第2版.chap3.LinkQueue;

/**
 * 排序
 * @author VincentJ
 * @date 2019-06-07
 */
public class SortMain {
    public static void main(String[] args)
        throws Exception {
        int[] test = {5, 1, 3, 6, 2, 4};

        insertSort(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        shellSort(test, new int[] {3, 2, 1});
        test = new int[] {5, 1, 3, 6, 2, 4};
        selectSort(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        selectSort2(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        heapSort(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        dubbleSort(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        quickSort(test, 0, test.length - 1);
        System.out.println();
        System.out.print("快速排序:");
        for (int b : test) {
            System.out.print(b + " ");
        }
        test = new int[] {5, 1, 3, 6, 2, 4};
        mergeSort(test);
        test = new int[] {5, 1, 3, 6, 2, 4};
        radixSort(test, 1, 10);

    }

    /**
     * 基数排序(桶排序)
     * @param d 进制的基数
     * @param m 数据元素的最大位数
     */
    public static void radixSort(int[] a, int m, int d)
        throws Exception {
        int n = a.length;
        int i, j, k;
        int power = 1;
        LinkQueue[] myQueue = new LinkQueue[d];

        // 创建链式队列数组对象
        for (i = 0; i < d; i++) {
            LinkQueue temp = new LinkQueue();
            myQueue[i] = temp;
        }
        // 进行m次基数排序
        for (i = 0; i < m; i++) {
            if (i == 0) {
                power = 1;
            } else {
                power = power * d;
            }

            // 依次将n个数据元素按第k位的大小放到相应的队列中
            for (j = 0; j < n; j++) {
                k = a[j] / power - (a[j] / (power * d)) * d;// 计算k值
                myQueue[k].append(a[j]);
            }
            // 顺序回收各队列中的数据元素到数组a中
            int p = 0;
            for (j = 0; j < d; j++) {
                while (myQueue[j].notEmpty()) {
                    a[p] = (int) myQueue[j].delete();
                    p++;
                }
            }
        }

        System.out.println();
        System.out.print("基数排序:");
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] a) {
        int n = a.length;
        int k = 1;// 归并长度从1开始
        int[] swap = new int[n];

        while (k < n) {
            merge(a, swap, k);
            // 从swap中放回a中
            for (int i = 0; i < n; i++) {
                a[i] = swap[i];
            }
            // 归并长度扩大
            k = 2 * k;
        }

        System.out.println();
        System.out.print("归并排序:");
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    /**
     * 一次归并
     */
    public static void merge(int[] a, int[] swap, int k) {
        int n = a.length;
        int m = 0;
        int i, j, u1, u2, l2;

        int l1 = 0;// 第一个有序子数组下界为0
        while (l1 + k <= n - 1) {
            l2 = l1 + k;// 第二个有序数组下界
            u2 = (l2 + k - 1 <= n - 1) ? l2 + k - 1 : n - 1;// 第二个有序数组上界
            u1 = l2 - 1;// 第一个有序数组上界

            for (i = l1, j = l2; i <= u1 && j <= u2; m++) {
                if (a[i] <= a[j]) {
                    swap[m] = a[i];
                    i++;
                } else {
                    swap[m] = a[j];
                    j++;
                }
            }

            // 子数组2已归并完，将子数组1中的剩余元素放到数组swap中
            while (i <= u1) {
                swap[m] = a[i];
                m++;
                i++;
            }

            // 子数组1已归并完，将子数组2中的剩余元素放到数组swap中
            while (j <= u2) {
                swap[m] = a[j];
                m++;
                j++;
            }
            l1 = u2 + 1;
        }

        // 将原始数组中只够一组的数据元素顺序存放到数组swap中
        for (i = l1; i < n; i++, m++) {
            swap[m] = a[i];
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int temp = a[low];// 以第一个元素作为标准数据

        while (i < j) {
            // 扫描右端
            while (i < j && temp <= a[j]) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            // 扫描左端
            while (i < j && a[i] < temp) {
                i++;
            }

            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }

        a[i] = temp;
        if (low < i) {
            // 左端递归
            quickSort(a, low, i - 1);
        }
        if (i < high) {
            // 右端递归
            quickSort(a, j + 1, high);
        }
    }

    /**
     * 冒泡排序
     */
    public static void dubbleSort(int[] a) {
        int flag = 1;// 标记本次排序是否有交换(1有，0没有),可以提前结束，减少不必要的循环
        int n = a.length;
        int temp;

        for (int i = 1; i < n && flag == 1; i++) {
            flag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    flag = 1;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.print("冒泡排序:");
        for (int b : a) {
            System.out.print(b + " ");
        }
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
        System.out.println();
        System.out.print("堆排序:");
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
        System.out.println();
        System.out.print("直接选择排序(稳定版):");
        for (int b : a) {
            System.out.print(b + " ");
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
        System.out.println();
        System.out.print("直接选择排序(不稳定版):");
        for (int b : a) {
            System.out.print(b + " ");
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
        System.out.println();
        System.out.print("希尔排序:");
        for (int b : a) {
            System.out.print(b + " ");
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
        System.out.print("直接插入排序:");
        for (int b : a) {
            System.out.print(b + " ");
        }
    }

}

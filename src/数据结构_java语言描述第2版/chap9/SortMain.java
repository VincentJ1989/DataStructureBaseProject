package 数据结构_java语言描述第2版.chap9;

/**
 * 排序
 * @author VincentJ
 * @date 2019-06-07
 */
public class SortMain {
    public static void main(String[] args) {
        int[] test = {64, 5, 7, 89, 6, 24};
        insertSort(test);
        shellSort(test, new int[] {3, 2, 1});

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

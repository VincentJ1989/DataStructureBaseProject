package 数据结构_java语言描述第2版.chap10;

/**
 * 查找
 * @author VincentJ
 * @date 2019-06-30
 */
public class SearchMain {
    public static void main(String[] args) {
    }

    /**
     * 无序序列的查找<br>
     * 在数组a中查找elem元素。有则返回对应元素的下标；反之返回-1
     */
    public int seqSearch(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] != elem) {
            i++;
        }
        return a[i] == elem ? i : -1;
    }

    /**
     * 有序序列之顺序查找
     */
    public int orderSepSearch(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] < elem) {
            i++;
        }
        return a[i] == elem ? i : -1;
    }

    /**
     * 有序序列之二分查找(循环结构)
     */
    public int biSearch(int[] a, int elem) {
        int n = a.length;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == elem) {
                return mid;
            } else if (a[mid] < elem) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

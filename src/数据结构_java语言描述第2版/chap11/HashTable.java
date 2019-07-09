package 数据结构_java语言描述第2版.chap11;

/**
 * 哈希表类
 * @author VincentJ
 * @date 2019-07-09
 */
public class HashTable {
    private HashItem[] ht;
    private int tableSize;
    private int currentSize;

    HashTable(int m) {
        tableSize = m;
        ht = new HashItem[tableSize];
        currentSize = 0;
    }

    /**
     * x是否存在
     */
    public boolean isIn(int x) {
        int i = find(x);
        return i >= 0;
    }

    /**
     * 取数据元素值
     */
    public int getValue(int i) {
        return ht[i].data;
    }

    /**
     * 查找
     */
    private int find(int x) {
        int i = x % tableSize;
        int j = i;

        if (ht[j] == null) {
            ht[j] = new HashItem(0);
        }

        // 线性探查法
        while (ht[j].info == 1 && ht[j].data != x) {// 发生了哈希冲突
            j = (j + 1) % tableSize;// 得到下一个哈希地址
            if (j == i) {
                return -tableSize;// 表示已查完了整个哈希表的数组
            }
        }

        if (ht[j].info == 1) {// 表示查到了，返回下标
            return j;
        } else {// 没有查到，返回哈希地址的负值
            return -j;
        }

    }
}

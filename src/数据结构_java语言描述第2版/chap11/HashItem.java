package 数据结构_java语言描述第2版.chap11;

/**
 * 哈希表项类
 * @author VincentJ
 * @date 2019-07-09
 */
public class HashItem {
    int data;
    /**
     * 标识，0标识空闲，1标识占用
     */
    int info;

    public HashItem(int i) {
        info = i;
    }

    public HashItem(int d, int i) {
        data = d;
        info = i;
    }
}

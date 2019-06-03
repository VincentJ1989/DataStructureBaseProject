package 数据结构_java语言描述第2版.chap7;

/**
 * 保存哈夫曼编码的哈夫曼编码类
 * @author VincentJ
 * @date 2019-06-03
 */
public class Code {
    /**编码用数组*/
    int[] bit;
    /**编码的起始下标*/
    int start;
    /**字符的权值*/
    int weight;

    public Code(int n) {
        bit = new int[n];
        start = n - 1;
    }
}

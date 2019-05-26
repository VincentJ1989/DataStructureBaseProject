package 数据结构_java语言描述第2版.chap4;

/**
 * 缓存串类的设计(这是简化版的，只设计了必需的成员函数)
 * @author VincentJ
 * @date 2019-05-26
 */
public class MyStringBuffer {
    private char[] value;
    private int count;

    public MyStringBuffer(String str) {
        char[] chararray = str.toCharArray();
        value = chararray;
        count = chararray.length;
    }

    /**
     * 字符数组的复制
     * @param src 源串的字符数组
     * @param srcPos 源串的起始下标
     * @param dst 目标串的字符数组（拿去复制的串）
     * @param dstPos 目标串的起始下标
     * @param length 新串的长度
     */
    private static void arrayCopy(char[] src, int srcPos, char[] dst, int dstPos, int length) {
        if (src.length - srcPos < length || dst.length - dstPos < length) {
            throw new StringIndexOutOfBoundsException(length);
        }

        for (int i = 0; i < length; i++) {
            dst[dstPos++] = src[srcPos++];
        }
    }

    public char[] toArray() {
        return value;
    }

    public int length() {
        return count;
    }

    /**
     * 连接
     * @param str
     * @return
     */
    public MyStringBuffer concat(MyStringBuffer str) {
        int otherLen = str.length();
        if (otherLen == 0) {
            return this;
        }
        // 注意这里的顺序
        expandCapacity(count + otherLen);
        count = count + otherLen;
        return this;
    }

    /**
     * 重新申请内存空间
     * @param newCapacity
     */
    private void expandCapacity(int newCapacity) {
        char[] newValue = new char[newCapacity];
        // 复制原字符数组
        arrayCopy(value, 0, newValue, 0, count);
        // 让value指向新穿件的newValue数组
        value = newValue;

    }

}

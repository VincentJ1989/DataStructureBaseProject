package 数据结构_java语言描述第2版.chap4;

/**
 * 操作不改变原串值的类的设计
 * @author VincentJ
 * @date 2019-05-26
 */
public class MyString {
    /**字符数组*/
    private char[] value;
    /**字符个数*/
    private int count;

    /**
     * 构造1
     */
    public MyString() {
        value = new char[0];
        count = 0;
    }

    /**
     * 构造函数2
     * @param value 
     * @param offset 数组起始下标
     * @param count
     */
    public MyString(char[] value, int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count < 0) {
            throw new StringIndexOutOfBoundsException(count);
        }
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }

        this.value = new char[count];
        this.count = count;
        // 数组复制
        arrayCopy(value, offset, this.value, 0, count);

    }

    /**
     * 构造函数2
     * @param value
     */
    public MyString(char[] value) {
        this.count = value.length;
        this.value = new char[count];
        arrayCopy(value, 0, this.value, 0, count);
    }

    /**
     * 构造函数4
     * @param str
     */
    public MyString(String str) {
        char[] chararray = str.toCharArray();
        this.value = chararray;
        this.count = chararray.length;
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

    /**
     * 取字符
     * @param index 下标
     * @return
     */
    public char charAt(int index) {
        if ((index < 0) || index >= count) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    /**
     * 取串长度
     * @return
     */
    public int length() {
        return count;
    }

    /**
     * 比较<p>
     *     1.字符比较
     *     2.长度比较
     * @param anotherStr
     * @return 当前串值大于传进来的就返回一个正数，相等为0，小于为负数
     */
    public int compareTo(MyString anotherStr) {
        int len1 = count;
        int len2 = anotherStr.count;
        int n = Math.min(len1, len2);
        char[] v1 = value;
        char[] v2 = anotherStr.value;
        int i = 0;
        int j = 0;

        int k = i;
        int lim = n + i;

        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                // 返回第一个不相等字符的数值差
                return c1 - c2;
            }
            k++;
        }
        // 当前边部分字符比较都相等时
        return len1 - len2;
    }

    /**
     * 取字符串
     * @param beginIndex 起始下标
     * @param endIndex 结束下标
     * @return 截取的字符串
     */
    public MyString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > count) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        if (beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
        }

        return ((beginIndex == 0) && (endIndex == count)) ? this
            : new MyString(value, beginIndex, endIndex - beginIndex);
    }

    /**
     * 取字符串
     * @param beginIndex 起始下标
     * @return
     */
    public MyString substring(int beginIndex) {
        return substring(beginIndex, count);
    }

    /**
     * 连接
     * @param str
     * @return
     */
    public MyString concat(MyString str) {
        int otherLen = str.length();
        char[] chararray = str.toArray();
        if (otherLen == 0) {
            return this;
        }
        char[] buf = new char[count + otherLen];
        // 复制原有的
        arrayCopy(value, 0, buf, 0, count);
        // 复制连接的
        arrayCopy(chararray, 0, buf, count, otherLen);
        return new MyString(buf);
    }

    /**
     * 插入子串
     * @param str 插入的子串
     * @param pos 插入的起始下标
     * @return
     */
    public MyString insert(MyString str, int pos) {
        if (pos < 0 || pos > count) {
            throw new StringIndexOutOfBoundsException(pos);
        }
        if (pos != 0) {
            // 原串的第一部分
            MyString str1 = this.substring(0, pos);
            // 原串的第二部分
            MyString str2 = this.substring(pos);

            MyString res1 = str1.concat(str);
            MyString res2 = res1.concat(str2);
            return res2;
        } else {
            return str.concat(this);
        }

    }

    /**
     * 删除子串(左闭右开)
     * @param beginIndex 起始下标
     * @param endIndex 终止下标
     * @return
     */
    public MyString delete(int beginIndex, int endIndex) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > count) {
            throw new StringIndexOutOfBoundsException(endIndex);
        }
        if (beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
        }
        // 全部删除，返回一个空的对象
        if (beginIndex == 0 && endIndex == count) {
            return new MyString();
        } else {
            MyString str1 = this.substring(0, beginIndex);
            MyString str2 = this.substring(endIndex);
            return str1.concat(str2);
        }
    }

    /**
     * 返回字符数组
     * @return
     */
    public char[] toArray() {
        char[] buf = new char[count];
        arrayCopy(value, 0, buf, 0, count);
        return buf;
    }
}

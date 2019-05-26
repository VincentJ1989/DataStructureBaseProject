package 数据结构_java语言描述第2版.chap5;

/**
 * 集合类的设计(基于MyVector)
 * @author VincentJ
 * @date 2019-05-26
 */
public class MySet {
    private MyVector values = new MyVector();

    public void add(Object obj) {
        if (obj == null) {
            return;
        }
        // 不存在则加到末尾
        if (values.indexOf(obj) < 0) {
            values.add(obj);
        }
    }

    public void remove(Object obj) {
        values.remove(obj);
    }

    /**
     * 属于
     * @param obj
     * @return
     */
    public boolean contain(Object obj) {
        return values.contain(obj);
    }

    /**
     * 包含
     * @param obj
     * @return
     */
    public boolean include(Object obj) {
        if (obj instanceof MySet) {
            MySet set = (MySet) obj;
            int counter = 0;
            // 还可以通过长度提前判断
            while (counter < set.size()) {
                Object temp = set.get(counter);
                counter++;
                if (!contain(temp)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public Object get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index >= values.size()) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + values.size());
        }
        return values.get(index);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MySet) {
            MySet set = (MySet) obj;
            // 相互包含即为相等(这是不考虑内部的顺序)
            return include(set) && set.include(this);
        } else {
            return false;
        }
    }

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.size() > 0;
    }
}

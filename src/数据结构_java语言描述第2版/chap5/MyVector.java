package 数据结构_java语言描述第2版.chap5;

/**
 * 支持扩展的数组(String中的Vector)
 * @author VincentJ
 * @date 2019-05-26
 */
public class MyVector {

    private static final int DEFAULTS_SIZE = 10;
    private static final int SIZE_FACTOR = 2;
    /**数据元素*/
    private Object[] elementData;
    /**元素个数*/
    private int elementCount;

    public MyVector() {
        this(DEFAULTS_SIZE);
    }

    public MyVector(int initialCapacity) {
        elementData = new Object[initialCapacity];
        elementCount = 0;
    }

    /**
     * 扩充内存
     * @param minCapacity
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            Object[] oldData = elementData;
            int newCapacity = oldCapacity * SIZE_FACTOR;
            if (newCapacity < minCapacity) {
                // 仍小于要求的，就直接使用要求的大小
                newCapacity = minCapacity;
            }
            elementData = new Object[newCapacity];
            // 把原来的数组元素复制到新数组的开始位置
            System.arraycopy(oldData, 0, elementData, 0, elementCount);
        }
    }

    /**
     * 在index出增加元素
     * @param index 增加的下标
     * @param element 增加的元素
     */
    public void add(int index, Object element) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">" + elementCount);
        }
        // 至少要多一个
        ensureCapacity(elementCount + 1);
        System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
        elementData[index] = element;
        elementCount++;
    }

    /**
     * 在最后添加元素
     * @param element
     */
    public void add(Object element) {
        add(elementCount, element);
    }

    /**
     * 设置元素
     * @param index
     * @param element
     */
    public void set(int index, Object element) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + elementCount);
        }
        elementData[index] = element;
    }

    /**
     * 取元素
     * @param index 下标
     * @return
     */
    public Object get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + elementCount);
        }
        return elementData[index];
    }

    /**
     * 获取元素个数
     * @return
     */
    public int size() {
        return elementCount;
    }

    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < elementCount; i++) {
                if (elementData[i] == null) {
                    // 返回第一个null元素
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elementCount; i++) {
                if (element.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contain(Object element) {
        return indexOf(element) >= 0;
    }

    public void remove(Object element) {
        int i = indexOf(element);
        if (i >= 0) {
            remove(i);
        }
    }

    public void remove(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + ">=" + elementCount);
        }
        int j = elementCount - index - 1;
        // 不是最后一个移除才进行复制
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    }
}

package 数据结构_java语言描述第2版.chap3;

/**
 * 顺序优先级队列中的数据元素设计
 * @author VincentJ
 * @date 2019-05-24
 */
public class Element {
    private Object elem;
    /**优先级(规定越低越小)*/
    private int priority;

    public Element(Object obj, int i) {
        elem = obj;
        priority = i;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object obj) {
        elem = obj;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int i) {
        priority = i;
    }
}

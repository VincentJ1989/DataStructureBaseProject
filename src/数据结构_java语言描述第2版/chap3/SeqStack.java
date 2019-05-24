package 数据结构_java语言描述第2版.chap3;

/**
 * 顺序堆栈类的设计
 * @author VincentJ
 * @date 2019-05-24
 */
public class SeqStack implements Stack {
    private static final int DEFAULT_SIZE = 10;
    /**栈顶位置*/
    int top;
    Object[] stack;
    int maxStakcSize;

    public SeqStack() {
        initiate(DEFAULT_SIZE);
    }

    public SeqStack(int sz) {
        initiate(sz);
    }

    private void initiate(int sz) {
        maxStakcSize = sz;
        top = 0;
        stack = new Object[sz];
    }

    @Override
    public void push(Object obj) throws Exception {
        if (top == maxStakcSize) {
            throw new Exception("堆栈已满!");
        }
        stack[top] = obj;
        top++;
    }

    @Override
    public Object pop() throws Exception {
        if (top == 0) {
            throw new Exception("堆栈已空!");
        }
        top--;
        return stack[top];
    }

    @Override
    public Object getTop() throws Exception {
        if(top==0){
            throw new Exception("堆栈已空!");
        }
        // 注意这里不是top
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() throws Exception {
        return top>0;
    }
}

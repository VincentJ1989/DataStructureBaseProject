package 数据结构_java语言描述第2版.chap7;

import 数据结构_java语言描述第2版.chap3.LinkStack;

/**
 * 二叉树中序游标类的设计
 * @author VincentJ
 * @date 2019-06-03
 */
public class BiTrInIterator extends BiTreeInterator {
    /**创建堆栈类duixiang*/
    private LinkStack s = new LinkStack();

    BiTrInIterator(BiTreeNode t) {
        super(t);
    }

    /**
     * 寻找最左孩子结点
     */
    private BiTreeNode goFarLeft(BiTreeNode t) {
        if (t == null) {
            return null;
        }
        try {
            while (t.getLeft() != null) {
                s.push(t.getLeft());
                t = t.getLeft();
            }
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        return t;
    }

    @Override
    public void reset() {
        if (root == null) {
            // 结束标记
            iteComplete = 1;
        } else {
            iteComplete = 0;
        }
        if (root == null) {
            return;
        }
        current = goFarLeft(root);
    }

    @Override
    public void next()
        throws Exception {
        if (iteComplete == 1) {
            System.out.println("已经到二叉树尾");
            return;
        }

        if (current.getRight() != null) {
            // 寻找当前结点右孩子结点的最左孩子结点
            current = goFarLeft(current.getRight());
        } else if (!s.isEmpty()) {
            // 若堆栈非空
            try {
                // 退栈
                current = (BiTreeNode) s.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            iteComplete = 1;
        }
    }
}

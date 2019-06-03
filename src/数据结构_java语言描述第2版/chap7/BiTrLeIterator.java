package 数据结构_java语言描述第2版.chap7;

import 数据结构_java语言描述第2版.chap3.LinkQueue;

/**
 * 二叉树层序游标类的设计
 * @author VincentJ
 * @date 2019-06-03
 */
public class BiTrLeIterator extends BiTreeInterator {
    /**创建链式队列类对象*/
    LinkQueue q = new LinkQueue();

    BiTrLeIterator(BiTreeNode t) {
        super(t);
    }

    @Override
    public void reset() {
        if (root == null) {
            // 置结束标记
            iteComplete = 1;
        } else {
            iteComplete = 0;
        }

        if (root == null) {
            return;
        }
        current = root;
        try {
            if (root.getLeft() != null) {
                // 左孩子结点入队
                q.append(root.getLeft());
            }
            if (root.getRight() != null) {
                // 右孩子结点入队
                q.append(root.getRight());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void next() {
        if (iteComplete == 1) {
            System.out.println("已到二叉树尾!");
            return;
        }

        if (q.notEmpty()) {
            // 非空
            try {
                // 出队列
                current = (BiTreeNode) q.delete();
                if (current.getLeft() != null) {
                    // 左孩子结点入队
                    q.append(current.getLeft());
                }
                if (current.getRight() != null) {
                    // 右孩子结点入队
                    q.append(current.getRight());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 置结束标记
            iteComplete = 1;
        }
    }
}

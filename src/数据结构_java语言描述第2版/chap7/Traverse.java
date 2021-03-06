package 数据结构_java语言描述第2版.chap7;

import 数据结构_java语言描述第2版.Visit;
import 数据结构_java语言描述第2版.chap3.LinkQueue;
import 数据结构_java语言描述第2版.chap3.LinkStack;

/**
 * 二叉树遍历类
 * @author VincentJ
 * @date 2019-05-28
 */
public class Traverse {
    /**
     * 前序遍历二叉树t，访问结点操作为vs.print(t.data)
     */
    public static void preOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            vs.print(t.getData());
            preOrder(t.getLeft(), vs);
            preOrder(t.getRight(), vs);
        }
    }

    /**
     * 中序遍历二叉树t，访问结点操作为vs.print(t.data)
     */
    public static void inOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            inOrder(t.getLeft(), vs);
            vs.print(t.getData());
            inOrder(t.getRight(), vs);
        }
    }

    /**
     * 后序遍历二叉树t，访问结点操作为vs.print(t.data)
     */
    public static void postOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            postOrder(t.getLeft(), vs);
            postOrder(t.getRight(), vs);
            vs.print(t.getData());
        }
    }

    /**
     * 层序遍历二叉树t，访问结点操作为vs.print(t.data)
     */
    public static void levelOrder(BiTreeNode t, Visit vs)
        throws Exception {
        // 第一步：创建链式队列类对象
        LinkQueue q = new LinkQueue();
        if (t == null) {
            return;
        }
        // 第二步：根结点入队列
        q.append(t);

        // 第三步：入队列
        BiTreeNode curr;
        while (q.notEmpty()) {
            // 非空循环

            // 出队列
            curr = (BiTreeNode) q.delete();
            // 访问该结点
            vs.print(curr.getData());

            if (curr.getLeft() != null) {
                // 左孩子结点入队列
                q.append(curr.getLeft());
            }

            if (curr.getRight() != null) {
                // 右孩子入队列
                q.append(curr.getRight());
            }
        }
    }

    /**
     * 非递归的二叉树前序遍历<p>
     *     利用栈转化
     */
    public static void preOrderNoRecur(BiTreeNode t, Visit vs)
        throws Exception {
        if (t == null) {
            return;
        }
        // 创建链式堆栈类对象
        LinkStack s = new LinkStack();
        // 根结点入栈
        s.push(t);

        BiTreeNode curr;
        while (!s.isEmpty()) {
            // 非空循环

            // 顶部出栈
            curr = (BiTreeNode) s.pop();
            // 访问结点
            System.out.println(curr.getData() + "");

            // 注意：这里是先push右孩子结点
            // 右孩子结点入栈
            if (curr.getRight() != null) {
                s.push(curr.getRight());
            }
            // 左孩子结点入栈
            if (curr.getLeft() != null) {
                s.push(curr.getLeft());
            }
        }
    }

}

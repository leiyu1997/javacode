package algo;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.node.factory.TreeFactory;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的测试
 */
public class TreeTest {

    private TreeNode tree = TreeFactory.getTree(5);

    @Test
    public void preTravelTest() {
        //前序遍历
        preTravel(tree);
        System.out.println();
        return;
    }

    /**
     * 先序遍历，其他深度遍历都是先序遍历的变种
     *
     * @param node
     */
    private void preTravel(TreeNode node) {
        System.out.print(node.val + ",");
        if (node.left != null) preTravel(node.left);
        if (node.right != null) preTravel(node.right);
    }

    /**
     * 图的广度优先遍历
     */
    @Test
    public void breadthFirstSearch() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val+",");
            if (queue.peek().left != null) queue.add(queue.peek().left);
            if (queue.peek().right != null) queue.add(queue.peek().right);
            queue.poll();
        }
        return;
    }

    @Test
    public void levelTravel(){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            int levelLength=queue.size();
            for (int i = 0; i <levelLength ; i++) {
                System.out.print(queue.peek().val+",");
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                queue.poll();
            }
            System.out.println();
        }
        return;
    }

}

package algo;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.node.factory.TreeFactory;
import com.leiyu.algo.tree.BreadthFirstSearch.BreadthFirstSearch;
import com.leiyu.algo.tree.BreadthFirstSearch.LevelTravel;
import com.leiyu.algo.tree.BreadthFirstSearch.PrintTravel;
import com.leiyu.algo.tree.DepthFirstSerach.MidTravel;
import com.leiyu.algo.tree.DepthFirstSerach.PostTravel;
import com.leiyu.algo.tree.ParentTravel;
import com.leiyu.algo.tree.DepthFirstSerach.PreTravel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树的遍历
 */
public class TreeTravelTest {

    private TreeNode tree;
    private ParentTravel travel;
    private static final int depth = 5;

    @Test
    //前序遍历
    public void preTravelTest() {
        travel = new PreTravel();
    }

    @Test
    //中序遍历
    public void midTravelTest() {
        travel = new MidTravel();
    }

    @Test
    //后序遍历
    public void postTravelTest() {
        travel = new PostTravel();
    }

    @Test
    //广度优先遍历
    public void BFSTest() {
        travel = new BreadthFirstSearch();
    }

    @Test
    //层次遍历
    public void levelTravelTest() {
        travel = new LevelTravel();
    }

    @Before
    public void before() {
        tree = TreeFactory.getTree(depth);
    }

    @After
    public void after() {
        PrintTravel print = new PrintTravel();
        System.out.println("树结构：");
        print.travel(tree, depth);
        System.out.println("输出：");
        travel.travel(tree);
    }
}

import com.leiyu.algo.node.Node;
import com.leiyu.algo.node.factory.LinkedFactory;
import com.leiyu.algo.node.util.LinkedUtils;
import org.junit.Test;

/**
 * @program: javacode
 * @description: 普通测试类
 * @author: yuleif
 * @create: 2020-09-15 20:06
 **/
public class MainTest {

    @Test
    public void test() {
        Node node= LinkedFactory.createNodeList(10);
        LinkedUtils.printLinkedNode(node);
    }
}

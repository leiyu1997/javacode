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
        int[] array = {1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 9, 9, 10, 11, 12, 13, 14, 15, 16};
        int pos = 0, len = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1, tempPos = i, tempLen = 0; j < array.length; j++) {
                i = j - 1;
                if (array[j] - array[j - 1] == 1) {
                    tempLen++;
                    if (tempLen > len) {
                        len = tempLen;
                        pos = tempPos;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = pos; i <= pos + len; i++) {
            System.out.println(array[i]);
        }
    }
}

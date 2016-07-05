import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.NotNull;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/7/1
 */


public class GuavaTest {

    @Before
    public void before() {
        System.out.println("Test Start *******");
    }

    /**
     * Optional
     */
    @Test
    public void test() {
        nullParamTest("222");

    }

    @After
    public void after() {
        System.out.println("Test End ******");
    }


    private void nullParamTest(@NotNull String name) {
        System.out.println(name);
    }
}

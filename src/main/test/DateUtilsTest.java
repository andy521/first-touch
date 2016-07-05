import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * write Title here
 * <p>
 * write Description here
 * </p>
 *
 * @author Jade ZHANG E-mail:pioneer_zcy@163.com
 * @copyright 2015-2016 sh.lianjia.com.
 * @date 16/7/4
 */

public class DateUtilsTest {

    @Test
    public void test() throws Exception{
        String[] pattern =(String[]) Arrays
                .asList("yyyy-MM",
                        "yyyyMM",
                        "yyyy/MM",
                        "yyyyMMdd",
                        "yyyy-MM-dd",
                        "yyyy/MM/dd",
                        "yyyyMMddHHmmss",
                        "yyyy-MM-dd HH:mm:ss",
                        "yyyy/MM/dd HH:mm:ss").toArray();
        Date date = DateUtils.parseDate("2016/02",pattern);
        System.out.println(date);
    }


}

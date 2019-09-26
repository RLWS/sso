package time.test;

import com.rlws.sso.commons.utils.MD5Utils;
import com.rlws.sso.commons.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring*.xml","classpath:/mybatis-config.xml"})
public class Date {
    @Test
    public void jedisTest() {
        String s = new RedisUtils().stringSet("rlws", "ming");
        System.out.println(s);
    }

    @Test
    public void md5Test(){
        String encode = MD5Utils.encode("12345678");
        System.out.println(encode);
    }
}

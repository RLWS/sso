package rsa.test;

import com.rlws.sso.commons.utils.MD5Utils;
import org.junit.Test;

public class javap {
    public static void main(String[] args) {
        int rlws = 1;
        Integer iter = 2;
        System.out.println(rlws);
        System.out.println(iter);
    }

    @Test
    public void test1(){
        String encode = MD5Utils.encode("123456");
        System.out.println(encode);
    }
}

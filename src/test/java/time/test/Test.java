package time.test;

import com.rlws.sso.commons.utils.RSAUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test() {
        Ftp.getConnect().upload("D:\\RuiHao\\svn.txt");
    }

    @org.junit.Test
    public void rsaTest() {
//        int primeNumber = RSAUtils.getPrimeNumber();
//        System.out.println(primeNumber);
        //Map rsa = RSAUtils.getRSA();
        int d = 1;
        while (true){
            if (d*37 % 396 == 1){
                break;
            }
            d ++;
        }
        System.out.println(d);
    }
}

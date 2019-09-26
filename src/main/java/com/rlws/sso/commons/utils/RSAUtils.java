package com.rlws.sso.commons.utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RSAUtils {


    public static Map getRSA(){
        HashMap<String, Object> map = new HashMap<>();
        int p = getPrimeNumber();
        map.put("p",p);
        int q = getPrimeNumber();
        map.put("q",q);
        String n = formatDoubleNumber((double) p*q);
        map.put("n",n);
        System.out.println("p:"+p+"q:"+q+"n:"+n);
        String  fn = formatDoubleNumber((double) (p-1)*(q-1));
        System.out.println("fn:"+fn);
        map.put("fn",fn);
        int e = getPrimeNumber();
        System.out.println("e:"+e);
        map.put("n",n);

        double fn_d = Double.parseDouble(fn);
        double d = 0;

        System.out.println(formatDoubleNumber(d));
        map.put("d",d);
        return map;
    }

    /**
     * 获取一个随机质数
     * @return
     */
    private static int getPrimeNumber() {
        Random random = new Random();
        int i = 0;
        while (true) {
            i = random.nextInt(1000000000);
            if (primeNumber(i)) {
                return i;
            }
        }
    }

    /**
     * 素数优化算法
     * @param num 传入的参数
     * @return
     */
    private static boolean primeNumber(int num) {
        if (num == 2 || num == 3)
            return true;
        if (num <= 1)
            return false;
        if (num % 6 != 1 && num % 6 != 5)
            return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 6; i < sqrt; i = i + 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将科学计数法的Double类型转为String类型查看
     * @param num   传入的Double参数
     * @return
     */
    private static String formatDoubleNumber(double num){
        if (num != 0.00){
            DecimalFormat decimalFormat = new DecimalFormat("########");
            return decimalFormat.format(num);
        }
        return "0";
    }
}

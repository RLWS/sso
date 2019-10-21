package rsa.test;

import com.rlws.sso.commons.utils.TokenUtils;
import lombok.Synchronized;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CriticalRegion {
    public Integer money = 1000;
    @Test
    public void main(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0;i < 100;i++){
            executorService.execute(()->{
                token();
            });
        }
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public void token(){

    }

    @Test
    public void token1(){
        //模拟数据
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0 ;i < 10 ;i++){
            int i1 = new Random().nextInt(10);
            strings.add(""+ i1);
        }
        System.out.println(strings);
        //用来保存重复的条数(set集合不能存入相同的对象,因此会去重)
        HashSet<Integer> set = new HashSet<>();
        for(int k=0;k<strings.size()-1;k++) {
            for (int h = k+1;h<strings.size();h++){
                //条件判断
                if(strings.get(k).equals(strings.get(h))){
                    //多加一个判断
                    set.add(h+1);
                }
            }
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("第"+next+"条重复");
        }
    }

    @Test
    public void aa(){
//        String msg="";
//        HashSet<Integer> set = new HashSet<>();
//        for(int k=0;k< data2.size()-1;k++){
//            for(int h=k+1;h<data2.size();h++){
//                if(data2.get(k).get("begindate").equals(data2.get(h).get("begindate"))
//                        &&data2.get(k).get("enddate").equals(data2.get(h).get("enddate"))
//                        &&data2.get(k).get("glbdef1").equals(data2.get(h).get("glbdef1"))){
//                    //msg+="第"+(h+1)+"条有重复记录</br>";
//                    set.add(h+1);
//                }
//            }
//        }
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            msg+="第"+next+"条有重复记录</br>";
//            //System.out.println("第"+next+"条重复");
//        }
    }

    @Test
    public void test(){
        StringBuilder sb = new StringBuilder();
        System.out.println(":::"+sb.toString()+":::");
    }
}

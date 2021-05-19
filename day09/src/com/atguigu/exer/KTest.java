package com.atguigu.exer;

import org.junit.Test;

/**
 * @author k
 * @create 2021-04-28 22:14
 */
public class KTest {
    @Test
    public void test1(){

        System.out.println(func(5));
        System.out.println(func2(5));
    }

    //阶乘
    public int func(int x){
        if (x==1){
            return 1;
        }else {
            return  func(x-1)*x;//1*2*3...
        }
    }


    //累加
    public int func2(int x){
        if(x==1){
            return 1;
        }else {
            return x+func2(x-1);
        }
    }


}

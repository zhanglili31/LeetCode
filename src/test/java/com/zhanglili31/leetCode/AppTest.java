package com.zhanglili31.leetCode;

import junit.framework.TestCase;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public void testApp() {
        System.out.println("ok");

    }

    //
    // 小车
    public class parkType {
        //类型
        int type;

        //总量
        int num;

        //剩余
        int remain;


    }

    public interface Park {
        //不同的车位类型，
        List<parkType> list = null;


        // 能否进入
        boolean canIn(int Type);


        //车进
        void carIn(int type);


        //出车
        void decrease(int type);
    }
    //
    //车：计时 计费
    //金额扣减，订单情况
    //停车场：车位统计，车型，
    //


}

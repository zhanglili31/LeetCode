package com.zhanglili31.leetCode.editor.cn.utils;

import java.util.Random;

public class CreateArray {
    public static int[] getArray(int length,int max) {
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i]=rand.nextInt(max);
        }
        return array;
    }
}

package com.zhanglili31.leetCode.editor.cn.utils;

import java.util.Arrays;

public class StringToArray {
    /*
    * 二维字符串转换为对应二char的二维数组。
    * 输入示例：[["1","0","1","0","0"],["1","1","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    * 输出示例：
    * [1, 0, 1, 0, 0]
    * [1, 1, 1, 1, 1]
    * [1, 1, 1, 1, 1]
    * [1, 0, 0, 1, 0]
    * */
    public static char[][] stringTo2DCharArray(String strInput) {

        strInput = strInput.substring(1, strInput.length() - 1);
        String strArray[] = strInput.split("]");
        StringBuilder[] stringBuilder = new StringBuilder[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder[i] = new StringBuilder(strArray[i]);
        }
        for (int i = 0; i < stringBuilder.length; i++) {
            for (int j = 0; j < stringBuilder[i].length(); j++) {
                char c = stringBuilder[i].charAt(j);
                if (c == '\"' || c == '[' || c == ']' || c == ',') {
                    stringBuilder[i].deleteCharAt(j);
                    j--;
                }
            }
        }
        int len = stringBuilder[0].length();
        int col = stringBuilder.length;
        char[][] res = new char[col][len];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < len; j++) {
                char c = stringBuilder[i].charAt(j);
                res[i][j] = c;
            }
            System.out.println(Arrays.toString(res[i]));
        }


        return res;
    }

    public static void main(String[] args) {
        String strInput = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
        stringTo2DCharArray(strInput);

    }
}

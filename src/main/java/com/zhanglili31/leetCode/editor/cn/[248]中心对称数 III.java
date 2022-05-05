package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//248 中心对称数 III
//2022-05-05 20:23:01
class StrobogrammaticNumberIii {

    public static void main(String[] args) {
        Solution solution = new StrobogrammaticNumberIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.strobogrammaticInRange("0", "100000000000000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strobogrammaticInRange(String low, String high) {
            int n = high.length();
            long lowNum = Long.valueOf(low);
            long highNum = Long.valueOf(high);
            int res = 0;
            List<String> single = new ArrayList<>();
            List<String> two = new ArrayList<>();
            single.add("0");
            single.add("1");
            single.add("8");
            two.add("00");
            two.add("11");
            two.add("88");
            two.add("69");
            two.add("96");
            List<String> list1 = new ArrayList<>();
            list1.add("0");
            list1.add("1");
            list1.add("8");
            List<String> list2 = new ArrayList<>();
            list2.add("11");
            list2.add("69");
            list2.add("88");
            list2.add("96");
            List<List<String>> list = new ArrayList<>();
            list.add(list1);
            list.add(list2);
            List<String> temp = null;
            List<String> addList = null;
            for (int i = 2; i < n; i++) {
                if (i % 2 == 0) {//增加后奇数 3
                    temp = list.get(i - 1);
                    addList = single;
                } else {
                    temp = list.get(i - 2);
                    addList = two;
                }
                List<String> newList = new ArrayList<>();
                for (int j = 0; j < temp.size(); j++) {

                    for (int k = 0; k < addList.size(); k++) {
                        StringBuilder strB = new StringBuilder(temp.get(j));
                        String insert = addList.get(k);
                        int points = strB.length() / 2;
                        newList.add(strB.insert(points, insert).toString());
                    }
                }
                list.add(newList);
            }
            //遍历获取结果
            for (int i = 0; i < list.size(); i++) {
                temp = list.get(i);
                for (int j = 0; j < temp.size(); j++) {
                    long cunNum = Long.valueOf(temp.get(j));
                    if (lowNum <= cunNum && cunNum <= highNum) {
                        res++;
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
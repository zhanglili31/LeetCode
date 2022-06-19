package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 62 圆圈中最后剩下的数字
//2022-06-16 01:34:44
class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //方法一：暴力模拟，
        //关键点1:index+=m-1
        //为什么是m-1,因为在list中删除当前位置的元素，所有后续的元素，索引向前走一步。
        //关键点2：当index大于list.size(),index=index%list.size()
        public int lastRemaining2(int n, int m) {
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() > 1) {
                index += m - 1;
                if (index < list.size()) {
                    list.remove(index);
                } else {
                    index = index % list.size();
                    list.remove(index);
                }
            }
            return list.get(0);
        }
        public int lastRemaining(int n,int m){
            int pos=0;
            int i=2;
            for (; i <= n; i++) {
                pos=(pos+m)%i;
            }
            return pos;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
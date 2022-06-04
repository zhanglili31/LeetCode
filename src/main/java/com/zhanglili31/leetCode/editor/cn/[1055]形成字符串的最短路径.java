package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1055 形成字符串的最短路径
//2022-06-04 00:09:41
class ShortestWayToFormString {

    public static void main(String[] args) {
        Solution solution = new ShortestWayToFormString().new Solution();
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
        //贪心思路：每一次尽可能的在source中去找到能与target匹配上的字符，然后更新target再次匹配，直到target的长度为0；
        //核心步骤：使用一个指针t指向target的第一个字符，循环遍历source中的每一个字符，当source正在遍历的字符和t指向的字符相同时，t向后走一步
        public int shortestWay(String source, String target) {
            int ans = 0;
            int t = 0;
            //当target的长度为0，target就匹配完成跳出循环
            while (target.length() > 0) {
                //核心步骤：使用一个指针t指向target的第一个字符，循环遍历source中的每一个字符，当source正在遍历的字符和t指向的字符相同时，t向后走一步
                for (int j = 0; j < source.length() && t < target.length(); j++) {
                    if (source.charAt(j) == target.charAt(t)) {
                        t++;
                    }
                }
                ans++;
                //t==0,说明source中没有target中的字符，这种情况就不可能匹配上，所有返回-1
                if (t == 0) {
                    return -1;
                }
                //删除target能与source匹配上的字符，剩下的target继续重复操作
                target = target.substring(t, target.length());
                t = 0;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
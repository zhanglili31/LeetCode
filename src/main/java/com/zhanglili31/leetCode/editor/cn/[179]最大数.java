package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;

//179 最大数
//2022-09-17 08:12:08
class LargestNumber {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new LargestNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        //参考：https://leetcode.cn/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
        public String largestNumber(int[] nums) {
            String strs[] = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = "" + nums[i];
            }
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;
                    return s2.compareTo(s1);
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }
            int k=0;
            for (; k < sb.length()-1; k++) {
                if(sb.charAt(k)!='0'){
                    break;
                }
            }
            return sb.substring(k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
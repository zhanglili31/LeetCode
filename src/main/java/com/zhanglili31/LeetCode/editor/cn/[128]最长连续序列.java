package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

//128最长连续序列
//2021-10-21 23:28:45
class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        int[] temp = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 涉及的经典问题
    //Java ConcurrentModificationException异常原因和解决方法
    // 遍历集合的同时，删除集合的元素。
    //https://www.cnblogs.com/zhuyeshen/p/10956822.html
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int len = 0;
            int maxLen = 0;
            for (int num : set) {
                len = 1;
                int tmp = num;
                if (set.contains(tmp - 1)) {
                    continue;
                }
                while (set.contains(++tmp)) {
//                set.remove(tmp);
                    len++;
                }
                if (len > maxLen) {
                    maxLen = len;
                }

            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

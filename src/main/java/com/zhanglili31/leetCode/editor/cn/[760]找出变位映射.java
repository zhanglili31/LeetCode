package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//760 找出变位映射
//2022-05-25 22:52:23
class FindAnagramMappings {

    public static void main(String[] args) {
        Solution solution = new FindAnagramMappings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            Stack<Integer> temp = map.getOrDefault(nums2[i], new Stack<Integer>());
            temp.push(i);
            map.put(nums2[i], temp);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=map.get(nums1[i]).pop();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}
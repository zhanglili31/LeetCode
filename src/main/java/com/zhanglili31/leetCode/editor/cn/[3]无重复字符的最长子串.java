package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

//3无重复字符的最长子串
//2021-04-12 23:25:23
class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String []args){
        Solution solution=new LongestSubstringWithoutRepeatingCharacters().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||"".equals(s))return 0;
        int len=0;
        int maxLen=0;
        int pre=0;
        Map<Character, Integer> map = new HashMap<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(map.containsKey(c)&&pre<=map.get(c)){
                len = i - map.get(c);
                pre=map.get(c)+1;
                map.put(c, i);
            }else{
                len++;
                map.put(c, i);
            }
            if (maxLen < len) {
                maxLen=len;
            }

        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

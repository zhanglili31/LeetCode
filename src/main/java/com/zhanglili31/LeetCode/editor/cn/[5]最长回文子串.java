package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//5最长回文子串
//2021-04-13 00:28:10
class LongestPalindromicSubstring{
    public static void main(String []args){
        Solution solution=new LongestPalindromicSubstring().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.longestPalindrome("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String pre=null;
        String pro=null;
        int h=0,t=0;
        String res=null;
        int len =0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() + 1; j++) {
                String temp = s.substring(i, j);
                if (isConvert(temp)) {
                    if (len < temp.length()) {
                        res=temp;
                        len=temp.length();
                    }
                }
            }
        }
        return res;
    }
    private boolean isConvert(String s){
        if(s==null||"".equals(s))return false;
        int i=0,j=s.length()-1;
        while (i < j) {
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

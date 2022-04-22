package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//900 RLE 迭代器
//2022-03-13 18:26:09
class RleIteratorP {

    public static void main(String[] args) {
//        Solution solution = new RleIterator().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RLEIterator {
        int points=0;
        int[] rle = null;

        public RLEIterator(int[] encoding) {
            this.rle = encoding;

        }

        public int next(int n) {
            int res=0;
            while (n >= 0) {
                if (points <= rle.length - 1) {
                    int temp = n - rle[points];
                    if (temp == 0) {
                        res = rle[points + 1];
                        rle[points] = 0;
                        points += 2;
                        break;
                    } else if (temp < 0) {
                        res = rle[points + 1];
                        rle[points] -= n;
                        break;
                    }else{
                        rle[points]=0;
                        points += 2;
                        n=temp;
                    }
                }else{
                    res=-1;
                    break;
                }
            }
            return res;

        }
    }

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
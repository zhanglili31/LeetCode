package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//406 根据身高重建队列
//2022-05-02 21:55:27
class QueueReconstructionByHeight {

    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            boolean needSwap = true;
            //先使用冒泡对身高排序
            while (needSwap) {
                needSwap = false;
                for (int i = 0; i < people.length - 1; i++) {
                    if (people[i][0] < people[i + 1][0]) {
                        int[] temp = people[i];
                        people[i] = people[i + 1];
                        people[i + 1] = temp;
                        needSwap = true;
                    }
                    if (people[i][0] == people[i + 1][0] && people[i][1] > people[i + 1][1]){
                        int[] temp = people[i];
                        people[i] = people[i + 1];
                        people[i + 1] = temp;
                        needSwap = true;
                    }
                }
            }
            //再使用插入排序。
            for (int i = 0; i < people.length; i++) {
                int points = people[i][1];//points 数量
                int k=0;//位置
                while (points >0  ) {
                    if (people[k][0] >= people[i][0]) {
                        points--;
                    }
                    k++;
                }
                //顺序移动
                int[] temp = people[i];
                for (int l = i; l>k; l--) {
                    people[l] = people[l - 1];
                }
                people[k]=temp;
            }
            return people;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
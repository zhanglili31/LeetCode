package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//294 翻转游戏 II
//2022-05-11 09:51:22
class FlipGameIi {

    public static void main(String[] args) {
        Solution solution = new FlipGameIi().new Solution();
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
            //优化参考方案：https://leetcode.cn/problems/flip-game-ii/solution/c-sprague-grundy-acmbo-yi-lun-xiang-guan-1ddj/
            public boolean canWin(String currentState) {
                Map<String, Boolean> map = new HashMap<>();
                int len = currentState.length();
                boolean res=false;
                for (int i = 0; i < len - 1; i++) {
                    char ch1 = currentState.charAt(i);
                    char ch2 = currentState.charAt(i + 1);
                    if (ch1 == '+' && ch2 == '+') {
                        res=true;
                        StringBuilder strB = new StringBuilder(currentState);
                        strB.replace(i, i + 2, "--");
                        boolean temp;
                        if(map.containsKey(strB.toString())){
                            temp=map.get(strB.toString());
                        }else{
                            temp=canWin(strB.toString());
                            map.put(strB.toString(), temp);
                        }
                        if(!temp){
                            return true;
                        }else{
                            res=false;
                        }
                    }
                }
                return res;
            }
            int[] array = null;
            int size = 0;
            public boolean canWin0(String currentState) {
                int len = currentState.length();
                array = new int[len];
                for (int i = 0; i < len - 1; i++) {
                    if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                        array[i] = 1;
                        size++;
                    }
                }
                return recursion();
            }

            public boolean recursion() {
                //甲不能动
                if (size == 0)
                    return false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] == 0)
                        continue;
                    array[i] = 0;
                    size--;
                    boolean i1=false;
                    if (array[i + 1] == 1) {
                        size--;
                        i1=true;
                        array[i+1]=0;
                    }
                    boolean i0=false;
                    if (i-1>=0&&array[i - 1] == 1) {
                        size--;
                        i0=true;
                        array[i-1]=0;
                    }
                    boolean res = true;
                    for (int j = 0; j < array.length - 1 && size > 0; j++) {
                        if (array[j] == 0)
                            continue;
                        array[j] = 0;
                        size--;
                        boolean j1=false;
                        if (array[j + 1] == 1) {
                            size--;
                            array[j+1]=0;
                            j1=true;
                        }
                        boolean j0=false;
                        if (j-1>=0&&array[j - 1] == 1) {
                            size--;
                            j0=true;
                            array[j-1]=0;
                        }
                        boolean temp=recursion();
                        array[j]=1;
                        size++;
                        if (j1) {
                            size++;
                            array[j+1]=1;
                        }
                        if (j0) {
                            size++;
                            array[j-1]=1;
                        }
                        if(!temp){
                            res=false;
                            break;
                        }

                    }

                    //恢复i，i+1
                    array[i] = 1;
                    size++;
                    if (i1) {
                        size++;
                        array[i+1]=1;
                    }
                    if (i0) {
                        size++;
                        array[i-1]=1;
                    }
                    if(size==0)return true;
                    if(res){
                        return res;
                    }
                }
                return false;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}
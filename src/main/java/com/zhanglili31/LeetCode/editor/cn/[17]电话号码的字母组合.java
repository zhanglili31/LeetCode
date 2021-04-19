package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17电话号码的字母组合
//2021-04-20 00:04:25
class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, ArrayList<Character>> map = new HashMap<Character, ArrayList<Character>>();
            ArrayList<Character> list = new ArrayList<>();
            list.add('a');
            list.add('b');
            list.add('c');
            map.put('2', list);
            list = new ArrayList<>();
            list.add('d');
            list.add('e');
            list.add('f');
            map.put('3', list);
            list = new ArrayList<>();
            list.add('g');
            list.add('h');
            list.add('i');
            map.put('4', list);
            list = new ArrayList<>();
            list.add('j');
            list.add('k');
            list.add('l');
            map.put('5', list);
            list = new ArrayList<>();
            list.add('m');
            list.add('n');
            list.add('o');
            map.put('6', list);
            list = new ArrayList<>();
            list.add('p');
            list.add('q');
            list.add('r');
            list.add('s');
            map.put('7', list);
            list = new ArrayList<>();
            list.add('t');
            list.add('u');
            list.add('v');
            map.put('8', list);
            list = new ArrayList<>();
            list.add('w');
            list.add('x');
            list.add('z');
            list.add('y');
            map.put('9', list);
            List<String> res = new ArrayList<String>();
            int i = 0;
            while (i < digits.length()) {
                if (res.size() == 0) {
                    ArrayList<Character> temp = map.get(digits.charAt(i));
                    for (int j = 0; j < temp.size(); j++) {
                        res.add("" + temp.get(j));
                    }
                } else {
                    ArrayList<Character> temp = map.get(digits.charAt(i));
                    List<String> tres = new ArrayList<String>();
                    for (int k = 0; k < res.size(); k++) {
                        for (int j = 0; j < temp.size(); j++) {
                            tres.add(res.get(k) + temp.get(j));
                        }
                    }
                    res = tres;

                }
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

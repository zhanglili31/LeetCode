package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//399 除法求值
//2022-05-04 00:24:50
class EvaluateDivision {

    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        List<List<String>>list0 = new ArrayList<>();
        list0.add(list);
        list0.add(list2);
        double[] values = {0.2, 0.3};

        List<String>list3=new ArrayList<>();
        list3.add("a");
        list3.add("f");
        List<List<String>>list4=new ArrayList<>();
        list4.add(list3);
        System.out.println(solution.calcEquation(list0, values, list4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo 有时间一定要重写DFS，把思路搞清楚
    class Solution {
        class MyPair {
            String val;
            double div;

            public MyPair() {
            }

            public MyPair(String val, double div) {
                this.val = val;
                this.div = div;
            }
        }
        //参考：https://leetcode-cn.com/problems/evaluate-division/solution/dfsxiang-jie-pou-xi-guo-cheng-qi-shi-hen-aqin/
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] res = new double[queries.size()];
            //构造图
            System.out.println("构造图开始");
            Map<String, List<MyPair>> map = new HashMap<String, List<MyPair>>();
            for (int i = 0; i < equations.size(); i++) {
                String str1 = equations.get(i).get(0);
                String str2 = equations.get(i).get(1);
                //正向路径
                MyPair myPair = new MyPair(str2, values[i]);
                if (map.containsKey(str1)) {
                    List temp = map.get(str1);
                    temp.add(myPair);
                } else {
                    List<MyPair> temp = new ArrayList<>();
                    temp.add(myPair);
                    map.put(str1, temp);
                }
                //逆向路径
                myPair = new MyPair(str1, 1 / values[i]);
                if (map.containsKey(str2)) {
                    List temp = map.get(str2);
                    temp.add(myPair);
                } else {
                    List<MyPair> temp = new ArrayList<>();
                    temp.add(myPair);
                    map.put(str2, temp);
                }

            }
            System.out.println("构造图完成，计算结果");
            //查找目标，并且计算结果
            for (int i = 0; i < queries.size(); i++) {
                String str1 = queries.get(i).get(0);
                String str2 = queries.get(i).get(1);
                res[i] = DFS(str1, str2, map);
            }
            return res;
        }

        //
        public double DFS(String str1, String str2, Map map) {
            int res = -1;
            List<String> hasLooked = new ArrayList<>();
            hasLooked.add(str1);

            LinkedList<Double> pathValues = new LinkedList<>();
            pathValues.add(1.0);

            LinkedList<List<MyPair>> nodes = new LinkedList<>();


            if(!map.containsKey(str1))return res;

            nodes.push((List<MyPair>) map.get(str1));
            while (!nodes.isEmpty()) {
                List<MyPair> cur = nodes.pop();
                LinkedList<MyPair> curStack = new LinkedList<>(cur);
                while (!curStack.isEmpty()) {
                    MyPair myPair = curStack.pop();
                    if (str2.equals(myPair.val)) {
                        pathValues.push(myPair.div);
                        double tempRes=1.0;
                        for (double douValues : pathValues) {
                            tempRes*=douValues;
                        }
                        return tempRes;
                    }
                    if (hasLooked.contains(myPair.val))
                        continue;
                    pathValues.push(myPair.div);
                    nodes.push(curStack);
                    curStack=new LinkedList<MyPair>((List<MyPair>)map.get(myPair.val));
                    hasLooked.add(myPair.val);


                }
                pathValues.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
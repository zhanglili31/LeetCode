package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//631 设计 Excel 求和公式
//2022-05-30 11:03:37
class DesignExcelSumFormula {

    public static void main(String[] args) {
//        Solution solution = new DesignExcelSumFormula().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        Excel excel = new Excel(3, 'C');
//        excel.set(1, 'A', 2);
//        excel.sum(3, 'C', new String[]{"A1", "A1:B2"});
//        excel.set(2, 'B', 2);
//        excel.get(3, 'C');
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
 class Excel {
        Formula[][] Formulas;//把每一个格子都看成是一个函数

        class Formula {
            Formula(HashMap<String, Integer> c, int v) {
                val = v;
                cells = c;
            }

            HashMap<String, Integer> cells;//map中存储依赖当前节点的其他节点。
            int val;
        }

        Stack<int[]> stack = new Stack<>();
        int h = 0;
        int w = 0;

        public Excel(int H, char W) {
            h = H;
            w = W - 'A' + 1;
            Formulas = new Formula[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Formulas[i][j] = new Formula(new HashMap<String, Integer>(), 0);
                }
            }
        }

        //1 将目标位置：设置为目标值
        //2 将其他所有包含目标值的点重新求和
        //3 删除所有边的关系，清空目标的hashmap。
        public void set(int row, char column, int val) {
            int[] po = getPosition(row, column);
            Formulas[po[0]][po[1]].val = val;
            Formulas[po[0]][po[1]].cells.clear();
            topologicalSort(po);
            stack.pop();
            while (!stack.isEmpty()) {
                int temp[] = stack.pop();
                Formulas[temp[0]][temp[1]].val = sumAll(temp);
            }

        }

        public int get(int row, char column) {
            int[] po = getPosition(row, column);
            return Formulas[po[0]][po[1]].val;

        }

        //0 重建边的关系
        //1 对目标坐标进行求和
        //2 将目表位置设置为目标值
        //3 将其他所有包含目标值的点重新求和
        public int sum(int row, char column, String[] numbers) {
            int[] po = getPosition(row, column);
            createMap(po, numbers);

            int val = sumAll(po);

            Formulas[po[0]][po[1]].val = val;

            topologicalSort(po);
            stack.pop();
            while (!stack.isEmpty()) {
                int temp[] = stack.pop();
                Formulas[temp[0]][temp[1]].val = sumAll(temp);
            }
            return val;


        }

        //建立边的关系/**/
        public void createMap(int[] po, String[] numbers) {
            Formula poF = Formulas[po[0]][po[1]];
            poF.cells.clear();
            for (int i = 0; i < numbers.length; i++) {
                List<int[]> temp = getRecOrPointPosition(numbers[i]);
                for (int j = 0; j < temp.size(); j++) {
                    int[] fa = temp.get(j);
                    Formula faF = Formulas[fa[0]][fa[1]];
                    poF.cells.put(getStringByPoi(fa[0], fa[1]), poF.cells.getOrDefault(getStringByPoi(fa[0], fa[1]), 0) + 1);
                }
            }
        }


        //对目标边求和
        public int sumAll(int[] po) {
            final int[] ans = {0};
            Formula target = Formulas[po[0]][po[1]];
            target.cells.forEach((k, v) -> {
                int[] temp = getRecOrPointPosition(k).get(0);
                ans[0] += Formulas[temp[0]][temp[1]].val * v;
            });
            return ans[0];
        }

        //对受到影响的边获取拓扑排序
        public void topologicalSort(int po[]) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (Formulas[i][j].cells.containsKey(getStringByPoi(po[0], po[1]))) {
                        topologicalSort(new int[]{i, j});
                    }
                }
            }
            stack.push(new int[]{po[0], po[1]});
        }

        //获取某个位置的坐标，或者某一个矩形的坐标
        public List<int[]> getRecOrPointPosition(String str) {
            List<int[]> list = new ArrayList<>();
            if (str.contains(":")) {
                String sp[] = str.split(":");
                int[] topLeft = getPositionByString(sp[0]);
                int[] bottomRight = getPositionByString(sp[1]);
                for (int i = topLeft[0]; i <= bottomRight[0]; i++) {
                    for (int j = topLeft[1]; j <= bottomRight[1]; j++) {
                        list.add(new int[]{i, j});
                    }
                }
            } else {
                list.add(getPositionByString(str));
            }
            return list;
        }

        private int[] getPosition(int row, char column) {
            return new int[]{row - 1, column - 'A'};
        }

        private int[] getPositionByString(String str) {
            char ch = str.charAt(0);
            str = str.substring(1, str.length());
            return getPosition(Integer.parseInt(str), ch);
        }

        //row 和column是从0开始计算的下标
        private String getStringByPoi(int row, int column) {
            char ch = (char) ('A' + column);
            return String.valueOf(ch) + String.valueOf(row+1);
        }
    }

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
package com.zhanglili31.leetCode.editor.cn;

//716 最大栈
//2022-05-24 16:12:21
class MaxStack {

    public static void main(String[] args) {
//        Solution solution = new MaxStack().new Solution();
//        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
//        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        String testStr = "hello";
//        String strArray[] = {"wrt", "wrf"};
//        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
//        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class MaxStack {
//        Stack<Integer> stack = new Stack<Integer>();
//        Stack<Integer> subStack = new Stack<>();
//
//        public MaxStack() {
//
//        }
//
//        public void push(int x) {
//            if (stack.isEmpty()) {
//                stack.push(x);
//                subStack.push(x);
//            }else{
//                stack.push(x);
//                if(x>subStack.peek()) {
//                    subStack.push(x);
//                }else{
//                    subStack.push(subStack.peek());
//                }
//            }
//
//        }
//
//        public int pop() {
//
//            subStack.pop();
//            return  stack.pop();
//
//        }
//
//        public int top() {
//           return  stack.peek();
//
//        }
//
//        public int peekMax() {
//            return subStack.peek();
//
//        }
//
//        public int popMax() {
//            int i=0;
//            Stack<Integer> temp = new Stack<>();
//            int max=subStack.peek();
//            while (stack.peek() != max) {
//                temp.add(stack.pop());
//                subStack.pop();
//            }
//            int ans=stack.pop();
//            subStack.pop();
//            while (!temp.isEmpty()) {
//                this.push(temp.pop());
//            }
//            return ans;
//        }
//    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
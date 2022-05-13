package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;

//362 敲击计数器
//2022-05-13 15:19:32
class DesignHitCounter {

    public static void main(String[] args) {
//        Solution solution = new DesignHitCounter().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class HitCounter {
        class Node {
            int timestamp;
            int n;
        }

        LinkedList<Node> queue ;
        int ans=0;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        public void hit(int timestamp) {
            ans++;
            if (queue.size() > 0) {
                Node node = queue.peekLast();
                if (node.timestamp == timestamp) {
                    node.n++;
                    return;
                }
            }
            Node node=new Node();
            node.timestamp=timestamp;
            node.n=1;
            queue.add(node);
        }

        public int getHits(int timestamp) {
            while(!queue.isEmpty()) {
                Node node = queue.peekFirst();
                if(timestamp-node.timestamp>=300){
                    ans-=node.n;
                    queue.poll();
                }else{
                    break;
                }
            }
            return ans;
        }
    }

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
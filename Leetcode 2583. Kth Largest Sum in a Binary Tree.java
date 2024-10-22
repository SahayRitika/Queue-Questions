/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> qu= new LinkedList<>();
        PriorityQueue<Long> pq= new PriorityQueue<>(Comparator.reverseOrder());
        qu.add(root);
        qu.add(null);

        long ans=0;

        while(!qu.isEmpty()){
            TreeNode currNode= qu.poll();
            if(currNode==null){
                pq.add(ans);
                ans=0;
                if(qu.isEmpty()){
                    break;
                }else{  
                   qu.add(null);
                }
            }else{
                ans+= currNode.val;
                if(currNode.left!= null){
                    qu.add(currNode.left);
                }
                if(currNode.right!= null){
                    qu.add(currNode.right);
                }
            }
        }
        //System.out.println(pq);
        if(k> pq.size()) return -1;
        while(k--> 0){
            ans=pq.poll();
        }

        return ans;
    }
}

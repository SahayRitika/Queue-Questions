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
    class Pair{
        int sum;
        int level;
        Pair(int sum, int level){
            this.sum= sum;
            this.level= level;
        }
    }
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> qu= new LinkedList<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>((p1, p2) -> p2.sum- p1.sum);

        qu.add(root);
        qu.add(null);
        int sum=0, level=1;

        while(!qu.isEmpty()){
            TreeNode currNode= qu.poll();
            if(currNode== null){//whenever null occurs that mean either tree has even traversed or onr level is completed either cases we'll update the queue first
                pq.add(new Pair(sum, level));
                sum=0;
                level++;
                if(qu.isEmpty()){
                    break;
                }else{
                    qu.add(null);
                }
            }else{
                sum+= currNode.val;
                if(currNode.left!= null){
                    qu.add(currNode.left);
                }
                if(currNode.right!= null){
                    qu.add(currNode.right);
                }
            }
        }

        return pq.poll().level;
    }
}
//can have a more optimised approach

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
    public TreeNode replaceValueInTree(TreeNode root) {
       Queue<TreeNode> qu= new LinkedList<>();
       List<Integer> levelSum= new ArrayList<>();
       //First Bfs for level sum
       qu.offer(root);
       while(!qu.isEmpty()){
        int n= qu.size();
        int sum=0;
        for(int i=0; i<n; i++){
            TreeNode node=qu.poll();
            sum+= node.val;
            if(node.left!=null) qu.add(node.left);
            if(node.right!=null) qu.add(node.right);
        }
        levelSum.add(sum);
       }

       //2nd BFS to change values
       qu.offer(root);
       root.val=0;
       int level=0;
       while(!qu.isEmpty()){
        int n= qu.size();
        
        int nextLevelSum=level+1< levelSum.size()? levelSum.get(level+1) : 0;

        for(int i=0; i<n; i++){
            TreeNode node= qu.poll();
            int childSum=0;
        if(node.left!= null){
            childSum+= node.left.val;
            qu.offer(node.left);
        }

        if(node.right!= null){
            childSum+= node.right.val;
            qu.offer(node.right);
        }

        if(node.left!= null) node.left.val= nextLevelSum - childSum;
        if(node.right!= null) node.right.val= nextLevelSum - childSum;
       }
       level++;
       }

       return root;

    }
}

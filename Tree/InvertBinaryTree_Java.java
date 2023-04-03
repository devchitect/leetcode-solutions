// Invert Binary Tree
// Given the root of a binary tree, invert the tree, and return its root.
/*
Example :
		Input: root = [4,2,7,1,3,6,9]
		Output: [4,7,2,9,6,3,1]
*/

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
 
 //Recursive approach
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;

        return root;
    }
}

/*
Complexity Analysis

Since each node in the tree is visited only once, the time complexity is O(n), where nnn is the number of nodes in the tree. 
We cannot do better than that, since at the very least we have to visit each node to invert it.

Because of recursion, O(h)function calls will be placed on the stack in the worst case, where hhh is the height of the tree. 
Because h\in O(n), the space complexity is O(n).
*/

//Iterative ~  similar to breadth-first search.
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}

/*
Complexity Analysis

Since each node in the tree is visited / added to the queue only once, the time complexity is O(n), where nnn is the number of nodes in the tree.

Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. 

*/

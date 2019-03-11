package Algorithms;
import java.util.*;
public class Trees {
	//used in ISVALIDBST, need to refactor code to remove it
	Integer previousNodeVal = null;

	//	Given a binary tree, determine if it is a valid binary search tree (BST).
	//	Assume a BST is defined as follows:
	//	The left subtree of a node contains only nodes with keys less than the node's key.
	//	The right subtree of a node contains only nodes with keys greater than the node's key.
	//	Both the left and right subtrees must also be binary search trees.
	public boolean isValidBST(Tree_Node root) {
		if(null == root) return true;
		if(null == root.left && null == root.right) return true;
		return isValidBSTHelper(root);
	}
	public boolean isValidBSTHelper(Tree_Node node) {
		boolean res = true;
		if(null != node.left) {
			res = isValidBSTHelper(node.left);
		}
		if(!res) return res;

		if(null != previousNodeVal && previousNodeVal >= node.val) {
			return false;
		}
		previousNodeVal = node.val;

		if(null != node.right) {
			res = isValidBSTHelper(node.right);
		}
		return res;
	}
    //  Given a binary tree, find the leftmost value in the last row of the tree.
	public int findBottomLeftValue(Tree_Node root) {
        Queue<Tree_Node> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
    }
	
	
	
}

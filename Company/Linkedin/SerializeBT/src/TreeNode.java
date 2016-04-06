
public class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int x) {
		this.val = x;
		this.left = null;
		this.right = null;
	}

	public static void printTree(TreeNode root, String indent) {
		if (root != null) {
			printTree(root.right, indent + "   ");
			System.out.println(indent + " " + root.val);
			printTree(root.left, indent + "   ");
		}
	}
}

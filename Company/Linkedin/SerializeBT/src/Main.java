
public class Main {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		//root.right.left = new TreeNode(4);
		//root.right.right = new TreeNode(5);
		TreeNode.printTree(root, "");
		SerializeDeserialize sd = new Codec();
		System.out.println("The serialized data is:" + sd.serialize(root));
		System.out.println("The deserialized binary tree of " + sd.serialize(root) + " is:");
		TreeNode.printTree(sd.deserialize(sd.serialize(root)), "");

	}
}

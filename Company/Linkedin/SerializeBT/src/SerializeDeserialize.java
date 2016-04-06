
public interface SerializeDeserialize {
	/*
	 * Input a binary tree, serialize such tree into a string where value and
	 * '#' represents node value and null node respectively.
	 */
	public String serialize(TreeNode root);

	/*
	 * Input a string data, convert such data into a balanced binary tree.
	 */
	public TreeNode deserialize(String data);
}

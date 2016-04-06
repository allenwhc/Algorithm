import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec implements SerializeDeserialize {
	/*
	 * Serialize uses queue implementation 
	 * Time complexity: O(h*2^(h-1)), h is height of binary tree 
	 * Extra space: O(2^(h-1))
	 * 
	 * @see SerializeDeserialize#serialize(TreeNode)
	 */
	public String serialize(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) return "";
		StringBuilder result = new StringBuilder("[");
		Queue<TreeNode> curr_lv = new LinkedList<>();
		boolean finished = false;
		curr_lv.offer(root);

		while (!finished && !curr_lv.isEmpty()) {
			int size = curr_lv.size();
			Queue<TreeNode> next_lv = new LinkedList<>();
			finished=true;
			//System.out.println(Arrays.asList(curr_lv));
			while (!curr_lv.isEmpty()) {
				TreeNode node = curr_lv.poll();
				if (node == null) {
					result.append("null").append(',');
					continue;
				}
				result.append(String.valueOf(node.val)).append(',');
				if (node.left != null || node.right != null)
					finished=false;
				next_lv.offer(node.left);
				next_lv.offer(node.right);
			}
			//System.out.println(result+","+finished);
			curr_lv = next_lv;
		}
		return result.deleteCharAt(result.length() - 1).append(']').toString();
	}

	/*
	 * Deserialize using queue 
	 * Time complexity : O(n), n is length of data Extra
	 * space: O(n)
	 * 
	 * @see SerializeDeserialize#deserialize(java.lang.String)
	 */
	public TreeNode deserialize(String data) {
		// TODO Auto-generated method stub
		if (data == null || data.length() == 0) return null;
		String[] node_val = data.substring(1, data.length() - 1).split(",");
		TreeNode root = new TreeNode(Integer.valueOf(node_val[0]));
		boolean is_left_child = true;
		TreeNode parent = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		for (int i = 1; i < node_val.length; i++) {
			TreeNode child = null;
			if (!node_val[i].equals("null")) {
				child = new TreeNode(Integer.valueOf(node_val[i]));
				q.offer(child);
			}
			if (is_left_child) {
				parent = q.poll();
				parent.left = child;
				is_left_child = false;
			} else {
				parent.right = child;
				is_left_child = true;
			}
		}
		return root;
	}

}

public class TreeNode {
	private Character c;
	private TreeNode left, right;

	public TreeNode (Character c) {
		this.c= c;
		left= null;
		right= null;
	}

	public TreeNode getLeft() {
		return left;
	}
	public TreeNode getRight() {
		return right;
	}

	public void setLeft(Character c) {
		left= new TreeNode(c);
	}
	public void setRight(Character c) {
		right= new TreeNode(c);
	}

	public Character getValue() {
		return c;
	}
	public String toString() {
		return c.toString();
	}
}
public class BinaryTree {

	private int size;
	private TreeNode root;

	public BinaryTree() {

	}

	public int getSize() {
		return size;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void add(Character c) {
		if (root==null) {
			root= new TreeNode(c);
			size++;
			return;
		}

		TreeNode nextTreeNode= root;
		while (true) {
			if (nextTreeNode.getValue().equals(c))
				break;
			if (c.compareTo(nextTreeNode.getValue())==-1) {
				System.out.println("Left");
				if (nextTreeNode.getLeft()==null) {
					nextTreeNode.setLeft(c);
					break;
				}
				else {
					nextTreeNode= nextTreeNode.getLeft();
				}
			}
			else if (c.compareTo(nextTreeNode.getValue())==1) {
				System.out.println("Right");
				if (nextTreeNode.getRight()==null) {
					nextTreeNode.setRight(c);
					break;
				}
				else {
					nextTreeNode= nextTreeNode.getRight();
				}
			}
		}

		if (nextTreeNode==null) {
			nextTreeNode= new TreeNode(c);
			size++;
		}
	}

	public String preOrder(TreeNode t) {
		if (t==null)
			return "";
		return t.getValue()+" "+preOrder(t.getLeft())+" "+preOrder(t.getRight());
	}

	public String preOrderToString() {
		return "PreOrder: "+shortenStr(preOrder(root));
	}

	public String inOrder(TreeNode t) {
		if (t==null)
			return "";
		return inOrder(t.getLeft())+" "+t.getValue()+" "+inOrder(t.getRight());
	}

	public String inOrderToString() {
		return "InOrder: "+shortenStr(inOrder(root));
	}

	public String postOrder(TreeNode t) {
		if (t==null)
			return "";
		return postOrder(t.getLeft())+" "+postOrder(t.getRight())+" "+t.getValue();
	}

	public String postOrderToString() {
		return "PostOrder: "+shortenStr(postOrder(root));
	}

	public String shortenStr(String str) {
		String newStr= "";
		for (int i=0; i<str.length(); i++)
			if (!str.substring(i,i+1).equals(" "))
				newStr+= str.substring(i,i+1)+" ";
		return newStr;
	}
}
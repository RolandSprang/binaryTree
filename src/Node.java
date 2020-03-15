/**
 * Singel node of a binary tree. <br>
 * A node is a sub-element of a binary tree. A node has its own integer value,
 * points to its parent node and can have a left and right node.<br>
 * The sorting of nodes is defined by the binary tree class.
 * 
 * @author Roland Sprang
 *
 */
public class Node {
	private int value;		// value of the current node
	private int level;		// level of the node in a binary tree
	
	private Node left;		
	private Node right;
	private Node parent;
	
	/**
	 * Creates a new {@link Node} for a binary tree.
	 * 
	 * @param value the value of the node
	 * @param parent the parent-node of the current node
	 * @param level the level of the current node
	 */
	public Node(int value, Node parent, int level) {
		this.value = value;
		this.parent = parent;
		this.level = level;
	}
	
	/**
	 * Returns the highest level of the following {@link Node}s.
	 * 
	 * @return the highest level of the node strand as {@link Integer}
	 */
	public int height() {
		int l = 0;
		int r = 0;
		if(this.left != null)
		{
			l = this.left.height() + 1;
		}
		if(this.right != null)
		{
			r = this.right.height() + 1;
		}
		return Math.max(l, r);
	}

// Getters & Setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}

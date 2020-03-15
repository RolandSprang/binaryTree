import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple partially ordered binary tree that is composed of child nodes.
 * The first number that will be inserted is the root node.<br>
 * A number that is smaller than the parent node is appended as a left subnode.<br>
 * A number that is greater than the parent node is appended as a right subnode.<br>
 * At the end, for example, the result looks like this:<br>
 * 	   6 		<br>
 *    / \		<br>
 *   3   7		<br>
 *  /\   /\		<br>
 * 1  2    9	<br>
 * 
 * @author Roland Sprang
 *
 */
public class BinaryTree{
	private Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	/**
	 * Inserts a number into a {@link BinaryTree} Object. <br> 
	 * The function creates a new {@link Node} an insert the value into it.<br>
	 * The numbers will be partciel sorted.
	 * 
	 * @param value the number that has to be insert into the {@link Node} of a binarySearchTree
	 */
	public void insert(int value) {
		
		if(root == null) 
			root = new Node(value, null, 0);
		else 
			insert(root, value); 	
	}
	
	/**
	 * Inserts a {@link ArrayList} into a {@link BinaryTree} Object. <br> 
	 * The function creates a new {@link Node} for every number an insert the value into it.<br>
	 * The numbers will be partciel sorted.
	 * 
	 * @param arLs An ArrayList which contains {@link Integer}
	 */
	public void insertArray(ArrayList<Integer> arLs) {
		Iterator<Integer> itr = arLs.iterator();
		while(itr.hasNext()) {
			int i = itr.next();
			insert(i); 
		}
	}

	private void insert(Node node, int value) {
		if(node.getValue() >= value) {
			if(node.getLeft() == null) {
				node.setLeft(new Node(value, node, node.getLevel() + 1));
			}
			else 
				insert(node.getLeft(),value);
		}
		else
			if(node.getRight() == null) {
				node.setRight(new Node(value, node, node.getLevel() + 1));
			}
			else
				insert(node.getRight(), value);
	}
	
	/**
	 * Returns the height of a {@link BinaryTree}
	 * 
	 * @return the height of the BinarySearchTree as {@link Integer}.
	 */
	public int height()
	{
		int l = 0;
		int r = 0;
		if(root.getLeft() != null)
		{
			l = root.getLeft().height() + 1;
		}
		if(root.getRight() != null)
		{
			r = root.getRight().height() + 1;
		}
		return Math.max(l, r);
	}
	


	/**
	 * Calculates the number of notes of a {@link BinaryTree}
	 * 
	 * @return the number of nodes of the tree as {@link Integer}
	 */
	public int numberOfNodes() {
		if(root == null)
			return 0;
		else
			return 1 + numberOfNodes(root.getLeft()) + numberOfNodes(root.getRight());
	}
	
	private int numberOfNodes(Node parent) {
		if(parent == null)
			return 0;
		else
			return 1 + numberOfNodes(parent.getLeft()) + numberOfNodes(parent.getRight());
		
	}
	
	/**
	 * Returns the lowest value in the binary tree.
	 * @return the lowest value in the tree as {@link Integer}
	 */
	public int getMin() {
		Node treeRoot = this.root;
		int minValue = treeRoot.getValue();
		if (treeRoot != null) {
			if(treeRoot.getLeft() != null) {
				if(treeRoot.getLeft().getValue() < treeRoot.getValue())
					minValue = treeRoot.getLeft().getValue();
				return getMin(treeRoot.getLeft(), minValue);
			}
		}
		return minValue;
	}
	
	private int getMin(Node parent, int minValue) {
			if(parent.getLeft() != null) {
				if(parent.getLeft().getValue() < parent.getValue())
					minValue = parent.getLeft().getValue();
				return getMin(parent.getLeft(), minValue);
			}
		return minValue;
	}
	
	/**
	 * Returns the highest value in the binary tree.
	 * @return the lowest value in the tree as {@link Integer}
	 */
	public int getMax() {
		Node treeRoot = this.root;
		int maxValue = treeRoot.getValue();
		if (treeRoot != null) {
			if(treeRoot.getRight() != null) {
				if(treeRoot.getRight().getValue() > treeRoot.getValue())
					maxValue = treeRoot.getRight().getValue();
				return getMaxValue(treeRoot.getRight(), maxValue);
			}
		}
		return maxValue;
	}
	
	private int getMaxValue(Node node, int maxValue) {
		if (node != null) {
			if(node.getRight() != null) {
				if(node.getRight().getValue() > node.getValue())
					maxValue = node.getRight().getValue();
				return getMaxValue(node.getRight(), maxValue);
			}
		}
		return maxValue;
	}
	
	/**
	 * Prints the {@link BinaryTree} on the console vertically.<br>
	 * The output is 'inorder' sorted, from the left to the right.
	 */
	public void printTree() {
		if(this.root != null) {
			Node treeRoot = this.root;
			// print left tree nodes
			if (treeRoot.getLeft() != null)
				printInOrder(treeRoot.getLeft());
			// print root value
			System.out.println(treeRoot.getValue() + "|");
			// print right tree nodes
			if(treeRoot.getRight()  != null)
				printInOrder(treeRoot.getRight());
		}
		else
			System.out.println("Empty tree");
	}
	
	private void printInOrder(Node node) {
		// print left/ right value
		if (node.getLeft() != null) {
			printInOrder(node.getLeft());
		}
		
		printNoteValue(node);
		
		if(node.getRight() != null) {
			printInOrder(node.getRight());
		}
	}

	private void printNoteValue(Node node) {
		for(int i = 0; i < node.getLevel() * 3; i++) {
			
			System.out.print(" ");
		}
		System.out.println("|" + node.getValue());
	}

	/**
	 * Returns the sum of all values of the binary tree.
	 * 
	 * @return the sum of all values as {@link Float}
	 */
	public float getSum() {
		Node root = this.root;
		float sum = root.getValue();
		
		// get parent node Value
		if(root != null) {
			if(root.getLeft() != null) {
				sum = getSum(root.getLeft(),sum);
			}
			if(root.getRight() != null) {
				sum = getSum(root.getRight(), sum);
			}
		}
		return sum;
	}

	private float getSum(Node node, float sum) {
		if(node.getLeft() != null) {
			sum = getSum(node.getLeft(), sum);
		}
		if(node.getRight() != null) {
			sum = getSum(node.getRight(), sum);
		}
		return node.getValue() + sum;
	}

	/**
	 * Returns the average of all values of the binary tree.
	 * 
	 * @return the average of all values of the binary tree as {@link Float}
	 */
	public float getAVG() {
		return getSum() / numberOfNodes();
	}

	public Node getRoot() {
		return root;
	}
}

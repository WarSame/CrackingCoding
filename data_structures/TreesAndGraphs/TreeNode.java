package data_structures.TreesAndGraphs;

public class TreeNode<E extends Comparable<E>> {
	private TreeNode<E> left;
	private TreeNode<E> right;
	private E data;
	private int depth;//Distance from top of tree to this node
	private int index;//Distance from left of tree to this node in number of elements
	public TreeNode(E data){//Creates root
		this(data,0,0);
	}
	public TreeNode(E data, int depth, int totalIndex){//Creates normal node
		this.left = null;
		this.right = null;
		this.data = data;
		this.depth = depth;
		this.index = totalIndex;
	}
	public TreeNode<E> getLeft(){
		return this.left;
	}
	public TreeNode<E> getRight(){
		return this.right;
	}
	public TreeNode<E> getChild(E data){
		if (this.getData().compareTo(data)<0){//If currentNode < data then data goes to the right
			return this.getRight();
		}
		//If currentNode >= data then data goes to the left
		return this.getLeft();
	}
	public void setChild(E data){
		if (this.getData().compareTo(data)<0){
			this.setRight(data);
			return;
		}
		this.setLeft(data);
	}
	public void setLeft(E data){
		this.left = new TreeNode<E>(data, this.depth+1, this.index*2);
	}
	public void setRight(E data){
		this.right = new TreeNode<E>(data, this.depth+1, this.index*2 + 1);
	}
	public int getDepth(){
		return this.depth;
	}
	public int getIndex(){
		return this.index;
	}
	public boolean isLeaf(){
		if (this.right==null&&this.left==null){
			return true;
		}
		return false;
	}
	public E getData(){
		return this.data;
	}
}

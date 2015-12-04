package data_structures.TreesAndGraphs;

public class TreeNode<E extends Comparable<E>> {
	private TreeNode<E> left;
	private TreeNode<E> right;
	private E data;
	private int distance;
	public TreeNode(E data){
		this.left = null;
		this.right = null;
		this.data = data;
		this.distance = 0;
	}
	public TreeNode(E data, int distance){
		this.left = null;
		this.right = null;
		this.data = data;
		this.distance = distance;
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
			this.setRight(data, distance+1);
			return;
		}
		this.setLeft(data,distance+1);
	}
	public void setLeft(E data, int distance){
		this.left = new TreeNode<E>(data, distance);
	}
	public void setRight(E data, int distance){
		this.right = new TreeNode<E>(data, distance);
	}
	public int getDistance(){
		return this.distance;
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

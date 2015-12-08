package data_structures.TreesAndGraphs;

public class TreeNode<E extends Comparable<E>> {
	private TreeNode<E> left;
	private TreeNode<E> right;
	private E data;
	private int index;//Distance from left of tree to this node in number of elements
	public TreeNode(E data){//Creates root
		this(data,0);
	}
	public TreeNode(){//Creates empty node
		this(null,0);
	}
	public TreeNode(E data, int totalIndex){//Creates normal node
		this.left = null;
		this.right = null;
		this.data = data;
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
	public void replace(TreeNode<E> child){//Replaces this with the input node
		this.setRightFromNode(child.getRight());
		this.setLeftFromNode(child.getLeft());
	}
	public void setChild(E data){
		if (this.getData().compareTo(data)<0){
			this.setRight(data);
			return;
		}
		this.setLeft(data);
	}
	public void setChild(TreeNode<E> data){
		if (this.getData().compareTo(data.getData())<0){
			this.setRightFromNode(data);
			return;
		}
		this.setLeftFromNode(data);
	}
	public void setLeft(E data){
		this.left = new TreeNode<E>(data, this.index*2);
	}
	public void setLeftFromNode(TreeNode<E> data){
		this.left = data;
	}
	public void setRight(E data){
		this.right = new TreeNode<E>(data, this.index*2 + 1);
	}
	public void setRightFromNode(TreeNode<E> data){
		this.right = data;
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
	public boolean remove(E data, TreeNode<E> parent){
		if (data.compareTo(this.getData())<0){//Tack left
			if (this.getLeft()!=null){
				return this.getLeft().remove(data,this);
			}
			else {
				return false;
			}
		}
		else if (data.compareTo(this.getData())>0){//Tack right
			if (this.getRight()!=null){
				return this.getRight().remove(data, this);
			}
			else {
				return false;
			}
		}
		else {//This is the node in question
			if (this.getLeft()!=null&&this.getRight()!=null){//2 children - tricky
				this.data = this.getRight().minValue();
				this.getRight().remove(this.getData(), this);
			}
			else if (parent.getRight()==this){//Right child only
				if (this.getLeft()==null){
					parent.setRightFromNode(this.getRight());
				}
				else {
					parent.setRightFromNode(this.getLeft());
				}
			}
			else {//Left child only
				if (this.getLeft()==null){
					parent.setLeftFromNode(this.getRight());
				}
				else {
					parent.setLeftFromNode(this.getLeft());
				}
			}
			return true;
		}
	}
	public E minValue(){
		if (this.getLeft()==null){
			return this.getData();
		}
		return left.minValue();
	}
}

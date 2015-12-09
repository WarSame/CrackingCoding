package data_structures.TreesAndGraphs;

public class TreeNode<E extends Comparable<E>> {
	private TreeNode<E> left;
	private TreeNode<E> right;
	private TreeNode<E> parent;
	private E data;
	public TreeNode(E data){
		this.left = null;
		this.right = null;
		this.data = data;
	}
	public TreeNode(){//Creates empty node
		this(null);
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
	public TreeNode<E> getParent(){
		return this.parent;
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
	public void setParent(TreeNode<E> parent){
		this.parent = parent;
	}
	public void setLeft(E data){
		this.left = new TreeNode<E>(data);
		if (data!=null){
			this.left.setParent(this);
		}
	}
	public void setLeftFromNode(TreeNode<E> data){
		this.left = data;
		if (data!=null){
			this.left.setParent(this);
		}
	}
	public void setRight(E data){
		this.right = new TreeNode<E>(data);
		if (data!=null){
			this.right.setParent(this);
		}
	}
	public void setRightFromNode(TreeNode<E> data){
		this.right = data;
		if (data!=null){
			this.right.setParent(this);
		}
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

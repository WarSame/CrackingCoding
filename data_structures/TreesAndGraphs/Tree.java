package data_structures.TreesAndGraphs;

import java.util.LinkedList;

public class Tree<E extends Comparable<E>> {
	private TreeNode<E> root;
	public Tree(){
		this.root = null;
	}
	public Tree(E data){
		this.root = new TreeNode<E>(data);
	}
	public TreeNode<E> getRoot(){
		return this.root;
	}
	public void insert(E data){
		TreeNode<E> currentNode = this.root;
		if (currentNode==null){
			this.root = new TreeNode<E>(data,0);
			return;
		}
		TreeNode<E> child;
		while (true){
			child = currentNode.getChild(data);
			if (child==null){
				break;
			}
			currentNode = child;
		}
		currentNode.setChild(data);
	}
	public void print(){//BFS to print the tree
		TreeNode<E> currentNode = this.root;
		if (currentNode==null){
			return;
		}
		LinkedList<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(currentNode);
		int currentDistance = 0;
		StringBuilder s = new StringBuilder();
		while (q.peek()!=null){//While there are nodes left to print
			currentNode = q.remove();
			if (currentNode.getDistance()>currentDistance){//If we hit a new level
				System.out.println(s);
				s = new StringBuilder();
				currentDistance++;
			}
			s.append(currentNode.getData()+" ");
			TreeNode<E> leftChild = currentNode.getLeft();
			TreeNode<E> rightChild = currentNode.getRight();
			if (leftChild!=null){
				//System.out.println("Adding left");
				q.add(leftChild);
			}
			if (rightChild!=null){
				//System.out.println("Adding right");
				q.add(rightChild);
			}
			//System.out.println(q.remove());
			//System.out.println(currentNode.getData()+"data");
		}
		System.out.println(s);
	}
	public TreeNode<E> find(E searchData){
		TreeNode<E> n = this.root;
		E nodeData = n.getData();
		while (n!=null&&nodeData!=searchData){
			if (nodeData.compareTo(searchData)<0){
				n = n.getRight();
			}
			else {
				n = n.getLeft();
			}
		}
		return n;//Either null or the correct result
	}
	public void delete(E delData){
		TreeNode<E> n = this.root;
		E nodeData = n.getData();
		while (n!=null && nodeData!=delData){
			if (nodeData.compareTo(delData)<0){
				n = n.getRight();
			}
			else {
				n = n.getLeft();
			}
			nodeData = n.getData();
		}
		if (n.isLeaf()){
			n=null;
			return;
		}
		//Trickier if it has children - have to make sure they get moved up appropriately
	}
}

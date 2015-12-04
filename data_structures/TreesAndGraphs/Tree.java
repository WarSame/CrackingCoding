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
			this.root = new TreeNode<E>(data);
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
		LinkedList<TreeNode<E>> level = new LinkedList<TreeNode<E>>();
		q.add(currentNode);
		level.add(currentNode);
		int currentDistance = 0;
		while (q.peek()!=null){
			//While there are nodes left to print
			currentNode = q.peek();
			if (currentNode.getDepth()>currentDistance){
				//If we hit a new level
				System.out.println(getLevel(currentDistance, level));
				//Level is empty now, so we need to refill it from q
				level = new LinkedList<TreeNode<E>>(q);
				currentDistance++;
			}
			q.remove();
			//Add the children to the q
			addChildren(q, currentNode);
		}
		//System.out.println("level"+level.peek().getData());
		//level = new LinkedList<TreeNode<E>>(q);
		System.out.println(getLevel(currentDistance,level));
	}
	private void addChildren(LinkedList<TreeNode<E>> q, TreeNode<E> currentNode) {
		TreeNode<E> leftChild = currentNode.getLeft();
		TreeNode<E> rightChild = currentNode.getRight();
		if (leftChild!=null){
			q.add(leftChild);
		}
		if (rightChild!=null){
			q.add(rightChild);
		}
	}
	public StringBuilder getLevel(int currentDistance, LinkedList<TreeNode<E>> level){
		//System.out.println("depth is "+currentDistance);
		StringBuilder s = new StringBuilder();
		for (int i = 0; i<Math.pow(2,currentDistance);i++){
			//Loop through the current level
			TreeNode<E> n = level.peek();
			if (n==null){
				return s;
			}
			//System.out.println("loop index is "+i);
			//System.out.println("node index is "+n.getIndex());
			if (n.getIndex()==i){
				//If it is a node
				s.append(level.remove().getData()+" ");
			}
			else {
				//Empty node
				s.append("- ");
			}
		}
		//System.out.println("exiting getlevel");
		return s;
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

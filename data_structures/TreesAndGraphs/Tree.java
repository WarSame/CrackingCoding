package data_structures.TreesAndGraphs;

import java.util.LinkedList;

public class Tree<E extends Comparable<E>> {
	private TreeNode<E> root;
	private int height;
	public Tree(){
		this.root = null;
	}
	public Tree(E data){
		this.root = new TreeNode<E>(data);
	}
	public TreeNode<E> getRoot(){
		return this.root;
	}
	public int getHeight(TreeNode<E> n){
		if (n==null){
			return -1;
		}
		return Math.max(getHeight(n.getLeft()), getHeight(n.getRight()))+1;
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
		this.height = getHeight(this.root);
		if (currentNode==null){
			return;
		}
		LinkedList<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(currentNode);
		LinkedList<TreeNode<E>> level = new LinkedList<TreeNode<E>>(q);
		int currentDepth = 0;
		while (q.peek()!=null){
			//While there are nodes left to print
			currentNode = q.peek();
			if (currentNode.getDepth()>currentDepth){
				//If we hit a new level
				System.out.println(getLevel(currentDepth, level));
				//Level is empty now, so we need to refill it from q
				level = new LinkedList<TreeNode<E>>(q);
				currentDepth++;
			}
			q.remove();
			//Add the children to the q
			addChildren(q, currentNode);
		}
		System.out.println(getLevel(currentDepth,level));
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
	public StringBuilder getLevel(int currentDepth, LinkedList<TreeNode<E>> level){
		//Return a string representing the current level of the tree
		StringBuilder s = new StringBuilder();
		int currentWidth = (int) Math.pow(2,currentDepth);
		int maxWidth = (int) Math.pow(2,this.height);
		s.append(getSideBufferSpaces(currentWidth, maxWidth));
		for (int i = 0; i<currentWidth;i++){
			//Loop through the current level
			TreeNode<E> n = level.peek();
			if (n==null){
				return s;
			}
			if (n.getIndex()==i){
				//If it is a node
				s.append(level.remove().getData()+" ");
			}
			else {
				//Empty node
				s.append("- ");
			}
		}
		return s;
	}
	private String getSideBufferSpaces(int currentWidth, int maxWidth) {
		if (currentWidth == maxWidth){
			return "";
		}
		int widthDifference = maxWidth - currentWidth;
		int sideWidth = (widthDifference)/2;
		StringBuilder s = new StringBuilder();
		for (int i =0;i<sideWidth;i++){
			s.append("  ");
		}
		return s.toString();
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

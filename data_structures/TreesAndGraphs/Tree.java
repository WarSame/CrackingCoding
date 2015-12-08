package data_structures.TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
	public int getHeight(){
		return getHeightRecurse(this.root);
	}
	public int getHeightRecurse(TreeNode<E> n){
		if (n==null){
			return -1;
		}
		return Math.max(getHeightRecurse(n.getLeft()), getHeightRecurse(n.getRight()))+1;
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
	public void print(){
		printTree(this.root);
	}
	private void printTree(TreeNode<E> root){//BFS to print the tree
		Queue<TreeNode<E>> currentLevel = new LinkedList<TreeNode<E>>();
		Queue<TreeNode<E>> nextLevel = new LinkedList<TreeNode<E>>();
		currentLevel.add(root);
		int level = 0;
		int maxHeight = this.getHeight();
		while (!currentLevel.isEmpty() && level<maxHeight){
			System.out.print(getSideBufferSpaces((int)Math.pow(2,level), (int)Math.pow(2,maxHeight-1)));
			Iterator<TreeNode<E>> iter = currentLevel.iterator();
			while (iter.hasNext()){
				TreeNode<E> currentNode = iter.next();
				if (currentNode.getData()==null){
					System.out.print("- ");
					nextLevel.add(new TreeNode<E>());//Add 2 dummy children
					nextLevel.add(new TreeNode<E>());
					continue;
				}
				if (currentNode.getLeft()!=null){//Add left or
					nextLevel.add(currentNode.getLeft());
				}
				else {//Add empty node
					nextLevel.add(new TreeNode<E>());
				}
				if (currentNode.getRight()!=null){
					nextLevel.add(currentNode.getRight());
				}
				else {
					nextLevel.add(new TreeNode<E>());
				}
				System.out.print(currentNode.getData()+" ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode<E>>();
			level++;
		}
	}
	private String getSideBufferSpaces(int currentWidth, int maxWidth) {
		if (currentWidth == maxWidth){
			return "";
		}
		int widthDifference = maxWidth - currentWidth;
		int sideWidth = (1+widthDifference)/2;//To centralize it
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
	public boolean remove(E data){
		if (this.root==null){
			return false;
		}
		if (this.root.getData()==data){
			TreeNode<E> auxRoot = new TreeNode<E>();
			auxRoot.setLeftFromNode(this.root);
			boolean ret = root.remove(data, auxRoot);
			this.root = auxRoot.getLeft();
			return ret;
		}
		else {
			return this.root.remove(data, null);
		}
	}
}

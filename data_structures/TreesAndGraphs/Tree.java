package data_structures.TreesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Tree<E extends Comparable<E>> {
	private TreeNode<E> root;
	public Tree(){
		this.root = null;
	}
	public Tree(E data){
		this.root = new TreeNode<E>(data);
	}
	public Tree(TreeNode<E> n){
		this.root = n;
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
		if (this.root==null){
			throw new NoSuchElementException();
		}
		printTree(this.root);
	}
	private void printTree(TreeNode<E> root){//BFS to print the tree
		Queue<TreeNode<E>> currentLevel = new LinkedList<TreeNode<E>>();
		Queue<TreeNode<E>> nextLevel = new LinkedList<TreeNode<E>>();
		currentLevel.add(root);
		int level = 0;
		int maxHeight = this.getHeight();
		while (!currentLevel.isEmpty() && level<maxHeight+1){
			System.out.print(getSideBufferSpaces((int)Math.pow(2,level), (int)Math.pow(2,maxHeight)));
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
			if (nodeData.compareTo(searchData)<0){//nodeData - searchData <0
				n = n.getRight();
			}
			else {
				n = n.getLeft();
			}
			nodeData = n.getData();
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
	public int maxDepth(TreeNode<E> n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(n.getLeft()), maxDepth(n.getRight()));
	}
		
	public int minDepth(TreeNode<E> n) {
		if (n == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(n.getLeft()), minDepth(n.getRight()));
	}
	
	public boolean isBalanced(){
		return isBalanced(this.root);
	}
	public boolean isBalanced(TreeNode<E> root){
		//Gives 2 and 5 instead of 3 and 5
		int max = maxDepth(root);
		int min = minDepth(root);
		return ((max-min) <= 1);
	}
	public static <E extends Comparable<E>> Tree<E> treeFromArray(E[] A){
		return new Tree<E>(fromArrayRecurse(A,0,A.length-1));
	}
	private static <E extends Comparable<E>> TreeNode<E> fromArrayRecurse(E[] A, int min, int max){
		if (max<min){
			return null;
		}
		int mid = (max + min)/2; 
		TreeNode<E> n = new TreeNode<E>(A[mid]);
		n.setLeftFromNode(fromArrayRecurse(A, min, mid-1));
		n.setRightFromNode(fromArrayRecurse(A, mid+1, max));
		return n;
	}
	public TreeNode<E> getSuccessor(TreeNode<E> source){
		//If node has a right child, then successor is min of that child
		//If not, track up. If source was a left child, parent is successor.
		//If source was a right child, find the successor of parent
		if (source == null){
			return null;
		}
		if (source.getParent()==null||source.getRight()!=null){
			return findMin(source.getRight());
		}
		TreeNode<E> parent = source.getParent();
		while (parent!=null){
			if (parent.getLeft()==source){
				return parent;
			}
			source = parent;
			parent = source.getParent();
		}
		return parent;
	}
	public TreeNode<E> findMin(TreeNode<E> n){//Find minimum child of a node
		TreeNode<E> leftChild = n.getLeft();
		if (leftChild==null){
			return null;
		}
		return findMin(leftChild);
	}
}

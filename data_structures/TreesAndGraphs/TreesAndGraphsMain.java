package data_structures.TreesAndGraphs;

public class TreesAndGraphsMain {

	public static void main(String[] args) {
		Integer[] i = new Integer[]{1,2,3,5,6,7,8,9,12,16};
		Tree<Integer> t = Tree.treeFromArray(i);
		t.print();
		System.out.println(t.getSuccessor(t.find(8)).getData());
	}

}

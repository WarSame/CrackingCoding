package data_structures.TreesAndGraphs;

public class TreesAndGraphsMain {

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<Integer>();
		t.insert(4);
		t.insert(3);
		t.insert(6);
		t.insert(8);
		t.print();
		//System.out.println(t.getRoot().getRight().getData());
	}

}

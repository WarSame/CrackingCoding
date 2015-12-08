package data_structures.TreesAndGraphs;

public class TreesAndGraphsMain {

	public static void main(String[] args) {
		Tree<Integer> t = new Tree<Integer>();
		t.insert(4);
		t.insert(3);
		t.insert(6);
		t.insert(8);
		t.insert(1);
		t.insert(17);
		t.insert(19);
		t.insert(20);
		t.insert(17);
		t.remove(6);
		t.print();
		//System.out.println(t.getHeight(t.getRoot()));
	}

}

package data_structures.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pair.Pair;

public class Graph{
	List<GraphNode> allNodes;
	public Graph(){
		allNodes = new ArrayList<GraphNode>();
	}
	public boolean pathExists(GraphNode source, GraphNode destination){
		//Return true if a path exists from source to destination
		LinkedList<GraphNode> nodes = new LinkedList<GraphNode>();
		nodes.add(source);
		while (!nodes.isEmpty()){//BFS search
			GraphNode currentNode = nodes.remove();
			for (Pair<Integer,GraphNode> edge:currentNode.getEdges()){
				GraphNode n = edge.getR();
				if (n==destination){
					return true;
				}
				if (!n.getVisited()){//Mark incoming edges
					n.setVisited(true);
					nodes.add(n);
				}
			}
		}
		return false;
	}
	public void add(GraphNode n){
		allNodes.add(n);
	}
}

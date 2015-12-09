package data_structures.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import pair.Pair;

public class GraphNode {
	List<Pair<Integer, GraphNode>> outVertices;
	private boolean visited;
	public GraphNode(){
		visited = false;
		outVertices = new LinkedList<Pair<Integer, GraphNode>>();
	}
	public GraphNode(LinkedList<Pair<Integer,GraphNode>> pairs){
		this.outVertices = pairs;
		visited = false;
	}
	public boolean getVisited(){
		return this.visited;
	}
	public void setVisited(boolean val){
		this.visited=val;
	}
	public void addEdge(Integer weight, GraphNode destination){
		outVertices.add(new Pair<Integer, GraphNode>(weight, destination));
	}
	public List<Pair<Integer,GraphNode>> getEdges(){
		return this.outVertices;
	}
	
}

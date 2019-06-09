import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class ADTGraph {
	
	HashMap<VertexNode, HashSet<VertexNode>> map = new HashMap<>();
	
	/**
	 * Adds a Vertex to the HashMap of the Graph.
	 * 
	 * @param node The node to add to the Map.
	 * @return a boolean, true if the insertion was successful, false otherwise.
	 */
	public boolean addVertex(VertexNode node)
	{
		if(this.map.containsKey(node))
			return false;
		else {
			this.map.put(node, new HashSet<VertexNode>());
			return true;
		}
	}
	/**
	 * Adds an edge to the Graph with two VertexNodes.
	 * @param a - First Node
	 * @param b - Second Node
	 */
	public void addEdge(VertexNode a, VertexNode b)
	{
		if(a.equals(b)) // For now, we won't allow self-loops of a Vertex.
		{
			System.out.println("Cannot have an edge with a Vertex of itself.");
			return;
		}
		if(this.map.containsKey(a) && this.map.containsKey(b)) // Check if the Map has Vertex 'a', we're adding VertexNode b to VertexNode  a's ArrayList of VertexNodes.
		{	// If true, then we will check 
			if(this.map.get(a).contains(b) || this.map.get(b).contains(a))
			{
				System.out.println("No duplicates.");
			}
			else {
				this.map.get(a).add(b);
				this.map.get(b).add(a);
			}
		}
		else {
			System.out.println("Not found");
		}
	}
	
	public void printEdges(VertexNode n)
	{
		for(VertexNode node : this.map.get(n))
			System.out.println(node.nodeData);
	}
	
}

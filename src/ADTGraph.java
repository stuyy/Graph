import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
		return this.map.putIfAbsent(node, new HashSet<VertexNode>()) ==  null ? true : false;
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
				System.out.println("No duplicates.");
			else {
				this.map.get(a).add(b);
				this.map.get(b).add(a);
			}
		}
		else if(this.map.containsKey(a) && !this.map.containsKey(b)) // If VertexNode a is a Vertex, but VertexNode b is not, we add b as a Vertex, and then add the edges.
			this.addEdge(b, a, false);
		else if(this.map.containsKey(b) && !this.map.containsKey(a))
			this.addEdge(a, b, false);
		else {
			System.out.println("Not found");
		}
	}
	
	/**
	 * Utility function to insert Vertices.
	 * @param a - The node to insert to the Map if it does not exist.
	 * @param b - The edge to add.
	 * @param flag - If true, insert both nodes as Vertices, if false, insert only one.
	 */
	private void addEdge(VertexNode a, VertexNode b, boolean flag)
	{
		if(flag)
		{
			// Add both nodes as a Vertex, and then add their edges.
		}
		else {
			this.map.putIfAbsent(a, new HashSet<VertexNode>());
			this.map.get(a).add(b);
			this.map.get(b).add(a);
		}
	}
	
	/**
	 * Prints all of the edges of a given Vertex.
	 * @param n - a VertexNode
	 */
	public void printEdges(VertexNode n)
	{
		System.out.print("Edges of " + n.nodeData + " - ");
		for(VertexNode node : this.map.get(n))
			System.out.print(node.nodeData + " ");
		System.out.println();
	}
	
	/**
	 * Prints all of the vertices of the graph.
	 */
	public void printVertices()
	{
		for(Map.Entry<VertexNode, HashSet<VertexNode>> entry : this.map.entrySet())
		{
			System.out.println("Vertex: " + entry.getKey().nodeData);
			System.out.print("Edges: ");
			for(VertexNode edge : entry.getValue())
				System.out.print(edge.nodeData + " ");
			System.out.println("\n");
		}
	}
}

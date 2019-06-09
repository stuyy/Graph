import java.util.HashMap;
import java.util.ArrayList;

public class ADTGraph {
	
	HashMap<VertexNode, ArrayList<VertexNode>> map = new HashMap<>();
	
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
			this.map.put(node, new ArrayList<VertexNode>());
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
		if(this.map.containsKey(a)) // If the map contains VertexNode a
		{
			ArrayList<VertexNode> edges = this.map.get(a);
			if(edges.contains(b))
			{
				System.out.println("B is already an edge with A");
				return;
			}
			else {
				System.out.println("No edge. Adding...");
				this.map.get(a).add(b);
			}
		}
	}
	
	public static void main(String [] args)
	{
		ADTGraph graph = new ADTGraph();
		VertexNode a = new VertexNode("A");
		VertexNode b = new VertexNode("B");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addEdge(a, b);
		
		ArrayList<VertexNode> edges = graph.map.get(a);
		for(VertexNode n : edges)
			System.out.println(n.nodeData);
		
	}
}

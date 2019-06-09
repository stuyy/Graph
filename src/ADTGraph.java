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
	
	public static void main(String [] args)
	{
		ADTGraph graph = new ADTGraph();
		VertexNode a = new VertexNode("A");
		VertexNode b = new VertexNode("A");
		graph.addVertex(a);
		graph.addVertex(b);
		
	}
}

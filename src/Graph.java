import java.util.* ;

public class Graph {
	
	HashMap<String, ArrayList<Edge>> map = new HashMap<>();
	public void addVertex(String node)
	{	
		if(this.map.containsKey(node))
		{
			System.out.println("Yes");
		}
		else
			this.map.put(node, new ArrayList<Edge>());
	}
	
	public void addEdge(VertexNode A, VertexNode B) throws Exception
	{
		// Need to check if both Vertices are in the Graph/Map.
		if(this.map.containsKey(A.nodeData) && this.map.containsKey(B.nodeData)) // If both Nodes are found
		{
			this.map.get(A.nodeData).add(new Edge(A, B));
			this.map.get(B.nodeData).add(new Edge(B, A));
		}
		else if(!this.map.containsKey(A.nodeData) && this.map.containsKey(B.nodeData)) // If Node A is not in the Graph, but Node B is.
		{
			this.map.put(A.nodeData, new ArrayList<Edge>());
			this.map.get(A.nodeData).add(new Edge(A, B));
			this.map.get(B.nodeData).add(new Edge(B, A));
		}
		else {
			throw new Exception("VertexNode not found.");
		}
	}
	public void addEdge(String A, String B) throws Exception
	{
		if(this.map.containsKey(A) && this.map.containsKey(B))
		{
			this.map.get(A).add(new Edge(new VertexNode(A), new VertexNode(B)));
			this.map.get(B).add(new Edge(new VertexNode(B), new VertexNode(A)));
		}
		else {
			throw new Exception("VertexNode not found.");
		}
	}
	public void printVertices()
	{
		for(Map.Entry<String, ArrayList<Edge>> adj : this.map.entrySet())
		{
			System.out.println("Vertex: " + adj.getKey().toString());
			ArrayList<Edge> edges = adj.getValue();
			System.out.println("Edges:");
			for(Edge e : edges)
				System.out.println(e.firstNode.nodeData + ", " +  e.secondNode.nodeData);
			
			System.out.println("---------");
		}
	}
	
	public ArrayList<Edge> getEdges(String vertex) { 
		return this.map.containsKey(vertex) ? this.map.get(vertex) : null; 
	}
	
	
}

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
	
	public void addEdge(VertexNode A, VertexNode B)
	{
		// Need to check if both Vertices are in the Graph/Map.
		if(this.map.containsKey(A.nodeData) && this.map.containsKey(B.nodeData))
		{
			this.map.get(A.nodeData).add(new Edge(A, B));
			this.map.get(B.nodeData).add(new Edge(B, A));
		}
	}
	public void addEdge(String A, String B)
	{
		if(this.map.containsKey(A) && this.map.containsKey(B))
		{
			this.map.get(A).add(new Edge(new VertexNode(A), new VertexNode(B)));
			this.map.get(B).add(new Edge(new VertexNode(B), new VertexNode(A)));
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
	
	public static void main(String [] args)
	{
		Graph graph = new Graph();
		// Add all vertices.
		graph.addVertex("Anson");
		graph.addVertex("Joshua");
		graph.addVertex("Jack");
		
		// Add all edges
		graph.addEdge(new VertexNode("Anson"), new VertexNode("Joshua"));
		graph.addEdge("Anson", "Jack");
		ArrayList<Edge> edges = graph.getEdges("Anson");
		for(Edge e : edges)
			System.out.println(e.firstNode.nodeData + "-" + e.secondNode.nodeData);
	}
}

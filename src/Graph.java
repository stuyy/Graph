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
	
	public static void main(String [] args)
	{
		Graph graph = new Graph();
		graph.addVertex("Anson");
		graph.addVertex("Joshua");
		graph.addVertex("Jack");
		graph.addEdge(new VertexNode("Anson"), new VertexNode("Joshua"));
		graph.addEdge(new VertexNode("Anson"), new VertexNode("Jack"));
		graph.printVertices();
	}
}

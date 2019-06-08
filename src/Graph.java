import java.util.* ;

public class Graph {
	
	HashMap<String, List<Edge>> map = new HashMap<>();
	public void addVertex(String node)
	{	
		if(this.map.containsKey(node))
		{
			System.out.println("Yes");
		}
		else
			this.map.put(node, new ArrayList<Edge>());
	}
	
	public void addEdge()
	{
		
	}
	public void printVertices()
	{
		for(Map.Entry<String, List<Edge>> adj : this.map.entrySet())
			System.out.println(adj.getKey().toString() + " : " + adj.getValue());
	}
	
	public static void main(String [] args)
	{
		Graph graph = new Graph();
		graph.addVertex("Anson");
		graph.addVertex("Joshua");
		graph.printVertices();
	}
}

import java.util.ArrayList;

public class GraphDriver {
	public static void main(String [] args) throws Exception
	{
		Graph graph = new Graph();
		// Add all vertices.
		VertexNode A = new VertexNode("Anson");
		VertexNode B = new VertexNode("Jack");
		graph.addVertex("Anson");
		graph.addVertex("Jack");
		graph.addEdge(A,  B);
		graph.addEdge(A, B);
		graph.addEdge(B, A);
		graph.printEdges("Jack");
	}
}

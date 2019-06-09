import java.util.ArrayList;
import java.util.HashSet;

public class GraphDriver {

	public static void main(String [] args)
	{
		long start = System.nanoTime();
		ADTGraph graph = new ADTGraph();
		VertexNode a = new VertexNode("A");
		VertexNode b = new VertexNode("B");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addEdge(a, b);
		graph.addEdge(a, b);
		graph.printEdges(a);
		long end = System.nanoTime();
		double totalTimeElapsed = end-start;
		System.out.printf("%f\n", totalTimeElapsed/1000000000);
	}
}

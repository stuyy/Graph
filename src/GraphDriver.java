import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GraphDriver {

	public static void main(String [] args) throws Exception
	{
		ADTGraph graph = new ADTGraph();
		VertexNode a = new VertexNode("A");
		VertexNode b = new VertexNode("B");
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addEdge(a, b);
		graph.addEdge(a, new VertexNode("C"));
		
		graph.addVertex(new VertexNode("C"));
		graph.addEdge(a, new VertexNode("D"));
		
		graph.addEdge(new VertexNode("E"), new VertexNode("C"));
		
		graph.addEdge(b, new VertexNode("C"));
		graph.addEdge(new VertexNode("D"), new VertexNode("E"));
		graph.addVertex(new VertexNode("F"));
		graph.addEdge(new VertexNode("F"), new VertexNode("E"));

		graph.addEdge(new VertexNode("G"), new VertexNode("H"));
		graph.printVertices();
		
		int [][] matrix  = graph.getMatrixRepresentation();
		for(int i = 0; i <matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
		
		graph.DFS(new VertexNode("F"));
		
	}
}

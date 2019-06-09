import java.util.Objects;

public class VertexNode {
	
	public String nodeData;
	
	public VertexNode (String nodeData)
	{
		this.nodeData = nodeData;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(nodeData);
	}
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof VertexNode))
			return false;
		
		VertexNode node = (VertexNode) obj;  // Cast obj to VertexNode
		return this.nodeData.equals(node.nodeData);
	}
}

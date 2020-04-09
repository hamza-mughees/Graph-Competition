
public class Edge {
	int u;				// vertex from
	int v;				// vertex to
	double w;			// weight
	
	public Edge(int u, int v, double w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}
	
	public int to() {
		return v;
	}
	
	public double weight() {
		return w;
	}
}

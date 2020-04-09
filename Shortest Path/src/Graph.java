import java.util.LinkedList;

public class Graph {
	LinkedList<Edge> graph[];
	
	public Graph(int n) {
		graph = new LinkedList[n];
		
		for (int i=0; i<graph.length; i++) {
			graph[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u, int v, double w) {
		// add edge of weight w, connecting u and v
		graph[u].add(0, new Edge(u, v, w));
	}
	
	public int size() {
		return graph.length;
	}
	
	public double[][] getAdjMatrix() {
		int n = graph.length;
		double matrix[][] = new double[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				// initialise all distances to infinity
				if (i==j) matrix[i][j] = 0;
				else matrix[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int m=0; m<graph[i].size(); m++) {
				Edge e = graph[i].get(m);
				int j = e.to();
				matrix[i][j] = e.weight();
			}
		}
		
		return matrix;
	}
}

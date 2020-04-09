
public class DijkstraSP {
	int n;
	double matrix[][];
	Edge edgeTo[];
	double distTo[];
	boolean visited[];
	
	public DijkstraSP(Graph graph, int s) {
		this.n = graph.size();
		this.edgeTo = new Edge[n];
		this.distTo = new double[n];	
		this.matrix = graph.getAdjMatrix();
		this.visited = new boolean[n];
		
		for (int i=0; i<n; i++) {
			// Initialise all distances to infinity;
			distTo[i] = Double.POSITIVE_INFINITY;
			visited[i] = false;
		}
		
		distTo[s] = 0;	// distance from s to s is 0
		
		dijkstra();
	}
	
	private void dijkstra() {
		for (int i=0; i<n-1; i++) {
			int v = nearestNonVisited();
			
			for (int j=0; j<n; j++) {
				// relaxation
				if (!visited[j] && distTo[j] > distTo[v] + matrix[v][j]) {
					distTo[j] = distTo[v] + matrix[v][j];
				}
			}
			
			visited[v] = true;
		}
	}
	
	private int nearestNonVisited() {
		// nearest vertex to the source
		double minDist = Double.POSITIVE_INFINITY;	// so its always changed
		int nearest = -1;
		
		for (int i=0; i<n; i++) {
			if (!visited[i] && distTo[i] <= minDist) {
				minDist = distTo[i];
				nearest = i;
			}
		}
		
		return nearest;
	}
	
	public double[] dists() {
		return this.distTo;
	}
}

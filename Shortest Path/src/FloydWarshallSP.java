
public class FloydWarshallSP {
	int n;
	double matrix[][];
	int pred[][];
	
	public FloydWarshallSP(Graph graph) {
		n = graph.size();
		matrix = graph.getAdjMatrix();
		pred = new int[n][n];
		
		performFW();
	}
	
	private void performFW() {
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
						pred[i][j] = k;
					}
				}
			}
		}
	}
	
	public double[][] dists() {
		return this.matrix;
	}
}

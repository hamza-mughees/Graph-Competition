import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     * @throws FileNotFoundException 
    */
	
	int sA, sB, sC;
	int n;				// number of intersections (vertices)
	int e;				// number of streets (edges)
	Graph graph;
	
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
    	this.sA = sA;
    	this.sB = sB;
    	this.sC = sC;
    	
    	if (filename != null && !filename.equals("")) {
    		File file = new File(filename);
        	Scanner reader;
        	
			try {
				reader = new Scanner(file);
				
				this.n = reader.nextInt();
	        	this.e = reader.nextInt();
	        	
	        	this.graph = new Graph(n);
	        	
	        	for (int i=0; i<this.e; i++) {
	        		int u = reader.nextInt();
	        		int v = reader.nextInt();
	        		double w = reader.nextDouble();
	        		this.graph.addEdge(u, v, w);
	        	}
			} catch (FileNotFoundException | NoSuchElementException e1) {
				e1.printStackTrace();
			}
    	}
       //TODO
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){
    	if (graph==null || min(sA, sB, sC)<50 || max(sA, sB, sC)>100) 
    		return -1;
    	
    	int maxT = -1;
    	
    	double allDists[][] = new double[n][];
    	
    	for (int i=0; i<n; i++) {
    		allDists[i] = new DijkstraSP(graph, i).dists();
    	}
    	
    	for (int i=0; i<n; i++) {
    		for (int j=1; j<n; j++) {
    			for (int k=0; k<n; k++) {
    				if (i==j || i==k || j==k) continue;
    				for (int l=0; l<n; l++) {
    					double dists[] = allDists[l];
    					
    					double dA = converter(dists[i]);
    					double dB = converter(dists[j]);
    					double dC = converter(dists[k]);
    					
    					int tA = (int) Math.ceil(dA / sA);
    					int tB = (int) Math.ceil(dB / sB);
    					int tC = (int) Math.ceil(dC / sC);
    					
    					int greatestT = Math.max(tA, tB);
    					greatestT = Math.max(greatestT, tC);
    					
    					if (greatestT==Integer.MAX_VALUE) return -1;
    					maxT = Math.max(maxT, greatestT);
    				}
    			}
    		}
    	}
    	
    	return maxT;
        //TO DO
    }
    
    private double converter(double num) {
    	return num * 1000;
    }
    
    private int min(int a, int b, int c) {
    	return Math.min(Math.min(a, b), c);
    }
    
    private int max(int a, int b, int c) {
    	return Math.max(Math.max(a, b), c);
    }
}
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;

public class CompetitionTests {
	// input speeds
	final int sA = 50;
	final int sB = 75;
	final int sC = 100;
	
	// only testing inputs A, B, M and N since limited submission size
    @Test
    public void testDijkstraConstructor() {
    	CompetitionDijkstra compTime = new CompetitionDijkstra(null, sA, sB, sC);
        assertEquals(-1, compTime.timeRequiredforCompetition());
        
        compTime = new CompetitionDijkstra("input-A.txt", sA, sB, sC);
        assertEquals(-1, compTime.timeRequiredforCompetition());
        
        compTime = new CompetitionDijkstra("input-B.txt", sA, sB, sC);
        assertEquals(10000, compTime.timeRequiredforCompetition());
        
        compTime = new CompetitionDijkstra("input-M.txt", sA, sB, sC);
        assertEquals(300, compTime.timeRequiredforCompetition());
        
        compTime = new CompetitionDijkstra("input-N.txt", sA, sB, sC);
        assertEquals(160, compTime.timeRequiredforCompetition());
    	//TODO
    }

    @Test
    public void testFWConstructor() {
    	CompetitionFloydWarshall compTime = new CompetitionFloydWarshall(null, sA, sB, sC);
    	assertEquals(-1, compTime.timeRequiredforCompetition());
    	
    	compTime = new CompetitionFloydWarshall("input-A.txt", sA, sB, sC);
    	assertEquals(-1, compTime.timeRequiredforCompetition());
    	
    	compTime = new CompetitionFloydWarshall("input-B.txt", sA, sB, sC);
    	assertEquals(10000, compTime.timeRequiredforCompetition());
    	
    	compTime = new CompetitionFloydWarshall("input-M.txt", sA, sB, sC);
    	assertEquals(300, compTime.timeRequiredforCompetition());
    	
    	compTime = new CompetitionFloydWarshall("input-N.txt", sA, sB, sC);
    	assertEquals(160, compTime.timeRequiredforCompetition());
        //TODO
    }

    //TODO - more tests
    
}
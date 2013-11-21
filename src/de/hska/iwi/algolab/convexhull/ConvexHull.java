package de.hska.iwi.algolab.convexhull;

import java.util.List;

import de.hska.iwi.algolab.convexhull.algorithm.Algorithm;
import de.hska.iwi.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.hska.iwi.algolab.dataset.CircleDataset;
import de.hska.iwi.algolab.dataset.Dataset;
import de.hska.iwi.algolab.dataset.InnerRectangleDataset;
import de.hska.iwi.algolab.dataset.RandomDataset;
import de.hska.iwi.algolab.dataset.RectangleDataset;
import de.hska.iwi.algolab.dataset.TestDataset;

/**
 * Convex hull calculation with different algorithms
 * @author Michael Klein
 */
public class ConvexHull {

	public static void main(String[] args) {
		

		Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();	
		Dataset dataset;
		
		int rounds = 14;
//		benchmark.runtimeBenchmark(algo, new RectangleDataset(1), rounds, 500);
//	    benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), rounds, 500);
      benchmark.runtimeBenchmark(algo, new CircleDataset(1), rounds, 500);
//      benchmark.runtimeBenchmark(algo, new RandomDataset(1), rounds, 500);
		
			
		
	
		dataset = new RectangleDataset(350);
//		dataset = new InnerRectangleDataset(350);
//		dataset = new CircleDataset(350);
//		dataset = new RandomDataset(350);
		
		List<Point> result = algo.calculate(dataset.getPoints());
		
		Export plot = new Export("D:\\plotResult.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
		plot.store();
		
	}
	
}

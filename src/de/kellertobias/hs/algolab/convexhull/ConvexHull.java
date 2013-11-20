package de.kellertobias.hs.algolab.convexhull;

import java.util.List;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.RandomDataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;
import de.kellertobias.hs.algolab.dataset.TestDataset;

/**
 * Convex hull calculation with different algorithms
 * @author Michael Klein
 */
public class ConvexHull {

	public static void main(String[] args) {
		

		Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();
		
//		Dataset dataset = new TestDataset();
//		List<Point> result = algo.calculate(dataset.getPoints());
//		
//		Export plot = new Export("D:\\pplot.dat");
//		plot.addDataset(dataset);
//		plot.addHull(result);
//		plot.store();
		
		
	//	benchmark.runtimeBenchmark(algo, new CircleDataset(1), 6, 500);
	//	benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), 14, 500);
		benchmark.runtimeBenchmark(algo, new RectangleDataset(1), 14, 500);
	//	benchmark.runtimeBenchmark(algo, new RandomDataset(1), 12, 500);
		
		 
//		running benchmark for random
//		n=: 500 time=3.938ms
//		n=: 1000 time=2.608ms
//		n=: 2000 time=6.319ms
//		n=: 4000 time=2.974ms
//		n=: 8000 time=5.269ms
//		n=: 16000 time=7.156ms
//		n=: 32000 time=13.724ms
//		n=: 64000 time=27.174ms
//		n=: 128000 time=68.741ms
//		n=: 256000 time=161.491ms
//		n=: 512000 time=364.144ms
//		n=: 1024000 time=861.673ms
		
		
//		Dataset dataset = new CircleDataset(50);
//		ChanAlgorithm algo = new ChanAlgorithm();
//		System.out.println(algo.createSubsets(dataset.getPoints(), 2));
//		
		
		Dataset dataset = new TestDataset();
		List<Point> result = algo.calculate(dataset.getPoints());
//	
		Export plot = new Export("D:\\plotResult.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
		plot.store();
		
	}
	
}

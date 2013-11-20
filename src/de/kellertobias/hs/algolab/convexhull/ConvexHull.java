package de.kellertobias.hs.algolab.convexhull;

import java.util.List;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.ChanAlgorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.CircleDataset;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.InnerRectangleDataset;
import de.kellertobias.hs.algolab.dataset.RandomDataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;
import de.kellertobias.hs.algolab.dataset.TestDataset;

/**
 * 
 * @author Tobias Keller
 *
 */
public class ConvexHull {

	public static void main(String[] args) {
		
		// run benchmark
		//Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();
		
		Dataset dataset = new TestDataset();
		List<Point> result = algo.calculate(dataset.getPoints());
		
		System.out.println(result);
		
		Export plot = new Export("D:\\pplot.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
		plot.store();
		
		
	//	benchmark.runtimeBenchmark(algo, new CircleDataset(1), 6, 500);
	//	benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1), 14, 500);
	//	benchmark.runtimeBenchmark(algo, new RectangleDataset(1), 16, 500);
	//	benchmark.runtimeBenchmark(algo, new RandomDataset(1), 15, 500);
		
		 
//		Dataset dataset = new CircleDataset(50);
//		ChanAlgorithm algo = new ChanAlgorithm();
//		System.out.println(algo.createSubsets(dataset.getPoints(), 2));
//		
		
//		Dataset dataset = new CircleDataset(50);
//		List<Point> result = algo.calculate(dataset.getPoints());
//	
//		Export plot = new Export("D:\\pplot.dat");
//		plot.addDataset(dataset);
//		plot.addHull(result);
//		plot.store();
		
	}
	
}

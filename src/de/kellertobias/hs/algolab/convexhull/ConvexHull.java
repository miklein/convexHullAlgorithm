package de.kellertobias.hs.algolab.convexhull;

import java.util.List;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.RandomDataset;

public class ConvexHull {

	public static void main(String[] args) {
		
		// run benchmark
		Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();
		
		/*
		benchmark.runtimeBenchmark(algo, new CircleDataset(1));
		benchmark.runtimeBenchmark(algo, new InnerRectangleDataset(1));
		benchmark.runtimeBenchmark(algo, new RectangleDataset(1));
		benchmark.runtimeBenchmark(algo, new RandomDataset(1));
		*/
		 
		
			
		Dataset dataset = new RandomDataset(50);	
		List<Point> result = algo.calculate(dataset.getPoints());
				
		Export plot = new Export("D:\\pplot.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
		plot.store();
		
	}
	
}

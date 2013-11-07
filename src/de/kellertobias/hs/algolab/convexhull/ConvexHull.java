package de.kellertobias.hs.algolab.convexhull;

import java.util.List;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.CircleDataset;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.RandomDataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;

public class ConvexHull {

	public static void main(String[] args) {
		
	//	Benchmark benchmark = new Benchmark();
	//	benchmark.runtimeBenchmark();
		
		 
		Algorithm algo = new MonotoneChainAlgorithm();
			
		Dataset dataset = new RectangleDataset(500);	
		List<Point> result = algo.calculate(dataset.getPoints());
		
//		Export csv = new Export("D:\\test.csv");
//		csv.addPoints(dataset.getPoints());
//		csv.store();
//		
//		Export scvhull = new Export("D:\\hull.csv");
//		scvhull.addPoints(result);
//		scvhull.store();
		
		Export plot = new Export("D:\\pplot.dat");
		plot.addDataset(dataset);
		plot.addHull(result);
		plot.store();
		
	}
	
}

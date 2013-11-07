package de.kellertobias.hs.algolab.convexhull;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;

public class Benchmark {
	
	
	public void runtimeBenchmark(Algorithm algo, Dataset dataset) {
		
		Timer timer = new Timer();
		Export output = new Export("D:\\"+dataset.toString()+".benchmark.csv");
		
		System.out.println("running benchmark for "+dataset.toString());
		
		int n = 500;
		for (int i=0; i < 14; i++) {
			dataset.regeneratePoints(n);
			timer.start();
			algo.calculate(dataset.getPoints());
			timer.stop();
			output.addBenchmark(n, timer.getRuntime());
			System.out.println("n=: "+n+" time="+(timer.getRuntime())+"ns");
			n*= 2;
		}
		output.store();
	}
	
}

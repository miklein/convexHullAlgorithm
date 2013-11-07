package de.kellertobias.hs.algolab.convexhull;

import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.Dataset;
import de.kellertobias.hs.algolab.dataset.RectangleDataset;

public class Benchmark {
	
	public void runtimeBenchmark() {
		
		Algorithm algo = new MonotoneChainAlgorithm();
		Timer timer = new Timer();
		Export output = new Export("D:\\benchmark.csv");
		
		int n = 500;
		for (int i=0; i < 14; i++) {
			System.out.println("i="+i+" n="+n);
			
			Dataset dataset = new RectangleDataset(n);
			
			
			timer.start();
			algo.calculate(dataset.getPoints());
			timer.stop();
			output.addBenchmark(n, timer.getRuntime());
			System.out.println("runtime: "+(timer.getRuntime())+"ns");
			n*= 2;
		}
		output.store();
	}
	
}

package de.hska.iwi.algolab.convexhull;

import de.hska.iwi.algolab.convexhull.algorithm.Algorithm;
import de.hska.iwi.algolab.dataset.Dataset;

/**
 * Measures the runtime of the Algorithm
 * @author Michael Klein
 *
 */
public class Benchmark {
	
	/**
	 * Runs a benchmark for a given algorithm based on the dataset
	 * the tests will be performed <loop> times with a given <amount> of points
	 * in each loop the amount of points will be doubled.
	 * The results will written in a file
	 *  
	 * @param algorithm The algorithm, used for the benchmark
	 * @param dataset The dataset, which is used for the benchmark
	 * @param loops Repeating amount
	 * @param amount The initial amount of Points that will be used
	 */
	public void runtimeBenchmark(Algorithm algorithm, Dataset dataset, int loops, int amount) {
		
		Timer timer = new Timer();
		Export output = new Export("D:\\"+dataset.toString()+".benchmark.csv");
		
		System.out.println("running benchmark for "+dataset.toString());
		
		int n = amount;
		for (int i=0; i < loops; i++) {
			dataset.regeneratePoints(n);
			timer.start();
			algorithm.calculate(dataset.getPoints());
			timer.stop();
			
			
			double tmp = (double)(timer.getRuntime() * 0.000001);
			tmp = Math.round(tmp * Math.pow(10, 3)) / Math.pow(10, 3);
			output.addBenchmark(n, (double) tmp);
			System.out.println("n=: "+n+" time="+((double)tmp)+"ms");
			n*= 2;
		}
		output.store();
	}
	
}

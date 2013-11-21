package de.hska.iwi.algolab.convexhull.test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import de.hska.iwi.algolab.convexhull.Benchmark;
import de.hska.iwi.algolab.convexhull.algorithm.Algorithm;
import de.hska.iwi.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.hska.iwi.algolab.dataset.CircleDataset;
import de.hska.iwi.algolab.dataset.Dataset;

public class BenchmarkTest {

	@Test
	public void testBenchmark() {
		Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();
		Dataset dataSet = new CircleDataset(12);
		benchmark.runtimeBenchmark(algo, dataSet, 6, 500);
		
		File file = new File("D:\\"+dataSet.toString()+".benchmark.csv");
		Assert.assertTrue(file.exists());
		
		
		
		
		
	}

}

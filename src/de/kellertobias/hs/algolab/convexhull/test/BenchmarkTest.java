package de.kellertobias.hs.algolab.convexhull.test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import de.kellertobias.hs.algolab.convexhull.Benchmark;
import de.kellertobias.hs.algolab.convexhull.algorithm.Algorithm;
import de.kellertobias.hs.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.kellertobias.hs.algolab.dataset.CircleDataset;
import de.kellertobias.hs.algolab.dataset.Dataset;

public class BenchmarkTest {

	@Test
	public void testBenchmark() {
		Benchmark benchmark = new Benchmark();
		Algorithm algo = new MonotoneChainAlgorithm();
		Dataset dataset = new CircleDataset(12);
		benchmark.runtimeBenchmark(algo, dataset, 6, 500);
		
		File file = new File("D:\\"+dataset.toString()+".benchmark.csv");
		Assert.assertTrue(file.exists());
		
	}

}

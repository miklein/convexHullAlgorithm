package de.hska.iwi.algolab.convexhull.test;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.hska.iwi.algolab.convexhull.Export;
import de.hska.iwi.algolab.convexhull.Point;
import de.hska.iwi.algolab.convexhull.algorithm.Algorithm;
import de.hska.iwi.algolab.convexhull.algorithm.MonotoneChainAlgorithm;
import de.hska.iwi.algolab.dataset.Dataset;
import de.hska.iwi.algolab.dataset.RandomDataset;

public class ExportTest {

	private List<Point> calculatedConvexHull;
	private Dataset dataset;
	
	@Before
	 public void setUp() {
		Algorithm algo = new MonotoneChainAlgorithm();
		this.dataset = new RandomDataset(400);
		this.calculatedConvexHull = algo.calculate(dataset.getPoints());
	
		
	}
	
	
	@Test
	public void testFileExport() {
		String path = "D:\\junitPlot.dat";
		
		Export plot = new Export(path);
		plot.addDataset(dataset);
		plot.addHull(calculatedConvexHull);
		plot.store();
		
		File file = new File(path);
		Assert.assertTrue(file.exists());
		
		
	}
	
	@Test
	public void testFailedFileExport() {
		String path = "D\\junitPlot.dat";
		
		Export plot = new Export(path);
		plot.addDataset(dataset);
		plot.addHull(calculatedConvexHull);
		plot.store();
		
		File file = new File(path);
		Assert.assertFalse(file.exists());
		
		
	}
	

}
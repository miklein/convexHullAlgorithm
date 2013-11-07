package de.kellertobias.hs.algolab.convexhull.test;

import org.junit.Assert;
import org.junit.Test;

import de.kellertobias.hs.algolab.dataset.RandomDataset;

public class RandomDatasetTest {

	@Test
	public void testAll() {
		RandomDataset randomDataset = new RandomDataset(32);
		Assert.assertEquals(32, randomDataset.getPoints().size());		
		
		Assert.assertEquals("random", randomDataset.toString());
		
	
	}

}

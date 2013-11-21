package de.kellertobias.hs.algolab.dataset;

import java.util.ArrayList;
import java.util.List;

import de.kellertobias.hs.algolab.convexhull.Point;

public class DefinedDataset implements Dataset {
	
	private ArrayList<Point> points = new ArrayList<Point>();

	@Override
	public void regeneratePoints(int amount) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Point> getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}
	
	public DefinedDataset(ArrayList<Point> points) {
		this.points = points;
	}
	
}

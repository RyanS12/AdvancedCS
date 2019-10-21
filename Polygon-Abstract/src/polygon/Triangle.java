package polygon;

import java.util.ArrayList;
//import java.awt.Point;

public class Triangle extends Polygon{

	
	public static final int NUMOFSIDES = 3;
	
	
	
	
	public Triangle(ArrayList<Point> coors) {
		super(NUMOFSIDES, coors);
		
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		super(NUMOFSIDES);
		addOneCoordinate(p1);
		addOneCoordinate(p2);
		addOneCoordinate(p3);
	}

	

	@Override
	public double area() {
		// TODO Auto-generated method stub
		
		Point a = coordinates.get(0);
		
		Point b = coordinates.get(1);
		
		Point c = coordinates.get(2);
		
		double crossP = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		
		return Math.abs(crossP / 2);
		
	}

	@Override
	public boolean isEquilateral() {
		// TODO Auto-generated method stub
		
		Point a = coordinates.get(0);
		
		Point b = coordinates.get(1);
		
		Point c = coordinates.get(2);
		
		double length1 = Math.round(Math.sqrt((c.x - b.x) * (c.x - b.x) + (c.y - b.y) * (c.y - b.y)));
		
		double length2 = Math.round(Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
		
		double length3 = Math.round(Math.sqrt((c.x - a.x) * (c.x - a.x) + (c.y - a.y) * (c.y - a.y)));
		
		if(length1 == length2 && length3 == length2) {
			
			return true;
			
		}
		return false;
		
		
		
		
		
		
	}

}

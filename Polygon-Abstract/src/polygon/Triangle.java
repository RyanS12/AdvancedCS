package polygon;

import java.util.ArrayList;
//import java.awt.Point;

public class Triangle extends Polygon{

	
	public static final int NUMOFSIDES = 3;
	
	public Triangle() {
		super();
	}
	
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
	
	public double findLength(Point a, Point b) {
		return Math.round(Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
	}

	@Override
	public boolean isEquilateral() {
		// TODO Auto-generated method stub
		
		Point a = coordinates.get(0);
		Point b = coordinates.get(1);
		Point c = coordinates.get(2);
		
		double length1 = findLength(c,b);
		double length2 = findLength(a,b);
		double length3 = findLength(a,c);
			
		return length1 == length2 && length3 == length2;		
		
		
		
		
		
		
	}

}

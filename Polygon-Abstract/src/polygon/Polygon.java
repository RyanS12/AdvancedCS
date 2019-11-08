package polygon;
//import java.awt.Point;
import java.util.ArrayList;

public abstract class Polygon {
	int numOfSides;
	ArrayList<Point> coordinates;
	
	public Polygon(int numOfSides) {
		this.numOfSides = numOfSides;
		coordinates = new ArrayList<>();
	}
	
	public Polygon(int numOfSides, ArrayList<Point> coors) {
		this.numOfSides = numOfSides;
		coordinates = coors;
	}

	public void addOneCoordinate(double x, double y) {
		this.coordinates.add(new Point(x, y));
	}
	
	public void addOneCoordinate(Point p) {
		coordinates.add(p);
	}
	
	

	public abstract double area();
	
	public abstract boolean isEquilateral();
	
	public int sumOfInteriorAngles() {
		return 180*(numOfSides - 2);
	}
	
	public int interiorAngle() {
		if(isEquilateral()) return sumOfInteriorAngles()/numOfSides;
		return -1;
	}
	
	
}
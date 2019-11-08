package polygon;

import java.util.ArrayList;

public class PolygonRunner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Point> list = new ArrayList<Point>();
		

		Point p1 = new Point(1.0, 0.0);
		Point p2 = new Point(-1.0, 0.0);
		Point p3 = new Point(0.0, Math.sqrt(3));
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		Triangle t = new Triangle(list);
		
		Triangle t2 = new Triangle(p1,p2,p3);
		
		/*t.addOneCoordinate(1.0, 0.0);
		
		t.addOneCoordinate(-1.0, 0.0);
		
		t.addOneCoordinate(0.0, Math.sqrt(3));*/
		
		System.out.println(t2.area());
		
		System.out.println(t.area());
		
		System.out.println(t.isEquilateral());
		
		
	}

}

import java.awt.geom.Point2D;

public class Tester {

	public static void main(String[] args) {
		LineSegment line = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(0,500)).build();
		LineSegment line2 = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(200,250)).build();
		LineSegment line3 = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(0,-500)).build();
		System.out.println(Data.roads.toString());
		Vehicle car = new Vehicle.Builder(2, new Point2D.Double(0,0), 45).build();
		Driver driver = new Driver(0);
		driver.tick();
		driver.tick();
		driver.tick();
		
	}
}

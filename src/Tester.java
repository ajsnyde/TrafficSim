import java.awt.geom.Point2D;

public class Tester {

	public static void main(String[] args) {
		LineSegment line = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(500,500)).build();
		LineSegment line2 = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(500,500)).build();
		LineSegment line3 = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(500,500)).build();
		System.out.println(Data.roads.toString());
		
	}
}

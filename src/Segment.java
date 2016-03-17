import java.awt.geom.Point2D;
import java.util.ArrayList;

abstract class Segment implements Road{
	static String type = "ABSTRACT-OVERRIDE NOW";
	static int id = 0;
	final int ID = id++;
	double length;
	double speedLimit;
	Point2D.Double a, b;
	Control controlA = null;
	Control controlB = null;
	ArrayList<Integer> connectionsA = new ArrayList<Integer>();
	ArrayList<Integer> connectionsB = new ArrayList<Integer>();
	
	public String toString() {
		return type + " - " + ID;
	}
}

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public interface Road {
	
	// A to B, which direction will you be facing if you've traveled x length
	public double getDegrees(double length); 
	//public double getRadians(double length);
	public double getLength();
	public Point2D.Double getA();
	public Point2D.Double getB();
	public Point2D.Double getPoint(double distance);
	public double getSpeedLimit();
	public void draw(Graphics2D g, Dimension dim, Rectangle2D.Double view);
	//dim is the size of the graphics window, view is the window in the map
}

import java.awt.geom.Point2D;

public interface Road {
	
	// A to B, which direction will you be facing if you've traveled x length
	public double getDegrees(double length); 
	//public double getRadians(double length);
	public double getLength();
	public Point2D.Double getA();
	public Point2D.Double getB();
	public Point2D.Double getPoint(double distance);
	public double getSpeedLimit();
}

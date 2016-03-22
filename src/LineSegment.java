import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class LineSegment extends Segment {

	private LineSegment() {}
	
	public static class Builder {
		// Required parameters
		private Point2D.Double a, b;
		private double length;
		private double degrees;
		private ArrayList<Integer> connectionsA = new ArrayList<Integer>();
		private ArrayList<Integer> connectionsB = new ArrayList<Integer>();
		
		// Optional parameters - initialized to default values
		private int calories = 0;
		private Control controlA = null;
		private Control controlB = null;
		private double speedLimit = 10; // meters per second
		
		public Builder(Point2D.Double a, Point2D.Double b) {
			this.a = a;
			this.b = b;
			length = Point2D.Double.distance(a.getX(), a.getY(), b.getX(), b.getY());
		}
		
		//optional parameters
		public Builder controlA(Control controlA) {
			this.controlA = controlA;
			return this;
		}
		public Builder controlB(Control controlB) {
			this.controlB = controlB;
			return this;
		}
		public Builder connectionB(int in) {
			connectionsB.add(in);
			return this;
		}
		public Builder connectionA(int in) {
			connectionsA.add(in);
			return this;
		}
		
		public Builder calories(int val)
        { calories = val;      return this; }
		
		public Builder speedLimit(double speedLimit) {
			this.speedLimit  = speedLimit;
			return this;
		}
		
		public LineSegment build() {
            return new LineSegment(this);
        }


	}

	private LineSegment(Builder builder) {
		type = "Line Segment";
		a = builder.a;
		b = builder.b;
		length = builder.length;
		controlA = builder.controlA;
		controlB = builder.controlB;
		connectionsA.addAll(builder.connectionsA);
		connectionsB.addAll(builder.connectionsB);
		Data.roads.put(ID, this);
	}

	public double getDegrees( double length) {
		return (Math.toDegrees(Math.atan((b.getY()-a.getY())/(b.getX()-a.getX()))));
	}
	
	public Point2D.Double getPoint(double distance) {
		double x = a.getX()+((distance/length)*(b.getX()-a.getX()));
		double y = a.getY()+((distance/length)*(b.getY()-a.getY()));
		return new Point2D.Double(x,y);
	}

	public double getLength() {
		return length;
	}
	
	public double getSpeedLimit() {
		return speedLimit;
	}

	public Point2D.Double getA() {
		return a;
	}

	public Point2D.Double getB() {
		return b;
	}
	
	public void draw(Graphics2D g, Dimension dim, Rectangle2D.Double view) {
		//TODO: Replace with code that scales properly.
		g.setColor(new Color(0,0,0));
		g.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
	}
}

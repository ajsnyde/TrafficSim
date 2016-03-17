import java.awt.Dimension;
import java.awt.geom.Point2D;

public class Vehicle {
	static int id = 0;
	final int ID = id++;
	String type = "Vehicle";
	
	//required for safe operations
	private int segmentID;
	private Point2D.Double center;
	private double degrees;
	
	// optional - automatically set
	private double distance = 0; // distance from point A on current segment, meters
	private Dimension size = new Dimension(2,5); // meters; width and length
	private double speed = 0;	// meters per second
	
	
	public Vehicle(int segmentID){
		this.segmentID = segmentID;
		center = Data.roads.get(segmentID).a;
		degrees = Data.roads.get(segmentID).getDegrees(0);
		if(Data.roads.get(segmentID) == null)
			throw new IllegalArgumentException("SegmentID not found! Vehicle not added to hash!");
		else
			Data.vehicles.put(ID, this);
	}
	
	public int getSegmentID() {
		return segmentID;
	}

	public void setSegmentID(int segmentID) {
		this.segmentID = segmentID;
	}

	public Point2D.Double getCenter() {
		return center;
	}

	public void setCenter(Point2D.Double center) {
		this.center = center;
	}

	public double getDegrees() {
		return degrees;
	}

	public void setDegrees(double degrees) {
		this.degrees = degrees;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getID() {
		return ID;
	}

	public Dimension getSize() {
		return size;
	}
	private double acceleration = .1; // m/sec^2
	public double getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}
	
	public static class Builder {
		// Required parameters
		private int segmentID;
		private Point2D.Double center;
		private double degrees;
		// Optional parameters - initialized to default values
		private double distance = 0; // distance from point A on current segment
		private Dimension size = new Dimension(5,10); // feet; width and length
		private double speed = 0;
		
		private int calories = 0;
		
		public Builder(int segmentID, Point2D.Double center, double degrees) {
			this.segmentID = segmentID;
			this.center = center;
			this.degrees = degrees;
		}
		
		//optional parameters
		public Builder distance(double distance) {
			this.distance = distance;
			return this;
		}
		
		public Builder speed(double speed) {
			this.speed = speed;
			return this;
		}
		
		public Builder calories(int val)
        { calories = val;      return this; }
		
        public Vehicle build() {
            return new Vehicle(this);
        }


	}

	private Vehicle(Builder builder) {
		type = "Vehicle";
		segmentID = builder.segmentID;
		center = builder.center;
		degrees = builder.degrees;
		distance = builder.distance;
		speed = builder.speed;
		Data.vehicles.put(ID, this);
	}
	
	public String toString() {
		return type + " - " + ID;
	}
}

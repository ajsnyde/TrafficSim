
public class Driver {

	Vehicle car;
	Segment road;
	
	Driver(int carID){	// largely testing
		//car = new Vehicle.Builder(1,new Point2D.Double(0,0),45).build();
		car = Data.vehicles.get(carID);
		road = Data.roads.get(car.getSegmentID());
	}
	
	void tick(){
		
		if(car.getSpeed() <= road.getSpeedLimit() + car.getAcceleration())	// Car should accelerate to Speed Limit
			car.setSpeed(car.getSpeed()+car.getAcceleration());
		else if(car.getSpeed() >= 0 + car.getAcceleration())				// Car should decelerate if over, but never be going in reverse
			car.setSpeed(car.getSpeed()+car.getAcceleration());
		else car.setSpeed(0);												// Last-ditch effort to thwart bugs. For now..
		
		car.setDegrees(road.getDegrees(car.getDistance()));
		car.setDistance(car.getDistance()+car.getSpeed());
		car.setCenter(Data.roads.get(car.getSegmentID()).getPoint(car.getDistance()));
		System.out.println(toString());
	}
	
	public String toString(){
		
		return car.type + " - " + car.ID + " speed: " + car.getSpeed() + " angle: " + car.getDegrees() + " X/Y: " + car.getCenter().toString();
		
	}
	
}

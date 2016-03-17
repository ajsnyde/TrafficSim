import java.awt.geom.Point2D;

public class Driver {

	Vehicle car;
	
	Driver(){	// largely testing
		car = new Vehicle.Builder(1,new Point2D.Double(0,0),45).build();
		
	}
	
	void tick(){
		car.setSpeed(car.getSpeed()+1);
		car.setDistance(car.getDistance()+car.getSpeed());
		
		
	}
	
}

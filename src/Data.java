import java.util.concurrent.ConcurrentHashMap;

public class Data {
	public static ConcurrentHashMap<Integer, Segment> roads = new ConcurrentHashMap<Integer, Segment>(256, 5, 10);
	public static ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<Integer, Vehicle>(32, 5, 10);
	
	public Data(){
		
		
		
	}
	
	
	
}

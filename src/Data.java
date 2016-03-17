import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Data {
	
	public final static int ACCESSDB = 0;
	public final static int CSV = 1;
	
	
	private final static String GETLINESEGMENTS = "SELECT * FROM LineSegments";
			//+ "(x1, y1, x2, y2, speedLimit, control1, control2, connections1, connections2) VALUES"
			//+ "(?,?,?,?,?,?,?,?,?)";
	
	public static ConcurrentHashMap<Integer, Segment> roads = new ConcurrentHashMap<Integer, Segment>(256, 5, 10);
	public static ConcurrentHashMap<Integer, Vehicle> vehicles = new ConcurrentHashMap<Integer, Vehicle>(32, 5, 10);
	
	public Data(){
		
		
		
	}
	
	public static boolean loadFromDB(File file, int type) {	// load from predefined types
		
		switch (type) {
			case ACCESSDB: {
				loadAccess(file);
				break;
			}
			
			case CSV:{
				loadCSV(file);
				
				break;
			}
			default:{
				throw new IllegalArgumentException("Type not valid! For reference, consider constants within class.");
			}
		}
		
		return false;
	}
	
	private static boolean loadAccess(File file) {	
		// TODO: open new window with CheckBoxTree (open-source) for user-defined input
		
		Connection dbCon;
		try {
			
			dbCon = DriverManager.getConnection("jdbc:ucanaccess://"+file.getAbsolutePath());
			PreparedStatement statement = dbCon.prepareStatement(GETLINESEGMENTS);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				double x1 = rs.getDouble("x1");
				double x2 = rs.getDouble("x2");
				double y1 = rs.getDouble("y1");
				double y2 = rs.getDouble("y2");
				new LineSegment.Builder(new Point2D.Double(x1,y1),new Point2D.Double(x2,y2)).build();
				
			}
			
			dbCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}
	
	
	private static boolean loadCSV(File file) {	// incomplete
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(file));
			int i = 0;
			while ((line = br.readLine()) != null) {
				++i;
				String[] object = line.split(cvsSplitBy);
				if(object[0].equals("LineSegment")) {
					double x1 = Double.parseDouble(object[1]);
					double y1 = Double.parseDouble(object[2]);
					double x2 = Double.parseDouble(object[3]);
					double y2 = Double.parseDouble(object[4]);
					new LineSegment.Builder(new Point2D.Double(x1,y1),new Point2D.Double(x2,y2)).build();
				} else if(object[0].equals("Vehicle")) {
					
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
		
		return false;
	}
	
	
}

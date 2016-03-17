import java.awt.geom.Point2D;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Tester {

	public static void main(String[] args) {
		
		
	    JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Access Databases", "accdb");
	    chooser.addChoosableFileFilter(filter);
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
		
		Data.loadFromDB(chooser.getSelectedFile(), Data.ACCESSDB);
		
		
		//LineSegment line = new LineSegment.Builder(new Point2D.Double(0,0), new Point2D.Double(0,500)).build();
		System.out.println(Data.roads.toString());
		Vehicle car = new Vehicle.Builder(1, new Point2D.Double(0,0), 45).build();
		Driver driver = new Driver(0);
		driver.tick();
		driver.tick();
		driver.tick();
		
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Visual {

	public static JPanel displayPanel;
	public static Dimension size = new Dimension(100, 100);
	public static Rectangle2D.Double view = new Rectangle2D.Double(0, 0, 500, 500);
	public static class Canvas extends JPanel {

		public void paintComponent(Graphics2D g) {
			System.out.println("Repainting");
			super.paintComponent(g);
			int w = getWidth();
			int h = getHeight();
			drawMap(g,w,h);
			drawCars(g,w,h);
		}
	}
	
	Visual(){
		displayPanel = new Canvas();
	}
	

	public static void drawMap(Graphics2D g, int w, int h) {
		// Draw roads
		System.out.println("Drawing Map!");
		for (Segment segment : Data.roads.values()) {
			segment.draw(g, size, view);
		}
	}

	public static void drawCars(Graphics2D g, int w, int h) {
		// TODO: Replace with actual code
		System.out.println("Drawing Cars!");
		g.setColor(new Color(255, 0, 0));
		for (Vehicle car : Data.vehicles.values()) {
			g.drawRect((int) car.getCenter().getX() - 1, (int) car.getCenter().getX() - 1, 2, 2);
		}
	}

	public JPanel update() {
		displayPanel.repaint();
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);
		return content;
	}
}

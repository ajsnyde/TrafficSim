import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrafficGUI {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrafficGUI window = new TrafficGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TrafficGUI() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Visual visual = new Visual();
		frame.getContentPane().add(visual.update(), BorderLayout.CENTER);
		System.out.println(visual.displayPanel.getSize());
		
		JButton btnUpdate = new JButton("Update!");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				visual.update();
				System.out.println(visual.displayPanel.getSize());
			}
		});
		frame.getContentPane().add(btnUpdate, BorderLayout.SOUTH);
	}

}

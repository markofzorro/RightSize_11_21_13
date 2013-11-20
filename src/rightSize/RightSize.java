/**
 * 
 */
package rightSize;

/**
 * @author zero
 *
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import srs.SRSDoc;
import charts.SRSChartDoc;
import cluster.ClusterDoc;
//import jFreeChart.RSLineChartOldNoWord;

//import charts2D.*;

/**
 * This class extends JDesktopPane, which allows views be displayed in internal panes that nestle nicely in
 * fanned rows so users can keep them and compare.
 * 
 * <p>This class sets up the main window and menu. Each menu item creates a Document that
 * creates the requisite views to get input and display results.
 * 
 * User choose the desired sample type in menu and action listener creates appropriate document. 
 * 
 * @author Mark White
 *
 **/


// HERE'S THE NEW TEXT. WILL IT BE ERASED? I HOPE SO.

public class RightSize extends JFrame implements ActionListener
{
	private JDesktopPane desktop = null;
	private SRSDoc srsDoc =null;
	private ClusterDoc clusterDoc = null;
	private SRSChartDoc chartDoc = null;

	public RightSize()
		{
			super("RightSize: SaftyNet verson. From your friends at SafetyNet and TEPHINET.");
			

			// Make the big window be indented 50 pixels from each edge
			// of the screen.
			int inset = 50;
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setBounds(inset, inset, screenSize.width - inset * 2,
					screenSize.height - inset * 2);

			// Set up the GUI.
			desktop = new JDesktopPane(); // a specialized layered pane
			// createFrame(); //create first "window"
			setContentPane(desktop);
			// SRSDoc = new SRSSRSDoc(desktop);
			setJMenuBar(createMenuBar());

			// Make dragging a little faster but perhaps uglier.
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		}

	protected JMenuBar createMenuBar()
		{
			JMenuBar menuBar = new JMenuBar();

			// Set up the lone menu.
			JMenu menu = new JMenu("File");
			//menu.setMnemonic(KeyEvent.VK_D);
			menuBar.add(menu);

			// Set up the first menu item.
			/*
			 * JMenuItem menuItem = new JMenuItem("New");
			 * menuItem.setMnemonic(KeyEvent.VK_N);
			 * menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N,
			 * ActionEvent.ALT_MASK)); menuItem.setActionCommand("new");
			 * menuItem.addActionListener(this); menu.add(menuItem);
			 */
			// Set up the second menu item.
			JMenuItem fileExitMenuItem = new JMenuItem("Exit");
			fileExitMenuItem = new JMenuItem("Quit");
			fileExitMenuItem.setMnemonic(KeyEvent.VK_Q);
			fileExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_Q, ActionEvent.ALT_MASK));
			fileExitMenuItem.setActionCommand("quit");
			fileExitMenuItem.addActionListener(this);
			menu.add(fileExitMenuItem);

			JMenu sampleSizeMenu = new JMenu("Calculate Sample Sizes");
			menuBar.add(sampleSizeMenu);

			JMenuItem srsMI = new JMenuItem("Simple Random Sample");
			srsMI.setActionCommand("srs");
			srsMI.addActionListener(this);
			sampleSizeMenu.add(srsMI);
			
			JMenuItem clusterMI = new JMenuItem("Cluster Sample");
			clusterMI.setActionCommand("cluster");
			clusterMI.addActionListener(this);
			sampleSizeMenu.add(clusterMI);
			
			JMenu aboutMenu = new JMenu("About");
			JMenuItem aboutMI = new JMenuItem("About This Program");
			aboutMI.setActionCommand("aboutProgram");
			aboutMI.addActionListener(this);
			aboutMenu.add(aboutMI);
			
			JMenuItem supportersMI = new JMenuItem("Supporters and Contributors");
			supportersMI.setActionCommand("supporters");
			supportersMI.addActionListener(this);
			aboutMenu.add(supportersMI);
			
			//menu.setMnemonic(KeyEvent.VK_D);
			menuBar.add(aboutMenu);

			
			

			return menuBar;
		}

	// React to menu selections.
	public void actionPerformed(ActionEvent e)
		{
			if ("quit".equals(e.getActionCommand()))
				{
					quit();
				} 
				else if ("srs".equals(e.getActionCommand()))
					{
						srsDoc = new SRSDoc(desktop);
					//	srsDoc.graph();
					}
				else if ("cluster".equals(e.getActionCommand()))
						clusterDoc = new ClusterDoc(desktop);
				else if ("aboutProgram".equals(e.getActionCommand()))
					{
						String text = "This program is dedicated to all the FETP trainees, present and past\nwho need to learn to do accurate surveys. I hope this helps you learn to design\n fine surveysthat help you improve the health of your population.\n\nWritten by Mark White";
						JOptionPane.showMessageDialog(null, text, "Rightsize 2.01.0 is not finished yet.", JOptionPane.PLAIN_MESSAGE, null);
					}
				else if("supporters".equals(e.getActionCommand()))
					{
						String text = 
								"This program is brought to you by TEPHINET, which provided moral and\n" +
								"financial support. Many FETPs and their trainees provided input and provided\n" +
								"helpful suggestions and advice. WHO and the US CDC provided technical assistance.\n\n" +
								"Many people contributed thier expertise and pateince to testing and helping\n" +
								"Design the screens. Conchy Roces, Conky Lim-Quizon, and Dionisio Herrera\n" +
								"were great.\n\nI'd also like to acknowledge the help of the Vietnamese trainee\n" +
								"who calculated along with the my presentation program and found an error.\n\n" +
								"The China FETP trainees who asked to be able to calculate with large populations\n"+
								"will be pleased to know the program can handle populations of more than 10 to\n" +
								"the 80th power. That's the estimated number of atoms in the universe. They'll\n" + 
								"have to take my word for it since the program can't accept numbers this large.\n" +
								"I'll fix it in the next version."
								
										;
						JOptionPane.showMessageDialog(null, text, "Rightsize 2.01.0 is not finished yet.", JOptionPane.PLAIN_MESSAGE, null);
					}	
					
		}


	// Quit the application.
	protected void quit()
		{
			System.exit(0);
		}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI()
		{
			// Make sure we have nice window decorations.
			JFrame.setDefaultLookAndFeelDecorated(true);

			// Create and set up the window.
			RightSize frame = new RightSize();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Display the window.
			frame.setVisible(true);
		}

	public static void main(String[] args)
		{
			// Schedule a job for the event-dispatching thread:
			// creating and showing this application's GUI.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run()
					{
						createAndShowGUI();
					}
			});
		}
}


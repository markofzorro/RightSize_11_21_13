/**
 * 
 */
package rightSize;

/**
 * @author zero
 *
 */
import java.awt.Component;
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
import javax.swing.KeyStroke;

import charts2D.*;

/*
 * Desktop pane allows sample sizes to be displayed in internal panes that nestle nicely in
 * fan rows so users can keep them and compare.
 * 
 * The class sets up the main window and menu. Each menu item creates a SRSDocument that
 * creates the requisite view to get input and display results.
 * 
 * the SRSDocument does calculations and holds variables so that graphs can be created and shown.
 * 
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class RightSize extends JFrame implements ActionListener
{
	private JDesktopPane desktop;
	private SRSDoc srsDoc;
	private ClusterDoc clusterDoc = null;

	public RightSize()
		{
			super("RightSize from your freinds at TEPHINET");

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
			menu.setMnemonic(KeyEvent.VK_D);
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
			
			JMenuItem chartMI = new JMenuItem("Chart Test");
			chartMI.setActionCommand("chart");
			chartMI.addActionListener(this);
			sampleSizeMenu.add(chartMI);

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
					srsDoc = new SRSDoc(desktop);
				else if ("cluster".equals(e.getActionCommand()))
						clusterDoc = new ClusterDoc(desktop);
				else if ("chart".equals(e.getActionCommand()))
					{
						LMZChart chart = new LMZChart();
						chart.setVisible(true);
						desktop.add(chart);
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

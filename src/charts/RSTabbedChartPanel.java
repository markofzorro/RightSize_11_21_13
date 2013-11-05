
package charts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import basesAndUtilites.*;
/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class RSTabbedChartPanel extends JPanel
	{
		public RSTabbedChartPanel()
			{
				super(new GridLayout(1, 1));
				D.b("Reached RSTabbedChartView constructor");

				JTabbedPane tabbedPane = new JTabbedPane();
				//setPreferredSize( new Dimension(w, h));
				Dimension d = new Dimension(1600, 1400);
				setPreferredSize(d);
				
			//	ImageIcon icon = createImageIcon("images/middle.gif");

				JComponent popPanel = makeTextPanel("Population goes here");
				tabbedPane.addTab("Population", popPanel);
				//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

				
				//JPanel proportionPanel = new JPanel();
				//JLabel filler = new JLabel("Proportion panel goes here.");
				//filler.setHorizontalAlignment(JLabel.CENTER);
				//proportionPanel.setLayout(new GridLayout(1, 1));
				//proportionPanel.add(filler);
				//JComponent panel2 = makeTextPanel("Panel #2");
				
				RSChartPanel chartPanel = new RSChartPanel();
				tabbedPane.addTab("Proportion", chartPanel);
				//tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

				
				
				JComponent panel3 = makeTextPanel("Confidence Interval");
				tabbedPane.addTab("Width of Confidence Interval", panel3);
				//tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

				JComponent panel4 = makeTextPanel("Panel has a preferred size of 1010 x 500).");
				panel4.setPreferredSize(new Dimension(1010, 500));
				tabbedPane.addTab("Tab 4", panel4);
				tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

				// Add the tabbed pane to this panel.
				add(tabbedPane);

				// The following line enables to use scrolling tabs.
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
				Dimension dim = new Dimension(1400 , 1600);
				setPreferredSize(dim);
				//pack();
			}

		protected JComponent makeTextPanel(String text)
			{
				JPanel panel = new JPanel(false);
				JLabel filler = new JLabel(text);
				filler.setHorizontalAlignment(JLabel.CENTER);
				panel.setLayout(new GridLayout(1, 1));
				panel.add(filler);
				return panel;
			}

		/**
		 * Create the GUI and show it. For thread safety, this method should be
		 * invoked from the event dispatch thread.
		 */
		private static void createAndShowGUI()
			{
				// Create and set up the window.
				JFrame frame = new JFrame("TabbedPaneDemo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// Add content to the window.
				frame.add(new RSTabbedChartPanel(), BorderLayout.CENTER);

				// Display the window.
				frame.pack();
				frame.setVisible(true);
			}

/*		public static void main(String[] args)
			{
				// Schedule a job for the event dispatch thread:
				// creating and showing this application's GUI.
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								// Turn off metal's use of bold fonts
								UIManager.put("swing.boldMetal", Boolean.FALSE);
								createAndShowGUI();
							}
					});
			}
			*/
	}

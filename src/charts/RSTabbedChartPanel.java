
package charts;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import basesAndUtilites.D;
/*
 * RSTabbedChartPanel
 * 
 * Generates the panel the charts will appear on.
 * 
 * Manages the tabs, including which tab is open. 
 * 
 *
 */

/**
 * Creates tabbed pane to display charts.
 * All management of tabs is in this class. 
 * @author markofzero
 *
 */
public class RSTabbedChartPanel extends JPanel
	{
		
		public RSTabbedChartPanel(RSChartDoc doc)
			{
				super();
				D.b("Reached RSTabbedChartPanel constructor");

				JTabbedPane tabbedPane = new JTabbedPane();
				//setPreferredSize( new Dimension(w, h));
				Dimension d = new Dimension(1600, 1400);
				setPreferredSize(d);
				
			//	ImageIcon icon = createImageIcon("images/middle.gif");

				JPanel popTestPanel = new JPanel();
				JLabel testLabel = new JLabel("Population goes here.");
				popTestPanel.add(testLabel);
				tabbedPane.addTab("Testing", popTestPanel);
				//tabbedPane.addTab("Population", popPanel);
				//JPanel populationPanel = doc.createPopulatonPanel();				
				JPanel chartPanel = doc.createProportionsPanel();
				tabbedPane.addTab("Proportion", doc.createProportionsPanel());
				//tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
				
				
				// get the currently selected index for this tabbed pane
			//	int selectedIndex = tabbedPane.getSelectedIndex();
				//System.out.println("Default Index:" + selectedIndex); // it is "population"
				//tabbedPane.setSelectedIndex(selectedIndex + 1); // set it to the next one, which is the proportion

				
				
			//	JComponent ciPanel = makeTextPanel("Confidence Interval");
				tabbedPane.addTab("Width of Confidence Interval", doc.createConfidenceIntervalPanel());

				JPanel confidenceCoefficientPanel = doc.createProportionsPanel();
				tabbedPane.addTab("Confidence Coefficient", doc.createConfidenceCoefficientPanel());
				
//				tabbedPane.setSelectedIndex(selectedIndex + 3); // CC is the third panel

				// Add the tabbed pane to this panel.
				add(tabbedPane);

				// The following line enables to use scrolling tabs.
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
				Dimension dim = new Dimension(1400 , 1600);
				setPreferredSize(dim);
				
						}
	}

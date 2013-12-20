
package srs;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
public class SRSTabbedChartPanel extends JPanel
	{
		
		public SRSTabbedChartPanel(SRSChartDoc doc)
			{
				super();
				setName("simple Random Sample Charts");
				D.b("Reached RSTabbedChartPanel constructor");
				
				setLayout(new BorderLayout());
				JTabbedPane tabbedPane = new JTabbedPane();
				//setPreferredSize( new Dimension(w, h));
				Dimension d = new Dimension(2000, 1400);  // was 1600, 1400
				setPreferredSize(d);
				
			//	ImageIcon icon = createImageIcon("images/middle.gif");

				
				//tabbedPane.addTab("Population", popPanel);
				JPanel populationPanel = doc.createPopulatonPanel();
				tabbedPane.addTab("Population", populationPanel);
				
				JPanel chartPanel = doc.createProportionsPanel();
				tabbedPane.addTab("Proportion", doc.createProportionsPanel());
				
				tabbedPane.addTab("Width of Confidence Interval", doc.createConfidenceIntervalPanel());

				JPanel confidenceCoefficientPanel = doc.createConfidenceLevelPanel();
				tabbedPane.addTab("Confidence Level", doc.createConfidenceLevelPanel());
				
//				tabbedPane.setSelectedIndex(selectedIndex + 3); // CC is the third panel

				// Add the tabbed pane to this panel.
				add(tabbedPane, BorderLayout.CENTER);

				// The following line enables to use scrolling tabs.
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
//				Dimension dim = new Dimension(1400 , 1600);
//				setPreferredSize(dim);
				
						}

	}

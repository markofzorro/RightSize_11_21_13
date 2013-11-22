
package charts;

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
public class ClusterTabbedChartPanel extends JPanel
	{
		
		public ClusterTabbedChartPanel(ClusterChartDoc clusterChartDoc)
			{
				super();
				D.b("Reached ClusterTabbedChartPanel constructor");
				
				setLayout(new BorderLayout());
				JTabbedPane tabbedPane = new JTabbedPane();
				//setPreferredSize( new Dimension(w, h));
				Dimension d = new Dimension(2000, 1400);  // was 1600, 1400
				setPreferredSize(d);
				
							
				//tabbedPane.addTab("Population", popPanel);
				JPanel populationPanel = clusterChartDoc.createPopulatonPanel();
				tabbedPane.addTab("Population", populationPanel);
/************* ADD THESE IN AS YOU BUILD THE TABBED PANE ********************/				
				JPanel chartPanel = clusterChartDoc.createProportionsPanel();
				tabbedPane.addTab("Proportion", clusterChartDoc.createProportionsPanel());
	/*			
				tabbedPane.addTab("Width of Confidence Interval", clusterChartDoc.createConfidenceIntervalPanel());

				JPanel confidenceCoefficientPanel = clusterChartDoc.createProportionsPanel();
				tabbedPane.addTab("Confidence Coefficient", clusterChartDoc.createConfidenceCoefficientPanel());
	*/			
				// Add the tabbed pane to this panel.
				add(tabbedPane, BorderLayout.CENTER);

				// The following line enables to use scrolling tabs.
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
				
						}
	}

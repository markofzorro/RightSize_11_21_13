/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cluster;

//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import basesAndUtilites.D;
import basesAndUtilites.Globals;
import basesAndUtilites.RSInternalFrame;




/**
 * 
 * @author markwhite
 */
public class ClusterView extends RSInternalFrame
	{
		private ClusterDoc doc = null;
		private cluster.ClusterPanel ClusterPanel = null;
		JButton graphButton = null;

		private double clusterSize = 0;
		private double clustersNeeded = 0;
		private double designEffect = 0;

		private JPanel contentPane = new JPanel();

		// ClusterButtonPanel pb = null; Not a class
		// begin variable declarations

		private javax.swing.JButton okButton;
		private javax.swing.JButton cancelButton;

		private JPanel buttonPanel;

		// end variable declarations

		/**
		 * Creates new Internal Frame for user interactions for simple random
		 * sample calculations.
		 */
		public ClusterView(ClusterDoc clusterDoc, String title)
			{
				super(title); // Sets the title of RSInternalFrame. this allows
								// us to keep count of the panels

				
				this.doc = clusterDoc;
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				// contentPane.setLayout(new BorderLayout(0, 0));
				contentPane.setLayout(new BoxLayout(contentPane,
						BoxLayout.Y_AXIS));
				setContentPane(contentPane);
				setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

				/*
				 * Inherits box layout from RSInternalPane. this shows
				 * components vertically from top to bottom
				 */

				initComponents();
				pack();

			}

		private JPanel initButtonPanel()
			{
				buttonPanel = new JPanel();
				buttonPanel.setLayout(new FlowLayout());
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, Globals.TEXT_SIZE));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
						{
							dispose();
							// System.out.println("OK button Clicked.");
						}
				});
				buttonPanel.add(cancelButton);

				// add buttonPanel to internal frame

				okButton = new JButton("OK");
				okButton.setFont(new java.awt.Font("Lucida Grande", 0, Globals.TEXT_SIZE));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
						{

							doc.calculate();
							addGraphButton();

						}
				});
				buttonPanel.add(okButton);
				return buttonPanel;

			}
		
		private void addGraphButton()
			{
				if (graphButton == null) // there isn't a button yet.
					{	
						graphButton = new JButton("Graph");
						graphButton.setFont(new java.awt.Font("Lucida Grande", 0, Globals.TEXT_SIZE));
						graphButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e)
								{
									D.b("Reached addGraphButton()");
									doc.chart();
									//RSChartDoc rsDoc = new RSChartDoc(doc);
									
									
								}
						});
						buttonPanel.add(graphButton);
					}
				else
						return;
			}

		private void initComponents()
			{
				ClusterPanel = new ClusterPanel(doc);
				ClusterPanel.setVisible(true);
				getContentPane().add(ClusterPanel);
				initButtonPanel();
				getContentPane().add(buttonPanel);
				pack();
				// setSize(1000, 1000);
			}

		public void update(double clustersNeeded, double roh, double designEffect)
			{

				setClustersNeeded(clustersNeeded);
				//= clustersNeeded;
				setRohString(roh);
				setDesignEffect(designEffect);
				revalidate();

			}

		/*************** getters and setters *********************/
		public String getPopString()
			{
				
				
				return ClusterPanel.getPopulationString();
			}

		public String getProportionString()
			{
				return ClusterPanel.getProportionString();
			}

		public String getConfidenceIntervalString()
			{
				return ClusterPanel.getConfidenceIntervalString();
			}

		public String getConfidenceLevelString()
			{
			//	D.b("Clusterview.getCCString(): CC is " +  ClusterPanel.getCCString());
				return ClusterPanel.getConfidenceLevelString();
				
			}

		public void setClustersNeeded(double d)
			{

				ClusterPanel.setLblClustersNeeded(d);
			}

		public void setDesignEffect(double d)
			{
				ClusterPanel.setLblDesignEffect(d);
				// ClusterPanel.setLblN(d);
			}
		public void setRohString(double d)
			{
				D.b("Clusterview.setRohString: d is " + d);
				ClusterPanel.setRohString(d);
				// ClusterPanel.setLblN(d);
			}
		
		public String getClusterSizeString()
			{
				D.b("Clusterview.getClusterSizeString: clusterSizeString is " + ClusterPanel.getClusterSizeString());
				return ClusterPanel.getClusterSizeString();
			}
		public String getROHString()
			{
				D.b("Clusterview: rohString is " + ClusterPanel.getROHString());
				return ClusterPanel.getROHString();
			}
		
		/******* end getters and setters *****************/

		/**
		 * @param args
		 *            the command line arguments
		 */

	}

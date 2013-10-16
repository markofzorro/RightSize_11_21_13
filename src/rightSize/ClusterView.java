/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rightSize;

//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 * @author markwhite
 */
public class ClusterView extends RSInternalFrame
	{
		private ClusterDoc doc = null;
		private ClusterPanel ClusterPanel = null;

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
				cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
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
				okButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
						{

							doc.calculate();

						}
				});
				buttonPanel.add(okButton);
				return buttonPanel;

			}

		private void initComponents()
			{
				ClusterPanel = new ClusterPanel();
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
				setROH(roh);
				setDesignEffect(designEffect);
				revalidate();

			}

		/*************** getters and setters *********************/
		public String getPopString()
			{
				
				
				return ClusterPanel.getPopString();
			}

		public String getProportionString()
			{
				return ClusterPanel.getProportionString();
			}

		public String getCIString()
			{
				return ClusterPanel.getCIString();
			}

		public String getCCString()
			{
				return ClusterPanel.getCCString();
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
		public void setROH(double d)
			{
				ClusterPanel.setLblROH(d);
				// ClusterPanel.setLblN(d);
			}
		
		public String getClusterSizeString()
			{
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

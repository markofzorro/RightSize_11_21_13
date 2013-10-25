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
public class SRSView extends RSInternalFrame
	{
		private SRSDoc doc = null;
		//RSChartDoc chartDoc = null;
		private SRSPanel srsPanel = null;
		private JPanel contentPane = new JPanel();
		
		//private double pop = 0;
		

		// SRSButtonPanel pb = null; Not a class
		// begin variable declarations

		private javax.swing.JButton okButton = null;
		private javax.swing.JButton cancelButton = null;
		private javax.swing.JButton graphButton = null;

		private JPanel buttonPanel;

		// end variable declarations

		/**
		 * Creates new Internal Frame for user interactions for simple random
		 * sample calculations.
		 */
		public SRSView(SRSDoc doc, String title)
			{
				super(title); // Sets the title of RSInternalFrame. this allows
								// us to keep count of the panels

				// super("Simple Random Sample");
				// setTitle("Simple Random Sample");
				this.doc = doc;
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
							addGraphButton();
							
						}
				});
				buttonPanel.add(okButton);
				return buttonPanel;

			}

		private void initComponents()
			{
//				chart = new RSChart(doc);
				srsPanel = new SRSPanel();
				srsPanel.setVisible(true);
				getContentPane().add(srsPanel);
				initButtonPanel();
				getContentPane().add(buttonPanel);
				pack();
				// setSize(1000, 1000);
			}

		public void update(double n0, double fpc, double n)
			{

				//this.n0 = n0;
				set_n0(n0);
				set_n(n);
				set_fpc(fpc);
				revalidate();

			}
		
		private void addGraphButton()
			{
				if (graphButton == null) // there isn't a button yet.
					{	
						graphButton = new JButton("Graph");
						graphButton.setFont(new java.awt.Font("Lucida Grande", 0, 24));
						graphButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e)
								{
									D.b("Reached addGraphButton()");
									doc.graph();
								//	RSChartDoc rsDoc = new RSChartDoc(doc);
									
									
								}
						});
						buttonPanel.add(graphButton);
					}
				else
						return;
			}

		/*************** getters and setters *********************/
		public String getPopString()
			{
				
				
				return srsPanel.getPopString();
			}

		public String getProportionString()
			{
				return srsPanel.getProportionString();
			}

		public String getCIString()
			{
				return srsPanel.getCIString();
			}

		public String getCCString()
			{
				return srsPanel.getCCString();
			}

		public void set_n0(double d)
			{

				srsPanel.setLblN0(d);
			}

		public void set_n(double d)
			{
				srsPanel.setLblN(d);
				
			}

		public void set_fpc(double d)
			{
				srsPanel.setLblFpc(d);
			}

		/*
		 * setProportion(view.getProportion()); setCI(view.getCI());
		 * setCC(view.getCC());
		 */

		/******* end getters and setters *****************/

		/**
		 * @param args
		 *            the command line arguments
		 */

	}

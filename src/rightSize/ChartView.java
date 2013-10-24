package rightSize;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author markwhite
 */
public class ChartView extends RSInternalFrame
	{
		ChartDoc doc = null;
		SRSPanel srsPanel = null;
		JPanel contentPane = new JPanel();
		

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
		public ChartView(ChartDoc doc, String title)
			{
				super(title); // Sets the title of RSInternalFrame. this allows
								// us to keep count of the panels

				D.b("Reached ChartView constructor");
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

						//	doc.calculate();
						//	addGraphButton();
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
			//	getContentPane().add(srsPanel);
				initButtonPanel();
				getContentPane().add(buttonPanel);
				pack();
				// setSize(1000, 1000);
			}

/*		public void update(double n0, double fpc, double n)
			{

				//this.n0 = n0;
				set_n0(n0);
				set_n(n);
				set_fpc(fpc);
				revalidate();

			}
	*/	
	}

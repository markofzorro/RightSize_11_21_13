/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rightSize;

import java.awt.Font;

import javax.swing.BorderFactory;

/**
 * 
 * @author markofzero
 */
public class OldSRSResultsPanel extends javax.swing.JPanel
{

	// Variables declaration - do not modify
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JLabel n0Label;
		private javax.swing.JLabel nLabel;
	

		
	/**
	 * Creates new form ShowResultsPanel
	 */
	public OldSRSResultsPanel()
		{
			initComponents();
			setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 20)); // top,
			// left,
			// bottom,
			// right

		}

//	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
		{
			java.awt.GridBagConstraints gridBagConstraints;

			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			n0Label = new javax.swing.JLabel();
			nLabel = new javax.swing.JLabel();
			
			
			//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setLayout(new java.awt.GridBagLayout());

			jLabel2.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			jLabel2.setText("Sample Size:");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 10;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(30, 50, 0, 0);
			add(jLabel2, gridBagConstraints);

			jLabel3.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			jLabel3.setText("Sample Size with Finite Population Correction:");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(8, 50, 27, 0);
			add(jLabel3, gridBagConstraints);

			n0Label.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			n0Label.setText(""); // display blank until result exists
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(30, 49, 0, 24);
			add(n0Label, gridBagConstraints);

			nLabel.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			nLabel.setText("");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(8, 49, 27, 33);
			add(nLabel, gridBagConstraints);

		//	pack();
		}// </editor-fold>

	
	/*************** Setters *************/
	
	/**
	 * Uses longs to get rid of annoying decimal
	 * @param n0
	 */
	public void set_n0Label(double n0)
		{
			long l = (long) n0;
			String s = Long.toString(l);
			n0Label.setText(s);
		}

	public void set_nLabel(double n)
		{
			long l = (long) n;
			String s = Long.toString(l);
			nLabel.setText(s);
		//	revalidate();
		}
	
	/*****end setters ***/

	
	// End of variables declaration
}

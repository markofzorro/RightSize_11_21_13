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
public class SRSResultsPanel extends javax.swing.JPanel
{

	/**
	 * Creates new form ShowResultsPanel
	 */
	public SRSResultsPanel()
		{
			initComponents();
			setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 20)); // top,
			// left,
			// bottom,
			// right

		}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
		{
			java.awt.GridBagConstraints gridBagConstraints;

			jLabel2 = new javax.swing.JLabel();
			jLabel3 = new javax.swing.JLabel();
			n0 = new javax.swing.JLabel();
			n = new javax.swing.JLabel();

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

			n0.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			n0.setText("Sample Size Goes Here");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(30, 49, 0, 24);
			add(n0, gridBagConstraints);

			n.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 24)); // NOI18N
			n.setText("Sample Size Goes Here");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(8, 49, 27, 33);
			add(n, gridBagConstraints);

		//	pack();
		}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel n0;
	private javax.swing.JLabel n;
	// End of variables declaration
}

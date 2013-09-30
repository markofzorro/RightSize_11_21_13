/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rightSize;

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
			jLabel5 = new javax.swing.JLabel();
			jLabel6 = new javax.swing.JLabel();

			//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			setLayout(new java.awt.GridBagLayout());

			jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
			jLabel2.setText("Sample Size:");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 10;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(30, 50, 0, 0);
			add(jLabel2, gridBagConstraints);

			jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
			jLabel3.setText("Sample Size with Finite Population Correction:");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(8, 50, 27, 0);
			add(jLabel3, gridBagConstraints);

			jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
			jLabel5.setText("Sample Size Goes Here");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(30, 49, 0, 33);
			add(jLabel5, gridBagConstraints);

			jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
			jLabel6.setText("Sample Size Goes Here");
			gridBagConstraints = new java.awt.GridBagConstraints();
			gridBagConstraints.gridx = 2;
			gridBagConstraints.gridy = 1;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
			gridBagConstraints.insets = new java.awt.Insets(8, 49, 27, 33);
			add(jLabel6, gridBagConstraints);

		//	pack();
		}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	// End of variables declaration
}

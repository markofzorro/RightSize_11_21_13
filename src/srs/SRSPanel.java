package srs;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import basesAndUtilites.D;
import basesAndUtilites.GlobalConstants;

public class SRSPanel extends JPanel
	{
		JTextField tfPop = null;
		JTextField tfProportion = null;
		JTextField tfCI = null;
		JTextField tfCC = null;
		JLabel lblN0 = null;
		JLabel lblN = null;
		JLabel lblFpc = null;

		/**
		 * Create the panel. Has four equal sized columns. Adds rows prn.
		 * Presents choices to users and collects their choices.
		 * 
		 * Default values are added in this class.
		 */
		public SRSPanel()
			{
				setLayout(new GridLayout(0, 4));
				// setSize(500, 500);

				// first Row. Must fill three empty columns
				newLabel("Assumptions:", GlobalConstants.TITLE_SIZE);
				fillCols(3);

				// second row
				newLabel("Target Population Size", GlobalConstants.TEXT_SIZE);
				fillCols(1);
				tfPop = newTf("1000");
				add(tfPop);
				fillCols(1);

				// third row
				newLabel("Expected Proportion", GlobalConstants.TEXT_SIZE);
				fillCols(1);
				tfProportion = newTf("50");
				add(tfProportion);
				newLabel("%", GlobalConstants.TEXT_SIZE);

				// fourth row
				newLabel("Desired Width of Confidence Interval", GlobalConstants.TEXT_SIZE);
				JLabel lblPm = new JLabel( "\u00B1"); // plus/minus sign
				lblPm.setHorizontalAlignment(SwingConstants.TRAILING);
				lblPm.setFont(new java.awt.Font("Lucida Grande", 1, GlobalConstants.TEXT_SIZE)); // NOI18N
				add(lblPm);
				tfCI = newTf("5");
				add(tfCI);
				newLabel("%", GlobalConstants.TEXT_SIZE);

				// Fifth Row
				newLabel("Desired Confidence Coeffecient", GlobalConstants.TEXT_SIZE);
				fillCols(1);
				tfCC = newTf("95");
				add(tfCC);
				newLabel("%", GlobalConstants.TEXT_SIZE);

				// Sixth Row

				// Draw separator across all 4 columns
				for (int i = 0; i < 4; i++)
					add(new JSeparator());

				// Results:
/******************* Results start here ***********/
				// row 7
				JLabel lblTitle = new JLabel("Results:");
				lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, GlobalConstants.TITLE_SIZE)); // NOI18N
				add(lblTitle);
				fillCols(3);

				// Row 8
				newLabel("Sample Size", GlobalConstants.TEXT_SIZE);
				fillCols(1);
				lblN0 = newLabel("", GlobalConstants.TEXT_SIZE);
				lblN0.setHorizontalAlignment(SwingConstants.TRAILING);

				fillCols(1);

				// Row 9
				newLabel("Finite Population Correction", GlobalConstants.TEXT_SIZE);
				fillCols(2);
				lblFpc = newLabel("", GlobalConstants.TEXT_SIZE);
				lblFpc.setHorizontalAlignment(SwingConstants.TRAILING);
				//fillCols(1);

				// Row 8
				newLabel("Corrected Sample Size", GlobalConstants.TEXT_SIZE);
				fillCols(1);
				lblN = newLabel("", GlobalConstants.TEXT_SIZE);
				lblN.setHorizontalAlignment(SwingConstants.TRAILING);

				fillCols(1);
			}

		/****************** Helper Methods ***************************/
		
		JLabel newLabel(String s, int fontSize)
			{
				JLabel label = new JLabel(s);
				label.setFont(new java.awt.Font("Lucida Grande", 1, fontSize)); // NOI18N
				add(label);

				return label;
			}

		JTextField newTf(String s)
			{
				JTextField field = new JTextField(s);
				field.setHorizontalAlignment(SwingConstants.TRAILING);
				field.setFont(new java.awt.Font("Lucida Grande", 1, GlobalConstants.TEXT_SIZE)); // NOI18N
				return field;
			}

		private void fillCols(int number)
			{
				for (int i = 0; i < number; i++)
					{
						add(new JLabel(""));
					}

			}

		/********************* Getters **************/

		public String getPopString()
			{
				D.b("panel:getPopString(). tfPopString is: " + tfPop.getText() + " "+ tfPop);
				D.b("SRSPanel.getPopString(): tfPop is " + tfPop.getText());
				return tfPop.getText();
			}

		public String getProportionString()
			{
				return tfProportion.getText();
			}

		public String getCIString()
			{
				return tfCI.getText();
			}

		public String getCCString()
			{
				return tfCC.getText();
			}

		/************** Setters ************/
		public void setLblN0(double d)
			{
				lblN0.setText(Double.toString(d));

			}

		public void setLblN(double d)
			{
				lblN.setText(Double.toString(d));

			}

		public void setLblFpc(double d)
			{
				lblFpc.setText(Double.toString(d));

			}

	}

package rightSize;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		 */
		public SRSPanel()
			{
				setLayout(new GridLayout(0, 4));
				// setSize(500, 500);

				// first Row. Must fill three empty columns
				newLabel("Assumptions:", 36);
				fillCols(3);

				// second row
				newLabel("Target Population Size", 24);
				fillCols(1);
				tfPop = newTf("100");
				add(tfPop);
				fillCols(1);

				// third row
				newLabel("Expected Proportion", 24);
				fillCols(1);
				tfProportion = newTf("50");
				add(tfProportion);
				newLabel("%", 24);

				// fourth row
				newLabel("Desired Width of Confidence Interval", 24);
				JLabel lblPm = new JLabel("±");
				lblPm.setHorizontalAlignment(SwingConstants.TRAILING);
				lblPm.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
				add(lblPm);
				tfCI = newTf("5");
				add(tfCI);
				newLabel("%", 24);

				// Fifth Row
				newLabel("Desired Confidence Coeffecient", 24);
				fillCols(1);
				tfCC = newTf("95");
				add(tfCC);
				newLabel("%", 24);

				// Sixth Row

				// Draw separator across all 4 columns
				for (int i = 0; i < 4; i++)
					add(new JSeparator());

				// Results:
/******************* REsults start here ***********/
				// row 7
				JLabel lblTitle = new JLabel("Results:");
				lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
				add(lblTitle);
				fillCols(3);

				// Row 8
				newLabel("Sample Size", 24);
				fillCols(1);
				lblN0 = newLabel("", 24);
				lblN0.setHorizontalAlignment(SwingConstants.TRAILING);

				fillCols(1);

				// Row 9
				newLabel("Finite Population Correction", 24);
				fillCols(2);
				lblFpc = newLabel("", 24);
				lblFpc.setHorizontalAlignment(SwingConstants.TRAILING);
				//fillCols(1);

				// Row 8
				newLabel("Corrected Sample Size", 24);
				fillCols(1);
				lblN = newLabel("", 24);
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
				field.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
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

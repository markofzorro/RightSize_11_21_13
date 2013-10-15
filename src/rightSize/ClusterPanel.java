package rightSize;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

		public class ClusterPanel extends JPanel
			{
				JTextField tfPop = null;
				JTextField tfProportion = null;
				JTextField tfCI = null;
				JTextField tfCC = null;
				JTextField tfClusterSize = null;
				JTextField tfROH = null;
			
				// Result labels
				JLabel lblClustersNeeded = null;
				JLabel lblDesignEffect= null;
			

				/**
				 * Create the panel. Has four equal sized columns. Adds rows prn.
				 */
				public ClusterPanel()
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
						newLabel("Desired Cluster Size", 24);
						fillCols(1);
						tfClusterSize = newTf("10");
						add(tfClusterSize);
						//newLabel("%", 24);
						fillCols(1);

						// Seventh Row
						newLabel("Estimated Rate of Homogeneity", 24);
						fillCols(1);
						tfROH = newTf("0.2");
						add(tfROH);
						newLabel("%", 24);
						

						// Draw separator across all 4 columns
						for (int i = 0; i < 4; i++)
							add(new JSeparator());

						// Results:
		/******************* Results start here ***********/
						// row 7
						JLabel lblTitle = new JLabel("Results:");
						lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
						add(lblTitle);
						fillCols(3);

						// Row 8
						newLabel("Clusters Needed", 24);
						fillCols(1);
						lblClustersNeeded = newLabel("", 24);
						lblClustersNeeded.setHorizontalAlignment(SwingConstants.TRAILING);

						fillCols(1);

						// Row 9
						newLabel("Design Effect", 24);
						fillCols(2);
						lblDesignEffect = newLabel("", 24);
						lblDesignEffect.setHorizontalAlignment(SwingConstants.TRAILING);
						//fillCols(1);

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
				public void setLblClustersNeeded(double d)
					{
						lblClustersNeeded.setText(Double.toString(d));

					}

				public void setLblDesignEffect(double d)
					{
						lblDesignEffect.setText(Double.toString(d));

					}

				
			}

	
